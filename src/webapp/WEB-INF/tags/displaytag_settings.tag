<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%-- @ include file="/WEB-INF/jsp/include.jsp" --%>

<display:setProperty name="basic.msg.empty_list">
    <div class="feedSearch"><spring:message code="basic.msg.empty_list"/></div>
</display:setProperty>

<display:setProperty name="basic.msg.empty_list_row">
	<tr class="empty"><td colspan="{0}"><spring:message code="basic.msg.empty_list_row"/></td></tr>
</display:setProperty>  

<display:setProperty name="error.msg.invalid_page"><spring:message code="error.msg.invalid_page"/></display:setProperty>  
<display:setProperty name="paging.banner.item_name"><spring:message code="paging.banner.item_name"/></display:setProperty>  
<display:setProperty name="paging.banner.items_name"><spring:message code="paging.banner.items_name"/></display:setProperty>  

<display:setProperty name="paging.banner.no_items_found">
    <div class="paging"><div class="pagingLeft"><spring:message code="paging.banner.no_items_found"/></div>
</display:setProperty>  
<display:setProperty name="paging.banner.one_item_found">
    <div class="paging"><div class="pagingLeft"><spring:message code="paging.banner.one_item_found"/></div>
</display:setProperty>  
<display:setProperty name="paging.banner.all_items_found">
    <div class="paging"><div class="pagingLeft"><spring:message code="paging.banner.all_items_found"/></div>
</display:setProperty>  
<display:setProperty name="paging.banner.some_items_found">
    <div class="paging"><div class="pagingLeft"><spring:message code="paging.banner.some_items_found"/></div>
</display:setProperty>  

<display:setProperty name="paging.banner.full">
    <div class="pagingRight"><span class="pageNumbers">{0}</span><span class="pageNavigation">
    <span class="firstPage"><a href="{1}" title="<spring:message code="paging.banner.first_page"/>"><spring:message code="paging.banner.first"/></a></span><span class="separator"> | </span>
    <span class="previousPage"><a href="{2}" title="<spring:message code="paging.banner.prev_page"/>"><abbr title="<spring:message code="paging.banner.prev"/>"><spring:message code="paging.banner.prev_abbr"/></abbr></a></span><span class="separator"> | </span>
    <span class="nextPage"> <a href="{3}" title="<spring:message code="paging.banner.next_page"/>"><abbr title="<spring:message code="paging.banner.next"/>"><spring:message code="paging.banner.next_abbr"/></abbr></a></span><span class="separator"> | </span>
    <span class="lastPage"><a href="{4}" title="<spring:message code="paging.banner.last_page"/>"><spring:message code="paging.banner.last"/></a></span></span></div></div>
</display:setProperty>  

<display:setProperty name="paging.banner.first">
    <div class="pagingRight"><span class="pageNumbers">{0}</span><span class="pageNavigation">
    <span class="nextPage"> <a href="{3}" title="<spring:message code="paging.banner.next_page"/>"><abbr title="<spring:message code="paging.banner.next"/>"><spring:message code="paging.banner.next_abbr"/></abbr></a></span><span class="separator"> | </span>
    <span class="lastPage"><a href="{4}" title="<spring:message code="paging.banner.last_page"/>"><spring:message code="paging.banner.last"/></a></span></span></div></div>
</display:setProperty>  

<display:setProperty name="paging.banner.last">
    <div class="pagingRight"><span class="pageNumbers">{0}</span><span class="pageNavigation">
    <span class="firstPage"><a href="{1}" title="<spring:message code="paging.banner.first_page"/>"><spring:message code="paging.banner.first"/></a></span><span class="separator"> | </span>
    <span class="previousPage"><a href="{2}" title="<spring:message code="paging.banner.prev_page"/>"><abbr title="<spring:message code="paging.banner.prev"/>"><spring:message code="paging.banner.prev_abbr"/></abbr></a></span><span class="separator">
</display:setProperty>  

<display:setProperty name="paging.banner.onepage">
	<div class="pagingRight"><span class="pageNumbers"><spring:message code="paging.banner.page"/></span></div></div>
</display:setProperty>  

<display:setProperty name="paging.banner.page.selected"><span class="currentPage">{0}</span></display:setProperty>  
<display:setProperty name="paging.banner.page.link"><a href="{1}" title="<spring:message code="paging.banner.page_link.title"/>">{0}</a></display:setProperty>  
<display:setProperty name="paging.banner.page.separator"><span class="separator"> | </span></display:setProperty>  
