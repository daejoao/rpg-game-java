import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BattleSystem {
	Scanner scanner = new Scanner(System.in);

  public void startBattle(Player player, HashMap<String, Enemy> enemies) {
		boolean isBattleOngoing = true;

		System.out.println(player.getName() + " entrou em uma batalha!");
		while (isBattleOngoing) {
			// Turno do jogador
			System.out.println("Sua vez! Digite o nome do inimigo que queira atacar:");
			this.printAllBattleEnemies(enemies);

			boolean enemyExistsInBattle;
			String enemyChosen;
			do {	
				enemyChosen = scanner.nextLine().toUpperCase();
				enemyExistsInBattle = enemies.containsKey(enemyChosen);

				if (!enemyExistsInBattle) {
					System.out.println("Este inimigo não está presente na batalha, escolha outro!");
				}
			} while (!enemyExistsInBattle);

			Enemy enemyToAttack = enemies.get(enemyChosen);
			System.out.println("> " + player.getName() + " decidiu atacar " + enemyToAttack.getName());

			player.attack(enemyToAttack);
			
			isBattleOngoing = false;
		}

	}

	private void printAllBattleEnemies(HashMap<String, Enemy> enemies) {
		for (Map.Entry<String, Enemy> enemy : enemies.entrySet()){
			System.out.println("> " + enemy.getValue().getName() + " (" + enemy.getValue().getHealthPoints() + "HP)");
		}
	}
}
