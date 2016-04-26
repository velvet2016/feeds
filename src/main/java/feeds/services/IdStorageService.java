package feeds.services;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by linux on 24.04.16.
 */
public class IdStorageService {
    private static IdStorageService instance;
    public static IdStorageService getInstance(){
        if (instance==null){
            instance = new IdStorageService();
        }
        return instance;
    }

    Map<String,Map<String,String>> tagToIdsMap = new HashMap<String,Map<String,String>>();
    public Map<String,String> getTestIdToVendorIdMap(String tag){
        return tagToIdsMap.get(tag);
    }
    public void storegetTestIdToVendorIdMap(String tag, Map<String,String> testIdToVendorIdMap){
        tagToIdsMap.put(tag, testIdToVendorIdMap);
    }
}
