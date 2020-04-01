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
public class TestDevices {
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
    public void TestCars() {
    	Ddevices.setSession(s);
    	List<Cars> ans = Ddevices.getCars("bluetooth");
    	Assert.assertEquals(ans.size(), 3);
    }
    @Test
    public void TestDelete() {
    	Ddevices.setSession(s);
    	Ddevices.delete(Ddevices.getById(8));
    	Assert.assertNull(Ddevices.getById(8));
    }
    @Test
    public void TestUpdate() {
    	Ddevices.setSession(s);
    	Devices dev = Ddevices.getById(1);
    	dev.setName("wipers");
    	Ddevices.update(dev);
    	dev = Ddevices.getById(1);
    	Assert.assertEquals(dev.getName(),"wipers");
    }
    @Test
    public void TestInsert() {
    	Ddevices.setSession(s);
    	Dcars.setSession(s);
    	Set<Cars> cars = new HashSet<Cars>();
    	cars.add(Dcars.getById(3));
    	Ddevices.addDevice(4,"hinged roof",cars);
    	Assert.assertEquals(Ddevices.getAll().size(),9);
    }
}