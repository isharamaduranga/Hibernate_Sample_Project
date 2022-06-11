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
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer{
    @Id
    private String id;
    private String name;
    private String address;
    private String salary;
    @OneToMany
    private List<Order> orderList= new ArrayList<>();
    public Customer() {
    }

    public Customer(String id, String name, String address, String salary, List<Order> orderList) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.orderList = orderList;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", salary='" + salary + '\'' +
                ", orderList=" + orderList +
                '}';
    }
}
