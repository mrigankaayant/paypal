package com.ayantsoft.test;

import java.util.HashMap;
import java.util.Map;

import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

public class FindTransaction {

	public static void main(String[] args) {
		
System.out.println("AFTER PAYMENT SUCCESS.............");
		
      String clientId = "AVdQORIEP6W1kTNIkst42o_gt6BpESyQgNj3QobBKWJxUDc9t2DqFLZEcSOh2g6vYte_8bE8KlLBvDC5";
      String clientSecret = "ENniHM2uDw-TbvOegrPNdZ2-Yhdxz-xAfD1PuTc5376mhP8iCAfLy2jy-MxguXpMTXFQrR0plmG60HsW";



		Payment payment = new Payment();
		payment.setId("PAY-6S754226VM628351TLKKVFPI");

		PaymentExecution paymentExecution = new PaymentExecution();
		paymentExecution.setPayerId("94ED3238MFH7N");
		try {
			APIContext context = new APIContext(clientId, clientSecret, "sandbox");
			Payment createdPayment = payment.execute(context, paymentExecution);
			System.out.println(createdPayment);
		} catch (PayPalRESTException e) {
			System.err.println(e.getDetails());
		}
		
		

	}

}
