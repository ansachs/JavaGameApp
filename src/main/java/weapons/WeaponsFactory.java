package weapons;

import constants.Element;
import constants.WeaponType;

public class WeaponsFactory {
    public static Weapon getWeapon(WeaponType weaponType, double DMGMin, double DMGMax, double STRModifier, Element element){
        switch (weaponType) {
            case AXE:
                return new Axe(weaponType, DMGMin, DMGMax, STRModifier, element, 1.2);
            case MACE:
                return new Mace(weaponType, DMGMin, DMGMax, STRModifier, element, 1.0);
            case SWORD:
                return new Sword(weaponType, DMGMin, DMGMax, STRModifier, element, 1.4);
            default:
                return null;
        }
    }
}
