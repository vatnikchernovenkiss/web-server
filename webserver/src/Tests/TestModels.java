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
public class TestModels {
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
    public void TestTitle() {
    	Dmodels.setSession(s);
    	List<Models> ans = Dmodels.getByTitle("Focus");
    	Assert.assertEquals(ans.size(), 1);
    }
    @Test
    public void TestDelete() {
    	Dmodels.setSession(s);
    	Dmodels.delete(Dmodels.getById(10));
    	Assert.assertNull(Dmodels.getById(10));
    }
    @Test
    public void TestUpdate() {
    	Dmodels.setSession(s);
    	Models mod = Dmodels.getById(1);
    	mod.setTitle("karoq");
    	Dmodels.update(mod);
    	mod = Dmodels.getById(1);
    	Assert.assertEquals(mod.getTitle(),"karoq");
    }
    @Test
    public void TestInsert() {
    	Dmodels.setSession(s);
    	Ddevelopers.setSession(s);
    	Developers dev = Ddevelopers.getById(1);
    	Set<Cars> car = new HashSet<Cars>();
    	Dmodels.addModel(10, "State", car, dev);
    	Assert.assertNotNull(Dmodels.getByTitle("State"));
    }
}
    