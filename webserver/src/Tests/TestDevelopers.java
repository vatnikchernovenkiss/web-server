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
public class TestDevelopers {
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
    public void TestModels() {
    	Ddevelopers.setSession(s);
    	List<Models> ans = Ddevelopers.getModels("Nissan");
    	Assert.assertEquals(ans.size(), 2);
    }
    public void TestCars() {
    	Ddevelopers.setSession(s);
    	List<Cars> ans = Ddevelopers.getCars("Nissan");
    	Assert.assertEquals(ans.size(), 0);
    }
    @Test
    public void TestDelete() {
    	Ddevelopers.setSession(s);
    	Ddevelopers.delete(Ddevelopers.getById(5));
    	Assert.assertNull(Ddevelopers.getById(5));
    }
    @Test
    public void TestUpdate() {
    	Ddevelopers.setSession(s);
    	Developers dev = Ddevelopers.getById(1);
    	dev.setName("Shkodaa");
    	Ddevelopers.update(dev);
    	dev = Ddevelopers.getById(1);
    	Assert.assertEquals(dev.getName(),"Shkodaa");
    }
    @Test
    public void TestInsert() {
    	Ddevelopers.setSession(s);
    	Ddevelopers.addDeveloper(11, "Motors", new HashSet<Models>(), new HashSet<Cars>());
    	Assert.assertEquals(Ddevelopers.getAll().size(), 5);
    }
}