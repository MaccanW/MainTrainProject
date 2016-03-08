package org.ics.eao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.ics.ejb.User;

/**
 * Session Bean implementation class UserEAO
 */
@Stateless
public class UserEAO implements UserEAOLocal {

    @PersistenceContext(unitName="LabEJBSql")
    private EntityManager em;
	
    public UserEAO() {
    }
    
    public User findUserByUserName(String userName){
    	return em.find(User.class, userName);
    }
    
    public User createUser(User u){
    	em.persist(u);
    	return u;
    }
    
    public User update(User u){
    	em.merge(u);
    	return u;
    }
    
    public void deleteUser(String userName){
    	User u = this.findUserByUserName(userName);
    	if(u != null){
    		em.remove(u);
    	}
    }
    
    @Override
    public List<User> findAll(){
    	TypedQuery<User>query = em.createNamedQuery("User.findAll", User.class);
    	
    	List<User>results = query.getResultList();
    	return results;
    }
    
    @Override
    public List<User> findByUserName(String userName){
    	TypedQuery<User> query = em.createNamedQuery("User.findByUserName", User.class);
    	query.setParameter("userName", userName);
    	List<User> results = query.getResultList();
    	return results;
    }
    
    @Override
	public boolean authenticateUser(String userName, String passWord) {
		User user = findUserByUserName(userName);
		if (user != null && user.getUserName().equals(userName) && user.getPassWord().equals(passWord)) {
			return true;
		} else {
			return false;
		}
	}
	@Override
	public User getUserByUserNAme(String userName) {
		// Customer c = em.find(Customer.class, cEmail);
		// List<Customer> list = c.getcEmail()
		TypedQuery<User> query = em.createNamedQuery("User.findByUserName", User.class);
		query.setParameter("userName", userName);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
