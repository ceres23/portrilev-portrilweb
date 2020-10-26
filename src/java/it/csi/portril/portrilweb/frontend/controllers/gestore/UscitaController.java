/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.frontend.controllers.gestore;

import it.csi.portril.portrilweb.frontend.controllers.ControllerBase;
import it.csi.portril.portrilweb.util.LogUtil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/gestore/uscita")

public class UscitaController extends ControllerBase{
	
	private  LogUtil log = new LogUtil(getClass());
	
	
	/**
	 * 
	 * @param loginModel
	 * @param session
	 * @return
	 */
	@RequestMapping(value="esci",method = {RequestMethod.GET})	
	public String esci() {
		String methodName="esci";
		log.startMethod(methodName);

		log.stopMethod(methodName+" vado alla pagina /login.jsp");
		return "redirect: /gestore/menuGestore/start.do";
	}	

}