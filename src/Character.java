import logger.Logger;

public abstract class Character {
	private String name;
	private double healthPoints;
	protected double attackPower;
	private double maxHealthPoints;
	public boolean isAlive = true;
	
	Logger log = new Logger();

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
		this.healthPoints -= damagePoints;
		log.printWithDelay(this.name + " sofreu " + damagePoints + " de ano.", 5);

		
		if (this.healthPoints <= 0) {
			log.printWithDelay(this.name + " morreu.",10);

			this.isAlive = false;
		} else {
			log.printWithDelay(this.name + " agora possui " + this.healthPoints + " pontos de vida.", 5);
		}
	}
	
	public void recoverLife(double recoverHealthPoints) {
		this.healthPoints += recoverHealthPoints;
		
		if (this.healthPoints > this.maxHealthPoints) {
			this.healthPoints = this.maxHealthPoints;
		}
		
		log.printWithDelay(this.name + " recuperou " + recoverHealthPoints + " pontos de vida.", 5);
		
		if (this.healthPoints == this.maxHealthPoints) {
			log.printWithDelay(this.name + " agora está com a vida máxima!", 10);
			return;
		}
		
		System.out.println(this.name + " possui " + this.healthPoints + " pontos de vida.");
	}

	public void attack(Character target) {
		log.printWithDelay("> "+ this.getName() + " realizou um ataque!", 5);
		target.takeDamage(this.attackPower);
	}
	
	public double getHealthPoints() {
		return this.healthPoints;
	}
	
	public double getMaxHealthPoints() {
		return this.maxHealthPoints;
	}
}
