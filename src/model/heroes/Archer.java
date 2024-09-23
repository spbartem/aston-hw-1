package model.heroes;

import model.Character;
import model.Role;

public class Archer extends Character {
    public Archer(String name, int health, int damage, Role role) {
        super(name, health, damage, role);
    }

    @Override
    public void attackEnemy(Character character) {
        System.out.printf("The " + this.defineClassAndName() + " attacks "
                + character.defineClassAndName() + " with his irresistible arrows%n");
        character.takeDamage(getDamage() + criticalAttack());
    }

    @Override
    public void specialAbility() {

    }
}
