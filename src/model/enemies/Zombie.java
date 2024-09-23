package model.enemies;

import model.Character;
import model.Role;

public class Zombie extends Character {
    private int countOfReturn = 0;

    public Zombie(String name, int health, int damage, Role role) {
        super(name, health, damage, role);
    }

    public void setCountOfReturn(int countOfReturn) {
        this.countOfReturn = countOfReturn;
    }

    @Override
    public void attackEnemy(Character enemy) {
        System.out.printf("The " + this.defineClassAndName() + " attacks " + enemy.defineClassAndName() + " with a sound 'Braaaains'%n");
        enemy.takeDamage(getDamage() + criticalAttack());
    }

    @Override
    public void specialAbility() {
        if (getHealth() <= 0 && countOfReturn < 1) {
            this.setHealth(600);
            setCountOfReturn(++countOfReturn);
            System.out.println(defineClassAndName() + " has been returned with x2 health");
        }
    }
}
