package kg.geektech.game.players;

public class Golem extends Hero{
    public Golem(int health, int damage,  String name) {
        super(health, damage, SuperAbility.SHIELD, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int shield = boss.getDamage() / 5;
        int aliveHero = 0;
        for (int i = 0; i < heroes.length; i++) {
            if (this == heroes[i]) {
                continue;
            } else if (this !=heroes[i]) {
                aliveHero++;
                heroes[i].setHealth(heroes[i].getHealth() + shield);


            }
        }
        this.setHealth(this.getHealth()-shield*aliveHero);
        System.out.println("Golems shield: " + shield * aliveHero);

    }
    }
