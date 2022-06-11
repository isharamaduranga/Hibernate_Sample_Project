import entity.Customer;
import entity.Item;
import entity.OrderDetails;
import entity.Orders;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfiguration;

/**
 * @author : Ishara Maduarnga
 * Project Name: hibernate_Thogakade
 * Date        : 6/11/2022
 * Time        : 5:28 PM
 * Year        : 2022
 */

public class AppInitializer {
    public static void main(String[] args) {


        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        /**  Customer (C R U D)  */

         session.save(new Customer("CI001","Piyal","Colombo",50000));
         session.save(new Customer("CI002","Nishantha","Negombo",35000));
         session.save(new Customer("CI003","Isuru","Colombo",80000));

          Customer c1 = session.get(Customer.class, "CI002");
          System.out.println(c1.getId()+" - "+c1.getName()+" - "+c1.getSalary()+" - "+c1.getAddress());

          Customer c2 = new Customer("CI003","Isuru","Bandaragama",80000);
          session.update(c2);

          session.delete(session.get(Customer.class,"CI003"));

       /**  Item (C R U D)  */
        session.save(new Item("II001","Rice",1500,50));
        session.save(new Item("II002","Noodles",650,80));
        session.save(new Item("II003","Milk",1700,200));

         Item i1 = session.get(Item.class, "II003");
        System.out.println(i1.getCode()+" - "+i1.getDescription()+" - "+i1.getUnitPrice()+" - "+i1.getQtyOnHand());

        Item i2= new Item("II003","Milk",1950,250);
        session.update(i2);

        session.delete(session.get(Item.class,"II003"));

        /**  ORDERS (C R U D)  */
        session.save(new Orders("OI001","2022-05-30",session.get(Customer.class,"CI001")));
        session.save(new Orders("OI002","2022-05-30",session.get(Customer.class,"CI001")));
        session.save(new Orders("OI003","2022-06-02",session.get(Customer.class,"CI002")));
        session.save(new Orders("OI004","2022-06-12",session.get(Customer.class,"CI002")));


        Orders o1 = session.get(Orders.class, "OI004");
        System.out.println(o1.getId()+" / "+o1.getDate());

        session.delete(o1);

        /**  ORDER DETAILS(C R U D)  */

         Orders od1 = session.get(Orders.class, "OI001");
         Orders od2 = session.get(Orders.class, "OI002");

         Item ii1 = session.get(Item.class, "II001");
         Item ii2 = session.get(Item.class, "II002");

         session.save(new OrderDetails("ODT001",od1,ii1,5, ii1.getUnitPrice()));
         session.save(new OrderDetails("ODT002",od1,ii1,10, ii2.getUnitPrice()));

        session.save(new OrderDetails("ODT003",od1,ii2,8, ii2.getUnitPrice()));
        session.save(new OrderDetails("ODT004",od2,ii1,10, ii1.getUnitPrice()));

        session.save(new OrderDetails("ODT005",od2,ii2,11, ii2.getUnitPrice()));
        session.save(new OrderDetails("ODT006",od2,ii2,9, ii2.getUnitPrice()));

       OrderDetails dd1 = session.get(OrderDetails.class, "ODT005");
       dd1.setUnitPrice(590);
       session.update(dd1);

       session.delete(session.get(OrderDetails.class,"ODT006"));


        transaction.commit();
        session.close();


    }
}
