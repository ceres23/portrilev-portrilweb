/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.model.validator;

import it.csi.portril.portrilweb.model.GestioneColonneModuloModel;
import it.csi.portril.portrilweb.util.LogUtil;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Validatore delle password
 */
public class InserisciColonnaModuloValidator  implements Validator {
	
	private  LogUtil log = new LogUtil(getClass());
	
	
	@Override
	public boolean supports(Class<?> clazz) {
		//non posso mettere un'istanza di password xche' il reset ha un oggetto utente che passando di qui va in errore
		return GestioneColonneModuloModel.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dimensione", "dimensioneNotNull.colonneModuloModel.dimensione");
		 
		GestioneColonneModuloModel cm =  (GestioneColonneModuloModel) obj; 
		
		if(cm.getTipoValore().equals("Alfanumerico")){
			//se il tipo  Alfanumerico il campo dimensione deve essere valorizzato
			if(cm.getDimensione()==null ||cm.getDimensione() <1){				
				log.info("validate","dimensione nulla o <1 ");
				//il primo parametro  il campo su cui si deve manifestare l'errore 
				//il secondo parametro la chiave per la descrizione nel file ValidationMessages
				errors.rejectValue("dimensione", "dimensioneNotNull.colonneModuloModel.dimensione"); 
			}else{
				if(cm.getDimensione()>255){				
					log.info("validate","dimensione massima 255");
					errors.rejectValue("dimensione", "dimensioneMax.colonneModuloModel.dimensione"); 
				}		
			}	
			
			if(cm.getDimensioneMin()==null || (cm.getDimensioneMin()>cm.getDimensione())){				
				log.info("validate","dimensione nulla o maggiore della massima ");
				errors.rejectValue("dimensioneMin", "dimensioneMinNotNull.colonneModuloModel.dimensioneMin"); 
			}
		}
		
		
		if(cm.getTipoValore().equals("ValoreFisso")){
			if(!(cm.getValoreFisso()!=null && !cm.getValoreFisso().trim().equals(""))){				
				log.info("validate","dimensione nulla ");
				errors.rejectValue("valoreFisso", "valoreFissoNotNull.colonneModuloModel.valoreFisso"); 
			}		
		}
		
	}
}