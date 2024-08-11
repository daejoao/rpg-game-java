import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BattleSystem {
	Scanner scanner = new Scanner(System.in);

  public void startBattle(Player player, HashMap<String, Enemy> enemies) {
		boolean isBattleOngoing = true;
		Integer goldGainedInBattle = 0;
		List<Integer> playerPossibleChoices = Arrays.asList(1, 2);
		Integer playerChoice;

		System.out.println(player.getName() + " entrou em uma batalha!");
		while (isBattleOngoing) {
			// Turno do jogador
			this.printBattleScreen(player, enemies);
			System.out.println("Sua vez! Digite o número da ação que queira realizar:");

			do {
				try {
						playerChoice = scanner.nextInt();
				} catch (InputMismatchException e) {
						System.out.println("Entrada inválida! Por favor, digite um número.");
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
							System.out.println("Digite o nome do inimigo que queira atacar:");
							enemyChosen = scanner.nextLine().toUpperCase();
							enemyExistsInBattle = enemies.containsKey(enemyChosen);
			
							if (!enemyExistsInBattle) {
								System.out.println("Este inimigo não está presente na batalha, escolha outro!");
							}
						} while (!enemyExistsInBattle);
			
						Enemy enemyToAttack = enemies.get(enemyChosen);
						System.out.println("> " + player.getName() + " decidiu atacar " + enemyToAttack.getName());
			
						player.attack(enemyToAttack);

						// Valida se inimigos estão vivos
						if (!enemyToAttack.isAlive) {
							enemies.remove(enemyChosen);

							Integer goldDropped = enemyToAttack.dropGold();
							goldGainedInBattle += goldDropped;

							System.out.println("> " + player.getName() + " derrotou " + enemyToAttack.getName() + "!");
							System.out.println("> " + enemyToAttack.getName() + " dropou $" + goldDropped + " de ouro!");
						}

						break;
					case 2:
						player.useHealingItem();
						break;
					default:
						System.out.println("Ação inválida, escolha novamente:");
				}
			} while (!playerPossibleChoices.contains(playerChoice));
			
			
			if (enemies.isEmpty()) {
				System.out.println("> " + player.getName() + " derrotou todos os inimigos e conquistou $" + goldGainedInBattle + " de ouro na batalha! \n");
				
				player.addGold(goldGainedInBattle);
				isBattleOngoing = false;
			}

			// Turno do inimigo
			for (Map.Entry<String, Enemy> enemy: enemies.entrySet()) {
				enemy.getValue().attack(player);

				if (!player.isAlive) {
					System.out.println(player.getName() + " foi derrotado por " + enemy.getValue().getName());

					isBattleOngoing = false;
					break;
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
