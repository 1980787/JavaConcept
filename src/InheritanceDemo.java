public class InheritanceDemo {
    public static void main(String args[]){
        Bird bird = new Bird();
        bird.walk();
        bird.fly();
        bird.sing();
        System.out.println();

        // Create a new Adder object
        Adder a = new Adder();
        // Print the name of the superclass on a new line
        System.out.println("My superclass is: " + a.getClass().getSuperclass().getName());
        // Print the result of 3 calls to Adder's `add(int,int)` method as 3 space-separated integers:
        System.out.print(a.add(10,32) + " " + a.add(10,3) + " " + a.add(10,10) + "\n");
    }
}
class Animal{
    void walk(){
        System.out.println("I am walking");
    }
}
// a Bird object has all the properties that an Animal object has,
// as well as some additional unique properties.
class Bird extends Animal{
    void fly(){
        System.out.println("I am flying");
    }
    void sing() {
        System.out.println("I am singing");
    }
}

class Arithmetic {
    int add (int num1, int num2) {
        return num1 + num2;
    }
}

class Adder extends Arithmetic {

}