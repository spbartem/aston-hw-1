package model.heroes;

import model.Character;
import model.Role;

public class Warrior extends Character {
    public Warrior(String name, int health, int damage, Role role) {
        super(name, health, damage, role);
    }

    @Override
    public void attackEnemy(Character enemy) {
        System.out.printf("The " + this.defineClassAndName() + " attacks "
                + enemy.defineClassAndName() + " with his sharp axe%n");
        enemy.takeDamage(getDamage() + criticalAttack());
    }

    @Override
    public void specialAbility() {

    }
}
