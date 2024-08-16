package inventory;

import java.util.ArrayList;
import java.util.List;

import inventory.healing.HealingItem;
import inventory.weapons.Weapon;

public class Inventory {
  private List<HealingItem> healingItens;
  private List<Weapon> weapons;

  public Inventory() {
    this.healingItens = new ArrayList<HealingItem>();
    this.weapons = new ArrayList<Weapon>();
  }

  public void storeItem(HealingItem item) {
    this.healingItens.add(item);
  }

  public void storeItem(Weapon item){
    this.weapons.add(item);
  }

  public void seeInventory() {
    this.seeHealingItens();
    this.seeWeapons();
  }

  public void seeHealingItens() {
    if (!this.healingItens.isEmpty()){
      System.out.println("[ Items de Cura ]");

      for (HealingItem healingItem : this.healingItens) {
        int healingItemID = this.healingItens.indexOf(healingItem);

        System.out.println("> [" + healingItemID + "] " + healingItem.getName() + " | " + healingItem.getDescription());
      }
    } else {
      System.out.println("Voce nao tem itens de cura");
    }
  }

  public void seeWeapons() {
    if (!this.weapons.isEmpty()){
      System.out.println("[ Armas ]");

      for (Weapon weapon : this.weapons) {
        int weaponID = this.weapons.indexOf(weapon);

        System.out.println("> [" + weaponID + "] " + weapon.getName());

      }
    }
  }

  public HealingItem getHealingItem(Integer itemId) {
    try {
      HealingItem healingItem = this.healingItens.get(itemId);

      this.healingItens.remove(healingItem);
      return healingItem;
    } catch (Exception err) {
      if (err instanceof IndexOutOfBoundsException) {
        System.out.println("Este item nao existe no inventario...");
      }

      return null;
    }
  }

  public Weapon getWeapon(Integer weaponId) {
    try {
      Weapon weapon = this.weapons.get(weaponId);

      return weapon;
    } catch (Exception err) {
      if (err instanceof IndexOutOfBoundsException) {
        System.out.println("Esta arma nao existe no inventario...");
      }

      return null;
    }
  }

  public List<HealingItem> getAllHealingItens() {
    return this.healingItens;
  }
}
