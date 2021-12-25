package kg.geektech.game.players;

import static kg.geektech.game.general.RPG_Game.random;

public class Berserk extends Hero{
    public Berserk(int health, int damage, String name) {
        super(health, damage,
                SuperAbility.SAVE_DAMAGE_AND_REVERT, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int block = random.nextInt(20,50);
        for (int i = 0; i < heroes.length; i++) {
            if (this == heroes[i]) {
                heroes[i].setDamage(getDamage()+block);
                System.out.println("Berserks repulse: " + block);
                break;
            }
        }

    }
}
