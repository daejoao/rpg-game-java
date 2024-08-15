import java.util.List;
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
		super(name, 8, 40);

		this.gold = 0;
	}

	public void useHealingItem() {
		List<HealingItem> healingItems = this.inventory.getAllHealingItens();

		if (healingItems.isEmpty()) {
			System.out.println("Você não itens de cura");
		} else {
			HealingItem chosenHealingItem;
			
			do {
				this.inventory.seeHealingItens();

				System.out.println("Digite o ID de um item para usá-lo: ");
				Integer itemId = scanner.nextInt();

				chosenHealingItem = this.inventory.getHealingItem(itemId);

				if (chosenHealingItem == null) {
					System.out.println("Escolha outro: ");
				}
			} while (chosenHealingItem == null);

			System.out.println("> " + this.getName() + " usou " + chosenHealingItem.getName());
			this.recoverLife(chosenHealingItem.getHealingAmount());
		}
	}

	public void equipWeapon(Weapon weapon) {
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
