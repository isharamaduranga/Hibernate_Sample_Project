import entity.Customer;
import entity.Item;
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


        transaction.commit();
        session.close();


    }
}
