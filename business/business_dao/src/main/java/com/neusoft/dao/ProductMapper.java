package com.neusoft.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.neusoft.entity.Account;
import com.neusoft.entity.Product;

/**
 * 商品CRUD
 * */
@Mapper
@Repository
public interface ProductMapper {
   //  @Select("select  productid,pname,pic,cateid,pdesc,price  from product")
	 public List<Product> findProducts();
	 
	 public Product findProductById(Product acc);
	 /**根据id删除商品*/
	 public Integer deleteById(Product acc) ;
	 /**添加商品*/
	 public Integer addproduct(Product acc);
	 
}
