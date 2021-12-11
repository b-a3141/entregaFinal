<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal-body">
	
	<div class="mb-3">
		<label for="name" class='col-form-label 
		 ${promotion.errors.get("name") != null ? "is-invalid" : "" }'>
		 Nombre:
		 </label> 
		 <input type="text" class="form-control" id="name" name="name"
			required value="${promotion.name}"></input>
		 <div class="invalid-feedback">
			<c:out value='${promotion.errors.get("name")}'></c:out>
		</div>
	</div>
	
	<div class="mb-3">
		<label for="type" class='col-form-label 
		 ${promotion.errors.get("type") != null ? "is-invalid" : "" }'>
		 Type:
		 </label> 
		 <input type="text" class="form-control" id="type" name="type"
			required value="${promotion.type}"></input>
		 <div class="invalid-feedback">
			<c:out value='${promotion.errors.get("type")}'></c:out>
		</div>
	</div>
	
	<div class="mb-3">
		<label for="description" class='col-form-label 
		 ${promotion.errors.get("type") != null ? "is-invalid" : "" }'>
		 Description:
		 </label> 
		 <input type="text" class="form-control" id="description" name="description"
			required value="${promotion.description}"></input>
		 <div class="invalid-feedback">
			<c:out value='${promotion.errors.get("description")}'></c:out>
		</div>
	</div>
	
	<div class="mb-3">
		<label for="imagen" class='col-form-label 
		 ${promotion.errors.get("type") != null ? "is-invalid" : "" }'>
		 Url Imagen:
		 </label> 
		 <input type="url" class="form-control" id="imagen" name="imagen"
			required value="${promotion.imagen}"></input>
		 <div class="invalid-feedback">
			<c:out value='${promotion.errors.get("imagen")}'></c:out>
		</div>
	</div>
	
	<div class="mb-3">
		<label for="capacity"
			class='col-form-label 
			${promotion.errors.get("capacity") != null ? "is-invalid" : "" }'>
			Duration:</label>
		<input class="form-control" type="number" id="capacity" name="capacity"
			required value="${promotion.duration}"></input>
		<div class="invalid-feedback">
			<c:out value='${promotion.errors.get("capacity")}'></c:out>
		</div>
	</div>
	
	<div class="mb-3">
		<label for="cost" class='col-form-label 
		${promotion.errors.get("cost") != null ? "is-invalid" : "" }'>
		Costo:
		</label>
		<input class="form-control" type="number" id="cost" name="cost"
			required value="${promotion.cost}"></input>
		<div class="invalid-feedback">
			<c:out value='${promotion.errors.get("cost")}'></c:out>
		</div>
	</div>
	
	<div class="mb-3">
		<label for="discount"
			class='col-form-label 
			${promotion.errors.get("discount") != null ? "is-invalid" : "" }'>
			Discount (1/0):</label>
		<input class="form-control" type="number" id="discount" name="discount"
			required value="${promotion.capacity}"></input>
		<div class="invalid-feedback">
			<c:out value='${promotion.errors.get("discount")}'></c:out>
		</div>
	</div>
</div>

<div>
	<button type="submit" class="btn btn-primary">Guardar</button>
	<a onclick="window.history.back();" class="btn btn-secondary"
		role="button">Cancelar</a>
</div>
