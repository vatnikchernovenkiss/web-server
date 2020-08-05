package DAO;
import DAO.DAO;
import Entities.*;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import java.util.Set;

import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Repository;

import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.sql.Timestamp;
@Repository
@Transactional
public class DaoOrders  extends DAO<Orders, Integer> {
	public List<Orders> getByCarNumber(String number) {
		 TypedQuery<Orders> query = getSession()
	                .createQuery("select o from Orders o inner join o.car_id c where c.registration_number = :registration_number")
	                .setParameter("registration_number", number);
	     return query.getResultList();
	}
	public List<Orders> getByStatus(String status) {
		TypedQuery<Orders> query = getSession()
                .createQuery("select o from Orders o where o.current_status = "+"\'"+status+"\'");
		return query.getResultList();
	}
	public List<Orders> getByDate(Date low, Date high) {
		TypedQuery<Orders> query = getSession()
                .createQuery("select o from Orders o where date_and_time between :low and :high ")
                .setParameter("low", low)
                .setParameter("high",high);
		return query.getResultList();
	}

	public List<Orders> getAll() {
		 TypedQuery<Orders> query = getSession().
				 createQuery("select d from Orders d");
		 return query.getResultList();
	}
	public void addOrder(int id, Date date, String status, Cars car, boolean test_drive, Clients client) {
		Orders order = new Orders();
		order.setIf_test_drive_required(test_drive);
		order.setId(id);
		order.setCar_id(car);
		order.setClient_id(client);
		order.setDate_and_time(date);
		order.setCurrent_status(status);
		save(order);
	}
}
