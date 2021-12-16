jQuery(document).ready(main)

function main() {

    /*Include the marker data and create the layers */
    let pinData = [
        ['Det over 330 år gamle Store Tårn på Christiansø har en bevæget historie som fæstningsværk bag sig.', 'Nyrenoverede Store Tårn', 55.32064521446226, 15.187448061725942,'/img/locations/den_store_taarn_linje2.jpeg'],
        ['Sangen "Ud på flisen, Karoline" om tjeneren Laurits og bogholderske Frøken Karoline blev landskendt i 1958, smag berømmelsen på kroen.', 'Kroen Ud på flisen, Karoline', 55.32083977341514, 15.186497194737282,'/img/locations/ud_paa_flisen_linje3.jpeg'],
        ['Kongens Bastion er en af de større bastioner på Christiansø, der blev anvendt til at forsvare søfæstningen.', 'Kongens Bastion', 55.317951798938815, 15.18846718246784,'/img/locations/kongens_bastion_linje4.jpeg'],
        ['Her fra Søfæstning Christiansøs højeste punkt har du mange muligheder for at indfange flotte motiver.', 'Møllebakken', 55.31925046535832, 15.189068364811785,'/img/locations/møllebakken_linje5.jpeg'],
        ['Når du har set Store Tårn, skal du også besøge museet på Lille Tårn på Frederiksø.', 'Lille Tårn på Frederiksø ', 55.322329613419015, 15.18371101745431,'/img/locations/lilletaarn_linje6.jpeg'],
        ['Rå kystlinje, der markerer Danmarks østligste punkt, og som nås via sammenfaldne volde.', 'Danmarks østligste punkt', 55.32042167575228, 15.192973332532961,'/img/locations/danmarks_oestligste_punkt_linje7.jpeg'],
        ['Hyggelig atmosfære især for børnefamilier.', 'Badebro', 55.321395545051864, 15.183469049589627,'/img/locations/badebro_linje8.jpeg'],
        ['Historisk butik med de fineste suiveniere til familien og vennerne derhjemme.', 'Sirenehuset', 55.32025983744189, 15.1868082958823,'/img/locations/sirenehuset_linje9.jpeg'],
    ];

    /* route 1*/
    let polylineRoute1 = [
        [55.32037, 15.18821],
        [55.32237, 15.18641],

    ];

    /* route 1*/
    let polylineRoute2 = [
        [55.32037, 15.18821],
        [56.32237, 16.18641],

    ];

    /* route 1*/
    let polylineRoute3 = [
        [55.32037, 15.18821],
        [53.32237, 14.18641],

    ];


    /* Create pins and their popups*/
    // Vi har taget udgangspunkt i denne måde at sætte pins ind på mappet
    // https://jsfiddle.net/askebos/v2c4fk40/9/ linje 15
    let myMarkerLayer = new L.LayerGroup();
    for (let i = 0; i < pinData.length; i++) {
        locationMarker = L.marker([pinData[i][2], pinData[i][3]]
        ).bindPopup("<h1>" + pinData[i][1] + "</h1> " +
            "<img height='200px' src=" + pinData[i][4] + ">" +
            "<p>" + pinData[i][0] + "</p>"
        ).addTo(myMarkerLayer)
    }

    /*Initialize map; and change Lat & Lang to Christiansø*/
    // Vi har taget udgangspunkt i dukumentationen på leaflets hjemmeside
    // https://leafletjs.com/examples/quick-start/
    let x = 55.32037
    let y = 15.18821
    let z = 16
    let myMap = L.map('map', {
        layers: myMarkerLayer
    }).setView([x, y], z);
    myMap.zoomControl.setPosition('bottomright');


    /*Add tileLayers from openstreetmap*/
    // Vi har taget udgangspunkt i dukumentationen på leaflets hjemmeside
    // https://leafletjs.com/examples/quick-start/
    mapLink = '<a href="http://openstreetmap.org">OpenStreetMap<\/a>';
    L.tileLayer('http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        attribution: '&copy; ' + mapLink + ' Christiansø Map',
        maxZoom: 18,
    }).addTo(myMap);

    /*Draw route function*/
    // Her har vi taget udgangspunkt i dokumentationen på leaflets hjemmeside
    // https://leafletjs.com/reference.html#polyline
    function drawRoute(list) {
        for (let i = 0; i < pinData.length; i++) {
            L.polyline(list).addTo(myMap);
        }
    }

    drawRoute(polylineRoute1);
    drawRoute(polylineRoute2);
    drawRoute(polylineRoute3);

}