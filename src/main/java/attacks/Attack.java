package attacks;

import constants.AttackType;
import constants.Element;

public interface Attack {

    public double getPercentOfWeaponAPS();
    public double getPercentOfWeaponDamage();
    public Element getElement();
    public AttackType getAttackType();
}
