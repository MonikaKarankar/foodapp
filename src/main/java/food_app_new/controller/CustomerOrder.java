package food_app_new.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import food_app_new.dao.FoodDao;
import food_app_new.dto.Menu;
import food_app_new.dto.Order;

@WebServlet("/additem")
public class CustomerOrder extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));

		FoodDao dao = new FoodDao();
		Menu menu = dao.getItem(id);
		List<Menu> menus = new ArrayList<Menu>();
		HttpSession httpSession = req.getSession();
		if (menu != null) {
			menus.add(menu);
			httpSession.setAttribute("items", menus);
			RequestDispatcher dispatcher = req.getRequestDispatcher("order.jsp");
			dispatcher.forward(req, resp);
		}
	}

}
