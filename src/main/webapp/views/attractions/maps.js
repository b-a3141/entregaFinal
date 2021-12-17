
let map;

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

}
let marker = new google.maps.Marker({
    position: {
           lat: -34.6037345,
           lng: -58.383
    },
    map: map,
    title: 'Viaducto de Segovia'
});