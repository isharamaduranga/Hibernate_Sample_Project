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

@Entity
public class Orders {
    @Id
    private String id;
    private String date;
    @ManyToOne
    private Customer customer;


    public Orders() {
    }

    public Orders(String id, String date, Customer customer) {
        this.id = id;
        this.date = date;
        this.customer = customer;
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
                '}';
    }
}
