package ReadRecords;

import Model.UserStat;

import java.util.Map;

public interface FileInput {

    Map<String, UserStat> Read();
}
