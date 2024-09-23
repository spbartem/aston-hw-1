package model.enemies;

import model.Character;
import model.Role;

public class Troll extends Character {
    public Troll(String name, int health, int damage, Role role) {
        super(name, health, damage, role);
    }

    @Override
    public void attackEnemy(Character enemy) {
        System.out.printf("The " + this.defineClassAndName() + " attacks " + enemy.defineClassAndName() + " with his huge stick%n");
        enemy.takeDamage(getDamage() + criticalAttack());
    }

    @Override
    public void specialAbility() {

    }
}
