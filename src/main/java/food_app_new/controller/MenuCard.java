package food_app_new.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food_app_new.dao.FoodDao;
import food_app_new.dto.Menu;

@WebServlet("/addmenu")
public class MenuCard extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Menu menu = new Menu();
		FoodDao dao = new FoodDao();
		
		String fname = req.getParameter("fname");
		double price=Double.parseDouble(req.getParameter("fprice"));
		String type = req.getParameter("ftype");
    
			menu.setName(fname);
			menu.setPrice(price);
			menu.setType(type);
			  dao.addMenu(menu);
			List<Menu>list=dao.getAllMenus();
//			list.stream().forEach(l->System.out.println(l));
			req.setAttribute("menuadded",list);
			RequestDispatcher dispatcher = req.getRequestDispatcher("menucard.jsp");
			dispatcher.include(req, resp);
			


	}
}
