package ReadRecords;

import Model.UserStat;

import java.util.HashMap;
import java.util.Map;

public class UserMultiMap implements AddToMultiMap {
    @Override
    public Map<String, UserStat> getMultiMap() {

        // create multimap to store key and values
        Map<String, UserStat> map = new HashMap<String, UserStat>();

        return map;

    }
}
