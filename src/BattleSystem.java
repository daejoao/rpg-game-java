import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import logger.Logger;

public class BattleSystem {
	Scanner scanner = new Scanner(System.in);
	Logger log = new Logger();

  public void startBattle(Player player, HashMap<String, Enemy> enemies) {
		boolean isBattleOngoing = true;
		Integer goldGainedInBattle = 0;
		List<Integer> playerPossibleChoices = Arrays.asList(1, 2);
		Integer playerChoice;

		log.printWithDelay(player.getName() + " entrou em uma batalha!", 5);
		while (isBattleOngoing) {
			// Turno do jogador
			this.printBattleScreen(player, enemies);
			log.printWithDelay("Sua vez! Digite o numero da acao que queira realizar:", 5);

			do {
				try {
						playerChoice = scanner.nextInt();
				} catch (InputMismatchException e) {
						System.out.println("Entrada invalida! Por favor, digite um numero.");
						playerChoice = null;

						scanner.next(); 
						continue;
				}

				switch (playerChoice) {
					case 1:
						boolean enemyExistsInBattle;
						String enemyChosen;
						scanner.nextLine();

						do {	
							log.printWithDelay("Digite o nome do inimigo que queira atacar:", 5);
							enemyChosen = scanner.nextLine().toUpperCase();
							enemyExistsInBattle = enemies.containsKey(enemyChosen);
			
							if (!enemyExistsInBattle) {
								log.printWithDelay("Este inimigo nao esta presente na batalha, escolha outro!", 5);
							}
						} while (!enemyExistsInBattle);
			
						Enemy enemyToAttack = enemies.get(enemyChosen);
						log.printWithDelay("> " + player.getName() + " decidiu atacar " + enemyToAttack.getName(), 5);
			
						player.attack(enemyToAttack);

						// Valida se inimigos estão vivos
						if (!enemyToAttack.isAlive) {
							enemies.remove(enemyChosen);

							Integer goldDropped = enemyToAttack.dropGold();
							goldGainedInBattle += goldDropped;

							log.printWithDelay("> " + player.getName() + " derrotou " + enemyToAttack.getName() + "!", 5);
							log.printWithDelay("> " + enemyToAttack.getName() + " dropou $" + goldDropped + " de ouro!", 5);
						}

						break;
					case 2:
						player.useHealingItem();
						break;
					default:
						System.out.println("Acao invalida, escolha novamente:");
				}
			} while (!playerPossibleChoices.contains(playerChoice));
			
			
			if (enemies.isEmpty()) {
				log.printWithDelay("> " + player.getName() + " derrotou todos os inimigos e conquistou $" + goldGainedInBattle + " de ouro na batalha! \n", 10);

				player.addGold(goldGainedInBattle);
				isBattleOngoing = false;
			}

			// Turno do inimigo
			for (Map.Entry<String, Enemy> enemy: enemies.entrySet()) {
				enemy.getValue().attack(player);

				if (!player.isAlive) {
					log.printWithDelay(player.getName() + " foi derrotado por " + enemy.getValue().getName(), 15);

					log.printWithDelay("--- Fim de jogo! ---", 15);
					System.exit(0);
				}
			}
		}
	}

	private void printBattleScreen(Player player, HashMap<String, Enemy> enemies) {
		System.out.println("\n--------- Inimigos ---------");

		for (Map.Entry<String, Enemy> enemy : enemies.entrySet()){
			String enemyName = enemy.getValue().getName();
			double enemyCurrentHP = enemy.getValue().getHealthPoints();
			double enemyMaxHP = enemy.getValue().getMaxHealthPoints();

			System.out.println("> " + enemyName + " (" + enemyCurrentHP + "/" + enemyMaxHP + " HP)");
		}

		System.out.println("\n--------- Jogador ---------");
		System.out.println("> Vida: (" + player.getHealthPoints() + "/" + player.getMaxHealthPoints() + " HP)");
		System.out.println("> [1] Atacar");
		System.out.println("> [2] Se curar");
		System.out.println("____________________________");
	}
}
