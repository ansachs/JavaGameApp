package attacks;

import constants.AttackType;
import constants.Element;

public class FiremostSmite extends MainAttacks{

    public FiremostSmite(double percentOfWeaponAPS, double percentOfWeaponDamage, Element element) {
        super(percentOfWeaponAPS, percentOfWeaponDamage, element);
        super.attackType = AttackType.FIREMOSTSMITE;
    }

    public AttackType getAttackType() {
        return attackType;
    }
}
