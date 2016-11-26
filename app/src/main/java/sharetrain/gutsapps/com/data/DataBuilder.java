package sharetrain.gutsapps.com.data;

public class DataBuilder {
    private String exit;
    private String arrival;
    private String train;
    private String seller;
    private String price;
    private Integer seats;

    public DataBuilder setExit(String exit) {
        this.exit = exit;
        return this;
    }

    public DataBuilder setArrival(String arrival) {
        this.arrival = arrival;
        return this;
    }

    public DataBuilder setTrain(String train) {
        this.train = train;
        return this;
    }

    public DataBuilder setSeller(String seller) {
        this.seller = seller;
        return this;
    }

    public DataBuilder setPrice(String price) {
        this.price = price;
        return this;
    }

    public DataBuilder setSeats(Integer seats) {
        this.seats = seats;
        return this;
    }

    public Data createData() {
        return new Data(exit, arrival, train, seller, price, seats);
    }
}