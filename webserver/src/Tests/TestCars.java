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
public class TestCars {
	private Session s;
    private DaoCars DCars= new DaoCars();
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
    public void TestDevice() {
    	DCars.setSession(s);
    	List<Cars> ans = DCars.getByDeviceName("video");
    	Assert.assertEquals(ans.size(), 2);
    }
    @Test
    public void TestTestDrive() {
    	DCars.setSession(s);
    	List<Cars> ans = DCars.getByTest_drive_client_name("Rodion Sulzhenko");
    	Assert.assertEquals(ans.size(), 3);
    }
    @Test
    public void TestModel() {
    	DCars.setSession(s);
    	List<Cars> ans = DCars.getByModelTitle("Fusion");
    	Assert.assertEquals(ans.size(), 2);

    }
    @Test
    public void TestPrice() {
    	DCars.setSession(s);
    	List<Cars> ans = DCars.getByPrice(200000,500000);
    	Assert.assertEquals(ans.size(), 2);

    }
    @Test
    public void TestNumber() {
    	DCars.setSession(s);
    	List<Cars> ans = DCars.getByRegistrationNumber("sqwe13");
    	Assert.assertEquals(ans.size(), 1);

    }
   @Test
    public void TestDelete() {
    	DCars.setSession(s);
    	DCars.delete(DCars.getById(10));
    	Assert.assertNull(DCars.getById(10));
    }
    @Test
    public void TestUpdate() {
    	DCars.setSession(s);
    	Cars car = DCars.getById(1);
    	car.setNumber_of_seats(5);
    	DCars.update(car);
    	car = DCars.getById(1);
    	Assert.assertEquals(car.getNumber_of_seats(),5);
    }
}
