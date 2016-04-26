package feeds.services;

/**
 * Created by linux on 23.04.16.
 */
public class DbService {
    private static DbService instance;
    public static DbService getInstance(){
        if (instance==null){
            instance = new DbService();
        }
        return instance;
    }
    public void  queryDb(){
        System.out.println("querying db...");
    }
}
