package food_app_new.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import food_app_new.dto.Menu;
import food_app_new.dto.Order;
import food_app_new.dto.User;

public class FoodDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("rushikesh");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public boolean userSignup(User user) {
		// TODO Auto-generated method stub
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		return true;
	}

	public User findUser(String email) {
		// TODO Auto-generated method stub
//		Query query=entityManager.createQuery("SELECT u FROM User u WHERE email=?1 AND password=?2");
//		query.setParameter(1,email);
//		query.setParameter(2,password);
//		 User user=(User)query.getSingleResult();

		Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.email=?1");
		query.setParameter(1, email);
		User user = (User) query.getSingleResult();
		if (user != null) {
			return user;
		}
		return null;
	}

	public void addMenu(Menu menu) {
		// TODO Auto-generated method stub
		entityTransaction.begin();
		entityManager.persist(menu);
		entityTransaction.commit();

	}

	public List<Menu> getAllMenus() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("SELECT m FROM Menu m").getResultList();

	}

	public Menu getItem(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(Menu.class, id);
	}

	public Order findOrder(String name) {
		// TODO Auto-generated method stub
		Query query = entityManager.createNamedQuery("SELECT o FROM Order o WHERE o.name=?1");
		query.setParameter(1, name);
		return (Order) query.getSingleResult();
	}

	public void saveOrder(Order order) {
		// TODO Auto-generated method stub
		entityTransaction.begin();
		entityManager.persist(order);
		entityTransaction.commit();
		
	}
}