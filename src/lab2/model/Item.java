package lab2.model;

import java.math.BigDecimal;
import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Created by jjensen on 4/23/14.
 */
public class Item {
    private long id;
    private BigDecimal currentBid;
    private DateTime experationDate;
    private DateTimeFormatter formatter = DateTimeFormat.forPattern("MM/dd/yyyy");

    public Item (long id, String experationDate) {
        this.id = id;
        this.experationDate = formatter.parseDateTime(experationDate);
        this.currentBid = new BigDecimal("0.00");
    }

    public Item() {

    }

    public long getId() {
        return id;

    }

    public void setId(long id) {
        this.id = id;
    }


    public BigDecimal getCurrentBid() {
        return currentBid;
    }

    public void setBid(String amount) {
        currentBid = new BigDecimal(amount);
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
