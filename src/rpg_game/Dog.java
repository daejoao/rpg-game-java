package rpg_game;

public class Dog {
	private String name;
	private String breed;
	private Integer age;
	
	public Dog(String name, String breed, Integer age) {
		this.name = name;
		this.breed = breed;
		this.age = age;
	}
	
	public void bark() {
		System.out.println("Woof-woof!");
	}
	
}
