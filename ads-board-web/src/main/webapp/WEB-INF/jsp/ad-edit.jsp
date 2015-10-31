<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$(".editForm")
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

<h2>Редактирование объявления</h2>
<br />

<form:form commandName="ad" cssClass="form-horizontal editForm">

	<div class="form-group">
		<label for="rubricId" class="col-sm-2 control-label">Рубрика:</label>
		<div class="col-sm-10">
			<form:select path="rubricId" cssClass="form-control">
				<c:forEach items="${rubrics}" var="rubric_sel">
					<c:if test="${rubric_sel.rubricId == ad.rubric.rubricId}">
						<option selected value="${rubric_sel.rubricId}">${rubric_sel.rubricName}</option>
					</c:if>
					<c:if test="${rubric_sel.rubricId != ad.rubric.rubricId}">
						<option value="${rubric_sel.rubricId}">${rubric_sel.rubricName}</option>
					</c:if>
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
	<div class="form-group">
		<div align="center">
			<input type="submit" value="Сохранить" class="btn btn-lg btn-primary" />
		</div>
	</div>
</form:form>