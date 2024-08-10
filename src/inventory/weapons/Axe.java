package inventory.weapons;

public class Axe implements Weapon {
  private String name;
  private double attackPower;

  public Axe() {
    this.name = "Machado";
    this.attackPower = 9;
  }

  public String getName() {
    return this.name;
  }
  
  public double getAttackPower() {
    return this.attackPower;
  }
}
