/**
 * @author : Ishara Maduarnga
 * Project Name: hibernate_Thogakade
 * Date        : 6/11/2022
 * Time        : 5:44 PM
 * Year        : 2022
 */

package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Orders {
    @Id
    private String id;
    private String date;
    @ManyToOne
    private Customer customer;


    @OneToMany(mappedBy = "orders")
    private List<OrderDetails> orderDetailsList = new ArrayList<>();


    public Orders() {
    }

    public Orders(String id, String date, Customer customer) {
        this.id = id;
        this.date = date;
        this.customer = customer;
    }

    public Orders(String id, String date, Customer customer, List<OrderDetails> orderDetailsList) {
        this.id = id;
        this.date = date;
        this.customer = customer;
        this.orderDetailsList = orderDetailsList;
    }

    public List<OrderDetails> getOrderDetailsList() {
        return orderDetailsList;
    }

    public void setOrderDetailsList(List<OrderDetails> orderDetailsList) {
        this.orderDetailsList = orderDetailsList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", customer=" + customer +
                ", orderDetailsList=" + orderDetailsList +
                '}';
    }
}
