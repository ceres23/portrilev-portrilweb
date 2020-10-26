/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.model.validator;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
 
@Documented
@Constraint(validatedBy = CodiceFiscaleValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CodiceFiscale {
  
	static final int LEN = 16;
	static final int LEN_TEMP = 11;
      
    String message() default "Il codice fiscale risulta errato";
      
    Class<?>[] groups() default {};
      
    Class<? extends Payload>[] payload() default {};

    int[] numChar() default {LEN, LEN_TEMP};
    
    boolean required() default false;
  
}