/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.model.validator;

import it.csi.portril.portrilweb.util.Validazioni;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang.StringUtils;

public class CodiceFiscaleValidator implements ConstraintValidator<CodiceFiscale, String> {

	private CodiceFiscale codiceFiscale;

	@Override
	public void initialize(CodiceFiscale codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext ctx) {
		
		boolean ris = false;
		
		if (StringUtils.isBlank(value)) {
			if(codiceFiscale.required()){
				return false;
			}
			return true;
		}	

		value= value.toUpperCase();				
		int[] numFiscpossibili = codiceFiscale.numChar();
		for(int a=0;a<numFiscpossibili.length;a++){
			int lenPossibili = codiceFiscale.numChar()[a];		
			if(lenPossibili==CodiceFiscale.LEN || lenPossibili==CodiceFiscale.LEN_TEMP){			
				ris= new Validazioni().isValidCodiceFiscale(value,lenPossibili);					
			}else {					
				if((value.length() == codiceFiscale.numChar()[a]) && !ris){
					ris = true;
				}
			}		
		}
		return ris;
	}





}