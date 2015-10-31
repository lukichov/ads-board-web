<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp" %>

<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>User name</th>
			<th>User login</th>
			<th>User password</th>
		</tr>
	</thead>
	<tbody>
			<tr>
				<td>${user.name}</td>
				<td>${user.login}</td>
				<td>${user.password}</td>
			</tr>
	</tbody>
</table>