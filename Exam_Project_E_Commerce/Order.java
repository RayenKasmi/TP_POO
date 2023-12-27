import java.time.LocalDate;


public class Order {
    protected static int numberOrders;
    protected int idOrder;
    protected int idCustomer;
    protected int idProduct;
    protected int quantity;
    protected double priceUnit;
    protected LocalDate date;

    public Order(int idCustomer, int idProduct, int quantity, double priceUnit) {
        this.idOrder=numberOrders;
        this.idCustomer = idCustomer;
        this.idProduct = idProduct;
        this.quantity = quantity;
        this.priceUnit = priceUnit;
        this.date=LocalDate.now();
        numberOrders++;
    }

    @Override
    public String toString() {
        return "Order: " +
                "idOrder= " + idOrder +
                "| idCustomer= " + idCustomer +
                "| idProduct= " + idProduct +
                "| quantity= " + quantity +
                "| priceUnit= " + priceUnit +
                "| date= " + date;
    }
}
