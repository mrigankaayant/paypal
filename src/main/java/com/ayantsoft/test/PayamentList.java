package com.ayantsoft.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentHistory;
import com.paypal.api.payments.RelatedResources;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;

public class PayamentList {

	public static void main(String[] args) {
		String clientId = "AVdQORIEP6W1kTNIkst42o_gt6BpESyQgNj3QobBKWJxUDc9t2DqFLZEcSOh2g6vYte_8bE8KlLBvDC5";
		String clientSecret = "ENniHM2uDw-TbvOegrPNdZ2-Yhdxz-xAfD1PuTc5376mhP8iCAfLy2jy-MxguXpMTXFQrR0plmG60HsW";

		try {

			APIContext context = new APIContext(clientId, clientSecret, "sandbox");
			System.out.println("Access Token: "+context.getAccessToken());
			System.out.println("Client Id: "+context.getClientID());
			System.out.println("Client Secrete: "+context.getClientSecret());
			System.out.println();
			System.out.println();
			System.out.println();


			Map<String, String> containerMap = new HashMap<String, String>();
			containerMap.put("count", "100");
			PaymentHistory paymentHistory = Payment.list(context,containerMap);

			if(paymentHistory != null){
				List<Payment> payments = paymentHistory.getPayments();

				int i=1;

				if(payments != null && payments.size() >0){

					for(Payment p:payments){
						
						System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
						System.out.println(p.getRedirectUrls());
						System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");

						//Paypal paypal = new Paypal();


						System.out.println("====================== Payment Informations ("+i+") ==========================");
						System.out.println("Payment Id : "+p.getId());
						System.out.println("Intent : "+p.getIntent());
						System.out.println("Cart : "+p.getCart());
						//paypal.setPaymentId(p.getId());
						//paypal.setIntent(p.getIntent());
						//paypal.setCard(p.getCart());


						System.out.println();
						System.out.println();
						System.out.println("======================= Payer Information =============================");
						if(p.getPayer() != null){
							System.out.println("payment method: "+p.getPayer().getPaymentMethod());
							System.out.println("Status: "+p.getPayer().getStatus());
							//paypal.setPaymentMethod(p.getPayer().getPaymentMethod());
							//paypal.setStatus(p.getPayer().getStatus());


							System.out.println();
							System.out.println();
							System.out.println("====================== Payer_info Informations ========================");

							System.out.println("Email: "+p.getPayer().getPayerInfo().getEmail());
							System.out.println("First Name: "+p.getPayer().getPayerInfo().getFirstName());
							System.out.println("Last Name: "+p.getPayer().getPayerInfo().getLastName());
							System.out.println("Payer Id: "+p.getPayer().getPayerInfo().getPayerId());
							System.out.println("Phone: "+p.getPayer().getPayerInfo().getPhone());
							System.out.println("Country Code: "+p.getPayer().getPayerInfo().getCountryCode());
							//paypal.setEmail(p.getPayer().getPayerInfo().getEmail());
							//paypal.setFirstName(p.getPayer().getPayerInfo().getFirstName());
							//paypal.setLastName(p.getPayer().getPayerInfo().getLastName());
							//paypal.setPayerId(p.getPayer().getPayerInfo().getPayerId());
							//paypal.setPhone(p.getPayer().getPayerInfo().getPhone());
							//paypal.setCountryCode(p.getPayer().getPayerInfo().getCountryCode());




							System.out.println();
							System.out.println();
							System.out.println("====================== shipping_address Informations===========================");
							System.out.println("recipient_name: "+p.getPayer().getPayerInfo().getShippingAddress().getRecipientName());
							System.out.println("line1: "+p.getPayer().getPayerInfo().getShippingAddress().getLine1());
							System.out.println("line2: "+p.getPayer().getPayerInfo().getShippingAddress().getLine2());
							System.out.println("City: "+p.getPayer().getPayerInfo().getShippingAddress().getCity());
							System.out.println("Country Code: "+p.getPayer().getPayerInfo().getShippingAddress().getCountryCode());
							System.out.println("Postal Code: "+p.getPayer().getPayerInfo().getShippingAddress().getPostalCode());
							System.out.println("State: "+p.getPayer().getPayerInfo().getShippingAddress().getState());
							//paypal.setRecipientName(p.getPayer().getPayerInfo().getShippingAddress().getRecipientName());
							//paypal.setLine1(p.getPayer().getPayerInfo().getShippingAddress().getLine1());
							//paypal.setLine2(p.getPayer().getPayerInfo().getShippingAddress().getLine2());
							//paypal.setCity(p.getPayer().getPayerInfo().getShippingAddress().getCity());
							//paypal.setCountryCode(p.getPayer().getPayerInfo().getShippingAddress().getCountryCode());
							//paypal.setPostalCode(p.getPayer().getPayerInfo().getShippingAddress().getPostalCode());
							//paypal.setState(p.getPayer().getPayerInfo().getShippingAddress().getState());

						}


						System.out.println();
						System.out.println();
						System.out.println("====================== Transactions Informations===========================");
						List<Transaction> transaction = p.getTransactions();
						if(transaction !=null && transaction.size() >0){
							for(Transaction t:transaction){
								List<RelatedResources> relatedResources = t.getRelatedResources();
								if(relatedResources != null && relatedResources.size() >0){
									for(RelatedResources r:relatedResources){
										if(r.getSale() != null){
											System.out.println("Sales Id: "+r.getSale().getId());
											System.out.println("Currency: "+r.getSale().getAmount().getCurrency());
											System.out.println("Total: "+r.getSale().getAmount().getTotal());
											System.out.println("Sub Total: "+r.getSale().getAmount().getDetails().getSubtotal());
											System.out.println("Shipping: "+r.getSale().getAmount().getDetails().getShipping());
											System.out.println("Tax: "+r.getSale().getAmount().getDetails().getTax());
											System.out.println("Payment Mode: "+r.getSale().getPaymentMode());
											System.out.println("State: "+r.getSale().getState());
											System.out.println("Protection Eligibility: "+r.getSale().getProtectionEligibility());
											System.out.println("Protection Eligibility Type: "+r.getSale().getProtectionEligibilityType());
											System.out.println("Currency: "+r.getSale().getTransactionFee().getCurrency());
											System.out.println("Value: "+r.getSale().getTransactionFee().getValue());
											System.out.println("Parent Payment: "+r.getSale().getParentPayment());
											System.out.println("Create Time: "+r.getSale().getCreateTime());
											System.out.println("Update Time: "+r.getSale().getUpdateTime());
											/* paypal.setSalesId(r.getSale().getId());
											paypal.setCurrency(r.getSale().getAmount().getCurrency());
											paypal.setTotal(r.getSale().getAmount().getTotal());
											paypal.setSubTotal(r.getSale().getAmount().getDetails().getSubtotal());
											paypal.setShipping(r.getSale().getAmount().getDetails().getShipping());
											paypal.setTax(r.getSale().getAmount().getDetails().getTax());
											paypal.setPaymentMode(r.getSale().getPaymentMode());
											paypal.setState(r.getSale().getState());
											paypal.setProtectionEligibility(r.getSale().getProtectionEligibility());
											paypal.setProtectionEligibilityType(r.getSale().getProtectionEligibilityType());
											paypal.setCurrency(r.getSale().getTransactionFee().getCurrency());
											paypal.setValue(r.getSale().getTransactionFee().getValue());
											paypal.setParentPayment(r.getSale().getParentPayment());
											paypal.setCreateTime(r.getSale().getCreateTime());
											paypal.setUpdateTime(r.getSale().getUpdateTime()); */
										}
									}
								}
							}  
						}

						System.out.println();
						System.out.println();
						i++;

					}

				}

			}

		} catch (Exception e) {
			System.err.println(e);
			
		}
		finally{
			
		}
	}
}
