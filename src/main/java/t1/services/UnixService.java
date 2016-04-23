package t1.services;

/**
 * Created by linux on 23.04.16.
 */
public class UnixService {
    private static UnixService instance;
    public static UnixService getInstance(){
        if (instance==null){
            instance = new UnixService();
        }
        return instance;
    }
    public void  uploadFile(){
        System.out.println("uploding file...");
    }
}
