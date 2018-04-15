package weapons;

import constants.Element;
import constants.WeaponType;

public class MainWeapons implements Weapon {
    protected double DMGMin;
    protected double DMGMax;
    protected double STRModifier;
    protected Element element;
    protected WeaponType weaponType;
    protected double attacksPerSecond;

    public MainWeapons(WeaponType type, double DMGMin, double DMGMax, double STRModifier, Element element, double attacksPerSecond) {
        this.weaponType = type;
        this.DMGMin = DMGMin;
        this.DMGMax = DMGMax;
        this.STRModifier = STRModifier;
        this.element = element;
        this.attacksPerSecond = attacksPerSecond;
    }

    @Override
    public String toString(){
        return "I am a " + this.weaponType;
    }

    public double getDMGMin() {
        return DMGMin;
    }

    public double getDMGMax() {
        return DMGMax;
    }

    public double getSTRModifier() {
        return STRModifier;
    }

    public Element getElement() {
        return element;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public double getAttacksPerSecond() {
        return attacksPerSecond;
    }


}
