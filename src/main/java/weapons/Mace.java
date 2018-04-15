package weapons;

import constants.Element;
import constants.WeaponType;

public class Mace extends MainWeapons {

//    private double attacksPerSecond = 1.0;

    public Mace(WeaponType weaponType, double DMGMin, double DMGMax, double STRModifier, Element element, double attacksPerSecond) {
        super(weaponType, DMGMin, DMGMax, STRModifier, element, attacksPerSecond);
    }
}
