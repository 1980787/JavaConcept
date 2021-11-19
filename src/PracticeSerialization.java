import java.io.*;

public class PracticeSerialization {
    public static void main(String[] args) {
        User user = new User("John Louis", "john.louis@gmail.com", "john1234", 23);
        String fileName = "file.ser"; // .ser that abbreviation of serialization

        // serialization
        try {
            // Saving of object in a file
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fos);
            // Method for serialization of user
            out.writeObject(user);

            out.close(); // close connection
            fos.close(); // close connection

            System.out.println("Object has been serialized");
        } catch(IOException e) {
            System.out.println("IOException is caught");
        }
        System.out.println();
        User user1 = null;
        // deserialzation
        try {
            // Reading the object from a file
            FileInputStream fos = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fos);

            // Method for deserialization of user
            user1 = (User) in.readObject();

            in.close(); // close connection
            fos.close(); // close connection

            System.out.println("Object has been deserialized");
            System.out.println(user1);
        } catch(Exception e) {
            System.out.println("Exception is caught");
        }
    }
}

class User implements java.io.Serializable {
    private String name;
    private String email;
    private transient String password; // transient; exclude from serialization
    private int age;
    // Serialization is determined by the type of the object it is actually connected to,
    //                            not the type of the variable in the instance.
//    Object obj = new Object(); // cannot serialization cuz ancestors object do not implement serializable
//    Object obj2 = new String("abc"); // can serialization

    public User(String name, String email, String password, int age) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}
