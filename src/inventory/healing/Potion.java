package inventory.healing;

public class Potion implements HealingItem {
  private double healingAmount = 10;

  public String getName() {
    return "Poção de cura";
  }

  public String getDescription() {
    return "Uma poção mágica que restaura 10 pontos de vida do jogador, curando ferimentos e revitalizando o corpo. Essencial para aventuras e batalhas.";
  }

  public double getHealingAmount() {
    return this.healingAmount;
  }
}
