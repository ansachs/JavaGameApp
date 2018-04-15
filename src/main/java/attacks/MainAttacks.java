package attacks;

import constants.AttackType;
import constants.Element;

public class MainAttacks implements Attack {
    protected double percentOfWeaponAPS;
    protected double PercentOfWeaponDamage;
    protected Element element;
    protected AttackType attackType;

    public MainAttacks(double percentOfWeaponAPS, double percentOfWeaponDamage, Element element) {
        this.percentOfWeaponAPS = percentOfWeaponAPS;
        PercentOfWeaponDamage = percentOfWeaponDamage;
        this.element = element;
    }

    public double getPercentOfWeaponAPS() {
        return percentOfWeaponAPS;
    }

    public double getPercentOfWeaponDamage() {
        return PercentOfWeaponDamage;
    }

    public Element getElement() {
        return element;
    }

    public AttackType getAttackType() {
        return attackType;
    }

    public void setAttackType(AttackType attackType) {
        this.attackType = attackType;
    }
}
