package kg.geektech.game.general;

import kg.geektech.game.players.*;

import java.util.Random;

public class RPG_Game {
    public static Random random = new Random();
    private static int standartDamageWarrior,standartDamageGolem,standartDamageBerserk,standartDamageThor,standartDamageMagic,standartDamageWitcher;

    public static void startGame() {
        Warrior warrior = new Warrior(290, 20, "Warrior");
        //Medic doc = new Medic(240, 5, 20, "Medic");
        Magic magic = new Magic(270, 15, "Mag");
        Berserk berserk = new Berserk(200, 10, "Berserk");
        //Medic assistant = new Medic(280, 10, 5, "Medic assistant");
        Thor thor = new Thor(250 , 20 ,"Thor");
        Golem golem = new Golem(1500 , 10 ,"Golem" );
        Witcher witcher = new Witcher(500,0,"Witcher");

        Hero[] heroes = {warrior, magic, berserk,witcher,thor,golem};
        Boss boss = new Boss(1000, 50);

        printStatistics(boss, heroes);
        while (!isGameFinished(boss, heroes)) {
            round(boss, heroes);
        }
    }

    private static void round(Boss boss, Hero[] heroes) {
        bossHits(boss, heroes);
        heroesHit(boss, heroes);
        heroesApplyAbilities(boss, heroes);
        printStatistics(boss, heroes);
        standartDamage(heroes);
    }

    private static void bossHits(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            }
        }
    }

    private static void heroesHit(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
                standartDamageWarrior = heroes[0].getDamage();
                standartDamageMagic = heroes[1].getDamage();
                standartDamageBerserk = heroes[2].getDamage();
                standartDamageWitcher = heroes[3].getDamage();
                standartDamageThor = heroes[4].getDamage();
                standartDamageGolem = heroes[5].getDamage();


            }


        }
    }
    private static void standartDamage (Hero[] heroes) {
        heroes[0].setDamage(standartDamageWarrior);
        heroes[1].setDamage(standartDamageMagic);
        heroes[2].setDamage(standartDamageBerserk);
        heroes[3].setDamage(standartDamageWitcher);
        heroes[4].setDamage(standartDamageThor);
        heroes[5].setDamage(standartDamageGolem);
    }

    private static void heroesApplyAbilities(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                heroes[i].applySuperPower(boss, heroes);
            }
        }
    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }

        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("________________");
        System.out.println("Boss health: " + boss.getHealth()
                + " [" + boss.getDamage() + "]");
        for (int i = 0; i < heroes.length; i++) {
           /* System.out.println(heroes[i].getClass().getSimpleName()
                    + " health: " + heroes[i].getHealth()
                    + " [" + heroes[i].getDamage() + "]");*/
            System.out.println(heroes[i].getName()
                    + " health: " + heroes[i].getHealth()
                    + " [" + heroes[i].getDamage() + "]");
        }
        System.out.println("________________");
    }
}
