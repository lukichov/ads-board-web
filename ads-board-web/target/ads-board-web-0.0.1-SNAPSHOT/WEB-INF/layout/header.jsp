<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<tilesx:useAttribute name="current" />


<!-- Static navbar -->
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href='<spring:url value = "/" />'>Доска
				объявлений</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li class="${current == 'index' ? 'active' : ''}"><a
					href='<spring:url value = "/" />'>Домашняя</a></li>
				<li class="${current == 'ads' ? 'active' : ''}"><a
					href='<spring:url value="/ads.html"></spring:url>'>Объявления</a></li>
				<security:authorize access="hasRole('ROLE_USER')">
					<li><a href='<spring:url value="/myads.html"></spring:url>'>Мои
							объявления</a></li>
				</security:authorize>

				<security:authorize access="hasRole('ROLE_ADMIN')">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Справочники <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li class="${current == 'users' ? 'active' : ''}"><a
								href='<spring:url value="/users.html"></spring:url>'>Пользователи</a></li>
							<li class="${current == 'rubrics' ? 'active' : ''}"><a
								href='<spring:url value="/rubrics.html"></spring:url>'>Рубрики</a></li>

						</ul></li>
				</security:authorize>
			</ul>

			<security:authorize access="isAuthenticated()">
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a
						href='<spring:url value="/login.html" />' class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Учетная запись <span class="caret"></span></a>
						<ul class="dropdown-menu">
								<li><a href="<spring:url value="/account.html" />">Мой профиль</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="<spring:url value="/logout" />">Выход</a></li>
						</ul></li>
				</ul>
				</security:authorize>
				<security:authorize access="! isAuthenticated()">
				<ul class="nav navbar-nav navbar-right">
					<li class="${current == 'register' ? 'active' : ''}"><a
						href="<spring:url value="/register.html" />">Регистрация</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
				<li class="${current == 'login' ? 'active' : ''}"><a
									href="<spring:url value="/login.html" />">Вход</a></li>
				</ul>
				</security:authorize>
		</div>
		<!--/.nav-collapse -->
	</div>
	<!--/.container-fluid -->
</nav>
