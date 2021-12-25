package kg.geektech.game.players;

public class Thor extends  Hero {


    public Thor(int health, int damage,  String name) {
        super(health, damage,
                SuperAbility.STUN, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (Math.random() < 0.5) {
                boss.setDamage(0);
                System.out.println("Thors stun");
                break;
            } else {
              boss.setDamage(50);
                break;
            }
        }

    }
}
