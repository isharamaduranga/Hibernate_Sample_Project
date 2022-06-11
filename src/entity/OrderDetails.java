/**
 * @author : Ishara Maduarnga
 * Project Name: hibernate_Thogakade
 * Date        : 6/11/2022
 * Time        : 5:45 PM
 * Year        : 2022
 */

package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrderDetails {
    @Id
    private String id;
    @ManyToOne
    private Orders orders;
    @ManyToOne
    private Item item;

    private int qty;
    private double unitPrice;

    public OrderDetails(String id, Orders orders, Item item, int qty, double unitPrice) {
        this.setId(id);
        this.setOrders(orders);
        this.setItem(item);
        this.setQty(qty);
        this.setUnitPrice(unitPrice);
    }

    public OrderDetails() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "id='" + id + '\'' +
                ", orders=" + orders +
                ", item=" + item +
                ", qty=" + qty +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
