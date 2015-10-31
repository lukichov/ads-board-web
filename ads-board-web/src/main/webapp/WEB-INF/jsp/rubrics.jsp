<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp" %>

<table class = "table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>Рубрики</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${rubrics}" var="rubric">
			<tr>
				<td>${rubric.rubricName}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>