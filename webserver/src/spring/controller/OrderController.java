package spring.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import form.OrderForm;
import DAO.*;
import Entities.*;
@Controller
public class OrderController {
	@Autowired 
	DaoCars CarDao;
	@Autowired
	DaoClients ClientDao;
	@Autowired
	DaoOrders OrderDao;
	@RequestMapping(value = "/order", method = RequestMethod.GET)
    public String getOrder(@RequestParam(value="id", required=true) int id, ModelMap map) {
		try {
			Orders order = OrderDao.getById(id);
			map.addAttribute("order",order);
			OrderForm form = new OrderForm();
			form.setId(id);
			form.setCurrent_status(order.getCurrent_status());
			map.addAttribute("form",form);
			return "order";
		} catch (Exception e) {
			return "error";
		}
	}
	@RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String getOrders(ModelMap map) {
		try {
			map.addAttribute("orders",OrderDao.getAll());
			return "orders";
		} catch (Exception e) {
            return "error";
        }
	}
	@RequestMapping(value = "/order_del", method = RequestMethod.GET)
    public String deleteOrder(@RequestParam(value="id", required=true) int id, ModelMap map) {
		try {
        	Orders order = OrderDao.getById(id);
        	OrderDao.delete(order);
        	return "redirect:orders";
		} catch (Exception e) {
            return "error";
        }
	}
	private void saveOrder(OrderForm form) {
		OrderDao.addOrder(form.getId(), form.date_and_time, form.getCurrent_status(),
				CarDao.getById(form.getCar_id()), form.getIf_test_drive_required(), 
				ClientDao.getById(form.getClient_id()));
	}
	private void updateOrder(OrderForm form) {
		Orders order = OrderDao.getById(form.getId());
		order.setCurrent_status(form.getCurrent_status());
		order.setDate_and_time(form.date_and_time);
		order.setIf_test_drive_required(form.getIf_test_drive_required());
		OrderDao.update(order);
	}

	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public String update_order(ModelMap map,
            @ModelAttribute("form") OrderForm form) {
		try {
			updateOrder(form);
			return "redirect:order?id=" + String.valueOf(form.getId());
		} catch (Exception e) {
			return "error";
		}
	}
	@RequestMapping(value = "/order_add", method = RequestMethod.GET)
    public String add_order(ModelMap map) {
		try {
        	OrderForm form= new OrderForm();
        	map.addAttribute("form",form);
        	map.addAttribute("cars",CarDao.getAll());
			map.addAttribute("clients",ClientDao.getAll());
        	return "order_add";
		} catch (Exception e) {
            return "error";
        }
	}
	@RequestMapping(value = "/order_add", method = RequestMethod.POST)
	public String add_order(ModelMap map,
            @ModelAttribute("form") OrderForm form) {
		try {
			saveOrder(form);
			return "redirect:orders";
		} catch (Exception e) {
			return "error";
		}
	}
}
