import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CovariantReturnTypes {
    public static void main(String[] args) throws IOException {
        System.out.println("Please Enter region that WestBengal or AndhraPradesh: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine().trim();
        Region region = null;
        switch (s) {
            case "WestBengal":
                region = new WestBengal();
                break;
            case "AndhraPradesh":
                region = new AndhraPradesh();
                break;
        }
        Flower flower = region.yourNationalFlower();
        System.out.println(flower.whatsYourName());
    }
}
class Flower {
    String whatsYourName() {
        return "I have many names ad types.";
    }
}

class Jasmine extends Flower{
    @Override
    String whatsYourName() {
        return "Jasmine";
    }
}

class Lily extends Flower{
    @Override
    String whatsYourName() {
        return "Lily";
    }
}

class Region {
    Flower yourNationalFlower(){
        return new Flower();
    }
}

class WestBengal extends Region{
    @Override
    Jasmine yourNationalFlower(){
        return new Jasmine();
    }
}

class AndhraPradesh extends Region{
    @Override
    Lily yourNationalFlower(){
        return new Lily();
    }
}
