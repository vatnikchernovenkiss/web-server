package DAO;

import org.hibernate.ReplicationMode;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class DAO<Type, Id extends Serializable> {
    private Class<Type> store;
    private Session session;
    public DAO() {
        this.store = (Class<Type>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
    public Session getSession() {
        return session;
    }
    public void setSession(Session session) {
        this.session = session;
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
