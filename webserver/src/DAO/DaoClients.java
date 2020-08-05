package DAO;
import DAO.DAO;
import org.springframework.stereotype.Repository;

import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import Entities.*;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import java.util.Set;

import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;
@Repository
@Transactional
public class DaoClients  extends DAO<Clients, Integer>  {
	public List<Clients> getByName(String name) {
		 TypedQuery<Clients> query = getSession()
	                .createQuery("select c from Clients c where c.full_name = :name")
	                .setParameter("name", name);
	     return query.getResultList();
	}
	public List<Clients> getByDate(Date low, Date high) {
		TypedQuery<Clients> query = getSession()
                .createQuery("select distinct c from Clients c inner join c.orders o where o.date_and_time between :low and :high ")
                .setParameter("low", low)
                .setParameter("high",high);
		return query.getResultList();
	}
	public List<Clients> getByStatus(String status) {
		TypedQuery<Clients> query = getSession()
                .createQuery("select distinct c from Clients c inner join c.orders o where o.current_status ="+"\'"+status+"\'");
		return query.getResultList();
	}
	public List<Clients> getByE_mail(String e_mail) {
		 TypedQuery<Clients> query = getSession()
	                .createQuery("select c from Clients c where c.e_mail = :e_mail")
	                .setParameter("e_mail", e_mail);
	     return query.getResultList();
	} 

	public List<Clients> getAll() {
		 TypedQuery<Clients> query = getSession().
				 createQuery("select d from Clients d");
		 return query.getResultList();
	}
	public List<Clients> getByCarId(int id) {
		TypedQuery<Clients> query = getSession().
				 createQuery("select distinct c from Clients c inner join c.test_drive_cars o where o.id = :id").
				 setParameter("id",id);
		 return query.getResultList();
	}
	public List<Clients> getByIds(List<Integer> ids) {
		TypedQuery<Clients> query = getSession().
				 createQuery("select c from Clients c where c.id in (:ids)").
				 setParameter("ids",ids);
		 return query.getResultList();
	}
	public void addClient(int id, String phone, String e_mail, String full_name, Set<Orders> orders, Set<Cars> test_drive_cars,
			int hashed_password, String address) {
		Clients client = new Clients();
		client.setId(id);
		client.setPhone(phone);
		client.setE_mail(e_mail);
		client.setFull_name(full_name);
		client.setOrders(orders);
		client.setTest_drive_cars(test_drive_cars);
		client.setHashed_password(hashed_password);
		client.setAddress(address);
		save(client);
	}
}
