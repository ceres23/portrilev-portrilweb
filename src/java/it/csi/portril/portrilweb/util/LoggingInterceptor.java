/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

	
	public class LoggingInterceptor implements HandlerInterceptor {
		protected  LogUtil log = new LogUtil(getClass());

/*
	    @Override
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
	            throws Exception {
	        HttpSession session = request.getSession();


	        if (session.getAttribute("isUserLoggedIn") == null) {
	         response.sendRedirect(request.getContextPath() + "/login.html");
	         return false;
	        }

	        System.out.println(request.getSession() + "--Before Method ");
	        System.out.println("---Before Method Execution---");
	        return true;
	    }
*/
		@Override
		public void afterCompletion(HttpServletRequest arg0,
				HttpServletResponse arg1, Object arg2, Exception arg3)
				throws Exception {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void postHandle(HttpServletRequest arg0,
				HttpServletResponse arg1, Object arg2, ModelAndView arg3)
				throws Exception {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean preHandle(HttpServletRequest arg0,
				HttpServletResponse arg1, Object arg2) throws Exception {
			// TODO Auto-generated method stub
			return false;
		}

	}