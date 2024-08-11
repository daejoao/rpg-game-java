import java.util.Scanner;
import inventory.healing.*;
import inventory.weapons.Weapon;
import inventory.Inventory;

public class Player extends Character {
	Scanner scanner = new Scanner(System.in);
	public Inventory inventory = new Inventory();
	public Weapon currentWeapon;
	private Integer gold;

	public Player(String name) {
		super(name, 5, 30);
	}

	public void useHealingItem() {
		HealingItem healingItem;
		
		do {
			this.inventory.seeHealingItens();

			System.out.println("Digite o ID de um item para usá-lo: ");
			Integer itemId = scanner.nextInt();

			healingItem = this.inventory.getHealingItem(itemId);

			if (healingItem == null) {
				System.out.println("Escolha outro: ");
			}
		} while (healingItem == null);

		System.out.println("> " + this.getName() + " usou " + healingItem.getName());
		this.recoverLife(healingItem.getHealingAmount());
	}

	public void equipWeapon(Integer weaponId) {
		Weapon weapon = this.inventory.getWeapon(weaponId);

		this.currentWeapon = weapon;
		this.attackPower += weapon.getAttackPower();
	}

	public Integer getTotalGold() {
		return this.gold;
	}

	public void addGold(Integer gold) {
		this.gold += gold;
	}
}
