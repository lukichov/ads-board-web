<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp" %>

<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>Пользователь</th>
			<th>Рубрика</th>
			<th>Дата</th>
			<th>Заголовок</th>
			<th>Объявление</th>
		</tr>
	</thead>
	<tbody>
			<tr>
				<td>${ad.user.name}</td>
				<td>${ad.rubric.rubricName}</td>
				<td><fmt:formatDate value="${ad.adDate}" pattern="dd.MM.yyyy  H:mm"/></td>
				<td>${ad.adHeader}</td>
				<td>${ad.adText}</td>
			</tr>
	</tbody>
</table>