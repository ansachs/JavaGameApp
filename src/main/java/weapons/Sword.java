package weapons;

import constants.Element;
import constants.WeaponType;

public class Sword extends MainWeapons{

//    private double attacksPerSecond = 1.4;

    public Sword(WeaponType weaponType, double DMGMin, double DMGMax, double STRModifier, Element element, double attacksPerSecond) {
        super(weaponType, DMGMin, DMGMax, STRModifier, element, attacksPerSecond);
    }
}
