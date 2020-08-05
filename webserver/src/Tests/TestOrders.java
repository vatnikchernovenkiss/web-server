package Tests;

import DAO.*;
import Entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.text.SimpleDateFormat;  

import java.util.*;
public class TestOrders {
	private SessionFactory s;

    private DaoCars Dcars;
    private DaoClients Dclients;
    private DaoOrders Dorders;
    private Transaction trans;


    public void setUp()  {
        s = new Configuration().configure().buildSessionFactory();
        trans = s.getCurrentSession().beginTransaction();
        Dorders = new DaoOrders();
    	Dorders.setSession(s);
    }

    public void shutDown() {
    	trans.commit();
        s.close();
    }
    
    @Test
    public void TestNumber() {
    	setUp();
    	List<Orders> ans = Dorders.getByCarNumber("qezx62");
    	Assert.assertEquals(ans.size(), 1);
    	shutDown();

    }
    @Test
    public void TestStatus() {
    	setUp();
    	List<Orders> ans = Dorders.getByStatus("supply");
    	Assert.assertEquals(ans.size(), 2);
    	shutDown();

    }
    @Test
    public void TestDate() {
    	setUp();
        Dclients = new DaoClients();
        Dclients.setSession(s);
    	Date date1 = new Date(119, Calendar.DECEMBER, 31), date2 = new Date(120, Calendar.AUGUST, 1);
	    List<Clients> ans = Dclients.getByDate(date1, date2);
	    Assert.assertEquals(ans.size(),1);
    	shutDown();
    }
    
    @Test
    public void TestDelete() {
    	setUp();
    	Dorders.delete(Dorders.getById(3));
    	Assert.assertNull(Dorders.getById(3));
    	shutDown();
    }
    @Test
    public void TestUpdate() {
    	setUp();
    	Orders ord = Dorders.getById(1);
    	ord.setIf_test_drive_required(true);
    	Dorders.update(ord);
    	ord = Dorders.getById(1);
    	Assert.assertEquals(ord.getIf_test_drive_required(),true);
    	shutDown();

    }
    @Test
    public void TestInsert() {
    	setUp();
    	Dcars= new DaoCars();
        Dclients = new DaoClients();
        Dcars.setSession(s);
        Dclients.setSession(s);
    	Cars car = Dcars.getById(10);
    	Clients cli = Dclients.getById(1);
    	Dorders.addOrder(7, new Date(119, Calendar.DECEMBER, 31), "done", car, false, cli);
    	Assert.assertEquals(Dorders.getAll().size(), 6);
    	shutDown();
    	
    }
}    
