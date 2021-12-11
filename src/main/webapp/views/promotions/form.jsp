<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal-body">

	<div class="mb-2">
		<label for="name" class="col-form-label">Nombre:</label> <input
			type="text" class="form-control" id="name" name="name" required
			value="${promotion.name}">
	</div>
	<div class="mb-2 w-25 d-inline-block">
		<label for="cost"
			class='col-form-label ${promotion.errors.get("cost") != null ? "is-invalid" : "" }'>Costo:</label>
		<input class="form-control" type="number" id="cost" name="cost"
			required value="${promotion.cost}"></input>
		<div class="invalid-feedback">
			<c:out value='${promotion.errors.get("cost")}'></c:out>
		</div>
	</div>

	<div class="mb-2 w-25 d-inline-block">
		<label for="discount"
			class='col-form-label ${promotion.errors.get("discount") != null ? "is-invalid" : "" }'>Discount:</label>
		<input class="form-control" type="number" id="discount"
			name="discount" required value="${promotion.discount}"></input>
		<div class="invalid-feedback">
			<c:out value='${promotion.errors.get("discount")}'></c:out>
		</div>
	</div>
	<div class="mb-2">
		<label for="descripcion"
			class='col-form-label ${promotion.errors.get("descripcion") != null ? "is-invalid" : "" }'>Descripción:</label>
		<input class="form-control" type="Text" id="descripcion"
			name="descripcion" required value="${promotion.descripcion}"></input>
		<div class="invalid-feedback">
			<c:out value='${promotion.errors.get("Descripcion")}'></c:out>
		</div>
	</div>

	<div class="mb-2">
		<label for="imagen"
			class='col-form-label ${promotion.errors.get("imagen") != null ? "is-invalid" : "" }'>Imagen:</label>
		<input class="form-control" type="text" id="imagen" name="imagen"
			required value="${promotion.imagen}"></input>
		<div class="invalid-feedback">
			<c:out value='${promotion.errors.get("imagen")}'></c:out>
		</div>
	</div>

	<div class="mb-2">
		<label for="type"
			class='col-form-label ${promotion.errors.get("type") != null ? "is-invalid" : "" }'>Type:</label>
		<input class="form-control" type="text" id="type" name="type" required
			value="${promotion.type}"></input>
		<div class="invalid-feedback">
			<c:out value='${promotion.errors.get("type")}'></c:out>
		</div>
	</div>

</div>
<div class="mb-2">
	<label for="selector" class='col-form-label'>Seleccione promos:</label>
	<select id="selector" name="selector" multiple="multiple">
		<c:forEach begin="1" end="12" varStatus="loop">
			<option id="${loop.count}" value="${loop.count}">
				<c:out value="${loop.count}"></c:out>
			</option>
		</c:forEach>
	</select>
	<div class="invalid-feedback">
		<c:out value='${promotion.errors.get("imagen")}'></c:out>
	</div>
</div>
<script type="text/javascript">
	$(function() {
		$('#selector').multiselect();
	});
</script>


<div>
	<button type="submit" class="btn btn-primary">Guardar</button>
	<a onclick="window.history.back();" class="btn btn-secondary"
		role="button">Cancelar</a>
</div>
