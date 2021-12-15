<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal-body">

	<div class="mb-2">
		<label for="username" class="col-form-label">Nombre:</label> <input
			type="text" class="form-control" id="username" name="username"
			required value="${userToEdit.username}">
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
	
	<div class="mb-2 w-25 d-inline-block">
		<label for="admin"
			class='col-form-label'>Admin:</label>
		<input class="form-control"  placeholder = "1 / 0" type="text" 
		id="admin" name="admin"
			required value="${userToEdit.admin}"></input>
		<div class="invalid-feedback">
			<c:out value='${userToEdit.admin}'></c:out>
		</div>
	</div>
	
	<div class="mb-2">
		<label for="typeAttractions"
			class='col-form-label'>Tipo de atracción</label>
		<input class="form-control" type="Text" id="typeAttractions" name="typeAttractions"
			required value="${userToEdit.typeAttractions}"></input>
		<div class="invalid-feedback">
			<c:out value='${userToEdit.typeAttractions}'></c:out>
		</div>
	</div>
	
	<div class="mb-2">
		<label for="password"
			class='col-form-label'>Contraseña:</label>
		<input class="form-control" type="text" id="password" name="password"
			required value="****"></input>
		<div class="invalid-feedback">
			<c:out value='inserte contraseña valida'></c:out>
		</div>
	</div>
		
</div>
<div>
	<button type="submit"  class="btn btn-primary">Guardar</button>
	<a onclick="window.history.back();" class="btn btn-secondary"
		role="button">Cancelar</a>
</div>