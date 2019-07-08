package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.Admin;
import com.example.demo.domain.Customer;
import com.example.demo.service.AdminService;
import com.example.demo.service.CustomerService;
import com.example.demo.utils.Page;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private AdminService adminService;
	
	//判断登录
	@RequestMapping(value="tologin", method = RequestMethod.POST)
	public String login(@RequestParam("username") String username, //
						@RequestParam("password") String password, //
						Model model , HttpSession session ) {
		Admin admin = adminService.findUser(username, password);
		if(admin != null) {
			
			session.setAttribute("USER_SESSION", admin);
			return "redirect:/customer/main.action";
		}
		model.addAttribute("msg", "账号或者密码错误");
		return "/WEB-INF/views/login.jsp";
	}
	
	/**
	 *  客户列表
	 */
	@RequestMapping(value = "/customer/main.action")
	public String list(@RequestParam(defaultValue="1")Integer page,
			@RequestParam(defaultValue="5")Integer rows, String username, Model model) {
		// 条件查询所有客户
		Page<Customer> customer = customerService
				.findCustomerList(page, rows, username);
		model.addAttribute("page", customer);
		
		// 添加参数
		model.addAttribute("username", customer);
		return "/WEB-INF/views/main.jsp";
	}
	
	// 注册跳转
	@RequestMapping(value = "/toRegister")
	public String toRegister() {
		return "/WEB-INF/views/register.jsp";
	}
	
	//退出登录
	@RequestMapping("/outlogin")
	public String outlogin(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
//	//跳转添加用户
//	@RequestMapping("/customer/toAdd")
//	public String addAA() {
//		
//		return "/WEB-INF/customer/add.jsp";
//	}
	// 跳到登录页面，请求为GET
	@RequestMapping(value = "login.action", method = RequestMethod.GET)
	public String toLogin() {
		return "/WEB-INF/views/login.jsp";
	}
	
	//新增用户后重定向跳转到主页
	@RequestMapping("/customer/add")
	@ResponseBody
	public String addAll(Customer customer) {
		int	row = customerService.createCustomer(customer);
		if(row > 0) {
			return "OK";
		}else {
			return "FAIL";
		}
	}
	
	//删除用户
	@RequestMapping("customer/deleteId")
	@ResponseBody
	public String delete(Integer id) {
		int row = customerService.deleteCustomer(id);
		if(row > 0) {
			System.out.println("删除成功");
			return "OK";
		}else {
			return "FULL";
		}
	}
	
	//通过id查询用户,跳到更新用户页面
	@RequestMapping("/customer/byId")
	@ResponseBody
	public Customer ById(@RequestParam("id") Integer id) {
		Customer customer = customerService.findById(id);
		return customer;
	}
	
	//更新用户
	@RequestMapping("/customer/Update")
	@ResponseBody
	public String update(Customer customer) {
		int row = customerService.updateCustomer(customer);
		if(row > 0) {
			return "OK";
		}else {
			return "FAIL";
		}
	}
}
