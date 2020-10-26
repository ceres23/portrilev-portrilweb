/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.util;

import it.csi.portril.portrilweb.dto.MsgAllert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import javax.ejb.EJBException;
import javax.mail.internet.MimeUtility;

import org.springframework.util.StringUtils;

import com.thoughtworks.xstream.XStream;

public class Utility {
	private static LogUtil log = new LogUtil(Utility.class);

	/**
	 * Costruisce una stringa rappresentante un tipico value object contenente
	 * metodi get e set.
	 * 
	 * @param obj
	 * @return esempio di ritorno: Fornitore: [ Codice: 116010 RagioneSociale:
	 *         IMPRE.MAR SRL COSTRUZIONI GENERALI Beneficiario: Beneficiario: [
	 *         Codice: null ModalitaDiPagamento: 1 Progressivo: 1 ] Stato: S ]
	 */
	public static String fieldsToString(Object obj) {
		XStream xs = new XStream();
		return "\n" + xs.toXML(obj);
	}

	/**
	 * 
	 * @param mappaMailDaInviate
	 * @param mappaMailInviate
	 * @return
	 */
	public Map<String, String> defferenzaMappa(Map<String, String> mappaMailDaInviate,Map<String, String> mappaMailInviate) {

		Set<String> listaChiavi = mappaMailInviate.keySet();
		for(String chiave :listaChiavi){
			mappaMailDaInviate.remove(chiave);
		}
		return mappaMailDaInviate;
	}
	
	/**
	 * 
	 * @return
	 */
	public static Integer getAnnoCorrente() {
		return Calendar.getInstance().get(Calendar.YEAR);
	}

	/**
	 * 
	 * @param annoStart
	 * @return
	 */
	public static List<String> getAnni(Integer annoStart) {
		final String methodName = "getAnni";
		log.startMethod(methodName);
		List<String> ris = new ArrayList<String>();
		Calendar cal = Calendar.getInstance();
		int annoCorrente = cal.get(Calendar.YEAR);

		if (annoStart == null) {
			annoStart = 2006;
		}
		for (int a = annoCorrente; a >= annoStart; a--) {
			ris.add(String.valueOf(a));
		}
		log.info(methodName, annoStart);
		log.info(methodName, annoCorrente);

		fieldsToString(ris);
		log.stopMethod(methodName);
		return ris;
	}

	/**
	 * Somma con la precisione data da BigDecimal un insieme di Double
	 * 
	 * @param a
	 * @return
	 */
	public static Double sum(Double... a) {
		BigDecimal res = new BigDecimal("0");
		for (int i = 0; i < a.length; i++) {
			Double d = a[i];
			if (d != null) {
				BigDecimal bd = new BigDecimal(d.toString());
				res = res.add(bd);
			}
		}
		return new Double(res.doubleValue());

	}

	/**
	 * Trasforma una stringa da Pippo_pluto_paperino in PippoPlutoPaperino
	 * 
	 * @param ca
	 * @return
	 */
	public static String capitalizeAfterUnderscore(String ca) {

		if (ca == null) {
			return null;
		}

		int i = ca.indexOf("_");
		while (i != -1) {
			ca = ca.substring(0, i)
					+ StringUtils.capitalize(ca.substring(i + 1));

			i = ca.indexOf("_");

		}
		return ca;
	}

