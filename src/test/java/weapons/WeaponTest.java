package weapons;

import constants.Element;
import constants.WeaponType;
import org.junit.BeforeClass;
import org.junit.Test;


import static constants.Element.COLD;
import static org.junit.Assert.assertEquals;

public class WeaponTest {
    private double DMGMin = 50;
    private  double DMGMax = 60;
    private double STRModifier = 5;
    private Element element = COLD;
    private WeaponsFactory factory;

//    @BeforeClass
//    public void newFactory(){
//       this.factory = new WeaponsFactory();
//    }


    @Test
    public void createsAnAxe(){
        WeaponType type = WeaponType.AXE;
        Weapon axe = this.factory.getWeapon(type, DMGMin, DMGMax, STRModifier, element);
        assertEquals(WeaponType.AXE, axe.getWeaponType());
    }

    @Test
    public void createsAMace(){
        WeaponType type = WeaponType.MACE;
        Weapon mace = this.factory.getWeapon(type, DMGMin, DMGMax, STRModifier, element);
        assertEquals(WeaponType.MACE, mace.getWeaponType());
    }

    @Test
    public void createsASword(){
        WeaponType type = WeaponType.SWORD;
        Weapon sword = this.factory.getWeapon(type, DMGMin, DMGMax, STRModifier, element);
        assertEquals(WeaponType.SWORD, sword.getWeaponType());
    }

}
