package ProcessRecords;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ProcessData implements CalcFunctions {
    @Override
    public String ChargeTimeTotal(List<Long> chargeTimeList) {
        long totalTime = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        for (long val : chargeTimeList) {
            totalTime += val;
        }
        return sdf.format(new Date(totalTime)).toString();
    }

    @Override
    public long creditsTotal(List<Long> creditList) {
        long totalCredits = 0;
        for (long val : creditList) {
            totalCredits += val;

        }
        return totalCredits;
    }

    @Override
    public String chargeTimeAvg(List<Long> chargeTimeList) {
        long avgTime = 0;
        long totalTime = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        if (!chargeTimeList.isEmpty()) {
            for (long val : chargeTimeList) {
                totalTime += val;
            }
            avgTime = totalTime / chargeTimeList.size();
        }
        return sdf.format(new Date(avgTime)).toString();
    }

    @Override
    public long creditsMax(List<Long> creditList) {
        long maxCredit = 0;
        if (!creditList.isEmpty()) {
            maxCredit = creditList.get(0);
            for (long val : creditList) {
                if (maxCredit < val) {
                    maxCredit = val;
                }
            }
        }
        return maxCredit;
    }
}
