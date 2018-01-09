package com.neusoft.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试redis-session共享
 * */
@Controller
public class RedisSessionController {

	@RequestMapping(value="/test")
	public String test() {
		
		return "home";
	}
	
	@RequestMapping(value="/first",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> fireReq(HttpServletRequest request){
		Map<String,Object> map=new HashMap<String,Object>();
		request.getSession().setAttribute("request url",request.getRequestURL());
		
		map.put("request url", request.getRequestURL());
		return map;
	}
	
	
	@RequestMapping(value="/second")
	@ResponseBody
	public Map<String,Object> secondReq(HttpServletRequest request){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("sessinId", request.getSession().getId());
		map.put("message", request.getSession().getAttribute("request url"));
		return map;
	}
	
	
}
