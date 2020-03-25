package DAO;
import DAO.DAO;

import Entities.*;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import java.util.Set;

import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

public class DaoDevices extends DAO<Devices, Integer>  {
	public List<Cars> getCars(String name) {
		TypedQuery<Cars> query = getSession()
                .createQuery("select distinct a from Cars a inner join a.devices b where b.name = :name")
                .setParameter("name", name);
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