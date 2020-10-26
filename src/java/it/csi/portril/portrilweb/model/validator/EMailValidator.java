/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.model.validator;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang.StringUtils;
 
	public class EMailValidator implements ConstraintValidator<EMail, String> {
	 
		private EMail mail;
		
	    @Override
	    public void initialize(EMail mail) {
	    	this.mail = mail;
	    }
	 
	    @Override
	    public boolean isValid(String strMail , ConstraintValidatorContext ctx) {
    		String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
	    	boolean ris=true;
    		if(StringUtils.isBlank(strMail)){
    			if(mail.required()){ris= false;}
    		}else{
	    		if (!strMail.matches(emailPattern)) {
	    			ris= false;
	    		}
    		}
    		return ris;
	    }
	    
	    
	    public static void main(String[] args){
	    	String strMail ="ragioner@comune.casale-monferrato.al.it";
	    	String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	    	

	    		if (strMail.matches(emailPattern)) {
	    			System.out.println("Mail corretta");
	    		}else{
	    			System.out.println("Mail Scorretta");
	    		}
	    	
	    	
	    }
	    
	}