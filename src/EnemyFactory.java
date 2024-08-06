class Enemy extends Character {
  public Enemy(String name, double attackPower, double maxHealthPoints){
    super(name, attackPower, maxHealthPoints);
  }
}

public class EnemyFactory {
  public Enemy createEnemy(String enemyType) {
    switch (enemyType){
      case "Goblin":
        return new Enemy("Goblin", 5, 15);
      case "Skeleton":
        return new Enemy("Skeleton", 7, 3);
      case "Undead":
        return new Enemy("Undead", 6, 20);
      case "Giant spider":
        return new Enemy("Giant spider", 4, 25);
      case "Bandit":
        return new Enemy("Bandit", 5, 18);
      case "Wolf":
        return new Enemy("Wolf", 8, 12);
      case "Bat":
      default:
        return new Enemy("Bat", 2, 1);
    }
  }
}
