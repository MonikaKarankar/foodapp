package food_app_new.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Menu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String Name;
	private double price;
	private String Type;
//	@OneToMany
//	private List<Order>order;
//	public List<Order> getOrder() {
//		return order;
//	}
//	public void setOrder(List<Order> order) {
//		this.order = order;
//	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Menu [id=" + id + ", Name=" + Name + ", price=" + price + ", Type=" + Type + "]";
	}
	
}
