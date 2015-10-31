<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$(".triggerRemove").click(
								function(e) {
									e.preventDefault();
									$("#modalRemove .removeBtn").attr("href",
											$(this).attr("href"));
									$("#modalRemove").modal();
								});
						$(".adForm")
								.validate(
										{
											rules : {
												adHeader : {
													required : true,
													minlength : 10,
													maxlength : 30
												},
												adText : {
													required : true,
													minlength : 20,
													maxlength : 400
												}
											},
											messages : {
												adHeader : {
													minlength : "Заголовок должен быть длиной не менее 10 символов",
													maxlength : "Заголовок должен быть длиной не более 30 символов",
													required : "Заголовок не может быть пустым!"
												},
												adText : {
													minlength : "Текст объявления должен быть длиной не менее 20 символов",
													maxlength : "Текст объявления должен быть длиной не более 400 символов",
													required : "Текст объявления не может быть пустым!"
												}
											},

											highlight : function(element) {
												$(element).closest(
														'.form-group')
														.removeClass(
																'has-success')
														.addClass('has-error');
											},
											unhighlight : function(element) {
												$(element)
														.closest('.form-group')
														.removeClass(
																'has-error')
														.addClass('has-success');
											}
										});
					});
</script>

<h2>Мои объявления</h2>
<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th >Объявление</th>
			<th><div align="center">Рубрика</div></th>
			<th><div align="center">Дата</div></th>
			<th><div align="center">Действия</div></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${ads}" var="ad">
			<tr>
				<td align="left"><a href='<spring:url value="/ads/${ad.adId}.html" />'>
						${ad.adHeader} </a></td>
				<td align="center">${ad.rubric.rubricName}</td>
				<td align="center"><fmt:formatDate value="${ad.adDate}"
						pattern="dd.MM.yyyy  H:mm" /></td>
				<td align="center"><a
					href='<spring:url value="/myads/remove/${ad.adId}.html" />'
					class="btn btn-danger triggerRemove"> Удалить</a> <a
					href='<spring:url value="/myads/edit/${ad.adId}.html" />'
					class="btn btn-primary editModal"> Редактировать</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal"
	data-target="#myModal">Добавить объявление</button>




<form:form commandName="ad" cssClass="form-horizontal adForm">
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Добавить объявление</h4>
				</div>
				<div class="modal-body">

					<div class="form-group">
						<label for="rubricId" class="col-sm-2 control-label">Рубрика:</label>
						<div class="col-sm-10">
							<form:select path="rubricId" cssClass="form-control">
								<c:forEach items="${rubrics}" var="rubric">
									<option value="${rubric.rubricId}">${rubric.rubricName}</option>
								</c:forEach>
							</form:select>
						</div>
					</div>

					<div class="form-group">
						<label for="adHeader" class="col-sm-2 control-label">Заголовок:</label>
						<div class="col-sm-10">
							<form:input path="adHeader" cssClass="form-control" />
							<form:errors path="adHeader" />
						</div>
					</div>

					<div class="form-group">
						<label for="adText" class="col-sm-2 control-label">Текст:</label>
						<div class="col-sm-10">
							<form:textarea path="adText" cssClass="form-control" rows="2" />
							<form:errors path="adText" />
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
					<input type="submit" class="btn btn-primary" value="Добавить">
				</div>
			</div>
		</div>
	</div>
</form:form>

<form:form commandName="ad" cssClass="form-horizontal adFormEdit">
	<!-- Modal -->
	<div class="modal fade" id="editModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Редактировать
						объявление</h4>
				</div>
				<div class="modal-body">

					<div class="form-group">
						<label for="rubricId" class="col-sm-2 control-label">Рубрика:</label>
						<div class="col-sm-10">
							<form:select path="rubricId" cssClass="form-control">
								<c:forEach items="${rubrics}" var="rubric">
									<option value="${rubric.rubricId}">${rubric.rubricName}</option>
								</c:forEach>
							</form:select>
						</div>
					</div>

					<div class="form-group">
						<label for="adHeader" class="col-sm-2 control-label">Заголовок:</label>
						<div class="col-sm-10">
							<form:input path="${ad.adHeader}" cssClass="form-control" />
							<form:errors path="adHeader" />
						</div>
					</div>

					<div class="form-group">
						<label for="adText" class="col-sm-2 control-label">Текст:</label>
						<div class="col-sm-10">
							<form:textarea path="adText" cssClass="form-control" rows="2" />
							<form:errors path="adText" />
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
					<input type="submit" class="btn btn-primary" value="Редактировать">
				</div>
			</div>
		</div>
	</div>
</form:form>

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