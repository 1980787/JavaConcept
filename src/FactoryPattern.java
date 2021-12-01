import java.util.Locale;
import java.util.Scanner;

public class FactoryPattern {
    public static void main(String[] args) {
        try {
            System.out.println("Enter your order pizza or cake: ");
            Scanner sc = new Scanner(System.in);
            // Creating the factory
            FoodFactory foodFactory = new FoodFactory();
            // Factory instantiates an object
            Food food = foodFactory.getFood(sc.nextLine());

            System.out.println("The factory returned " + food.getClass());
            System.out.println(food.getType());
        } catch (Exception e) {
            System.out.println("Unsuccessful Termination!!");
        }
    }
}

class FoodFactory {
    public Food getFood(String str) {
        Food result = null;
        if (str.compareToIgnoreCase("pizza") == 0) {
            result = new Pizza();
        }
        if (str.compareToIgnoreCase("cake") == 0) {
            result = new Cake();
        }
        return result;
    }
}
class Pizza implements Food {
    public String getType() {
        return "Someone ordered Fast Food!";
    }
}

class Cake implements Food {
    public String getType() {
        return "Someone ordered a Dessert!";
    }
}

// interface
interface Food {
    String getType();
}
