import java.util.HashMap;
import java.util.Map;

public class BattleSystem {
  public void startBattle(Player player, HashMap<String, Enemy> enemies) {}

	public void printAllBattleEnemies(HashMap<String, Enemy> enemies) {
		for (Map.Entry<String, Enemy> enemy : enemies.entrySet()){
			System.out.println("> " + enemy.getKey() + " (" + enemy.getValue().getHealthPoints() + "HP)");
		}
	}
}
