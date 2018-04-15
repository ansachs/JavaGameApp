package attacks;

import constants.AttackType;
import constants.Element;

public class FrostyCleave extends MainAttacks {

    public FrostyCleave(double percentOfWeaponAPS, double percentOfWeaponDamage, Element element) {
    super(percentOfWeaponAPS, percentOfWeaponDamage, element);
    super.attackType = AttackType.FROSTYCLEAVE;
    }

    public AttackType getAttackType() {
        return attackType;
    }

}
