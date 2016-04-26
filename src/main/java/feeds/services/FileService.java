package feeds.services;

/**
 * Created by linux on 23.04.16.
 */
public class FileService {
    private static FileService instance;
    public static FileService getInstance(){
        if (instance==null){
            instance = new FileService();
        }
        return instance;
    }
    public void  writingFile(){

        System.out.println("querying db...");
    }
}
