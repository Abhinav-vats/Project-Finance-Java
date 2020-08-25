package com.lti.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.ProductIdDto;
import com.lti.dto.ProductInfoDto;
import com.lti.entity.Product;
import com.lti.service.ProductInfoService;
import com.lti.service.exception.CustomerServiceException;
import com.lti.service.exception.ProductServiceException;
import com.lti.status.ProductInfoStatus;

@RestController
@CrossOrigin
public class ProductInfoController {
	@Autowired
	private ProductInfoService productInfoService;
	
	@PostMapping("/productinfo")
	public ProductInfoStatus display(@RequestBody ProductIdDto productIdDto) {
		try {
			//int customerId=Integer.parseInt(id);
			Product product=productInfoService.findById(productIdDto.getId());
			ProductInfoDto productInfoDto = new ProductInfoDto();
			BeanUtils.copyProperties(product, productInfoDto);
			ProductInfoStatus status = new ProductInfoStatus();
			status.setStatus(110);
			status.setMessage("Info Displayed");
			status.setProductInfoDto(productInfoDto);
			return status;
			
		}
		catch(CustomerServiceException e) {
			ProductInfoStatus status = new ProductInfoStatus();
			status.setStatus(102);
			status.setMessage(e.getMessage());
			return status;
		}
	}
	
	
	
}
