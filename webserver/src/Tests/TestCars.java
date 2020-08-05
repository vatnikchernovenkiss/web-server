package Tests;

import DAO.*;
import Entities.*;
import org.hibernate.Transaction;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.testng.Assert;

import org.testng.annotations.Test;

import java.util.*;
public class TestCars {
	private SessionFactory s;
    private DaoCars DCars;
    private DaoClients Dclients;
    private DaoDevices Ddevices;
    private DaoOrders Dorders;
    private DaoModels Dmodels;
    private DaoDevelopers Ddevelopers;

    private Transaction trans;

    public void setUp()  {
        s = new Configuration().configure().buildSessionFactory();
        trans = s.getCurrentSession().beginTransaction();
        DCars= new DaoCars();
        DCars.setSession(s);
 
    }

    public void shutDown() {
    	trans.commit();
        s.close();
    }
    @Test
    public void TestDevice() {
    	setUp();

    	List<Cars> ans = DCars.getByDeviceName("video");
    	Assert.assertEquals(ans.size(), 2);
    	 shutDown();
    }
    @Test
    public void TestTestDrive() {
    	setUp();
    	List<Cars> ans = DCars.getByTest_drive_client_name("Rodion Sulzhenko");
    	shutDown();
    	Assert.assertEquals(ans.size(), 3);
    }
    @Test
    public void TestModel() {
    	setUp();
    	List<Cars> ans = DCars.getByModelTitle("Fusion");
    	shutDown();

    	Assert.assertEquals(ans.size(), 2);

    }
    @Test
    public void TestPrice() {
    	setUp();
    	List<Cars> ans = DCars.getByPrice(200000,500000);
    	shutDown();

    	Assert.assertEquals(ans.size(), 2);

    }
    @Test
    public void TestNumber() {
    	setUp();
    	List<Cars> ans = DCars.getByRegistrationNumber("sqwe13");
    	shutDown();

    	Assert.assertEquals(ans.size(), 1);

    }
   @Test
    public void TestDelete() {
	   setUp();
    	DCars.delete(DCars.getById(10));
    	Assert.assertNull(DCars.getById(10));
    	shutDown();

    	
    }
    @Test
    public void TestUpdate() {
    	setUp();
    	Cars car = DCars.getById(1);
    	car.setNumber_of_seats(5);
    	DCars.update(car);
    	car = DCars.getById(1);
    	Assert.assertEquals(car.getNumber_of_seats(),5);
    	shutDown();
    }
    @Test
    public void TestAll() {
    	setUp();
    	List<Cars> l = DCars.getAll();
    	shutDown();

    	Assert.assertEquals(l.isEmpty(), false);
    }
    @Test
    public void TestInsert() {
    	setUp();
        Dclients = new DaoClients();
        Ddevices= new DaoDevices();
        Dorders = new DaoOrders();
        Dmodels = new DaoModels();
        Ddevelopers = new DaoDevelopers();
        Dclients.setSession(s);
        Ddevices.setSession(s);
        Dorders.setSession(s);
        Dmodels.setSession(s);
        Ddevelopers.setSession(s);
    	Set<Clients> cli = new HashSet<Clients>();
    	cli.add(Dclients.getById(1));
    	Set<Orders> ord = new HashSet<Orders>(Dorders.getByStatus("supply"));
    	Set<Devices> dev  = new HashSet<Devices>();
    	dev.add(Ddevices.getById(4));
    	DCars.addCar(11,Dmodels.getById(1),"ayaya999",4,"Cotton",1, new Date(119, Calendar.DECEMBER, 31),cli,300,
    			"Green",400,3,Ddevelopers.getById(2),ord,dev);
    	List<Cars> ans = DCars.getByRegistrationNumber("ayaya999");
    	shutDown();

    	Assert.assertEquals(ans.size(), 1);
    }
}
