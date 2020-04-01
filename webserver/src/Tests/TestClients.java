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

import static org.testng.Assert.assertNotNull;

import java.text.SimpleDateFormat;  

import java.util.*;
public class TestClients {
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
    public void TestName() {
    	Dclients.setSession(s);
    	List<Clients> ans = Dclients.getByName("Arseniy Veselov");
    	Assert.assertEquals(ans.size(), 1);
    }
    @Test
    public void TestDate() {
    	Dclients.setSession(s);
    	Date date1 = new Date(119, Calendar.DECEMBER, 31), date2 = new Date(120, Calendar.AUGUST, 1);
	    List<Clients> ans = Dclients.getByDate(date1, date2);
	    Assert.assertEquals(ans.size(),1);
      
    }
    @Test
    public void TestStatus() {
    	Dclients.setSession(s);
	    List<Clients> ans = Dclients.getByStatus("supply");
	    Assert.assertEquals(ans.size(), 3);
      
    }
    @Test
    public void TestE_mail() {
    	Dclients.setSession(s);
	    List<Clients> ans = Dclients.getByE_mail("6969696@mail.ru");
	    Assert.assertEquals(ans.size(), 1);
      
    }
    @Test
    public void TestDelete() {
    	Dclients.setSession(s);
    	Dclients.delete(Dclients.getById(6));
    	Assert.assertNull(Dclients.getById(6));
    }
    @Test
    public void TestUpdate() {
    	Dclients.setSession(s);
    	Clients cli = Dclients.getById(1);
    	cli.setE_mail("vv@mail.ru");
    	Dclients.update(cli);
    	cli = Dclients.getById(1);
    	Assert.assertEquals(cli.getE_mail(),"vv@mail.ru");
    }
    @Test
    public void TestInsert() {
    	Dclients.setSession(s);
    	Dcars.setSession(s);
    	Dorders.setSession(s);
    	Set<Cars> cars = new HashSet();
    	cars.add(Dcars.getById(3));
    	Set<Orders> ord = new HashSet();
    	Dclients.addClient(10,"Evgeny Erikhov","dml@mail.ru", "8-999-366-22-11",ord,cars,34333,"Moscow, Shosse Entuziastov");
    	assertNotNull(Dclients.getByName("Evgeny Erikhov"));
    	
    }
}