package com.lhdev.dsmyproj.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.lhdev.dsmyproj.entities.Sale;
import com.lhdev.dsmyproj.repositories.SaleRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsService {

	@Value("${twilio.sid}")
	private String twilioSid;

	@Value("${twilio.key}")
	private String twilioKey;

	@Value("${twilio.phone.from}")
	private String twilioPhoneFrom;

	@Value("${twilio.phone.to}")
	private String twilioPhoneTo;
	
	private SaleRepository saleRepository;
	
	public SmsService(SaleRepository saleRepository) {
		this.saleRepository =  saleRepository;
	}



	public void sendSms(Long saleId) {
		
		Sale sale = saleRepository.findById(saleId).get();
		
		String date = sale.getDate().getMonthValue() + "/" + sale.getDate().getYear();
		
		String msg = "O Vendedor "+ sale.getSellerName() + 
				     " foi destaque em " + date +
				     " com um total de " + String.format("%.2f", sale.getAmount());
		

		Twilio.init(twilioSid, twilioKey);

		PhoneNumber to = new PhoneNumber(twilioPhoneTo);
		PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

		Message message = Message.creator(to, from, msg ).create();

		System.out.println(message.getSid());
	}
}
