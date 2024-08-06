import java.util.HashMap;
/*
 *	To-do: validar métodos em que pode ocorrer "NullPointerException"; 
 */
public class Main {
	public static void main(String[] args) {
		EnemyFactory enemyFactory = new EnemyFactory();
		BattleSystem battleSystem = new BattleSystem();
		HashMap<String, Enemy> enemies = new HashMap<String, Enemy>();

		Player player = new Player("Dolphin Love");
		Enemy goblin = enemyFactory.createEnemy("Goblin");
		Enemy skeleton = enemyFactory.createEnemy("Skeleton");

		enemies.put("GOBLIN", goblin);
		enemies.put("SKELETON", skeleton);

		battleSystem.startBattle(player, enemies);
		if (!player.isAlive) {
			System.out.println("> " + player.getName() + " foi morto durante a batalha...");
		}
	}
}
