/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.util;

import it.csi.portril.portrilweb.dto.MsgAllert;
import it.csi.portril.portrilweb.integration.entity.PrTColonneModulo;
import it.csi.portril.portrilweb.model.CellaModuloModel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class ValidazioniCelleXSingolaRiga {
	
	protected  LogUtil log = new LogUtil(getClass());
	

	/**
	 * 
	 * @param colonna
	 * @param cella
	 * @return
	 */
	public List<MsgAllert> checkAlfanumerico(PrTColonneModulo colonna,CellaModuloModel cella,String iCol,String iRiga){
		String methodName="checkAlfanumerico";
		log.startMethodDebug(methodName);
		List<MsgAllert>     ris = new ArrayList<MsgAllert>();
		String  valoreCella     = cella.getValore();
		Integer dimensione 		= colonna.getDimensione();
		Integer dimensioneMin   = colonna.getDimensioneMin();
		String  obbligatorio 	= colonna.getFlagObbligatorieta();
		//String  bloccante 		= colonna.getFlgCtrlBloccante();
		String  preMsg          = colonna.getLabelColonna() +"__";
		

		log.debug(methodName, "cella in esame "+valoreCella + " posizione riga: "+iRiga+" colonna: "+iCol );

		if(obbligatorio.equals(Costanti.SI.getCostante()) && StringUtils.isEmpty(valoreCella)){			
			MsgAllert msg = new MsgAllert();
			msg.setTipo(Costanti.ERR.getCostante());
			msg.setMessaggio(preMsg +" cella obbligatoria " );
			ris.add(msg);
		}
		/*
		if(presentiCaratteriNonAmmessi(valoreCella)){
			MsgAllert msg = new MsgAllert();
			msg.setTipo(Costanti.ERR.getCostante());
			msg.setMessaggio(preMsg +" i caratteri ',' ';' non sono usabili nella compilazione del modulo " );
			ris.add(msg);
		}
*/

		if(StringUtils.isNotEmpty(valoreCella) && valoreCella.length() > dimensione){
			MsgAllert msg = new MsgAllert();			
			//msg.setTipo(Costanti.WARN.getCostante(),bloccante);
			msg.setTipo(Costanti.ERR.getCostante());
			msg.setMessaggio(preMsg +" lunghezza massima superata consentiti "+dimensione+" caratteri" );			
			ris.add(msg);
		}

		if(StringUtils.isNotEmpty(valoreCella) && valoreCella.length() < dimensioneMin){
			MsgAllert msg = new MsgAllert();			
			//msg.setTipo(Costanti.WARN.getCostante(),bloccante);
			msg.setTipo(Costanti.ERR.getCostante());
			msg.setMessaggio(preMsg +" lunghezza minima non raggiunta inserire almeno "+dimensioneMin+" caratteri" );			
			ris.add(msg);
		}

		log.stopMethodDebug(methodName);
		return ris;
	}
	
	/**
	 * 
	 * @param colonna
	 * @param cella
	 * @return
	 */
	public List<MsgAllert> checkNumerico(PrTColonneModulo colonna,CellaModuloModel cella,String iCol,String iRiga){
		String methodName="checkNumerico";
		log.startMethodDebug(methodName);

		ArrayList<MsgAllert>  ris=new ArrayList<MsgAllert>();
		
		String  preMsg          = colonna.getLabelColonna() +"__";
		String  obbligatorio 	= colonna.getFlagObbligatorieta();
		//String  bloccante 		= colonna.getFlgCtrlBloccante();
		String  opNum 			= colonna.getOperatoreNumerico();
		Double  valConf 		= colonna.getValoreConfrontoOperatoreNumerico();
		String  valoreCella     = cella.getValore();

	
		log.debug(methodName, preMsg );
		if(obbligatorio.equals(Costanti.SI.getCostante()) && StringUtils.isEmpty(valoreCella)){
			MsgAllert msg = new MsgAllert();
			msg.setTipo(Costanti.ERR.getCostante());
			msg.setMessaggio(preMsg +" valore obbligatorio " );		
			ris.add(msg);
		}

		if(!checkNumeroAmmesso(valoreCella)){
			MsgAllert msg = new MsgAllert();
			msg.setTipo(Costanti.ERR.getCostante());
			msg.setMessaggio(preMsg +"Formato NON Valido. Il formato numerico prevede solo caratteri numerici oltre all'eventuale  '.' utilizzato come separatore delle 2  cifre decimali es 1200.57" );
			ris.add(msg);
			return ris;
		}
		
		if(StringUtils.isNotEmpty(opNum)){
			Double valoreCellaDouble    = cella.getValoreDouble();

			log.info(methodName,"valoreCellaInt " + valoreCellaDouble);
			log.info(methodName,"valConf " + valConf);
			
			if(opNum.equals(Costanti.DIVERSO.getCostante()) && valoreCellaDouble.equals(valConf)){
				MsgAllert msg = new MsgAllert();
				//msg.setTipo(Costanti.WARN.getCostante(),bloccante);
				msg.setTipo(Costanti.ERR.getCostante());				
				msg.setMessaggio(preMsg +" Il valore contenuto nella cella deve essere diverso da " + valConf  );
				ris.add(msg);
			}
			if(opNum.equals(Costanti.MINORE.getCostante())  && valoreCellaDouble > valConf){
				MsgAllert msg = new MsgAllert();
				//msg.setTipo(Costanti.WARN.getCostante(),bloccante);
				msg.setTipo(Costanti.ERR.getCostante());				
				msg.setMessaggio(preMsg +" Il valore contenuto nella cella deve essere minore di " + valConf  );
				ris.add(msg);

			}
			if(opNum.equals(Costanti.MAGGIORE.getCostante()) && valoreCellaDouble < valConf ){
				MsgAllert msg = new MsgAllert();
				//msg.setTipo(Costanti.WARN.getCostante(),bloccante);
				msg.setTipo(Costanti.ERR.getCostante());				
				msg.setMessaggio(preMsg +" Il valore contenuto nella cella deve essere maggiore di " + valConf );
				ris.add(msg);

			}
			if(opNum.equals(Costanti.MINOREUGUALE.getCostante())  && valoreCellaDouble >= valConf){
				MsgAllert msg = new MsgAllert();
				//msg.setTipo(Costanti.WARN.getCostante(),bloccante);
				msg.setTipo(Costanti.ERR.getCostante());				
				msg.setMessaggio(preMsg +" Il valore contenuto nella cella deve essere minore di " + valConf  );
				ris.add(msg);

			}
			if(opNum.equals(Costanti.MAGGIOREUGUALE.getCostante()) && valoreCellaDouble <= valConf ){
				MsgAllert msg = new MsgAllert();
				//msg.setTipo(Costanti.WARN.getCostante(),bloccante);
				msg.setTipo(Costanti.ERR.getCostante());				
				msg.setMessaggio(preMsg +" Il valore contenuto nella cella deve essere maggiore di " + valConf );
				ris.add(msg);
			}

			if(opNum.equals(Costanti.UGUALE.getCostante())&& (!valoreCellaDouble.equals(valConf))){
				MsgAllert msg = new MsgAllert();
				//msg.setTipo(Costanti.WARN.getCostante(),bloccante);
				msg.setTipo(Costanti.ERR.getCostante());				
				msg.setMessaggio(preMsg +" Il valore contenuto nella cella deve essere uguale a " + valConf );
				ris.add(msg);

			}
						
		}		
		log.stopMethodDebug(methodName);
		return ris;
	}

	public List<MsgAllert> checkValoreFisso(PrTColonneModulo colonna,CellaModuloModel cella,String iCol,String iRiga){
		String methodName="checkAlfanumerico";
		log.startMethodDebug(methodName);
		List<MsgAllert>     ris = new ArrayList<MsgAllert>();
		String  valoreCella     = cella.getValore() ==null ? "" : cella.getValore().trim();
		String  valoreFisso 	= colonna.getValoreFisso() ==null ? "" : colonna.getValoreFisso().trim();
		String  preMsg          = colonna.getLabelColonna() +"__";
		

		log.debug(methodName, "cella in esame "+valoreCella + " posizione riga: "+iRiga+" colonna: "+iCol );

		if(!valoreFisso.equals(valoreCella)){			
			MsgAllert msg = new MsgAllert();
			msg.setTipo(Costanti.ERR.getCostante());
			msg.setMessaggio(preMsg +" Il valore contenuto nella cella deve essere uguale a " + valoreCella);
			ris.add(msg);
		}

		log.stopMethodDebug(methodName);
		return ris;
	}
	
	/**
	 * 
	 * @param colonna
	 * @param cella
	 * @return
	 */
	public List<MsgAllert> checkData(PrTColonneModulo colonna,CellaModuloModel cella,String iCol,String iRiga){
		String methodName="checkData";
		log.startMethodDebug(methodName);

		ArrayList<MsgAllert>  ris=new ArrayList<MsgAllert>();
		String  obbligatorio 	= colonna.getFlagObbligatorieta();
		String  valoreCella     = cella.getValore();
		String  preMsg          = colonna.getLabelColonna() +"__";
		
		log.debug(methodName, "campo  in esame " +colonna.getLabelColonna() );

		if(obbligatorio.equals(Costanti.SI.getCostante()) && StringUtils.isEmpty(valoreCella)){
			MsgAllert msg = new MsgAllert();
			msg.setTipo(Costanti.ERR.getCostante());
			msg.setMessaggio(preMsg +" cella obbligatoria " );
			ris.add(msg);
		}

		if(StringUtils.isNotEmpty(valoreCella)){
			if(!UtilDate.isDateValid(valoreCella,Costanti.FORMATO_DATASTR.getCostante())){
				MsgAllert msg = new MsgAllert();
				msg.setTipo(Costanti.ERR.getCostante());
				msg.setMessaggio(preMsg +" formato data non valido (es: "+Costanti.FORMATO_DATASTR.getCostante()+")" );
				ris.add(msg);

			}
		}		
		log.stopMethodDebug(methodName);
		return ris;
	}
	
	
	private static final Pattern PATTERN = Pattern.compile(".*?[,;].*"); 
	
	private static boolean presentiCaratteriNonAmmessi(String valore){
		if(StringUtils.isBlank(valore)){
			return false;
		}
		if (PATTERN.matcher(valore).matches()) {
			return true;
		}
		return false;
	}
	
	                                                            
	private static final Pattern PATTERN_NUM = Pattern.compile("^([1-9]\\d*|0)(\\.\\d{1,2})?$");

	private static boolean checkNumeroAmmesso(String valore){
		if (PATTERN_NUM.matcher(StringUtils.strip(valore)).matches() || StringUtils.isBlank(valore)) {
			return true;
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		Pattern p1 = Pattern.compile("^([1-9]\\d*|0)(\\.\\d{1,2})?$"); 
		Map<String, Boolean> tests = new LinkedHashMap<String, Boolean>();
		tests.put("123.33", true);
		tests.put("cippa0", false);
		tests.put("055.55", false);
		tests.put("5.", false);
		tests.put("0.35", true);
		tests.put("0.357", false);
		tests.put("357", true);
		
		for(Entry<String, Boolean> e : tests.entrySet()) {
			System.out.println(e.getKey()
					+ " => expected: " + e.getValue()
					+ ", p1: " + p1.matcher(e.getKey()).matches()
					+ ", class: " + checkNumeroAmmesso(e.getKey())
					+ ", BD: " + isOk(e.getKey())
			);
		}
	}
	
	private static boolean isOk(String str) {
		BigDecimal bd = null;
		try {
			bd = new BigDecimal(StringUtils.strip(str));
		}catch(NumberFormatException nfe) {}
		return bd != null;
	}


	private static void testCaratteriNumericiAmmessi() {
		boolean b = checkNumeroAmmesso("123.33");
		System.out.println("validazione numerowerwr " + b);
	}

	
	private static void testCaratteriNonAmmessi() {
		long time = System.currentTimeMillis();
		boolean res = false;
		for(long l = 0L; l < 1000000L; l++) {
			String valore = "cicc;io";
			boolean b = presentiCaratteriNonAmmessi(valore);
			res = res || b;
		}
		System.out.println(System.currentTimeMillis() - time + " ms");
	}
}