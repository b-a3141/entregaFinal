<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal-body">

	<div class="mb-1 w-50 d-inline-block">
		<label for="name" class="col-form-label">Nombre:</label> <input
			type="text" class="form-control" id="name" name="name" required
			value="${promotion.name}">
	</div>
	<div class="mb-1 w-25 d-inline-block">
		<label for="cost"
			class='col-form-label  ${promotion.errors.get("cost") != null ? "is-invalid" : "" }'>Costo:</label>
		<input class="form-control" type="number" id="cost" name="cost"
			required value="${promotion.cost}"></input>
		<div class="invalid-feedback">
			<c:out value='${promotion.errors.get("cost")}'></c:out>
		</div>
	</div>

	<div class="mb-1 w-20 d-inline-block">
		<label for="discount"
			class='col-form-label ${promotion.errors.get("discount") != null ? "is-invalid" : "" }'>Discount:</label>
		<input class="form-control" type="number" id="discount"
			name="discount" required value="${promotion.discount}"></input>
		<div class="invalid-feedback">
			<c:out value='${promotion.errors.get("discount")}'></c:out>
		</div>
	</div>
	<div class="mb-1">
		<label for="descripcion"
			class='col-form-label ${promotion.errors.get("descripcion") != null ? "is-invalid" : "" }'>Descripción:</label>
		<input class="form-control" type="Text" id="descripcion"
			name="descripcion" required value="${promotion.description}"></input>
		<div class="invalid-feedback">
			<c:out value='${promotion.errors.get("Descripcion")}'></c:out>
		</div>
	</div>

	<div class="mb-1 w-50 d-inline-block">
		<label for="imagen"
			class='col-form-label ${promotion.errors.get("imagen") != null ? "is-invalid" : "" }'>Imagen:</label>
		<input class="form-control" type="text" id="imagen" name="imagen"
			required value="${promotion.imagen}"></input>
		<div class="invalid-feedback">
			<c:out value='${promotion.errors.get("imagen")}'></c:out>
		</div>
	</div>

	<div class="mb-1 w-45 d-inline-block">
		<label for="type"
			class='col-form-label ${promotion.errors.get("type") != null ? "is-invalid" : "" }'>Type:</label>
		<input class="form-control" type="text" id="type" name="type" required
			value="${promotion.type}"></input>
		<div class="invalid-feedback">
			<c:out value='${promotion.errors.get("type")}'></c:out>
		</div>
	</div>
	<div class="mb-1 w-45 d-inline-block">
		<label for="type"
			class='col-form-label'>TypeAttraction:</label>
		<input class="form-control" type="text" id="typeAttraction" name="typeAttraction" required
			value="${promotion.typeAttraction}"></input>
		<div class="invalid-feedback">
			<c:out value='${promotion.errors.get("typeAttraction")}'></c:out>
		</div>
	</div>
</div>
	<div class="mb-1">
		<label for="type"
			class='col-form-label'>Atracciones contenidas(Id de atracciones divididos por comas (Ejemplo: 1,2,3)):</label>
		<input class="form-control" type="text" id="attractionContained" name="attractionContained" required
			value="${promotion.attractionContained}"></input>
	</div>

</div>


<div>
	<button type="submit" class="btn btn-primary">Guardar</button>
	<a onclick="window.history.back();" class="btn btn-secondary"
		role="button">Cancelar</a>
</div>