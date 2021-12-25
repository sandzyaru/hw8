package kg.geektech.game.players;

public class Witcher extends Hero{
    public Witcher(int health, int damage,  String name) {
        super(health, damage, SuperAbility.RESURRECTION, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        setDamage(0);
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth()==0 && this !=heroes[i]){
                heroes[i].setHealth(this.getHealth());
                this.setHealth(0);

                System.out.println("Witcher");
            }

            break;
        }
    }
}
