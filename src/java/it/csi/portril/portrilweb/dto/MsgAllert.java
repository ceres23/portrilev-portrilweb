/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.dto;
import it.csi.portril.portrilweb.util.Costanti;

public class MsgAllert extends GenericDTO{
	
	private static final long serialVersionUID = -7522672903288477964L;
	private String tipo="";
    private String label="";
    private String messaggio="";
	
    public MsgAllert() {
	}

    /**
     * @param tipo
     * @param label
     * @param messaggio
     */
    public MsgAllert(String tipo, String label,String messaggio) {
		super();
		this.tipo = tipo;
		this.label = label;
		this.messaggio = messaggio;
	}

    /**
     * @param tipo
     * @param label
     * @param messaggio
     */
    public MsgAllert(String tipo, String messaggio) {
		this( tipo, "", messaggio);
	}
    
	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}
	
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @param tipo
	 * @param bloccante
	 */
	public void setTipo(String tipo,String bloccante) {
		if(bloccante.equals(Costanti.SI.getCostante())){
			this.tipo = Costanti.ERR.getCostante();
		}else{
			this.tipo = tipo;			
		}
	}

	/**
	 * @return the messaggio
	 */
	public String getMessaggio() {
		return messaggio;
	}

	/**
	 * @param messaggio the messaggio to set
	 */
	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}
    
	

}
