package gameLogic;

import GameLogic.Game;
import attacks.Attack;
import attacks.AttackFactory;
import attacks.MainAttacks;
import characters.Lena;
import characters.Warrior;
import constants.AttackType;
import constants.Element;
import constants.WeaponType;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import weapons.Weapon;
import weapons.WeaponsFactory;

import static org.junit.Assert.assertEquals;

public class GameLogicTest {
//    WeaponsFactory factory;
    Warrior lena;
    Weapon weapon;
//    AttackFactory attackFactory;
    String[] columnNames = {"", "Minimum",
            "Maximum",
            "DPS"};
    String[] rowNames = {"Punch", "Smite", "Cleave"};
    Game game;
    double elementBonus;



    @Before
    public void createObjects(){
        WeaponsFactory factory = new WeaponsFactory();
      this.weapon = factory.getWeapon(WeaponType.AXE, 50, 65, 20, Element.FIRE);
      this.lena = Lena.getInstance(40);
      this.game = new Game();
//      this.attackFactory = new AttackFactory();
      this.elementBonus = 10;
        System.out.println("ran once");
    }

    @Test
    public void calculateDamage() {
        System.out.println(rowNames.length);
        System.out.println(columnNames.length);
        game.calculateDamageMatrix(lena, weapon, columnNames, rowNames, elementBonus);
    }

    @Test
    public void caclulatesMinimumDamage() {
        Attack punch =  AttackFactory.getAttack(AttackType.PLAINOLDPUNCH);
        double min = 50;
        double minDMG = game.calculateDamage(weapon, punch, min, elementBonus);
        assertEquals(60, minDMG, 0);
    }

    @Test
    public void calculatesMaximumDamage() {
        Attack punch =  AttackFactory.getAttack(AttackType.PLAINOLDPUNCH);
        double max = 65;
        double minDMG = game.calculateDamage(weapon, punch, max, elementBonus);
        assertEquals(78, minDMG, 0);
    }

    @Test
    public void calculatesMaximumDamageIdenticalElement() {
        Attack fire =  AttackFactory.getAttack(AttackType.FIREMOSTSMITE);
        double max = 65;
        double minDMG = game.calculateDamage(weapon, fire, max, elementBonus);
        assertEquals(77.22, minDMG, .01);
    }

    @Test
    public void calculatesMaximumDamageIdenticalElementEdgeCaseOne() {
        Attack fire =  AttackFactory.getAttack(AttackType.FIREMOSTSMITE);
        double max = 65;
        double minDMG = game.calculateDamage(weapon, fire, max, 0);
        assertEquals(70.2, minDMG, .01);
    }

    @Test
    public void calculatesMaximumDamageIdenticalElementEdgeCasesTwo() {
        Attack fire =  AttackFactory.getAttack(AttackType.FIREMOSTSMITE);
        double max = 65;
        double minDMG = game.calculateDamage(weapon, fire, max, 5);
        assertEquals(73.71, minDMG, .01);
    }

    @Test
    public void calculatesMaximumDamageIdenticalElementEdgeCaseThree() {
        Attack fire =  AttackFactory.getAttack(AttackType.FIREMOSTSMITE);
        double max = 65;
        double minDMG = game.calculateDamage(weapon, fire, max, 15);
        assertEquals(80.73, minDMG, .01);
    }

    @Test
    public void calculatesDPS() {
        double max = 78;
        double min = 60;
        Attack punch =  AttackFactory.getAttack(AttackType.PLAINOLDPUNCH);
        double DPS = game.calculateDPS(weapon, punch, min, max);
        assertEquals(82.8, DPS, .01);
    }



}
