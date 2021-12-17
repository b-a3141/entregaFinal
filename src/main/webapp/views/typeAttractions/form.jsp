<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal-body">


	<div class="mb-2 w-25 d-inline-block">
		<label for="cost"
			class='col-form-label'>Id:</label>
		<input class="form-control" type="number" id="id2" name="id2"
			required value="${typeAttraction.id}" readOnly></input>
	</div>

	<div class="mb-2">
		<label for="username" class="col-form-label">Nombre:</label> <input
			type="text" class="form-control" id="name" name="name"
			required value="${typeAttraction.name}">
	</div>

</div>
<div>
	<button type="submit"  class="btn btn-primary">Guardar</button>
	<a onclick="window.history.back();" class="btn btn-secondary"
		role="button">Cancelar</a>
</div>