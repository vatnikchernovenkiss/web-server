package DAO;
import DAO.DAO;
import Entities.*;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.sql.Timestamp;

import java.util.Set;

import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;
@Repository
@Transactional
public class DaoCars extends DAO<Cars, Integer> {
	public List<Cars> getByDeviceName(String name) {
		 TypedQuery<Cars> query = getSession()
	                .createQuery("select  c from Cars c inner join c.devices d where Lower(d.name) = lower(:name)")
	                .setParameter("name", name);
	     return query.getResultList();
	}
	public List<Cars> getByTest_drive_client_name(String name) {
		 TypedQuery<Cars> query = getSession()
	                .createQuery("select  c from Cars c inner join c.test_drive_clients t where t.full_name = :name")
	                .setParameter("name", name);
	     return query.getResultList();
	}
	public List<Cars> getByRegistrationNumber(String number) {
		TypedQuery<Cars> query = getSession()
                .createQuery("select  c from Cars c where c.registration_number = :registration_number")
                .setParameter("registration_number", number);
     return query.getResultList();
	}
	public List<Cars> getByModelTitle(String title) {
		 TypedQuery<Cars> query = getSession()
	                .createQuery("select  c from Cars c inner join c.model_id m where m.title = :title")
	                .setParameter("title", title);
	     return query.getResultList();
	}
	public List<Cars> getByPrice(double low, double high) {
		 TypedQuery<Cars> query = getSession()
	                .createQuery("select  c from Cars c where c.price between :low and :high ")
	                .setParameter("high", high)
	                .setParameter("low", low);
	     return query.getResultList();
	}

	public List<Cars> getAll() {
		 TypedQuery<Cars> query = getSession().
				 createQuery("select d from Cars d");
		 return query.getResultList();
	}
	
	public void addCar(int id, Models model, String registration_number,int number_of_seats, String upholstery, double price,
				Date last_maintenance_date, Set<Clients> test_drive_clients,double milage, String car_colour, double engine_power,
				int number_of_doors, Developers developer, Set<Orders> orders, Set<Devices> devices) {
			Cars NewCar = new Cars();
			NewCar.setOrders(orders);
			NewCar.setDevices(devices);
			NewCar.setDeveloper_id(developer);
			NewCar.setNumber_of_doors(number_of_doors);
			NewCar.setEngine_power(engine_power);
			NewCar.setCar_colour(car_colour);
			NewCar.setMilage(milage);
			NewCar.setTest_drive_clients(test_drive_clients);
			NewCar.setLast_maintance_date(last_maintenance_date);
			NewCar.setPrice(price);
			NewCar.setUpholstery(upholstery);
			NewCar.setNumber_of_seats(number_of_seats);
			NewCar.setRegistration_number(registration_number);
			NewCar.setModel_id(model);
			//NewCar.setId(id);
			save(NewCar);
	}
}
