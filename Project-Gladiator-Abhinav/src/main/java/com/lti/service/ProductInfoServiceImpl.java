package com.lti.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.PurchaseProductDto;
import com.lti.entity.AllotedCard;
import com.lti.entity.Customer;
import com.lti.entity.OrderDetail;
import com.lti.entity.PaymentSchedule;
import com.lti.entity.PlanType;
import com.lti.entity.Product;
import com.lti.repository.ProductInfoRepository;
import com.lti.service.exception.CustomerServiceException;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {
	@Autowired
	private ProductInfoRepository productInfoRepository;
	@Override
	public Product findById(int id){
		return productInfoRepository.findById(id);
		}
	@Override
	public String placeOrder(PurchaseProductDto purchaseProductDto) {
		
		if(productInfoRepository.isCustomerEligible(purchaseProductDto)) {
		
		Customer customer=productInfoRepository.fetchCustomer(purchaseProductDto.getUserId());
		Product product =productInfoRepository.fetchProductById(purchaseProductDto.getProductId());
		PlanType planType = productInfoRepository.fetchPlanTypeByPlan(purchaseProductDto.getPlan());
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setCustomer(customer);
		orderDetail.setProduct(product);
		orderDetail.setPlanType(planType);
		orderDetail.setPricePaid(0);
		productInfoRepository.addNewOrder(orderDetail);
		
		AllotedCard allotedCard = productInfoRepository.fetchAllotedCardByCustomer(customer);
		allotedCard.setCardCreditRemaining(allotedCard.getCardCreditRemaining()-product.getCostPerUnit());
 		allotedCard.setCardCreditUsed(allotedCard.getCardCreditUsed()+product.getCostPerUnit());
 		productInfoRepository.updateAllotedCard(allotedCard);
 		
 		int rem;
 		int installment;
 		rem= (int) ((product.getCostPerUnit())%planType.getDuration());
 		installment=(int) Math.floor(((product.getCostPerUnit())/planType.getDuration()));
 	
 		 List<String> monthsList=new ArrayList<>();
 		 monthsList.add("JANUARY");
 		monthsList.add("FEBRUARY");
 		monthsList.add("MARCH");
 		monthsList.add("APRIL");
 		monthsList.add("MAY");
 		monthsList.add("JUNE");
 		monthsList.add("JULY");
 		monthsList.add("AUGUST");
 		monthsList.add("SEPTEMBER");
 		monthsList.add("OCTOBER");
 		monthsList.add("NOVEMBER");
 		monthsList.add("DECEMBER");
 		String currentMonth=LocalDate.now().getMonth().toString();
 		int indexMonth = monthsList.indexOf(currentMonth);
 		for(int i=1;i<=planType.getDuration();i++) {
 			PaymentSchedule paymentSchedule = new PaymentSchedule();
 			paymentSchedule.setCustomer(customer);
 			paymentSchedule.setOrderDetail(orderDetail);
 			paymentSchedule.setPlanType(planType);
 			paymentSchedule.setPaymentStatus("false");
 			paymentSchedule.setMonthCount(i);
 			paymentSchedule.setMonthFor(monthsList.get((indexMonth+i)%12));
 			if(i==planType.getDuration()) {
 				paymentSchedule.setInstallment(installment+rem);
 				
 			}
 			else {
 				paymentSchedule.setInstallment(installment);
 			}
 			
 			productInfoRepository.addNewPaymentSchedule(paymentSchedule);
 		}
        return "Booking Successfull!";	
	}
		else {
			throw new CustomerServiceException("You are not eligible to purchase this product") ;
				
			
		}
	}
	
}
