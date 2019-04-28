package WriteRecords;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WriteCSV implements FileOutput {
    @Override
    public void writeToCSV(Map<String, List<String>> map) throws IOException {
        FileWriter csvWriter = new FileWriter("SampleOutput.txt");
        Set<String> users;
        try  {
            users =map.keySet();

            for (String user: users) {
                List<String> listm= map.get(user);
                List<String> finalList=new ArrayList<String>();
                finalList.add(0,user);
                finalList.add(1,listm.get(0));
                finalList.add(2,listm.get(1));
                finalList.add(3,listm.get(2));
                finalList.add(4,listm.get(3));
                csvWriter.append(String.join(",", finalList));
                csvWriter.append("\n");

            }

            csvWriter.flush();
            csvWriter.close();


        }catch (Exception e){

        }

    }

}
