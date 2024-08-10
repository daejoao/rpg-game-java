package inventory.weapons;

public class Knife implements Weapon {
  private String name;
  private double attackPower;

  public Knife() {
    this.name = "Faca de serrinha";
    this.attackPower = 6;
  }

  public String getName() {
    return this.name;
  }
  
  public double getAttackPower() {
    return this.attackPower;
  }
}
