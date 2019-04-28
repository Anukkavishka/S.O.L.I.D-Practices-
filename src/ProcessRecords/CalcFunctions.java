package ProcessRecords;

import java.util.List;

public interface CalcFunctions {
    public String chargeTimeAvg(List<Long> chargeTimeList);
    public long creditsMax(List<Long> creditList);
    public String ChargeTimeTotal(List<Long> chargeTimeList);
    public long creditsTotal(List<Long> creditList);
}
