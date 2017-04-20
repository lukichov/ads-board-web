<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp" %>

<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th width="10%"><div align="center">Пользователь</div></th>
			<th width="10%"><div align="center">Рубрика</div></th>
			<th width="10%"><div align="center">Дата</div></th>
			<th width="25%">Заголовок</th>
			<th width="45%">Объявление</th>
		</tr>
	</thead>
	<tbody>
			<tr>
				<td align="center">${ad.user.name}</td>
				<td align="center">${ad.rubric.rubricName}</td>
				<td align="center"><fmt:formatDate value="${ad.adDate}" pattern="dd.MM.yyyy  H:mm"/></td>
				<td>${ad.adHeader}</td>
				<td>${ad.adText}</td>
			</tr>
	</tbody>
</table>

<a href="javascript:history.back(-1);"><b>Вернуться назад</b></a>