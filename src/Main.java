
import java.util.Random;

public class Main {

    public static void main(String[] args){

        Random r = new Random();
        Monster m = new Monster(r.nextInt(5));
        Hero h = new Hero();

        while(m.getHealthValue() > 0 && h.getHealthValue() > 0) {
            h.whoAttacksFirst(m);
            System.out.println("---------------------------------------------------");
        }
    }
}
