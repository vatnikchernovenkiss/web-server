package Tests;

import DAO.*;
import Entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.text.SimpleDateFormat;  

import java.util.*;
public class TestOrders {
	private Session s;
    private DaoCars Dcars= new DaoCars();
    private DaoClients Dclients = new DaoClients();
    private DaoDevelopers Ddevelopers =  new DaoDevelopers();
    private DaoDevices Ddevices= new DaoDevices();
    private DaoOrders Dorders = new DaoOrders();
    private DaoModels Dmodels = new DaoModels();
    @BeforeClass
    public void CreateSession() {
    	s = new Configuration().configure().buildSessionFactory().openSession();
    }
    @Test
    public void TestNumber() {
    	Dorders.setSession(s);
    	List<Orders> ans = Dorders.getByCarNumber("qasw23");
    	Assert.assertEquals(ans.size(), 1);
    }
    @Test
    public void TestStatus() {
    	Dorders.setSession(s);
    	List<Orders> ans = Dorders.getByStatus("supply");
    	Assert.assertEquals(ans.size(), 4);
    }
    @Test
    public void TestDate() {
    	Dclients.setSession(s);
    	Date date1 = new Date(119, Calendar.DECEMBER, 31), date2 = new Date(120, Calendar.AUGUST, 1);
	    List<Clients> ans = Dclients.getByDate(date1, date2);
	    Assert.assertEquals(ans.size(),1);
      
    }
    @Test
    public void TestDelete() {
    	Dorders.setSession(s);
    	Dorders.delete(Dorders.getById(10));
    	Assert.assertNull(Dorders.getById(10));
    }
    @Test
    public void TestUpdate() {
    	Dorders.setSession(s);
    	Orders ord = Dorders.getById(1);
    	ord.setIf_test_drive_required(true);
    	Dorders.update(ord);
    	ord = Dorders.getById(1);
    	Assert.assertEquals(ord.getIf_test_drive_required(),true);
    }
    @Test
    public void TestInsert() {
    	Dcars.setSession(s);
    	Dclients.setSession(s);
    	Dorders.setSession(s);
    	Cars car = Dcars.getById(10);
    	Clients cli = Dclients.getById(1);
    	Dorders.addOrder(7, new Date(119, Calendar.DECEMBER, 31), "done", car, false, cli);
    	Assert.assertEquals(Dorders.getAll().size(), 11);
    	
    }
}    
