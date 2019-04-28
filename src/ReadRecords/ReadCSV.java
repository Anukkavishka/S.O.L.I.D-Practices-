package ReadRecords;

import ProcessRecords.ProcessData;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class ReadCSV implements FileInput {

    private UserMultiMap userMultiMap;
    private ProcessData processData;
    private BufferedReader inBuffer;

    public ReadCSV(ProcessData processData,UserMultiMap userMultiMap,BufferedReader inBuffer){
        this.processData=processData;
        this.userMultiMap=userMultiMap;
        this.inBuffer=inBuffer;
    }

    @Override
    public Map<String, List<String>> Read() {
        try {

            String strLine="";
            Map<String, List<String>> map = userMultiMap.getMultiMap();
            ArrayList arrayList = new ArrayList();

            while ((strLine = inBuffer.readLine()) != null) {

                String[] valReadings = strLine.split(",");
                arrayList.add(valReadings);
            }
            Iterator iterator = arrayList.iterator();

            while (iterator.hasNext()) {
                List<String> dataList = new ArrayList<String>();
                List<Long> creditsList = new ArrayList<Long>();
                List<Long> chargeTimeList = new ArrayList<Long>();
                Iterator iteratorInner = arrayList.iterator();
                String[] valCollection = (String[]) iterator.next();

                String user = valCollection[0];
                while (iteratorInner.hasNext()) {

                    String[] valCollectionInner = (String[]) iteratorInner.next();

                    if (valCollectionInner[0].equals(user)) {
                        creditsList.add(Long.parseLong(valCollectionInner[3]));
                        chargeTimeList.add((Long.parseLong(valCollectionInner[2])) - (Long.parseLong(valCollectionInner[1])));

                    }
                }

                //Calculating Data for specific user

                dataList.add(processData.creditsTotal(creditsList) + "");
                dataList.add(processData.ChargeTimeTotal(chargeTimeList));
                dataList.add(processData.chargeTimeAvg(chargeTimeList) + "");
                dataList.add(processData.creditsMax(creditsList) + "");

                //putting all calculated data of a specific user into the Map
                map.put(user, dataList);
            }


            return map;
        } catch (Exception e) {

        }
        return null;
    }
}
