/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.util;

public enum TipiFile {
	
	//TIPO_FILE_CSV("text/csv"), 
	TIPO_FILE_TXT("text/plain"), 
	TIPO_FILE_WORD("application/msword"), 
	//TIPO_FILE_GIF("image/gif"), 
	//TIPO_FILE_JPEG("image/jpeg"), 
	TIPO_FILE_PDF("application/pdf"), 
	TIPO_FILE_XLS("application/vnd.ms-excel"), 
	//TIPO_FILE_XLSX("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"), 
	
	;
	
	private String contentType;
	
	private TipiFile(String contentType) {
		this.contentType = contentType;
	}
	
	
	public String getContentType() {
		return contentType;
	}


	public static boolean fromCodice(String codice) {
		for(TipiFile tf : values()) {
			if(tf.getContentType().equals(codice)) {
				return true;
			}
		}
		return false;
	}
}
