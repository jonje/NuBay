package lab2.model;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.math.BigDecimal;

/**
 * Created by jjensen on 4/23/14.
 */
public class Item {
    private long id;
    private BigDecimal currentBid;
    private DateTime experationDate;
    private DateTimeFormatter formatter = DateTimeFormat.forPattern("MM/dd/yyyy");
    private String imgUrl;

    public Item (long id, String imgUrl, String experationDate) {
        this.id = id;
        this.experationDate = formatter.parseDateTime(experationDate);
        this.currentBid = new BigDecimal("0.00");
        this.imgUrl = imgUrl;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setExperationDate(DateTime date) {
        experationDate = date;
    }

    public DateTime getExperation() {
        return experationDate;
    }


}
