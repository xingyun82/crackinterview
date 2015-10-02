package design.tablebook;

import java.util.Date;

/**
 * Created by xingyun on 9/17/15.
 */
public class TableOrder {

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getBookTime() {
        return bookTime;
    }

    public void setBookTime(Date bookTime) {
        this.bookTime = bookTime;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String toString() {
        String res = "orderId:" + orderId + ", tableId:" + tableId +
                ", startTime:" + startTime + ", bookTime:" + bookTime +
                ", contactName:" + contactName + ", contanctPhone:" + contactPhone;
        return res;
    }


    private int orderId;
    private int tableId;
    private Date startTime;
    private Date endTime;
    private Date bookTime;
    private String contactName;
    private String contactPhone;


}
