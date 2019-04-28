package WriteRecords;

import Model.UserStat;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WriteCSV implements FileOutput {
    @Override
    public void writeToCSV(Map<String, UserStat> map) throws IOException {
        FileWriter csvWriter = new FileWriter("SampleOutput.txt");
        Set<String> users;
        try  {
            users =map.keySet();

            for (String user: users) {
                UserStat listm= map.get(user);
                List<String> finalList=new ArrayList<String>();
                finalList.add(0,user);
                finalList.add(1,listm.getCreditTotal());
                finalList.add(2,listm.getChargeTimeTotal());
                finalList.add(3,listm.getChargeTimeAvg());
                finalList.add(4,listm.getMaxCredit());
                csvWriter.append(String.join(",", finalList));
                csvWriter.append("\n");

            }

            csvWriter.flush();
            csvWriter.close();


        }catch (Exception e){

        }

    }

}