	/**
	 * 
	 * @param original
	 * @return
	 */
	/*
	public static Object copyGetSetInstance(Object original) {
		Object s = null;
		String methodName="Object";
		try {
			s = original.getClass().newInstance();
		} catch (InstantiationException e) {
			log.error(methodName, e);

		} catch (IllegalAccessException e) {
			log.error(methodName, e);
		}

		Object obj = original;
		Method[] methods = obj.getClass().getDeclaredMethods();
		for (Method method : methods) {
			if (methodName.startsWith("get")) {
				Object param;
				try {
					if(method!=null){
						param = method.invoke(obj);
						Method setMethod = getSetMethod(methodName, obj.getClass());
						setMethod.invoke(s, param);
					}
				} catch (IllegalArgumentException e) {
					log.error(methodName, e);
				} catch (IllegalAccessException e) {
					log.error(methodName, e);
				} catch (InvocationTargetException e) {
					log.error(methodName, e);
				}
			}
		}
		return s;
	}

	private static Method getSetMethod(String methodName, Class clas) {
		methodName = "set" + methodName.substring(3);
		Method[] methods = clas.getDeclaredMethods();
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				return method;
			}
		}
		log.info(methodName,"Impossibile trovare il metodo: " + methodName);
		return null;
	}
*/



/*

	public static byte[] readAllBytes(String filePath) throws Exception {
		File file = new File(filePath);
		return readAllBytes(file);
	}

	public static byte[] readAllBytes(File file) throws IOException {
		FileInputStream fis =null;
		byte[] b =null;
		try{
			fis = new FileInputStream(file);
			b = new byte[(int) file.length()];
			if(fis !=null){
				fis.read(b);
			}
		}catch(Exception e){
			log.error("readAllBytes", e);
		}finally{
			if(fis !=null){fis.close();}
		}
		return b;
	}
	
	Compliant Solution
	
	public void doSomething(String fileName) {
	  try {
	    InputStream is = new InputStream(file);
	    byte [] buffer = new byte[1000];
	    int count = 0;
	    while (count = is.read(buffer) > 0) {
	      // ...
	    }
	  } catch (IOException e) { ... }
	}

	 */
	
	
	/**
	 * 
	 * @param t
	 */
	public static void printNestedException(Throwable t) {
		final String methodName = "printNestedException";
		if (t == null) {
			log.error(methodName, "[null]: null");
			return;
		} else {
			log.error(methodName, "[" + t.getClass().getSimpleName() + "]: "+ t.getMessage());

			Throwable cause;
			if (t instanceof EJBException) {
				cause = ((EJBException) t).getCausedByException();
			} else {
				cause = t.getCause();
			}
			printNestedException(cause);
		}

	}

	/**
	 * 
	 * @param t
	 * @return
	 */
	public static Throwable getRootCauseException(Throwable t) {
		final String methodName = "getRootCauseException";
		if (t == null) {
			log.error(methodName, "[null]: null");
			return null;
		} else {
			log.error(methodName, "[" + t.getClass().getSimpleName() + "]: "
					+ t.getMessage());

			Throwable cause;
			if (t instanceof EJBException) {
				cause = ((EJBException) t).getCausedByException();
			} else {
				cause = t.getCause();
			}
			if (cause == null) {
				return t;
			} else {
				return getRootCauseException(cause);
			}
		}

	}

	/**
	 * 
	 * @param s
	 * @return
	 */
	public static String splitCamelCase(String s) {
		String exp = String.format("%s|%s|%s", "(?<=[A-Z])(?=[A-Z][a-z])",
				"(?<=[^A-Z])(?=[A-Z])", "(?<=[A-Za-z])(?=[^A-Za-z])");
		return s.replaceAll(exp, " ");
	}

	/**
	 * 
	 * @param val
	 * @param rep
	 * @return
	 */
	public static Object replaceNull(Object val,String rep){
		if(val==null){
			val=rep;
		}
		return val;
	}

