import org.hibernate.Session;


import DAO.*;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import Entities.*;
public class DBMan {
    public static void main(String[] args) {
       Session s = new Configuration().configure().buildSessionFactory().getCurrentSession();

	}
}
