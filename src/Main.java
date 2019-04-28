import ProcessRecords.ProcessData;
import ReadRecords.ReadCSV;
import ReadRecords.UserMultiMap;
import WriteRecords.WriteCSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Map<String, List<String>> map;
        UserMultiMap userMultiMap = new UserMultiMap();
        ProcessData processData = new ProcessData();
        BufferedReader inBuffer;
        Set<String> users;
        try {
            inBuffer = new BufferedReader(new FileReader("./inputSamples.txt"));
            ReadCSV readCSV = new ReadCSV(processData,userMultiMap,inBuffer);
            map=readCSV.Read();
            users =map.keySet();

            WriteCSV writeCSV=new WriteCSV();
            writeCSV.writeToCSV(map);

            for (String user: users) {
                List<String> listm= map.get(user);
                //System.out.println(user+"|user|"+listm.get(0)+"|Total credits|"+listm.get(1)+"|TotalTime|"+listm.get(2)+"|AvgTime|"+listm.get(3)+"|MaxCredits|");
            }
        }catch (IOException e){
            System.out.println("File Read Exception");
        }





        //System.out.println(map.size());




    }
}
