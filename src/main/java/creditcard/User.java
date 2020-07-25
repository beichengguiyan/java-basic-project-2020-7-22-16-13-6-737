package creditcard;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class User {
    private BigDecimal totalPoints;
    private List<Consumption> consumeRecord;

    public User() {
        this.totalPoints = new BigDecimal("0");
        consumeRecord = new ArrayList<>();
    }

    public BigDecimal getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(BigDecimal totalPoints) {
        this.totalPoints = totalPoints;
    }

    public List<Consumption> getConsumeRecord() {
        return consumeRecord;
    }

    public void setConsumeRecord(List<Consumption> consumeRecord) {
        this.consumeRecord = consumeRecord;
    }

    public void addConsumeRecord(Consumption consumption) {
        consumeRecord.add(consumption);
    }
}
