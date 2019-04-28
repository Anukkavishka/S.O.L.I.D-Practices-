package WriteRecords;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface FileOutput {

    void writeToCSV(Map<String, List<String>> map)throws IOException;
}
