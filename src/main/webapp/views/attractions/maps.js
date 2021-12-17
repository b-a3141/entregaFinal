let map;
// Nombre del proyecto para la api turismoTP3 
function initMap() {
  map = new google.maps.Map(document.getElementById("map"), {
    center: { lat: -34.6037345, lng: -58.3837591 },
    zoom: 15,
    mapTypeId: 'hybrid',
    scaleControl: true,
    fullscreenControlOptions: {
        position: google.maps.ControlPosition.RIGHT_BOTTOM
},
  });
}

function muestra_oculta(id){
	//se obtiene el id
if (document.getElementById){
	//se define la variable "el" igual a nuestro div 
var el = document.getElementById(id); 
 //damos un atributo display:none que oculta el div
el.style.display = (el.style.display == 'none') ? 'block' : 'none';

}
}
/*hace que se cargue la función lo que predetermina que div estará 
oculto hasta llamar a la función nuevamente*/

window.onload = function(){muestra_oculta('map');
/* "contenido_a_mostrar" es el nombre que le dimos al DIV */



}
let marker = new google.maps.Marker({
    position: {
           lat: -34.6037345,
           lng: -58.383
    },
    map: map,
    title: 'Viaducto de Segovia'
});