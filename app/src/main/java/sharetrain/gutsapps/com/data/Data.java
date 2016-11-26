package sharetrain.gutsapps.com.data;

/**
 * Created by Alejandro Gutierrez on 12/11/2016.
 */

public class Data {
    private String exit;
    private String arrival;
    private String train;
    private String seller;
    private String price;
    private Integer seats;

    public Data(String exit, String arrival, String train, String seller, String price, Integer seats) {
        this.exit = exit;
        this.arrival = arrival;
        this.train = train;
        this.seller = seller;
        this.price = price;
        this.seats = seats;
    }

    public String getExit() {
        return exit;
    }

    public void setExit(String exit) {
        this.exit = exit;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getTrain() {
        return train;
    }

    public void setTrain(String train) {
        this.train = train;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }
}
