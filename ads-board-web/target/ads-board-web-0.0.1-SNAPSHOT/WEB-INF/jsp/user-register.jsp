<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<c:if test="${param.success eq true}">
		<div class="alert alert-success">Регистрация успешна!</div>
	</c:if>
	
<h2>Регистрация пользователя</h2>

<form:form commandName="user" cssClass="form-horizontal">

	

	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">Имя
			пользователя</label>
		<div class="col-sm-10">
			<form:input path="name" cssClass="form-control" />
			<form:errors path="name"/>
		</div>
	</div>
	<div class="form-group">
		<label for="login" class="col-sm-2 control-label">Логин</label>
		<div class="col-sm-10">
			<form:input path="login" cssClass="form-control" />
			<form:errors path="login"/>
		</div>
	</div>
	<div class="form-group">
		<label for="password" class="col-sm-2 control-label">Пароль</label>
		<div class="col-sm-10">
			<form:password path="password" cssClass="form-control" />
			<form:errors path="password"/>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-2">
			<input type="submit" value="Сохранить" class="btn btn-lg btn-primary" />
		</div>
	</div>
</form:form>
