/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.integration.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the pr_r_utenti_moduli_compilatori database table.
 * 
 */
@Embeddable
public class PrRUtentiModuliCompilatoriPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_modulo")
	private Long idModulo;

	@Column(name="id_utente_compilatore")
	private Long idUtenteCompilatore;

    /**
     * 
     */
    public PrRUtentiModuliCompilatoriPK() {
    }
	/**
	 * @return
	 */
	public Long getIdModulo() {
		return this.idModulo;
	}
	/**
	 * @param idModulo
	 */
	public void setIdModulo(Long idModulo) {
		this.idModulo = idModulo;
	}
	/**
	 * @return
	 */
	public long getIdUtenteCompilatore() {
		return this.idUtenteCompilatore;
	}
	/**
	 * @param idUtenteCompilatore
	 */
	public void setIdUtenteCompilatore(long idUtenteCompilatore) {
		this.idUtenteCompilatore = idUtenteCompilatore;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PrRUtentiModuliCompilatoriPK)) {
			return false;
		}
		PrRUtentiModuliCompilatoriPK castOther = (PrRUtentiModuliCompilatoriPK)other;
		return  this.idModulo.equals(castOther.idModulo) && (this.idUtenteCompilatore.equals(castOther.idUtenteCompilatore));

    }
    
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idModulo.hashCode();
		hash = hash * prime + ((int) (this.idUtenteCompilatore ^ (this.idUtenteCompilatore >>> 32)));
		
		return hash;
    }
}