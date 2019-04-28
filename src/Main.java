import Model.UserStat;
import ProcessRecords.ProcessData;
import ReadRecords.ReadCSV;
import ReadRecords.UserMultiMap;
import WriteRecords.WriteCSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Map<String, UserStat> map;
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

        }catch (IOException e){
            System.out.println("File Read Exception");
        }




    }
}
