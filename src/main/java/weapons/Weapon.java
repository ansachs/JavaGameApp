package weapons;

import constants.Element;
import constants.WeaponType;

public interface Weapon {
    WeaponType getWeaponType();

    double getDMGMin();

    double getDMGMax();

    double getSTRModifier();

    Element getElement();

    public double getAttacksPerSecond();

}
