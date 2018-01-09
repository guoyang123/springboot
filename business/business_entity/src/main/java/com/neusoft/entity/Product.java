package com.neusoft.entity;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;



/**
 * 商品实体类
 * */

public class Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7104196417428838042L;
	private Integer productid;
	
	@NotEmpty(message="商品名称不能为空")
	private String pname ;
	private String pic;
	private Integer cateid ;
	 private String pdesc ;
	 private String price ;
	public Integer getProductid() {
		return productid;
	}
	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public Integer getCateid() {
		return cateid;
	}
	public void setCateid(Integer cateid) {
		this.cateid = cateid;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [productid=" + productid + ", pname=" + pname + ", pic=" + pic + ", cateid=" + cateid
				+ ", pdesc=" + pdesc + ", price=" + price + "]";
	}  
	
	 
	 
	 
	 
}
