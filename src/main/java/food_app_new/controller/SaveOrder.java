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
import javax.servlet.http.HttpSession;

import food_app_new.dao.FoodDao;
import food_app_new.dto.Item;
import food_app_new.dto.Order;
import food_app_new.dto.User;

@WebServlet("/saveOrder")
public class SaveOrder extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		    String name=req.getParameter("name");
		    double price=Double.parseDouble(req.getParameter("price"));
		    String type=req.getParameter("type");
		    int quantity=Integer.parseInt(req.getParameter("qua"));
		    
		    HttpSession httpSession=req.getSession();
		    User user=(User) httpSession.getAttribute("stafforder");
		    
		    
		    FoodDao dao=new FoodDao();
		    
		    Item item=new Item();
		    item.setName(name);
		    item.setPrice(price);
		    item.setQuantity(quantity);
		    item.setType(type);
		   
		    List<Item>items=new ArrayList<Item>();
		    items.add(item);
		    Order order=new Order();
		    order.setName(user.getName());
		    order.setSemail(user.getEmail());
		    order.setItems(items);
		    
		    if (order!=null) {
		    	dao.saveOrder(order);
			    HttpSession nextpage=req.getSession();
			    nextpage.setAttribute("finalorder","Final Order Page ");
			    RequestDispatcher dispatcher=req.getRequestDispatcher("finalorder.jsp");
			    dispatcher.forward(req, resp);	
			}	    
	}
}
