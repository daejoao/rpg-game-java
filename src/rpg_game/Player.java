package rpg_game;

public class Player {
	private String name;
	private double healthPoints;
	private double atackPower;
	private double defensePoints;
	
	public Player() {
		this.healthPoints = 30.0;
		this.atackPower = 6.0;
		this.defensePoints = 4.0;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void takeDamage(double damagePoints) {
		System.out.println(this.name + " possui " + this.healthPoints + " pontos de vida.");

		this.healthPoints -= damagePoints;
		System.out.println(this.name + " sofreu " + damagePoints + " de ano.");
		
		System.out.println(this.name + " possui" + this.healthPoints + " pontos de vida.");
	}
	
	public void recoverLife(double recoverHealthPoints) {
		this.healthPoints += recoverHealthPoints;
		
		System.out.println(this.name + " recuperou " + recoverHealthPoints + " pontos de vida.");
		System.out.println(this.name + " possui " + this.healthPoints + " pontos de vida.");
	}
}
