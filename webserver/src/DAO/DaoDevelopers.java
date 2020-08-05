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
public class DaoDevelopers  extends DAO<Developers, Integer>  {
	public List<Models> getModels(String name) {
		TypedQuery<Models> query = getSession()
                .createQuery("select m from Models m inner join m.developer_id d where d.name = :name")
                .setParameter("name", name);
    	 return query.getResultList();
	}
	public List<Cars> getCars(String name) {
		TypedQuery<Cars> query = getSession()
                .createQuery("select c from Cars c inner join c.developer_id d where d.full_name = :name")
                .setParameter("name", name);
    	 return query.getResultList();
	}

	public List<Developers> getAll() {
		 TypedQuery<Developers> query = getSession().
				 createQuery("select d from Developers d");
		 return query.getResultList();
	}
	public void addDeveloper(int id, String name, Set<Models> models, Set<Cars> cars) {
		Developers developer = new Developers();
		developer.setCars(cars);
		developer.setModels(models);
		developer.setName(name);
		developer.setId(id);
		save(developer);
	}
}
