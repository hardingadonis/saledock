
import io.hardingadonis.saledock.dao.ICustomerDAO;
import io.hardingadonis.saledock.dao.impl.CustomerDAOImpl;
import io.hardingadonis.saledock.model.Customer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * to change this license Click
 * nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this
 * template
 */

/**
 *
 * @author LINH
 */
public class TestCus {
  public static void main(String[] args) {
    CustomerDAOImpl dao = new CustomerDAOImpl();

    Customer cus = new Customer();
    cus.setName("eeee");
    cus.setCode("K");
    cus.setAddress("rrr");
    cus.setEmail("a@gmail.com");

    System.out.println(dao.insert(cus));
  }
}
