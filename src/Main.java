import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import filemanager.FileManager;
import inventory.healing.Elixir;
import inventory.healing.HealingItem;
import inventory.healing.Potion;
import inventory.healing.SpecialCheese;
import inventory.weapons.Knife;
import inventory.weapons.ShortSword;
import inventory.weapons.Weapon;
import logger.Logger;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		FileManager fileManager = new FileManager();
		Logger log = new Logger();

		EnemyFactory enemyFactory = new EnemyFactory();
		BattleSystem battleSystem = new BattleSystem();
		HashMap<String, Enemy> enemies = new HashMap<String, Enemy>();

		Player player = new Player("Jogador");

		String initialText = fileManager.readFileText("./src/resources/texts/initial-text.txt");
		log.printWithDelay(initialText, 10);

		String misteryFigureArrival = fileManager.readFileText("./src/resources/texts/mistery-figure.txt");
		log.printWithDelay(misteryFigureArrival, 10);  

		String keyAndKnifeScene = fileManager.readFileText("./src/resources/texts/key-and-knife.txt");
		log.printWithDelay(keyAndKnifeScene, 10); 

		Weapon knife = new Knife();
		player.inventory.storeItem(knife);
		player.equipWeapon(knife);
		
		log.printWithDelay("> Você equipa a faca e guarda a chave em seu bolso! \n", 5);

		String escapeAttempt = fileManager.readFileText("./src/resources/texts/escape-attempt.txt");
		log.printWithDelay(escapeAttempt, 10);

		String firstEnemyEncounter = fileManager.readFileText("./src/resources/texts/first-enemy-encounter.txt");
		log.printWithDelay(firstEnemyEncounter, 10);

		Enemy bat = enemyFactory.createEnemy("Bat");
		Enemy giantRat = enemyFactory.createEnemy("Rat");
		enemies.put("MORCEGO", bat);
		enemies.put("RATO GIGANTE", giantRat);

		battleSystem.startBattle(player, enemies);

		String prisonerAndSkeletonScene = fileManager.readFileText("./src/resources/texts/old-prisoner-skeleton-scene.txt");
		log.printWithDelay(prisonerAndSkeletonScene, 10);

		List<Integer> possibleChoices = Arrays.asList(1, 2);
		Integer playerChoice;

		do {
			playerChoice = scanner.nextInt();

			if (playerChoice == 1){
				String helpOldPrisoner = fileManager.readFileText("./src/resources/texts/help-old-prisoner.txt");
				log.printWithDelay(helpOldPrisoner, 10);

				Enemy skeleton = enemyFactory.createEnemy("Skeleton");
				enemies.put("ESQUELETO", skeleton);
				battleSystem.startBattle(player, enemies);

				String oldPrisonerDeath = fileManager.readFileText("./src/resources/texts/old-prisoner-death-scene.txt");
				log.printWithDelay(oldPrisonerDeath, 10);

				HealingItem elixir = new Elixir();
				Weapon sword = new ShortSword();

				player.inventory.storeItem(elixir);
				player.inventory.storeItem(sword);
				player.equipWeapon(sword);
		
				log.printWithDelay("> Você equipa a espada e guarda a poção no seu inventário! \n", 5);
			} else if (playerChoice == 2) {
				String dontHelpOldPrisoner = fileManager.readFileText("./src/resources/texts/dont-help-old-prisoner.txt");
				log.printWithDelay(dontHelpOldPrisoner, 10);

				Enemy skeleton = enemyFactory.createEnemy("Skeleton");
				Enemy undead = enemyFactory.createEnemy("Undead");
				enemies.put("ESQUELETO", skeleton);
				enemies.put("MORTO-VIVO", undead);
				battleSystem.startBattle(player, enemies);

				String oldPrisonerSword = fileManager.readFileText("./src/resources/texts/prisoner-sword-scene.txt");
				log.printWithDelay(oldPrisonerSword, 10);

				Weapon sword = new ShortSword();
				player.inventory.storeItem(sword);
				player.equipWeapon(sword);
		
				log.printWithDelay("> Você equipa a espada!", 5);
			}

			if (!possibleChoices.contains(playerChoice)) {
				System.out.println("Escolha inválida. Tente novamente.");
			}

		} while (!possibleChoices.contains(playerChoice));

		String hideoutScene = fileManager.readFileText("./src/resources/texts/hideout-scene.txt");
		log.printWithDelay(hideoutScene, 10);

		HealingItem healthPotion = new Potion();
		HealingItem healthPotion2 = new Potion();
		HealingItem specialCheese = new SpecialCheese();
		
		player.inventory.storeItem(healthPotion);
		player.inventory.storeItem(healthPotion2);
		player.inventory.storeItem(specialCheese);

		log.printWithDelay("> Você guarda no seu inventário duas poções de cura e um queijo especial! \n", 5);

		String finalBossScene = fileManager.readFileText("./src/resources/texts/final-boss-scene.txt");
		log.printWithDelay(finalBossScene, 10);

		Enemy warriorBandit = enemyFactory.createEnemy("Bandit");
		Enemy greyWolf = enemyFactory.createEnemy("Grey wolf");
		enemies.put("LOBO CINZA GIGANTE", greyWolf);
		enemies.put("BANDIDO GUERREIRO", warriorBandit);

		battleSystem.startBattle(player, enemies);

		String endGameScene = fileManager.readFileText("./src/resources/texts/end-game.txt");
		log.printWithDelay(endGameScene, 10);
	}
}
