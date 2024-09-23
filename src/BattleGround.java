import model.Character;
import model.Role;
import model.enemies.Troll;
import model.enemies.Witch;
import model.enemies.Zombie;
import model.heroes.Archer;
import model.heroes.Mage;
import model.heroes.Warrior;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class BattleGround {
    public static void main(String[] args) {
        Character hero = Objects.requireNonNull(chooseCharacter());
        List<Character> enemies = initialCharacters();
        battle(hero, enemies);
    }

    public static Character chooseCharacter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your hero:\n 1. Archer\n 2. Mage\n 3. Warrior");
        int choice = Integer.parseInt(scanner.nextLine());
        scanner.close();
        return getCharacter(choice);
    }

    public static Character getCharacter(int choice) {
        return switch (choice) {
            case 1 -> new Archer("Haldir", 750, 120, Role.HERO);
            case 2 -> new Mage("Hurry", 900, 200, Role.HERO);
            case 3 -> new Warrior("Batman", 1500, 150, Role.HERO);
            default -> {
                System.out.println("Invalid choice, try again.");
                yield chooseCharacter();
            }
        };
    }

    public static List<Character> initialCharacters() {
        return List.of(
                new Zombie("Henry", 300, 75, Role.ENEMY),
                new Troll("Bur", 350, 100, Role.ENEMY),
                new Witch("Marika", 200, 48, Role.ENEMY)
        );
    }

    public static void battle(Character hero, List<Character> enemies) {
        while (true) {
            if (hero.isAlive()) {
                System.out.println("\n=== The Hero is attacking ===");
                for (Character enemy : enemies) {
                    if (enemy.isAlive()) {
                        hero.attackEnemy(enemy);
                        enemy.specialAbility();
                    }
                }
            } else {
                System.out.println("\n!!! The Enemies is win !!!");
                break;
            }

            if (enemies.stream().anyMatch(Character::isAlive)) {
                System.out.println("\n=== The Enemies is attacking ===");
                for (Character character : enemies) {
                    if (character.isAlive()) {
                        character.attackEnemy(hero);
                        hero.specialAbility();
                    }
                }
            } else {
                System.out.println("\n!!! The " + hero.defineClassAndName() + " is win !!!");
                break;
            }
        }
    }

}
