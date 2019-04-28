package WriteRecords;

import Model.UserStat;

import java.io.IOException;
import java.util.Map;

public interface FileOutput {

    void writeToCSV(Map<String, UserStat> map)throws IOException;
}
