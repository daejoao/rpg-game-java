import inventory.healing.*;

public class Player extends Character {
	public Player(String name) {
		super(name, 5, 30);
	}

	public void useHealingItem(HealingItem item) {
		System.out.println("> " + this.getName() + " usou " + item.getName() + "!");

		this.recoverLife(item.getHealingAmount());
	}
}
