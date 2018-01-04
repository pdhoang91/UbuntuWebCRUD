package tma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tma.model.Order;
import tma.service.OrderService;

@Controller
public class AppControllerOrder {

	@Autowired
	OrderService orderService;
	
	@RequestMapping(value = { "/admin/listAll" }, method = RequestMethod.GET)
	public @ResponseBody List<Order> listAllOrder(ModelMap model) {
		return orderService.getAllOrders();
	}
	
	@RequestMapping(value = { "/admin/list/{orderId}" }, method = RequestMethod.GET)
    @ResponseBody
	public Order listOrderById(@PathVariable String orderId) {
		 return orderService.getOrderById(orderId);
	}
	
	@RequestMapping(value = { "/admin/add" }, method = RequestMethod.POST)
	@ResponseBody
	public String addOrderById(@RequestBody Order jsonString) {
		orderService.sendOrder(jsonString);
 		return "add order end!";
	}
	
	@RequestMapping(value = { "/admin/update/{orderId}" }, method = RequestMethod.PUT)
	@ResponseBody
	public String updateOrderById(@RequestBody Order jsonString, @PathVariable String orderId) {	
		
		Order currentOrder = orderService.getOrderById(orderId);
		currentOrder.setProductName(jsonString.getProductName());
		currentOrder.setQuantity(jsonString.getQuantity());
		
		orderService.updateOrder(currentOrder);
 		return "update order by id end";
	}
	
	@RequestMapping(value = { "/admin/delete/{orderId}" }, method = RequestMethod.DELETE)
    @ResponseBody
	public String deleteOrderById(@PathVariable String orderId) {
		
		orderService.deleteById(orderId);
		return "delete order by id end";
	}
	
	@RequestMapping(value = { "/admin/deleteAll" }, method = RequestMethod.DELETE)
    @ResponseBody
	public String deleteAllOrder() {
		
		orderService.deleteAllOrders();
		return "delete all order end";
	}
}