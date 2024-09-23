package model.heroes;

import model.Character;
import model.Role;

public class Mage extends Character {
    public Mage(String name, int health, int damage, Role role) {
        super(name, health, damage, role);
    }

    @Override
    public void attackEnemy(Character enemy) {
        System.out.printf("The " + this.defineClassAndName() + " attacks "
                + enemy.defineClassAndName() + " with his incredible flash%n");
        enemy.takeDamage(getDamage() + criticalAttack());
    }

    @Override
    public void specialAbility() {

    }
}
