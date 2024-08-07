package inventory.healing;

public class SpecialCheese implements HealingItem {
  private double healingAmount = 5;

  public String getName() {
    return "Queijo Especial";
  }

  public String getDescription() {
    return "Um queijo raro e de sabor intenso que restaura 5 pontos de vida. Ideal para uma recuperação rápida e eficaz durante aventuras desafiadoras";
  }

  public double getHealingAmount() {
    return this.healingAmount;
  }
}
