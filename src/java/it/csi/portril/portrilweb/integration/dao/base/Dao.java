/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.integration.dao.base;

import it.csi.portril.portrilweb.integration.entity.PrTModuli;

import java.util.List;

public interface Dao<E, PK> {
	
	void save(E entity);

	E update(E entity);

	void delete(E entity);

	List<E> findAll(int... rowStartIdxAndCount);

	E findById(PK id);



   
}
