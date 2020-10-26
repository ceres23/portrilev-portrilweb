/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.model.validator;
import it.csi.portril.portrilweb.util.CostantiERR;
import it.csi.portril.portrilweb.util.TipiFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.web.multipart.MultipartFile;
 

public class FileValidValidator  implements ConstraintValidator<FileValid, Object> {
 
    private String fileName;
 
    @Override
    public void initialize(final FileValid fv) {
    	this.fileName = fv.fieldName();
    }
 
    
    @Override
	public boolean isValid(final Object t, final ConstraintValidatorContext cvc) {
		final MultipartFile filedavalidare;
		boolean ris= false;
		try {
			BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(t);

			filedavalidare = (MultipartFile) bw.getPropertyValue(this.fileName);

		} catch (final Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
		return validaFile(filedavalidare, cvc);

	}
    
    private boolean validaFile(MultipartFile file, ConstraintValidatorContext cvc) {
		boolean ris = true;
		if(file==null || file.getOriginalFilename().isEmpty()){
			return ris;
		}
    	
    	if(file.getSize()>3000000){
    		cvc.buildConstraintViolationWithTemplate(CostantiERR.ERR_FILE_MAX.getCostante()).addConstraintViolation();
        	ris = false;
    	}
    	
    	if(!TipiFile.fromCodice(file.getContentType())){
    		cvc.buildConstraintViolationWithTemplate(CostantiERR.ERR_FILE_NONGESTITO.getCostante()).addConstraintViolation();
        	ris = false;
    	}    	
		return ris;
	}
    
    

}


/*

private boolean validaFile(Model model,MultipartFile file) {
		String methodName = "validaFile";
		boolean ris = true;
		if(file==null || file.getOriginalFilename().isEmpty()){
			ris = true;
		}
		
		log.info(methodName ,"nome: "+ file.getName());
    	log.info(methodName,"originalFileName: "+ file.getOriginalFilename());
    	log.info(methodName,"contentType: "+ file.getContentType());
    	log.info(methodName,"size: "+ file.getSize());
    	
    	if(file.getSize()>3000000){
    		log.warn(methodName ,"il file: "+ file.getOriginalFilename() + " e' troppo grosso ");
        	addOneMsgError(model,CostantiERR.ERR_FILE_MAX.getCostante());    	
        	ris = false;
    	}
    	
    	if(!TipiFile.fromCodice(file.getContentType())){
    		log.warn(methodName ,"il file: "+ file.getOriginalFilename() + " non e' un tipo censito ");    	
        	addOneMsgError(model,CostantiERR.ERR_FILE_NONGESTITO.getCostante());    		    		
        	ris = false;
    	}    	
		return ris;
	}
	
 */
