package feeds.services;

import feeds.LoggedClass;

/**
 * Created by linux on 23.04.16.
 */
public class UnixService extends LoggedClass{
    private static UnixService instance;
    public static UnixService getInstance(){
        if (instance==null){
            instance = new UnixService();
        }
        return instance;
    }
    public void  uploadFile(){
        logger.info("uploding file...");
    }
}
