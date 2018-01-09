package com.neusoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.dao.ProductMapper;

import com.neusoft.entity.Product;

@Service
public class ProductService {
    @Autowired
	private ProductMapper proDao;
	public List<Product> findProducts(Integer productid){
		
		return proDao.findProducts();
		
	}
	public Product findProductById(Product acc){
		
		return proDao.findProductById(acc);
		
	}
	
	/**
	 * 根据商品id删除商品
	 * */
	public Integer deleteProductById(Product pro) {
		
		return proDao.deleteById(pro);
		
	}
	
	/**
	 * 添加商品信息
	 * */
	public Integer addProduct(Product pro) {
		return proDao.addproduct(pro);
	}
	
	
}
