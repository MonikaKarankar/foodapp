package food_app_new.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import food_app_new.dao.FoodDao;
import food_app_new.dto.Menu;
import food_app_new.dto.User;

@WebServlet("/login")
public class UserLogin extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FoodDao dao = new FoodDao();
//		int id = Integer.parseInt(req.getParameter("id"));
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		User user = dao.findUser(email);
		HttpSession httpSession=req.getSession();
		List<Menu>menus=dao.getAllMenus();
		try {
			
			if (user.getEmail().equals(email)) {
				
				if (user.getPassword().equals(password)) {
					
					if (user.getRole().equalsIgnoreCase("manager")) {
//						req.setAttribute("user", dao.findUser(email));
						httpSession.setAttribute("user",user);
						RequestDispatcher dispatcher=req.getRequestDispatcher("menucard.jsp");						
						req.setAttribute("menuadded",menus);
						dispatcher.forward(req, resp);
					} else if (user.getRole().equalsIgnoreCase("staff")) {
					        httpSession.setAttribute("staff",menus);
					        httpSession.setAttribute("user",user);
					        RequestDispatcher dispatcher=req.getRequestDispatcher("staffmenu.jsp");
					        dispatcher.forward(req, resp);
					}else if (user.getRole().equalsIgnoreCase("customer")) {
						req.setAttribute("user",dao.findUser(email));
						RequestDispatcher dispatcher=req.getRequestDispatcher("displaymenu.jsp");
						dispatcher.forward(req, resp);
					}
					
				} else {
					req.setAttribute("pass","Please Enter Valid Password");
					RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
					dispatcher.include(req, resp);
				}
				
			} else {
				req.setAttribute("email","Please Enter Valid Email");
				RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
				dispatcher.include(req, resp);
			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			req.setAttribute("notfound","User Not Found By Given Id");
			RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
			dispatcher.include(req, resp);
		}

	}
}
