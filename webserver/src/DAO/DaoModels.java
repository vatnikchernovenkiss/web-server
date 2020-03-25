package DAO;
import DAO.DAO;
import Entities.*;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import java.util.Set;

import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

public class DaoModels extends DAO<Models, Integer>  {
	public List<Models> getByTitle(String title) {
		TypedQuery<Models> query = getSession()
                .createQuery("select  m from Models m where m.title = :title")
                .setParameter("title", title);
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
