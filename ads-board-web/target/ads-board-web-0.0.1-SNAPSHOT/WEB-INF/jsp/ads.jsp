<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/taglib.jsp"%>

<script type="text/javascript">
	$(document).ready(jQuery(function($) {
		$('#cheked').click(function() {
			var cb1 = $('#cheked').is(':checked');
			$('#username').prop('disabled', (cb1));

		});
		$(".triggerRemove").click(
				function(e) {
					e.preventDefault();
					$("#modalRemove .removeBtn").attr("href",
							$(this).attr("href"));
					$("#modalRemove").modal();
				});
	})

	);
</script>

<h2>Все объявления</h2>
<br />
<form:form id="filterForm" commandName="adFilter">
	<div class="panel panel-default">
		<div class="panel-body">
			<div class="form-group">

				<div class="row">
					<div class="col-xs-6">
						<label class="control-label">Имя пользователя</label>
						<c:choose>
							<c:when test="${adFilterSettings.checked}">
								<form:input type="text" class="form-control" path="username"
									id="username" placeholder="${adFilterSettings.username}"
									disabled="true" />
							</c:when>
							<c:otherwise>
								<form:input type="text" class="form-control" path="username"
									id="username" placeholder="${adFilterSettings.username}"
									disabled="false" />
							</c:otherwise>
						</c:choose>
					</div>

					<security:authorize access="isAuthenticated()">
						<div class="col-xs-2">

							<label class="check-inline"> Мои объявления <br /> <c:choose>
									<c:when test="${adFilterSettings.checked}">
										<form:checkbox name="myads" id="cheked" value="" path=""
											checked="true" />
									</c:when>
									<c:otherwise>
										<form:checkbox name="myads" id="cheked" value="" path="" />
									</c:otherwise>
								</c:choose>
							</label>
						</div>
					</security:authorize>

					<div class="col-xs-4 selectContainer">
						<label class="control-label">Рубрика</label>
						<form:select class="form-control" name="rubricId" path="rubricId">
							<option value="0">Все рубрики</option>
							<c:forEach items="${rubrics}" var="rubric">
								<c:if test="${adFilterSettings.rubricId == rubric.rubricId}">
									<option selected value="${rubric.rubricId}">${rubric.rubricName}</option>
								</c:if>
								<c:if test="${adFilterSettings.rubricId != rubric.rubricId}">
									<option value="${rubric.rubricId}">${rubric.rubricName}</option>
								</c:if>
							</c:forEach>
						</form:select>
					</div>

				</div>
			</div>

			<div align="center">
				<button type="submit" class="btn btn-default">Фильтр</button>
				&nbsp;&nbsp;
			</div>
		</div>
	</div>
</form:form>

<br />


<table class="table table-bordered table-hover table-striped">
	<c:choose>
		<c:when test="${adFilterSettings.checked}">
			<thead>
				<tr>
					<th width="55%">Объявление</th>
					<th width="15%"><div align="center">Рубрика</div></th>
					<th width="15%"><div align="center">Дата</div></th>
					<th width="15%"><div align="center">Управление</div></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ads}" var="ad">
					<tr>
						<td><a href='<spring:url value="/ads/${ad.adId}.html" />'>
								${ad.adHeader} </a></td>
						<td align="center">${ad.rubric.rubricName}</td>
						<td align="center"><fmt:formatDate value="${ad.adDate}"
								pattern="dd.MM.yyyy  H:mm" /></td>
						<td align="center">
							<a href='<spring:url value="/myads/remove/${ad.adId}.html" />'
							class="btn btn-danger btn-xs triggerRemove"> Удалить</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</c:when>
		<c:otherwise>
			<thead>
				<tr>
					<th width="55%">Объявление</th>
					<th width="15%"><div align="center">Пользователь</div></th>
					<th width="15%"><div align="center">Рубрика</div></th>
					<th width="15%"><div align="center">Дата</div></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ads}" var="ad">
					<tr>
						<td><a href='<spring:url value="/ads/${ad.adId}.html" />'>
								${ad.adHeader} </a></td>
						<td align="center">${ad.user.name}</td>
						<td align="center">${ad.rubric.rubricName}</td>
						<td align="center"><fmt:formatDate value="${ad.adDate}"
								pattern="dd.MM.yyyy  H:mm" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</c:otherwise>
	</c:choose>

</table>




<style type="text/css">
/* Adjust feedback icon position */
#movieForm .form-control-feedback {
	right: 15px;
}

#movieForm .selectContainer .form-control-feedback {
	right: 25px;
}
</style>


<!-- Modal delete -->
<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">Удаление объявления</h4>
			</div>
			<div class="modal-body">Действительно удалить?</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Отменить</button>
				<a href="" class="btn btn-danger removeBtn">Удалить</a>
			</div>
		</div>
	</div>
</div>




