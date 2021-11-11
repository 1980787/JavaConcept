// Figuring out
// map() of intermediate operations
// collect() of final operations
public class Person {
    private String fName;
    private String lName;
    private int age;

    Person(String fName, String lName, int age) {
        this.fName = fName;
        this.lName = lName;
        this.age = age;
    }
    String getfName() {
        return fName;
    }
    String getlName() {
        return lName;
    }
    int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person: fName=" + fName +  ", lName=" + lName + ", age=" + age;
    }
}
