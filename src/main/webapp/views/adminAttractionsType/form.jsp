<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="modal-body">

	<div class="mb-2">
		<label for="attractionsType" class="col-form-label">
		Nombre del tipo de atracción:</label> 
		<input type="text" class="form-control" id="attractionsTypeName" 
		name="attractionsTypeName" placeholder= "Una palabra sin espacios"
		required value="${attractionsType.attractionsTypeName}"
		maxlength="15" pattern="[a-z]">
		<p>Los nombres deben estar en minúsculas 
		y tener hasta 15 caracteres de longitud.</p>
	</div>

	
		
</div>


<div>
	<button type="submit"  class="btn btn-primary">Guardar</button>
	<a onclick="window.history.back();" class="btn btn-secondary"
		role="button">Cancelar</a>
</div>