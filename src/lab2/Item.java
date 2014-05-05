package lab2;

import java.math.BigDecimal;
import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Created by jjensen on 4/23/14.
 */
public class Item {
    private String id;
    private double currentBid;
    private DateTime experationDate;
    private DateTimeFormatter formatter = DateTimeFormat.forPattern("MM/dd/yyyy");

    public Item (String id, String experationDate) {
        this.id = id;
        this.experationDate = formatter.parseDateTime(experationDate);
        this.currentBid = 0.00;
    }

    public Item() {

    }

    public String getId() {
        return id;

    }

    public void setId(String id) {
        this.id = id;
    }


    public double getCurrentBid() {
        return currentBid;
    }

    public void setBid(String amount) {
        currentBid = Double.parseDouble(amount);
    }

    public int getTimeLeft() {
        DateTime now = new DateTime();
        int days = Days.daysBetween(now.withTimeAtStartOfDay(), experationDate.withTimeAtStartOfDay()).getDays();
        return days;

    }

    public void setExperationDate(DateTime date) {
        experationDate = date;
    }

    public DateTime getExperation() {
        return experationDate;
    }


}
