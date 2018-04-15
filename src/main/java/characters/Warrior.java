package characters;

import weapons.Weapon;

import java.util.List;

public class Warrior implements Character {
    protected double strength;
    protected double vitality;
    protected double level;
    protected boolean heavyArmor;
    protected List<Weapon> weaponlist;

    public Warrior(double level) {
        this.level = level;
        this.heavyArmor = false;

    }

//    public double attackDamage(Attack attack, Weapon weapon){
//        return attack.damage() * this.strength*(0.1);
//    }

    public void increaseLevel(){
        this.level ++;
        this.strength = this.strength + 10;
        this.vitality = this.vitality + 5;
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public void setVitality(double vitality) {
        this.vitality = vitality;
    }

    public double getVitality() {
        return vitality;
    }

    public boolean isHeavyArmor() {
        return heavyArmor;
    }

    public List<Weapon> getWeaponlist() {
        return weaponlist;
    }
}
