package edu.neumont.jjensen.model;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.swing.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;

/**
 * Created by jjensen on 4/23/14.
 */
public class Item {
    private long id;
    private BigDecimal currentBid;
    private BigDecimal startingBid;
    private DateTime expirationDate;
    private DateTimeFormatter formatter = DateTimeFormat.forPattern("MM/dd/yyyy");
    private String imgUrl;
    private String title;
    private String description;
    private int numberOfBids = 0;


    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getStartingBid() {

        return startingBid;
    }

    public void setStartingBid(String startingBid) {

        this.startingBid = new BigDecimal(startingBid);
    }

    public String getDescription() {
        return description;
    }

    public Item (long id, String title, String description, String startingBid, String imgUrl, String expirationDate) {
        this.id = id;
        this.expirationDate = formatter.parseDateTime(expirationDate);
        this.currentBid = new BigDecimal("0.00");
        this.imgUrl = imgUrl;
        this.title = title;
        this.startingBid = new BigDecimal(startingBid);
        this.description = description;


    }

    public Item() {
        currentBid = new BigDecimal("0.00");

    }

    public int getNumberOfBids() {
        return numberOfBids;
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
        numberOfBids++;
    }

    public int getTimeLeft() {
        DateTime now = new DateTime();
        int days = Days.daysBetween(now.withTimeAtStartOfDay(), expirationDate.withTimeAtStartOfDay()).getDays();
        return days;

    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setExpirationDate(String date) {
        expirationDate = formatter.parseDateTime(date);
    }

    public void setExpirationDate(DateTime date) {
        expirationDate = date;
    }

    public String getFormattedExpiration() {
        DateTimeFormatter dateParser = DateTimeFormat.forPattern("MM/dd/yyyy");
        String formattedDate = dateParser.print(expirationDate);

        return formattedDate;
    }

    public DateTime getExpiration() {
        return expirationDate;
    }

    public boolean isBidGreater(String bid) {
        BigDecimal newBid = new BigDecimal(bid);
        return currentBid.compareTo(newBid) < 0;
    }

    public boolean isBidGreaterThanStarting(String bid) {
        BigDecimal newBid = new BigDecimal(bid);
        return startingBid.compareTo(newBid) <= 0;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }


}