	/**
	 * 
	 * @param filename
	 * @param userAgent
	 * @return
	 * @throws Exception
	 */
	public static String encodeFilenameForDownload(String filename, String userAgent) throws Exception
	{
		//String userAgent = ServletActionContext.getRequest().getHeader("user-agent");

		boolean isInternetExplorer = (userAgent.indexOf("MSIE") > -1);

		if (isInternetExplorer)
			return "\"" + filename + "\"";

		return "\"" + MimeUtility.encodeWord(filename) + "\"";
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public List<String> splittaStriga(String str ){
		List<String> ris = new ArrayList<String>();
	
		StringTokenizer st = new StringTokenizer(str);
		while (st.hasMoreElements()) {
			ris.add(st.nextElement().toString());
		}
		return ris;
	}
	
	/**
	 * 
	 * @param str
	 * @param separatore
	 * @return
	 */
	public static  List<Long> splittaLong(String str ,String separatore){
		List<Long> ris = new ArrayList<Long>();
		StringTokenizer st = new StringTokenizer(str, separatore);
		while (st.hasMoreElements()) {
			ris.add(Long.parseLong(st.nextToken()));
		}	
		return ris;
	}

	/**
	 * 
	 * @param str
	 * @param separatore
	 * @return
	 */
	public static  List<String> splittaString(String str ,String separatore){
		List<String> ris = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(str, separatore);
		while (st.hasMoreElements()) {
			ris.add(st.nextToken());
		}	
		return ris;
	}
		
	/**
	 * 
	 * @param lista
	 * @param elemento
	 * @param posizione
	 * @return
	 */
	public static <T> List<T> addElementoAllaLista(List<T> lista, T elemento ,int posizione){
		
		List<T> listaRis = new ArrayList<T>();
		
		for(int i=0;i<lista.size();i++) {
			T listaSel = lista.get(i);
			if(posizione==i){
				listaRis.add(elemento);
			}
			
			listaRis.add(listaSel);
		}
		return listaRis;
	}
	
	/**
	 * 
	 * @param lista
	 * @param elemento
	 * @return
	 */
	public static <T> List<T> addElementoAllaLista(List<T> lista, T elemento ){
		return addElementoAllaLista(lista,  elemento ,0);
	}
	
	/**
	 * 
	 * @param listamsg
	 * @param tipo
	 * @return
	 */
	public static List<String> getlistMsg(List<MsgAllert> listamsg,String tipo){
		String methodName="getlistMsg";
		List<String> ris = new ArrayList<String>();
		for(MsgAllert msg:listamsg){
			if(msg.getTipo().equals(tipo)){
				ris.add(msg.getMessaggio());	
			}
		}
		
		return ris;
	}

	/**
	 * 
	 * @param listamsg
	 * @param tipo
	 * @return
	 */
	public static List<String> getlistMsg(List<MsgAllert> listamsg){
		String methodName="getlistMsg";
		List<String> ris = new ArrayList<String>();
		for(MsgAllert msg:listamsg){
			ris.add(msg.getMessaggio());	
		}
		
		return ris;
	}

	//numero con 2 decimali separati dal punto
	/**
	 * 
	 * @param valoreCella
	 * @return
	 */
	public static boolean isNumber(String valoreCella) {
		//da affinare (aaa.ddd,dd)
		String reg ="";
		//reg = "\\-?\\d+(\\.\\d+)?";
		reg = "^-?[0-9]+(\\.[0-9]{0,2})?$";
		//reg = "^\\-?[0-9](\\.[0-9]{0,2})?$|^\\-?[1-9]+(\\.[0-9]{0,2})?$";
		return valoreCella.matches(reg);
		
		
	}

	/**
	 * 
	 * @param nomeModulo
	 * @return
	 */
	public String generaNomeModuloCsv(String nomeModulo) {
		String date = UtilDate.formatDate(new Date(), "ddMMyyyy");
		nomeModulo=nomeModulo.replaceAll(" ", "");
		if(nomeModulo.length()>20){
			nomeModulo = nomeModulo.substring(0,10);
		}
		nomeModulo = nomeModulo+" "+date+".csv";
		return nomeModulo;
	}

	public List<Long> conversioneLista(String[] sLista) {
		Long[] lLista = new Long[sLista.length];		
		for (int i=0;i<sLista.length;i++){
			lLista[i]=Long.parseLong(sLista[i]);
		}
		return Arrays.asList(lLista);
	}

//	public static void main(String[] args) {
//		 
//		String str = "This is String , split by StringTokenizer, created by mkyong";
//		StringTokenizer st = new StringTokenizer(str);
// 
//		System.out.println("---- Split by space ------");
//		while (st.hasMoreElements()) {
//			System.out.println(st.nextElement());
//		}
// 
//		System.out.println("---- Split by comma ',' ------");
//		StringTokenizer st2 = new StringTokenizer(str, ",");
// 
//		while (st2.hasMoreElements()) {
//			System.out.println(st2.nextElement());
//		}
//	}
}
