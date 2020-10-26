/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.util.dozer.converter;
import it.csi.portril.portrilweb.util.LogUtil;
import java.math.BigDecimal;
import org.dozer.DozerConverter;


public class BigDecimalToIntegerConverter extends DozerConverter<BigDecimal, Integer> {
	private  LogUtil log = new LogUtil(getClass());

	public BigDecimalToIntegerConverter() {
		super(BigDecimal.class, Integer.class);
	}

	@Override
	public BigDecimal convertFrom(Integer src, BigDecimal dest) {
		String methodName = "convertFrom";
		try {
			return src == null ? null : new BigDecimal(src.intValue());
		} catch (NumberFormatException nfe) {
			log.debug(methodName, nfe.getMessage());
		}
		
		return dest;
	}

	@Override
	public Integer convertTo(BigDecimal src, Integer dest) {
		return src == null ? null : src.intValue();
	}

}
