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
public class TestDevices {
	private SessionFactory s;

    private DaoCars Dcars;
    private Transaction trans;

    private DaoDevices Ddevices;

    public void setUp()  {
        s = new Configuration().configure().buildSessionFactory();
        trans = s.getCurrentSession().beginTransaction();
        Ddevices= new DaoDevices();
    	Ddevices.setSession(s);
    }

    public void shutDown() {
        trans.commit();
        s.close();
    }
    
    @Test
    public void TestCars() {
    	setUp();
    	List<Cars> ans = Ddevices.getCars("bluetooth");
    	Assert.assertEquals(ans.size(), 2);
    	shutDown();
    }
    
    @Test
    public void TestDelete() {
    	setUp();
    	Ddevices.delete(Ddevices.getById(8));
    	Assert.assertNull(Ddevices.getById(8));
    	shutDown();
    	

    }
    @Test
    public void TestUpdate() {
    	setUp();
    	Devices dev = Ddevices.getById(1);
    	dev.setName("wipers");
    	Ddevices.update(dev);
    	dev = Ddevices.getById(1);
    	Assert.assertEquals(dev.getName(),"wipers");
    	shutDown();

    }
    @Test
    public void TestInsert() {
    	setUp();
        Dcars= new DaoCars();
        Dcars.setSession(s);
    	Set<Cars> cars = new HashSet<Cars>();
    	cars.add(Dcars.getById(3));
    	Ddevices.addDevice(4,"hinged roof",cars);
    	Assert.assertEquals(Ddevices.getAll().size(),8);
    	shutDown();

    }
}