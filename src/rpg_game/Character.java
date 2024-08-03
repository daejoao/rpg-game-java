package rpg_game;

public abstract class Character {
	protected String name;
	protected double healthPoints;
	protected double attackPower;
	protected double maxHealthPoints = 30;
	
	public Character(String name) {
		this.name = name;
		this.healthPoints = this.maxHealthPoints;
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
	
	// Optional
	public double getHealthPoints() {
		return this.healthPoints;
	}
	
	public double getMaxHealthPoints() {
		return this.maxHealthPoints;
	}
}
