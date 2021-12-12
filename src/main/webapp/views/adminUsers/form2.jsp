<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal-body">

	<div class="mb-2">
		<label for="username" class="col-form-label">Nombre:</label> <input
			type="text" class="form-control" id="username" name="username"
			required value="${userToEdit.username}" readonly>
	</div>

	<div class="mb-2 w-25 d-inline-block">
		<label for="cost"
			class='col-form-label'>Coins:</label>
		<input class="form-control" type="number" id="coins" name="coins"
			required value="${userToEdit.coins}"></input>
		<div class="invalid-feedback">
			<c:out value='${userToEdit.coins}'></c:out>
		</div>
	</div>

	<div class="mb-2 w-25 d-inline-block">
		<label for="time"
			class='col-form-label'>Tiempo:</label>
		<input class="form-control" type="number" id="time" name="time"
			required value="${userToEdit.time}"></input>
		<div class="invalid-feedback">
			<c:out value='${userToEdit.time}'></c:out>
		</div>
	</div>
		<div class="mb-2">
		<label for="id" class="col-form-label">Id:</label> <input
			type="text" class="form-control" id="id2" name="id2"
			required value="${userToEdit.id}" readonly>
	</div>
<div>
	<button type="submit"  class="btn btn-primary">Guardar</button>
	<a onclick="window.history.back();" class="btn btn-secondary"
		role="button">Cancelar</a>
</div>