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
public class DaoModels extends DAO<Models, Integer>  {
	public List<Models> getByTitle(String title) {
		TypedQuery<Models> query = getSession()
                .createQuery("select  m from Models m where m.title = :title")
                .setParameter("title", title);
    	 return query.getResultList();
	}

	public List<Models> getAll() {
		 TypedQuery<Models> query = getSession().
				 createQuery("select d from Models d");
		 return query.getResultList();
	}
	public void addModel(int id, String title, Set<Cars> cars, Developers developer ) {
		Models model = new Models();
		model.setCars(cars);
		model.setDeveloper_id(developer);
		model.setId(id);
		model.setTitle(title);
		save(model);
	}
}
