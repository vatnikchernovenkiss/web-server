package DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Transactional
public class DAO<Type, Id extends Serializable> {
    private Class<Type> store;
    @Autowired
    SessionFactory sessionFactory;
    public DAO() {
        this.store = (Class<Type>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    public void setSession(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public Type getById(Id id) {
        return getSession().get(store, id);
    }
    public List<Type> getAll() {
        CriteriaQuery<Type> query = getSession().getCriteriaBuilder().createQuery(store);
        query.from(store);
        return getSession().createQuery(query).getResultList();
    }
    public void save(Type t) {
        getSession().save(t);
      

    }
    public void update(Type t) {
        getSession().update(t);
    }
    public void delete(Type t) {
        getSession().delete(t);
    }
    
}
