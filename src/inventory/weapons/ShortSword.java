package inventory.weapons;

public class ShortSword implements Weapon {
  private String name;
  private double attackPower;

  public ShortSword() {
    this.name = "Espada curta";
    this.attackPower = 7;
  }

  public String getName() {
    return this.name;
  }
  
  public double getAttackPower() {
    return this.attackPower;
  }
}
