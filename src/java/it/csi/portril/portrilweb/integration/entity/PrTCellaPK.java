/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.integration.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * The primary key class for the pr_t_cella database table.
 * 
 */
@Embeddable
public class PrTCellaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

//	@Column(name="id_riga")
//	private Long idRiga;
//
//	@Column(name="id_colonna_modulo")
//	private Long idColonnaModulo;


	@ManyToOne
	@JoinColumn(name="id_colonna_modulo", nullable=false, insertable=false, updatable=false)
	private PrTColonneModulo prTColonneModulo;

	//bi-directional many-to-one association to PrTRighe
    @ManyToOne
	@JoinColumn(name="id_riga", nullable=false, insertable=false, updatable=false)
	private PrTRighe prTRighe;
	
   
    /**
     * 
     */
    public PrTCellaPK() {
    }
//	public Long getIdRiga() {
//		return this.idRiga;
//	}
//	public void setIdRiga(Long idRiga) {
//		this.idRiga = idRiga;
//	}
//	public Long getIdColonnaModulo() {
//		return this.idColonnaModulo;
//	}
//	public void setIdColonnaModulo(Long idColonnaModulo) {
//		this.idColonnaModulo = idColonnaModulo;
//	}

    
    
	/**
	 * @return the prTColonneModulo
	 */
	/**
	 * @return
	 */
	public PrTColonneModulo getPrTColonneModulo() {
		return prTColonneModulo;
	}



	/**
	 * @param prTColonneModulo the prTColonneModulo to set
	 */
	/**
	 * @param prTColonneModulo
	 */
	public void setPrTColonneModulo(PrTColonneModulo prTColonneModulo) {
		this.prTColonneModulo = prTColonneModulo;
	}



	/**
	 * @return the prTRighe
	 */
	/**
	 * @return
	 */
	public PrTRighe getPrTRighe() {
		return prTRighe;
	}



	/**
	 * @param prTRighe the prTRighe to set
	 */
	/**
	 * @param prTRighe
	 */
	public void setPrTRighe(PrTRighe prTRighe) {
		this.prTRighe = prTRighe;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PrTCellaPK)) {
			return false;
		}
		PrTCellaPK castOther = (PrTCellaPK)other;
		return 
			this.prTRighe.getIdRiga().equals(castOther.prTRighe.getIdRiga())
			&& this.prTColonneModulo.getIdColonnaModulo().equals(castOther.prTColonneModulo.getIdColonnaModulo());

    }

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.prTRighe.getIdRiga().hashCode();
		hash = hash * prime + this.prTColonneModulo.getIdColonnaModulo().hashCode();
		
		return hash;
    }
}