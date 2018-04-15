package characters;

public class Lena extends Warrior {
    private static Lena instance = null;

    public Lena(int level){
        super(level);
        super.setStrength(level * 10);
        super.setVitality(level * 5);
    }

    public static Lena getInstance(int level) {
        if(instance != null) {
            return instance;
        } else if((level >= 1) && (level <= 90)) {
            instance = new Lena(level);
            return instance;
        }
        return null;
    }

    @Override
    public String toString(){
        return "I am level " + this.level;
    }
}
