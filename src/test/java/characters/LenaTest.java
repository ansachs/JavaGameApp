package characters;

import characters.Lena;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class LenaTest {

    @Test
    public void createsACharacterAndOnlyOneCharacter(){
        Lena lena = Lena.getInstance(50);
//        System.out.println(lena.getStrength());
        Lena lena2 = Lena.getInstance(75);
        assertTrue(lena.toString().equals(lena2.toString()));
    }


}
