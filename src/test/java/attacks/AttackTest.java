package attacks;

import constants.AttackType;
import constants.WeaponType;
import org.junit.Test;
import weapons.Weapon;

import static org.junit.Assert.assertEquals;

public class AttackTest {
    AttackType attack;
    AttackFactory attackFactory;


    @Test
    public void createFireMostSmite(){
        attack = AttackType.FIREMOSTSMITE;
        Attack firemostSmite = attackFactory.getAttack(attack);
        assertEquals(attack, firemostSmite.getAttackType());
    }

    @Test
    public void createFrostyCleave(){
        attack = AttackType.FROSTYCLEAVE;
        Attack frostyCleave = attackFactory.getAttack(attack);
        assertEquals(attack, frostyCleave.getAttackType());
    }

    @Test
    public void createsPlainOldPunch(){
        attack = AttackType.PLAINOLDPUNCH;
        Attack plainOldPunch = attackFactory.getAttack(attack);
        assertEquals(attack, plainOldPunch.getAttackType());
    }
}
