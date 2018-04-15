package attacks;


import constants.AttackType;
import constants.Element;

public class PlainOldPunch extends MainAttacks {

    public PlainOldPunch(double percentOfWeaponAPS, double percentOfWeaponDamage, Element element) {
            super(percentOfWeaponAPS, percentOfWeaponDamage, element);
            super.attackType = AttackType.PLAINOLDPUNCH;
        }

    public AttackType getAttackType() {
        return attackType;
    }
}
