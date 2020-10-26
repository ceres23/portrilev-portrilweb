/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.model.validator;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
 

public class XorDateValidator  implements ConstraintValidator<XorDate, Object> {
 
    private String data1;
    private String data2;
 
    @Override
    public void initialize(final XorDate a) {
        this.data1 = a.data1();
        this.data2 = a.data2();
    }
 
    
    @Override
	public boolean isValid(final Object t, final ConstraintValidatorContext cvc) {
		final Date dataInizio;
		final Date dataFine;
		boolean ris= false;
		try {

			BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(t);
			dataInizio = (Date) bw.getPropertyValue(this.data1);
			dataFine = (Date) bw.getPropertyValue(this.data2);

		} catch (final Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}

		if (!(dataInizio == null ^ dataFine == null)) {
			ris= true;
		}
		
		return ris;
	}

}
