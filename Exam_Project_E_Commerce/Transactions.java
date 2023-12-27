import java.util.ArrayList;
import java.util.Iterator;

public class Transactions {
    ArrayList<Order> listOrders = new ArrayList<>();

    public void addOrder(Order order)
    {
        listOrders.add(order);
    }

    public void removeOrder(int idOrder)
    {
        Iterator<Order> iterator = listOrders.iterator();
        while (iterator.hasNext()) {
            Order order = iterator.next();
            if (order.idOrder == idOrder) {
                iterator.remove();
                System.out.println("Order: " + idOrder + " removed successfully");
            }
        }
    }

    public void displayOrders()
    {
        if(listOrders.isEmpty())
            System.out.println("Empty");
        else
        {
            for (Order order : listOrders) {
                System.out.println(order);
            }
        }
    }
}
