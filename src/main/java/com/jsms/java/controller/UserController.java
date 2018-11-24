package com.jsms.java.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jsms.java.model.RestfulResponse;
import com.jsms.java.model.User;
import com.jsms.java.service.UserService;

@RestController
public class UserController {

	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST,headers="Accept=application/json")
	public List<User> login(@RequestBody User user)
	{
		List<User> listOfCountries = new ArrayList<User>();
		
		if(user!=null){
			user = userService.findByUser(user);
		}
		listOfCountries.add(user);
		return listOfCountries;
	}

	@RequestMapping(value = "/changepassword", method = RequestMethod.POST,headers="Accept=application/json")
	public List<User> changePassword(@RequestBody User user)
	{
		List<User> listOfCountries = new ArrayList<User>();
		
		if(user!=null){
			user = userService.changePassword(user);
		}
		listOfCountries.add(user);
		return listOfCountries;
	}
	
    @RequestMapping(value="/forgotpassword/{accNo}", method=RequestMethod.GET, headers="Accept=application/json")
    public RestfulResponse forgotPassword(@PathVariable String accNo) {
        RestfulResponse restfulResponse = new RestfulResponse();
		try {
			restfulResponse.setMessage(userService.forgotPassword(accNo));
		} catch (EmptyResultDataAccessException e) {
			restfulResponse.setMessage("Invalid Account Number");
		}catch (Exception e) {
			restfulResponse.setMessage("Unable to send SMS.  Please try later");
		}
		return restfulResponse;
    }

	
}
