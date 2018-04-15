package weapons;

import constants.Element;
import constants.WeaponType;

public class Axe extends MainWeapons {

//    private double attacksPerSecond = 1.2;

    public Axe(WeaponType weaponType, double DMGMin, double DMGMax, double STRModifier, Element element, double attacksPerSecond) {
        super(weaponType, DMGMin, DMGMax, STRModifier, element, attacksPerSecond);
    }
}
