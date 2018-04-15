package attacks;

import constants.AttackType;
import constants.Element;

import static constants.WeaponType.AXE;

public class AttackFactory {
    public static Attack getAttack(AttackType attack){
        switch (attack) {
            case FIREMOSTSMITE:
                return new FiremostSmite(100, 90, Element.FIRE);
            case FROSTYCLEAVE:
                return new FrostyCleave(90, 120, Element.COLD);
            case PLAINOLDPUNCH:
                return new PlainOldPunch(100,100, Element.PHYSICAL);
            default:
                return null;
        }
    }
}
