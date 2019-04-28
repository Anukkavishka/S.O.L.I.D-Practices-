package ReadRecords;

import Model.UserStat;
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
    public Map<String, UserStat> Read() {
        try {

            String strLine="";
            Map<String, UserStat> map = userMultiMap.getMultiMap();
            ArrayList arrayList = new ArrayList();

            while ((strLine = inBuffer.readLine()) != null) {

                String[] valReadings = strLine.split(",");
                arrayList.add(valReadings);
            }
            Iterator iterator = arrayList.iterator();

            while (iterator.hasNext()) {
                UserStat userStat=new UserStat();
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


                userStat.setCreditTotal(processData.creditsTotal(creditsList) + "");
                userStat.setChargeTimeTotal(processData.ChargeTimeTotal(chargeTimeList));
                userStat.setChargeTimeAvg(processData.chargeTimeAvg(chargeTimeList) + "");
                userStat.setMaxCredit(processData.creditsMax(creditsList) + "");

                //putting all calculated data of a specific user into the Map
                map.put(user, userStat);
            }


            return map;
        } catch (Exception e) {

        }
        return null;
    }
}
