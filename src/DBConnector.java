public class DBConnector {
    // single instance of DBConnector
    private static DBConnector dbConnector = null;

    // private constructor
    private DBConnector() {}
    // public method to get singleton DBConnector instance
    public static DBConnector getDbConnector() {
        if (dbConnector == null) {
            dbConnector = new DBConnector();
        }
        return dbConnector;
    }
}
