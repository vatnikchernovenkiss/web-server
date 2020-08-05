package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.HashSet;
import java.util.Set;
import form.ClientForm;
import DAO.*;
import Entities.*;
@Controller
public class ClientController {

	@Autowired
	private DaoClients ClientDao;

	@RequestMapping(value = "/client", method = RequestMethod.GET)
    public String getClient(@RequestParam(value="id", required=true) int id, ModelMap map) {
		try {
			Clients client = ClientDao.getById(id);
			map.addAttribute("client",client);
			ClientForm form= new ClientForm();
        	form.setId(id);
        	map.addAttribute("form",form);
			return "client";
		} catch (Exception e) {
            return "error";
        }
	}
	@RequestMapping(value = "/clients", method = RequestMethod.GET)
    public String getClients(ModelMap map) {
		try {
			map.addAttribute("clients",ClientDao.getAll());
			return "clients";
		} catch (Exception e) {
            return "error";
        }
	}
	@RequestMapping(value = "/client_del", method = RequestMethod.GET)
    public String deleteClient(@RequestParam(value="id", required=true) int id, ModelMap map) {
		try {
        	Clients client = ClientDao.getById(id);
        	ClientDao.delete(client);
        	return "redirect:cars";
		} catch (Exception e) {
            return "error";
        }
	}
	private void saveClient(ClientForm form) {
		Set<Cars> tmp = new HashSet<Cars>();
		Set<Orders> tmp1 =  new HashSet<Orders>();
		ClientDao.addClient(form.getId(), form.getPhone(), form.getE_mail(), form.getFull_name(), tmp1, 
				tmp, form.getHashed_password(), form.getAddress());
	}
	private void updateClient(ClientForm form) {
    	Clients client = ClientDao.getById((form.getId()));
    	client.setAddress(form.getAddress());
    	client.setE_mail(form.getE_mail());
    	client.setFull_name(form.getFull_name());
    	client.setHashed_password(form.getHashed_password());
    	client.setPhone(form.getPhone());
        ClientDao.update(client);
	}
	@RequestMapping(value = "/client", method = RequestMethod.POST)
	public String update_car(ModelMap map,
            @ModelAttribute("form") ClientForm form) {
		try {
			updateClient(form);
			return "redirect:client?id=" + String.valueOf(form.getId());
		} catch (Exception e) {
			return "error";
		}
	}
	@RequestMapping(value = "/client_add", method = RequestMethod.GET)
    public String add_client(ModelMap map) {
		try {
        	ClientForm form= new ClientForm();
        	map.addAttribute("form",form);
        	return "client_add";
		} catch (Exception e) {
            return "error";
        }
	}
	@RequestMapping(value = "/client_add", method = RequestMethod.POST)
	public String add_car(ModelMap map,
             @ModelAttribute("form") ClientForm form) {
		try {
			saveClient(form);
			return "redirect:clients";
		} catch (Exception e) {
			return "error";
		}
	}
}

