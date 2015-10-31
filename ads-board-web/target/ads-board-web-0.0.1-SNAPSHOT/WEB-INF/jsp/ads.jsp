<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<h2>Все объявления</h2>

<div class="dropdown">
  <button id="dLabel" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    Dropdown trigger
    <span class="caret"></span>
  </button>
  <ul class="dropdown-menu" aria-labelledby="dLabel">
    <c:forEach items="${rubrics}" var="rubric">
    <li><a data-toggle="dropdown" href="ads/rubric/${rubric.rubricId}.html">${rubric.rubricName}</a></li>
									
								</c:forEach>
  </ul>
</div>
<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>Объявление</th>
			<th>Рубрика</th>
			<th>Дата</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${ads}" var="ad">
			<tr>
				<td><a href='<spring:url value="/ads/${ad.adId}.html" />'>
						${ad.adHeader} </a></td>
				<td>	${ad.rubric.rubricName} </td>
				<td><fmt:formatDate value="${ad.adDate}" pattern="dd.MM.yyyy  H:mm"/></td>
			</tr>
		</c:forEach>
	</tbody>
</table>