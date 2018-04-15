package GameLogic;

import attacks.Attack;
import attacks.AttackFactory;
import characters.Lena;
import characters.Warrior;
import constants.AttackType;
import constants.Element;
import constants.WeaponType;
import weapons.Weapon;
import weapons.WeaponsFactory;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Game {
    private Warrior lena;
    private Weapon weapon;
    private double DMGMin;
    private  double DMGMax;
    private double STRModifier;
    private Element element;
    private String[] columnNames = {"","Minimum",
            "Maximum", "DPS"};
    private String[] rowNames = {"Punch", "Smite", "Cleave"};
    private double elementBonus;

    public void run() {
        String response = "";
        System.out.println("\n");
        Scanner reader = new Scanner(System.in);
        while (lena == null) {
            System.out.println("Please input your characters current level");
            response = reader.nextLine();
            try {
                lena = Lena.getInstance(Integer.parseInt(response));
                System.out.println(lena.toString());
            } catch (Exception e) {
                System.out.printf("invalid selection: %s", response);
            }
        }
            System.out.println("Please select a weapon");
            int count = 0;
            while (weapon == null) {
                for (WeaponType type : WeaponType.values()) {
                    count++;
                    System.out.printf("%d - %s \n", count, type.toString());

                }
                response = reader.nextLine();
                int weaponNum;
                if (Integer.valueOf(response) < 1 || Integer.valueOf(response) > count) {
                    weaponNum = (int) checkConstraints("Not a valid selection", 1, count);
                } else {
                    weaponNum = Integer.parseInt(response);
                }
                DMGMin = checkConstraints("Enter Minimum weapon damage value between 1-100:", 1, 100);
                DMGMax = checkConstraints("Enter Maximum weapon damage, value must between 1-100:", 1, 100);
                STRModifier = checkConstraints("Enter weapon strength modifier, value must be between 1-100:", 1, 100);
                count = 0;
                System.out.println("Please select a weapon element modifier");
                for (Element type : Element.values()) {
                    count++;
                    System.out.printf("%d - %s \n", count, type.toString());
                }
                response = reader.nextLine();
                int elementNum;
                if (Integer.parseInt(response) < 1 || Integer.parseInt(response) > count) {
                    elementNum = (int) checkConstraints("Not a valid selection", 1, count);
                } else {
                    elementNum = Integer.parseInt(response);
                }
                System.out.println("Enter the elemental weapons bonus, either 0 or between 5-15%");
                response = reader.nextLine();
                double possibleBonus = Double.parseDouble(response);
                if (possibleBonus == 0.0) {
                    elementBonus = 0.0;
                } else if (possibleBonus < 5.0 || possibleBonus > 15.0 ){
                    elementBonus = checkConstraints("Enter the elemental weapons bonus, either 0 or between 5-15%", 5.0, 15.0);
                } else {
                    elementBonus = possibleBonus;
                }
                try {
                    weapon = WeaponsFactory.getWeapon(WeaponType.values()[weaponNum - 1], DMGMin, DMGMax, STRModifier, Element.values()[elementNum - 1]);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            Object[][] data = calculateDamageMatrix(lena, weapon, columnNames, rowNames, elementBonus);

            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    CustomTable.createAndShowGUI(data, columnNames);
                }
            });

    }

    public Object[][] calculateDamageMatrix(Warrior warrior, Weapon weapon, String[] columnNames, String[] rowNames, double elementBonus){
        double calculations[] = new double[9];
        double baseStrength = warrior.getStrength() + weapon.getSTRModifier();
        Object[][] data = new Object[rowNames.length][columnNames.length];
        int i = 0;
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);

        for(AttackType attackType:AttackType.values()){
            data[i][0] = rowNames[i];
            Attack attack = AttackFactory.getAttack(attackType);
            double DMGmin = (calculateDamage(weapon, attack , weapon.getDMGMin(), elementBonus));
            data[i][1] = df.format(DMGmin);
            double DMGmax = calculateDamage(weapon, attack , weapon.getDMGMax(), elementBonus);
            data[i][2] = df.format(DMGmax);
            double DPS = calculateDPS(weapon, attack, DMGmin, DMGmax);
            data[i][3] = df.format(DPS);
            i++;
        }

        return data;

    }

    public double calculateDamage(Weapon weapon, Attack attack, double minOrMaxDMG, double elementBonus){
        double weaponsBonus = weapon.getSTRModifier();
        Element weaponElementType = weapon.getElement();
        Element attackElementType = attack.getElement();
        if (weaponElementType == attackElementType) {
            return ((1 + weaponsBonus/100) * minOrMaxDMG * attack.getPercentOfWeaponDamage()/100 * (1 + elementBonus/100));
        } else {
            return ((1 + weaponsBonus/100) * attack.getPercentOfWeaponDamage()/100 * minOrMaxDMG);
        }
    }

    public double calculateDPS(Weapon weapon, Attack attack, double minDMG, double maxDMG){
        return ((minDMG + maxDMG)/2 * weapon.getAttacksPerSecond() * attack.getPercentOfWeaponAPS()/100);
    }



    public double checkConstraints(String string, double low, double high) {
        Scanner reader = new Scanner(System.in);
        String response = "-1";
        double integerResponse = -1;
        while (Double.parseDouble(response) < low || Double.parseDouble(response) > high ) {
            System.out.println(string);
            response = reader.nextLine();
            try {
                integerResponse = Double.parseDouble(response);
            } catch (Error e) {

            }
        }
        return integerResponse;
    }



}
