/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.integration.dao.interfaces;

import it.csi.portril.portrilweb.integration.entity.CsiLogAudit;

public interface CsiLogAuditDAO {
	/**
	 * 
	 * @param CsiLogAudit
	 * @return CsiLogAudit
	 */
	CsiLogAudit create(CsiLogAudit entity);
	/**
	 * 
	 * @param CsiLogAudit
	 * @return CsiLogAudit
	 */
	CsiLogAudit update(CsiLogAudit entity);
	/**
	 * 
	 * @param CsiLogAudit
	 * @return void
	 */
	void     delete(CsiLogAudit entity);
}
