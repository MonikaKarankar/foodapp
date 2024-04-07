package food_app_new.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food_app_new.dao.FoodDao;
import food_app_new.dto.User;


@WebServlet("/signup")
public class UserSignup extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	     
		User user=new User();
		FoodDao dao=new FoodDao();
		
		String name=req.getParameter("name");
	     String address=req.getParameter("address");
	     long phone=Long.parseLong(req.getParameter("phone"));
	     String pass=req.getParameter("password");
	     String role=req.getParameter("role");
	     String email=req.getParameter("email");   
	     user.setName(name);
	     user.setPhone(phone);
	     user.setEmail(email);
	     user.setPassword(pass);
	     user.setAddress(address);
	     user.setRole(role);
	     
//	     EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("rushikesh");
//	     EntityManager entityManager=entityManagerFactory.createEntityManager();
//	     EntityTransaction entityTransaction=entityManager.getTransaction();
//	     entityTransaction.begin();
//	     entityManager.persist(user);
//	     entityTransaction.commit();
	     
	        if (dao.userSignup(user)) {
//				 resp.sendRedirect("login.jsp");
	             req.setAttribute("signup","SIGNUP SUCCESSFULLY PLEASE LOGIN");
	             RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
				 dispatcher.forward(req, resp);  	
			} else {
				RequestDispatcher dispatcher=req.getRequestDispatcher("signup.jsp");
				dispatcher.include(req, resp);
			}
	     
	}
}
