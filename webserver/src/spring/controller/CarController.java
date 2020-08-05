package spring.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import form.CarForm;
import form.ModelForm;
import DAO.*;
import Entities.*;
@Controller
public class CarController {
	@Autowired 
	private DaoDevices DeviceDao;
	@Autowired
	private DaoCars CarDao;
	@Autowired
	private DaoClients ClientDao;
	@Autowired
	private DaoDevelopers DeveloperDao;
	@Autowired
	private DaoModels ModelDao;
	@RequestMapping(value = "/car", method = RequestMethod.GET)
    public String getCar(@RequestParam(value="id", required=true) int id, ModelMap map) {
        try {
        	Cars car = CarDao.getById(id);
            map.addAttribute("car", car);
            map.addAttribute("devices_all",DeviceDao.getAll());
			map.addAttribute("clients_all",ClientDao.getAll());
			CarForm form = new CarForm();
			form.setId(id);
			map.addAttribute("form",form);
			map.addAttribute("devices",DeviceDao.getByCar( id));
			map.addAttribute("clients",ClientDao.getByCarId(id));
            return "car";
        } catch (Exception e) {
            return "error";
        }
	}
	@RequestMapping(value = "/cars", method = RequestMethod.GET)
	 public String getCars( ModelMap map) {
		 try {
			 List<Cars> cars = CarDao.getAll();
			 map.addAttribute("cars",cars);
			 return "cars";
		 } catch (Exception e) {
			 	map.addAttribute("ex", e);
	            return "error";
	     }
	}
	@RequestMapping(value = "/car_del", method = RequestMethod.GET)
    public String delete_car(@RequestParam(value="id", required=true) int id, ModelMap map) {
		try {
        	Cars car = CarDao.getById(id);
        	CarDao.delete(car);
        	return "redirect:cars";
		} catch (Exception e) {
            return "error";
        }
	}
	 private void saveCar(CarForm form) {
	 CarDao.addCar(form.getId(), ModelDao.getById(form.getModel_id()), form.getRegistration_number(), form.getNumber_of_seats(),
				 form.getUpholstery_type(), form.getPrice(), form.last_maintance_date, 
				 new HashSet<Clients>(ClientDao.getByIds(form.getTest_drive_clients_id())),
				 form.getMilage(), form.getCar_colour(), form.getEngine_power(), form.getNumber_of_doors(), 
				 DeveloperDao.getById(form.getDeveloper_id()), new HashSet<Orders>(), new HashSet<Devices>(DeviceDao.getByIds(form.getDevices_id())));
	 }
	 private void updateCar(CarForm form) {
		 Cars car = CarDao.getById((form.getId()));
		 car.setRegistration_number(form.getRegistration_number());
		 car.setCar_colour(form.getCar_colour());
		 car.setEngine_power(form.getEngine_power());
		 car.setLast_maintance_date(form.last_maintance_date);
		 car.setMilage(form.getMilage());
		 car.setNumber_of_doors(form.getNumber_of_doors());
		 car.setNumber_of_seats(form.getNumber_of_seats());
		 car.setPrice(form.getPrice());
		 Set<Clients> new_clients = new HashSet<Clients>(ClientDao.getByIds(form.getTest_drive_clients_id()));
		 car.setTest_drive_clients(new_clients);
		 car.setUpholstery(form.getUpholstery_type());
		 Set<Devices> new_devices = new HashSet<Devices>(DeviceDao.getByIds(form.getDevices_id()));
		 car.setDevices(new_devices);
		 CarDao.update(car);
	 }

	 @RequestMapping(value = "/car", method = RequestMethod.POST)
	 public String update_car(ModelMap map,
             @ModelAttribute("form") CarForm form) {
		try {
			updateCar(form);
			return "redirect:car?id=" + String.valueOf(form.getId());
		} catch (Exception e) {
			return "error";
		}
	 }
	 @RequestMapping(value = "/car_add", method = RequestMethod.GET)
	 public String add_car( ModelMap map) {
		 try {
			 CarForm form = new CarForm();
			 map.addAttribute("form",form);
			 map.addAttribute("devices",DeviceDao.getAll());
			 map.addAttribute("clients",ClientDao.getAll());
			 map.addAttribute("models",ModelDao.getAll());
			 map.addAttribute("developers",DeveloperDao.getAll());
	         return "car_add";
		 } catch (Exception e) {
	            return "error";
	     }	 
	 }
	 @RequestMapping(value = "/car_add", method = RequestMethod.POST)
	 public String add_car(ModelMap map,
             @ModelAttribute("form") CarForm form) {
		try {
			saveCar(form);
			return "redirect:cars";
		} catch (Exception e) {
			return "error";
		}
	 }
	 @RequestMapping(value = "/model_del", method = RequestMethod.GET)
	 public String delete_model(@RequestParam(value="id", required=true) int id, ModelMap map) {
		 try {
			 Models model = ModelDao.getById(id);
			 ModelDao.delete(model);
	        	return "redirect:cars";
			} catch (Exception e) {
	            return "error";
	        }
	 }
	 @RequestMapping(value = "/model_add", method = RequestMethod.GET)
	 public String add_model(ModelMap map) {
		 try {
			 ModelForm form = new ModelForm();
			 map.addAttribute("form", form);
			 map.addAttribute("developers", DeveloperDao.getAll());
	        	return "model_add";
			} catch (Exception e) {
	            return "error";
	        }
	 }
	 
	 private void saveModel(ModelForm form) {
		 ModelDao.addModel(1, form.getTitle(), new HashSet<Cars>(), DeveloperDao.getById(form.getDeveloper_id()));
	 }

	 @RequestMapping(value = "/model_add", method = RequestMethod.POST)
	 public String add_model(ModelMap map,
             @ModelAttribute("form") ModelForm form) {
		try {
			saveModel(form);
			return "redirect:cars";
		} catch (Exception e) {
			return "error";
		}
	 }
}

