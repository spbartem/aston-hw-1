package model;

public abstract class Character implements Mortal {
    private final String name;
    private int health;
    private final int damage;
    private final Role role;


    public Character(String name, int health, int damage, Role role) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException("Health cannot be negative");
        }
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public String defineClassAndName() {
        return String.format("%s %s (%s)", getClass().getSimpleName(), this.getName(), this.getHealth());
    }

    public abstract void attackEnemy(Character character);

    public void takeDamage(int damage) {
        setHealth(Math.max(getHealth() - damage, 0));
        if (getHealth() <= 0) {
            System.out.printf("==== " + defineClassAndName() + " is dead ===%n");
        }
    }

    @Override
    public boolean isAlive() {
        return getHealth() > 0;
    }

    public Role getRole() {
        return role;
    }

    public int criticalAttack() {
        if (Math.random() > 0  && Math.random() < 0.15) {
            System.out.println("CRITICAL ATTACK!");
            return getDamage() * 2;
        } else {
            return 0;
        }
    }

    public abstract void specialAbility();
}
