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
public class DaoDevices extends DAO<Devices, Integer>  {
	public List<Cars> getCars(String name) {
		TypedQuery<Cars> query = getSession()
                .createQuery("select distinct a from Cars a inner join a.devices b where b.name = :name")
                .setParameter("name", name);
    	 return query.getResultList();
	}
	public List<Devices> getByCar(int i) {
		TypedQuery<Devices> query = getSession()
                .createQuery("select distinct a from Devices a inner join a.cars b where b.id = :id")
                .setParameter("id", i);
    	 return query.getResultList();
	}

	public List<Devices> getAll() {
		 TypedQuery<Devices> query = getSession().
				 createQuery("select d from Devices d");
		 return query.getResultList();
	}
	public List<Devices> getByIds(List<Integer> ids) {
		TypedQuery<Devices> query = getSession().
				 createQuery("select d from Devices d where d.id in (:ids)").
				 setParameter("ids",ids);
		 return query.getResultList();
	}
	public void addDevice(int id, String name, Set<Cars> cars) {
		Devices device = new Devices();
		device.setId(id);
		device.setCars(cars);
		device.setName(name);
		save(device);
	}
}