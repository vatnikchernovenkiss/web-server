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
public class TestModels {
	private SessionFactory s;

    private DaoDevelopers Ddevelopers;
    private DaoModels Dmodels;
    private Transaction trans;


    public void setUp()  {
        s = new Configuration().configure().buildSessionFactory();
        trans = s.getCurrentSession().beginTransaction();
        Dmodels = new DaoModels();
    	Dmodels.setSession(s);
    }

    public void shutDown() {
    	trans.commit();
        s.close();
    }
    
    @Test
    public void TestTitle() {
    	setUp();
    	List<Models> ans = Dmodels.getByTitle("Focus");
    	Assert.assertEquals(ans.size(), 1);
    	shutDown();

    }
    @Test
    public void TestDelete() {
    	setUp();
    	Dmodels.delete(Dmodels.getById(4));
    	Assert.assertNull(Dmodels.getById(4));
    	shutDown();

    }
    @Test
    public void TestUpdate() {
    	setUp();
    	Models mod = Dmodels.getById(1);
    	mod.setTitle("karoq");
    	Dmodels.update(mod);
    	mod = Dmodels.getById(1);
    	Assert.assertEquals(mod.getTitle(),"karoq");
    	shutDown();

    }
    @Test
    public void TestInsert() {
    	setUp();
        Ddevelopers =  new DaoDevelopers();
        Ddevelopers.setSession(s);
    	Developers dev = Ddevelopers.getById(1);
    	Set<Cars> car = new HashSet<Cars>();
    	Dmodels.addModel(10, "State", car, dev);
    	Assert.assertNotNull(Dmodels.getByTitle("State"));
    	shutDown();

    }
}
    