package com.mall.comment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.mall.comment.pojo.MallProduct;

public class ProductService {
	
	@Autowired
	private RestTemplate restTemplate;//通过restTemplate来发生送为服务的请求
	
	public MallProduct selectProductById(Integer productId){
		return this.restTemplate.getForObject("http://192.168.0.57:8086/product/selectById?id="+productId, MallProduct.class);
	}

}
