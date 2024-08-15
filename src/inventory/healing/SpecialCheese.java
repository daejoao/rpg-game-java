package inventory.healing;

public class SpecialCheese implements HealingItem {
  private double healingAmount;

  public SpecialCheese() {
    this.healingAmount = 15;
  }

  public String getName() {
    return "Queijo Especial";
  }

  public String getDescription() {
    return "Um queijo raro e de sabor intenso que restaura 15 pontos de vida.";
  }

  public double getHealingAmount() {
    return this.healingAmount;
  }
}
