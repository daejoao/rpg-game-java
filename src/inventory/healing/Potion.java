package inventory.healing;

public class Potion implements HealingItem {
  private double healingAmount;

  public Potion() {
    this.healingAmount = 30;
  }

  public String getName() {
    return "Poção de cura";
  }

  public String getDescription() {
    return "Uma poção mágica que restaura 30 pontos de vida do jogador, curando ferimentos e revitalizando o corpo.";
  }

  public double getHealingAmount() {
    return this.healingAmount;
  }
}
