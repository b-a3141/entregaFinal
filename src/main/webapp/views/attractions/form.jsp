<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal-body">
	<div class="mb-2">
		<label for="name" class="col-form-label">Nombre:</label> <input
			type="text" class="form-control" id="name" name="name"
			required value="${attraction.name}">
	</div>
	<div class="mb-2 w-25 d-inline-block">
		<label for="cost"
			class='col-form-label ${attraction.errors.get("cost") != null ? "is-invalid" : "" }'>Costo:</label>
		<input class="form-control" type="number" id="cost" name="cost"
			required value="${attraction.cost}"></input>
		<div class="invalid-feedback">
			<c:out value='${attraction.errors.get("cost")}'></c:out>
		</div>
	</div>
	<div class="mb-2 w-25 d-inline-block">
		<label for="duration"
			class='col-form-label ${attraction.errors.get("duration") != null ? "is-invalid" : "" }'>Duration:</label>
		<input class="form-control" type="number" id="duration" name="duration"
			required value="${attraction.duration}"></input>
		<div class="invalid-feedback">
			<c:out value='${attraction.errors.get("duration")}'></c:out>
		</div>
	</div>
	
	<div class="mb-2 w-25 d-inline-block">
		<label for="capacity"
			class='col-form-label ${attraction.errors.get("capacity") != null ? "is-invalid" : "" }'>Capacity:</label>
		<input class="form-control" type="number" id="capacity" name="capacity"
			required value="${attraction.capacity}"></input>
		<div class="invalid-feedback">
			<c:out value='${attraction.errors.get("capacity")}'></c:out>
		</div>
	</div>
	<div class="mb-2">
		<label for="descripcion"
			class='col-form-label ${attraction.errors.get("descripcion") != null ? "is-invalid" : "" }'>Descripción:</label>
		<input class="form-control" type="Text" id="descripcion" name="descripcion"
			required value="${attraction.descripcion}"></input>
		<div class="invalid-feedback">
			<c:out value='${attraction.errors.get("Descripcion")}'></c:out>
		</div>
	</div>
	
	<div class="mb-2">
		<label for="imagen"
			class='col-form-label ${attraction.errors.get("imagen") != null ? "is-invalid" : "" }'>Imagen:</label>
		<input class="form-control" type="text" id="imagen" name="imagen"
			required value="${attraction.imagen}"></input>
		<div class="invalid-feedback">
			<c:out value='${attraction.errors.get("imagen")}'></c:out>
		</div>
	</div>
	
	<div class="mb-2">
		<label for="type"
			class='col-form-label ${attraction.errors.get("type") != null ? "is-invalid" : "" }'>Type:</label>
		<input class="form-control" type="text" id="type" name="type"
			required value="${attraction.type}"></input>
		<div class="invalid-feedback">
			<c:out value='${attraction.errors.get("type")}'></c:out>
		</div>
	</div>
	
</div>
<div>
	<button type="submit"  class="btn btn-primary">Guardar</button>
	<a onclick="window.history.back();" class="btn btn-secondary"
		role="button">Cancelar</a>
</div>
