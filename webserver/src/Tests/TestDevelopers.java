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
public class TestDevelopers {
	private SessionFactory s;

    private DaoDevelopers Ddevelopers;
    private Transaction trans;

    public void setUp()  {
        s = new Configuration().configure().buildSessionFactory();
        trans = s.getCurrentSession().beginTransaction();
        Ddevelopers =  new DaoDevelopers();
    	Ddevelopers.setSession(s);
 
    }

    public void shutDown() {
        trans.commit();
        s.close();
    }
    @Test
    public void TestModels() {
    	setUp();
    	List<Models> ans = Ddevelopers.getModels("Nissan");
    	Assert.assertEquals(ans.size(), 2);
    	shutDown();

    }
    public void TestCars() {
    	setUp();
    	List<Cars> ans = Ddevelopers.getCars("Nissan");
    	Assert.assertEquals(ans.size(), 0);
    	shutDown();
    }
    @Test
    public void TestDelete() {    	
    	setUp();
    	Ddevelopers.delete(Ddevelopers.getById(5));
    	Assert.assertNull(Ddevelopers.getById(5));
    	shutDown();

    }
    @Test
    public void TestUpdate() {
    	setUp();
    	Developers dev = Ddevelopers.getById(1);
    	dev.setName("Shkodaa");
    	Ddevelopers.update(dev);
    	dev = Ddevelopers.getById(1);
    	Assert.assertEquals(dev.getName(),"Shkodaa");
    	shutDown();

    }
    @Test
    public void TestInsert() {
    	setUp();
    	Ddevelopers.addDeveloper(11, "Motors", new HashSet<Models>(), new HashSet<Cars>());
    	Assert.assertEquals(Ddevelopers.getAll().size(), 5);
    	shutDown();

    }
}