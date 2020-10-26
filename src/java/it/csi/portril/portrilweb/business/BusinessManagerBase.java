/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.business;

import it.csi.portril.portrilweb.util.LogUtil;
import it.csi.portril.portrilweb.util.dozer.MapId;
import it.csi.portril.portrilweb.util.paginazione.ListaPaginata;
import it.csi.portril.portrilweb.util.paginazione.ListaPaginataImpl;
import it.csi.portril.portrilweb.util.paginazione.ParametriPaginazione;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
/*
import it.csi.siac.siaccommon.util.dozer.MapId;
import it.csi.siac.siaccorser.model.paginazione.ListaPaginata;
import it.csi.siac.siaccorser.model.paginazione.ListaPaginataImpl;
import it.csi.siac.siaccorser.model.paginazione.ParametriPaginazione;
*/

public class BusinessManagerBase {

	protected  LogUtil log = new LogUtil(getClass());
	
	@Autowired
	protected Mapper mapper;

	protected <T> T map(Object source, Class<T> clazz) {
		return mapper.map(source, clazz);
	}

	protected void map(Object source, Object dest) {
		mapper.map(source, dest);
	}

	protected <T> T map(Object source, Class<T> clazz, MapId mapId) {
		String mapIdStr = mapId != null ? mapId.name() : null;
		return mapper.map(source, clazz, mapIdStr);
	}

	protected void map(Object source, Object dest, MapId mapId) {
		String mapIdStr = mapId != null ? mapId.name() : null;
		mapper.map(source, dest, mapIdStr);
	}

	protected <T> T mapNotNull(Object source, Class<T> clazz) {
		if (source != null)
			return map(source, clazz);
		return null;
	}

	protected void mapNotNull(Object source, Object dest) {
		if (source != null)
			map(source, dest);
	}

	protected <T> T mapNotNull(Object source, Class<T> clazz, MapId mapId) {
		if (source != null)
			return map(source, clazz, mapId);
		return null;
	}

	protected void mapNotNull(Object source, Object dest, MapId mapId) {
		if (source != null)
			map(source, dest, mapId);
	}

	protected <A, DA> List<A> convertiLista(Iterable<DA> listDa, Class<A> classA) {
		return convertiLista(listDa, classA, null);
	}

	protected <A, DA> List<A> convertiLista(Iterable<DA> listDa, Class<A> classA,
			MapId mapId) {
		if (listDa == null)
			return null;

		List<A> listA = new ArrayList<A>();

		for (DA tuplaDa : listDa) {
			A mapped = map(tuplaDa, classA, mapId);
			listA.add(mapped);
		}

		return listA;
	}

	protected Pageable toPageable(ParametriPaginazione pp) {
		Pageable pageable = new PageRequest(pp.getNumeroPagina(),
				pp.getElementiPerPagina());
		return pageable;
	}
	
	protected Pageable toPageable(int numeroPagina, int elementiPerPagina) {
		Pageable pageable = new PageRequest(numeroPagina, elementiPerPagina);
		return pageable;
	}

	protected Pageable toPageable(ParametriPaginazione pp, Sort sort) {
		Pageable pageable = new PageRequest(pp.getNumeroPagina(),
				pp.getElementiPerPagina(), sort);
		return pageable;
	}

	protected ParametriPaginazione toParametriPaginazione(Pageable pageable) {
		ParametriPaginazione pp = new ParametriPaginazione();
		pp.setNumeroPagina(pageable.getPageNumber());
		pp.setElementiPerPagina(pageable.getPageSize());
		return pp;
	}

