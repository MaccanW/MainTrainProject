package org.ics.eao;

import java.util.List;

import javax.ejb.Local;

import org.ics.ejb.User;

@Local
public interface UserEAOLocal {
	public User findUserByUserName(String userName);
	public User createUser(User u);
    public User update(User u);
    public void deleteUser(String userName);
    public boolean authenticateUser(String userName, String passWord);
    public User getUserByUserNAme(String userName) ;
    
    public List<User> findByUserName(String userName);
    public List<User> findAll();
}
