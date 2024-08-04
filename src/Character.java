package rpg_game;

public abstract class Character {
	private String name;
	private double healthPoints;
	private double attackPower;
	private double maxHealthPoints;
	
	public Character(String name, double attackPower, double maxHealthPoints) {
		this.name = name;
		this.attackPower = attackPower;
		this.maxHealthPoints = maxHealthPoints;
		this.healthPoints = maxHealthPoints;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void takeDamage(double damagePoints) {
		System.out.println(this.name + " possui " + this.healthPoints + " pontos de vida.");

		this.healthPoints -= damagePoints;
		System.out.println(this.name + " sofreu " + damagePoints + " de ano.");
		
		if (this.healthPoints <= 0) {
			System.out.println(this.name + " morreu.");
			return;
		} 
		
		System.out.println(this.name + " agora possui " + this.healthPoints + " pontos de vida.");
	}
	
	public void recoverLife(double recoverHealthPoints) {
		this.healthPoints += recoverHealthPoints;
		
		System.out.println(this.name + " recuperou " + recoverHealthPoints + " pontos de vida.");
		
		if (this.healthPoints == this.maxHealthPoints) {
			System.out.println(this.name + " agora está com a vida máxima!");
			return;
		}
		
		System.out.println(this.name + " possui " + this.healthPoints + " pontos de vida.");
	}

	// To-do> adicionar um sistema de morte do personagem;
	public void attack(Character target) {
		System.out.println(this.getName() + " realizou um ataque!");
		target.takeDamage(this.attackPower);
	}
	
	public double getHealthPoints() {
		return this.healthPoints;
	}
	
	public double getMaxHealthPoints() {
		return this.maxHealthPoints;
	}
}
