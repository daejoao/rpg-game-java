package rpg_game;
public class Main {
	public static void main(String[] args) {
		EnemyFactory enemyFactory = new EnemyFactory();

		Player player = new Player("Dolphin Love");
		Enemy orc = enemyFactory.createEnemy("Orc");

		player.attack(orc);
		orc.attack(player);		
	}
}
