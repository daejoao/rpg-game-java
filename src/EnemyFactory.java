import java.util.Random;

class Enemy extends Character {
  private Integer maxGoldDrop;

  public Enemy(String name, double attackPower, double maxHealthPoints, Integer maxGoldDrop){
    super(name, attackPower, maxHealthPoints);

    this.maxGoldDrop = maxGoldDrop;
  }

  public Integer dropGold() {
    Random random = new Random();
		Integer goldDrop = random.nextInt((this.maxGoldDrop - 1) + 1) + 1;

		return goldDrop;
  }
}

public class EnemyFactory {
  public Enemy createEnemy(String enemyType) {
    switch (enemyType){
      case "Goblin":
        return new Enemy("Goblin", 5, 15, 10);
      case "Skeleton":
        return new Enemy("Esqueleto", 6, 15, 8);
      case "Undead":
        return new Enemy("Morto-vivo", 6, 20, 12);
      case "Giant spider":
        return new Enemy("Aranha gigante", 4, 20, 11);
      case "Bandit":
        return new Enemy("Bandido Guerreiro", 8, 25, 25);
      case "Dark wolf":
        return new Enemy("Lobo Negro Gigante", 5, 15, 15);
      case "Grey wolf":
        return new Enemy("Lobo Cinza Gigante", 5,15, 15);
      case "Rat":
        return new Enemy("Rato gigante", 2, 3, 5);
      case "Bat":
      default:
        return new Enemy("Morcego", 2, 1, 4);
    }
  }
}
