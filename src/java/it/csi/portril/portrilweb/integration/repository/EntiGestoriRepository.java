/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.integration.repository;

import it.csi.portril.portrilweb.integration.entity.PrTEntiGestori;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EntiGestoriRepository extends JpaRepository<PrTEntiGestori, Long> {

}