package rpg_game;

class Enemy extends Character {
  public Enemy(String name, double attackPower, double maxHealthPoints){
    super(name, attackPower, maxHealthPoints);
  }
}

public class EnemyFactory {
  public Enemy createEnemy(String enemyType) {
    switch (enemyType){
      case "Orc":
        return new Enemy("Orc", 7, 35);
      /* To-do: adicionar possíveis tipos de inimigos:
       * - Undead
       * - Skeleton
       * - Giant spider
       * - Bandit
       * - Wolf
       */
      default:
        return new Enemy("Bat", 1, 3);
    }
  }
}
