package inventory.healing;

public class Elixir implements HealingItem {
  private double healingAmount;

  public Elixir() {
    this.healingAmount = 100;
  }
  public String getName() {
    return "Elixir";
  }

  public String getDescription() {
    return "Um elixir raro que restaura completamente a saude do usuario, curando todos os pontos de vida de uma so vez.";
  }

  public double getHealingAmount() {
    return this.healingAmount;
  }
}
