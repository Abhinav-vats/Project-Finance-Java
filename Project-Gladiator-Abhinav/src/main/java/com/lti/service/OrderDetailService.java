package com.lti.service;
import com.lti.entity.*;

import java.util.List;
import com.lti.service.exception.*;

public interface OrderDetailService {
	
	List<OrderDetail> displayOrder() throws OrderDetailServiceException;

}
