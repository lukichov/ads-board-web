<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp" %>

<table class="table table-bordered table-hover table-striped centered" >
	<thead>
		<tr>
			<th width="34%">Имя пользователя</th>
			<th width="33%">Логин</th>
			<th width="33%">Ваши объявления</th>
		</tr>
	</thead>
	<tbody>
			<tr>
				<td>${user.name}</td>
				<td>${user.login}</td>
				<td><a href="/ads-board-web/myads.html">Объявления</a></td>
			</tr>
	</tbody>
</table>