	/**
	 * Trasforma una lista di Page<E> in una lista ListaPaginata<T>
	 * 
	 * Dove E &egrave; il tipo della classe entity e T &egrave; il tipo della classe di Model.
	 * 
	 * @author Domenico Lisi
	 * 
	 * @param pagedList
	 * @param classDest
	 * @param mapId
	 * @return
	 */
	protected <T, E> ListaPaginata<T> toListaPaginata(Page<E> pagedList,
			Class<T> classDest, MapId mapId) {
		ListaPaginataImpl<T> list = new ListaPaginataImpl<T>();

		if (!pagedList.hasContent())
			return list;

		int elementsPerPage = 1 + (int) (pagedList.getTotalElements() / pagedList
				.getTotalPages());

		list.setPaginaCorrente(pagedList.getNumber());
		list.setTotaleElementi((int) pagedList.getTotalElements());
		list.setTotalePagine(pagedList.getTotalPages());
		list.setHasPaginaPrecedente(pagedList.hasPreviousPage());
		list.setHasPaginaSuccessiva(pagedList.hasNextPage());
		list.setNumeroElementoInizio(1 + pagedList.getNumber()
				* elementsPerPage);
		list.setNumeroElementoFine(pagedList.getNumber() * elementsPerPage
				+ pagedList.getNumberOfElements());

		for (E dto : pagedList.getContent())
			list.add(map(dto, classDest, mapId));

		log.debug("toListaPaginata","toListaPaginata - " + "PaginaCorrente: "
				+ list.getPaginaCorrente() + " TotaleElementi: "
				+ list.getTotaleElementi() + " TotalePagine: "
				+ list.getTotalePagine());

		return list;

	}

	protected <T, E> ListaPaginata<T> toListaPaginata(Page<E> pagedList,
			Class<T> classDest) {
		return toListaPaginata(pagedList, classDest, null);
	}

	protected <T> ListaPaginata<T> toListaPaginata(Page<T> list) {
		// list.getTotalElements(); //Returns the total amount of elements.
		// list.getTotalPages(); //Returns the number of total pages.
		return toListaPaginata(list.getContent(), list.getTotalElements(),
				list.getTotalPages(), list.getNumber());
	}

	protected <T> ListaPaginata<T> toListaPaginata(List<T> simpleList,
			Long totaleElementi, ParametriPaginazione pp) {
		int totalePagine = (int) (totaleElementi / pp.getElementiPerPagina());
		return toListaPaginata(simpleList, totaleElementi, totalePagine,
				pp.getNumeroPagina());
	}

	protected <T> ListaPaginata<T> toListaPaginata(List<T> simpleList,Long totaleElementi, int totalePagine, int paginaCorrente) {
		ListaPaginataImpl<T> result = new ListaPaginataImpl<T>(simpleList);
		result.setTotaleElementi(totaleElementi.intValue());
		result.setTotalePagine(totalePagine);
		result.setPaginaCorrente(paginaCorrente);
		return result;
	}

	protected String mapToString(Integer i) {
		return mapToString(i, null);
	}

	protected String mapToString(Integer i, String nullValue) {
		if (i == null)
			return nullValue;

		return i.toString();
	}

	protected String mapToString(boolean flag) {
		return flag ? "S" : "N";
	}

	
	/**
	 * serve per rimappare da una lista di oggetti ad un'altra utilizzando dozer
	 * @param listaDa
	 * @param clazzA
	 * @return
	 */
	protected <DA, A> List<A> mapAll(List<DA> listaDa, Class<A> clazzA) {
		List<A> listA = new ArrayList<A>();
		
		for(DA da : listaDa) {
			A a = mapper.map(da, clazzA);
			listA.add(a);
		}
		return listA;
	}
	
	/**
	 * serve per rimappare da una lista si oggetti ad un'altra utilizzando dozer
	 * @param listaDa
	 * @param clazzA
	 * @return
	 */
	protected <DA, A> List<A> mapAll(List<DA> listaDa, List<A> listaA) {
		List<A> listA  = new ArrayList<A>();

		for(DA da : listaDa) {
			A a = (A)new Object();
			mapper.map(da, a);
			listA.add(a);
		}
		return listA;
	}
	
	
	public <T> List<T> addElementoAllaLista(List<T> lista, T elemento){
		return addElementoAllaLista( lista,elemento ,0);
	}
	
	public <T> List<T> addElementoAllaLista(List<T> lista, T elemento ,int posizione){
		
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
	
}
