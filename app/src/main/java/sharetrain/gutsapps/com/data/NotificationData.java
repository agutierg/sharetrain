package sharetrain.gutsapps.com.data;

import java.util.Date;

/**
 * Created by Alejandro Gutierrez on 24/11/2016.
 */

public class NotificationData {

    private String from;
    private String to;
    private Date dateOfSubmit;
    private String user;

    public NotificationData(String from, String to, Date dateOfSubmit, String user) {
        this.from = from;
        this.to = to;
        this.dateOfSubmit = dateOfSubmit;
        this.user = user;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Date getDateOfSubmit() {
        return dateOfSubmit;
    }

    public void setDateOfSubmit(Date dateOfSubmit) {
        this.dateOfSubmit = dateOfSubmit;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
