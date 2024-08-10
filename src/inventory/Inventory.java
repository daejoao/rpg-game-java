package inventory;

import java.util.ArrayList;
import java.util.List;
import inventory.healing.HealingItem;

public class Inventory {
  private List<HealingItem> healingItens;

  public Inventory() {
    this.healingItens = new ArrayList<>();
  }

  public void storeItem(HealingItem item) {
    this.healingItens.add(item);
  }

  public void seeInventory() {
    this.seeHealingItens();
  }

  public void seeHealingItens() {
    if (!this.healingItens.isEmpty()){
      System.out.println("[ Items de Cura ]");

      for (Item healingItem : this.healingItens) {
        int healingItemID = this.healingItens.indexOf(healingItem);

        System.out.println("> [" + healingItemID + "] " + healingItem.getName());
      }
    }
  }

  public HealingItem getHealingItem(Integer itemId) {
    try {
      HealingItem healingItem = this.healingItens.get(itemId);

      return healingItem;
    } catch (Exception err) {
      if (err instanceof IndexOutOfBoundsException) {
        System.out.println("Este item não existe no inventário...");
      }

      return null;
    }
  }
}
