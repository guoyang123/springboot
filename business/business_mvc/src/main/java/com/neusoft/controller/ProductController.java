package com.neusoft.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.neusoft.comms.FileUtil;
import com.neusoft.entity.Product;
import com.neusoft.service.ProductService;

@Controller
public class ProductController {
    @Autowired
	private ProductService proService;
	
	 /**
	  * 查看商品,没有分页
	  * */
	@RequestMapping("/home")
	public String findProducs(Model model) {
		List<Product> products=proService.findProducts(0);
		/*Product p=new Product();
		p.setProductid(1);
		Product pro=proService.findProductById(p);*/
		
		model.addAttribute("pros",products);
		return "home";
	}
	
	
	/**
	 * 删除商品
	 * */
	@RequestMapping(value="delproduct/{productid}")
	public String deleProduct(@PathVariable("productid") String pid){
		
		Product pro=new Product();
		pro.setProductid(Integer.parseInt(pid));
		Integer count=proService.deleteProductById(pro);
		System.out.println("删除商品=="+count);
		return "redirect:/home";
	}
	
	/**
	 * 添加商品
	 * */
	@RequestMapping(value="/addProduct")
	public String addProduct(Model model) {
		
		Product pro=new Product();
		model.addAttribute("product",pro);
		return "addproduct";
	}
	@RequestMapping(value="/addProduct",method=RequestMethod.POST)
	public String addProduct(@Valid Product pro,BindingResult result,@RequestParam("pic") MultipartFile  file,HttpServletRequest request) {
		
		/**
		 * step1:文件上传
		 * */
		 String contentType = file.getContentType();
	        String fileName = file.getOriginalFilename();
	      
	        String filePath = request.getSession().getServletContext().getRealPath("imgupload/");
	        System.out.println("filePath-->" + filePath);
	        
	        
	        try {
	            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
	            //step2:将商品信息插入到数据库
	            pro.setPic("http://192.168.3.21:8080/imgupload/"+fileName);
	            proService.addProduct(pro);
	        } catch (Exception e) {
	            // TODO: handle exception
	        	e.printStackTrace();
	        }
	      
		
		return "redirect:/home";
	}
	
}
