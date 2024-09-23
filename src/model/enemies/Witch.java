package model.enemies;

import model.Character;
import model.Role;

public class Witch extends Character {
    public Witch(String name, int health, int damage, Role role) {
        super(name, health, damage, role);
    }

    @Override
    public void attackEnemy(Character enemy) {
        System.out.printf("The " + this.defineClassAndName() + " attacks " + enemy.defineClassAndName() + " with her magic hat%n");
        enemy.takeDamage(getDamage() + criticalAttack());
    }

    @Override
    public void specialAbility() {

    }
}
