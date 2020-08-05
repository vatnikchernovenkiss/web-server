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

import static org.testng.Assert.assertNotNull;

import java.text.SimpleDateFormat;  

import java.util.*;
public class TestClients {
	private SessionFactory s;
    private DaoCars Dcars;
    private DaoClients Dclients;
    private Transaction trans;

    public void setUp()  {
        s = new Configuration().configure().buildSessionFactory();
        trans = s.getCurrentSession().beginTransaction();
        Dclients = new DaoClients();
    	Dclients.setSession(s);
    }

    public void shutDown() {
    	trans.commit();
        s.close();
    }
    @Test
    public void TestName() {
    	setUp();
    	List<Clients> ans = Dclients.getByName("Arseniy Veselov");
    	Assert.assertEquals(ans.size(), 1);
    	shutDown();
    }
    @Test
    public void TestDate() {
    	setUp();
    	Date date1 = new Date(119, Calendar.DECEMBER, 31), date2 = new Date(120, Calendar.AUGUST, 1);
	    List<Clients> ans = Dclients.getByDate(date1, date2);
	    Assert.assertEquals(ans.size(),1);
	    shutDown();
      
    }
    @Test
    public void TestStatus() {
    	setUp();
	    List<Clients> ans = Dclients.getByStatus("supply");
	    Assert.assertEquals(ans.size(), 3);
	    shutDown();
      
    }
    @Test
    public void TestE_mail() {
    	setUp();
	    List<Clients> ans = Dclients.getByE_mail("6969696@mail.ru");
	    Assert.assertEquals(ans.size(), 1);
	    shutDown();
      
    }
    @Test
    public void TestDelete() {
    	setUp();
    	Dclients.delete(Dclients.getById(6));
    	Assert.assertNull(Dclients.getById(6));
    	shutDown();
    }
    @Test
    public void TestUpdate() {
    	setUp();
    	Clients cli = Dclients.getById(1);
    	cli.setE_mail("vv@mail.ru");
    	Dclients.update(cli);
    	cli = Dclients.getById(1);
    	Assert.assertEquals(cli.getE_mail(),"vv@mail.ru");
    	shutDown();
    }
    @Test
    public void TestInsert() {
    	setUp();
        Dcars = new DaoCars();
        Dcars.setSession(s);  
    	Set<Cars> cars = new HashSet<Cars>();
    	cars.add(Dcars.getById(3));
    	Set<Orders> ord = new HashSet<Orders>();
    	Dclients.addClient(10,"Evgeny Erikhov","dml@mail.ru", "8-999-366-22-11",ord,cars,34333,"Moscow, Shosse Entuziastov");
    	assertNotNull(Dclients.getByName("Evgeny Erikhov"));
    	shutDown();
    	
    }
}