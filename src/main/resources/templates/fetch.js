window.addEventListener("load", async() => {

    let myMarker = new L.LayerGroup();
    /*Initialize map; and change Lat & Lang to Christiansø*/
    let x = 55.32037
    let y = 15.18821
    let z = 16
    let myMap = L.map('map', {
        layers: myMarker
    }).setView([x, y], z);
    myMap.zoomControl.setPosition('bottomright');

    //myMap.on('popupopen', function() {
    //    getDescription()
    //});

    /*Add tileLayers from openstreetmap*/
    mapLink = '<a href="http://openstreetmap.org">OpenStreetMap<\/a>';
    L.tileLayer('http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        attribution: '&copy; ' + mapLink + ' Christiansø Map',
        maxZoom: 18,
    }).addTo(myMap);

    async function fetchAllLocationData() {
        let array = []
        let res = await fetch('http://localhost:8080/locations/');
        let responseData = await res.json();

        responseData.forEach(data => {
            array.push(data);
        })
        return array
    }


    const pinData = await fetchAllLocationData()

    pinData.forEach(data => {
        data.description
    })

    console.log(pinData)


    /*Include the marker data and create the layers */
    let pinData2 = [
        ['Det over 330 år gamle Store Tårn på Christiansø har en bevæget historie som fæstningsværk bag sig.', 'Nyrenoverede Store Tårn', 55.32064521446226, 15.187448061725942, '/img/locations/den_store_taarn_linje2.jpeg'],
        ['Sangen "Ud på flisen, Karoline" om tjeneren Laurits og bogholderske Frøken Karoline blev landskendt i 1958, smag berømmelsen på kroen.', 'Kroen Ud på flisen, Karoline', 55.32083977341514, 15.186497194737282, '/img/locations/ud_paa_flisen_linje3.jpeg'],
        ['Kongens Bastion er en af de større bastioner på Christiansø, der blev anvendt til at forsvare søfæstningen.', 'Kongens Bastion', 55.317951798938815, 15.18846718246784, '/img/locations/kongens_bastion_linje4.jpeg'],
        ['Her fra Søfæstning Christiansøs højeste punkt har du mange muligheder for at indfange flotte motiver.', 'Møllebakken', 55.31925046535832, 15.189068364811785, '/img/locations/møllebakken_linje5.jpeg'],
        ['Når du har set Store Tårn, skal du også besøge museet på Lille Tårn på Frederiksø.', 'Lille Tårn på Frederiksø ', 55.322329613419015, 15.18371101745431, '/img/locations/lilletaarn_linje6.jpeg'],
        ['Rå kystlinje, der markerer Danmarks østligste punkt, og som nås via sammenfaldne volde.', 'Danmarks østligste punkt', 55.32042167575228, 15.192973332532961, '/img/locations/danmarks_oestligste_punkt_linje7.jpeg'],
        ['Hyggelig atmosfære især for børnefamilier.', 'Badebro', 55.321395545051864, 15.183469049589627, '/img/locations/badebro_linje8.jpeg'],
        ['Historisk butik med de fineste suiveniere til familien og vennerne derhjemme.', 'Sirenehuset', 55.32025983744189, 15.1868082958823, '/img/locations/sirenehuset_linje9.jpeg'],
        ['Elsker du sild, så skal du absolut besøge denne fiske handler.', 'Christiansøpigens Sild', 55.13758721062028, 15.145363403031045, '/img/locations/pigensSild.png']
    ];

    let locationPictures = [
        ['hv']
    ];


    /* Create pins and their popups*/


    for (let i = 0; i < pinData.length; i++) {
        locationMarker = L.marker([pinData[i][3], pinData[i][3]]
        ).bindPopup("<h1>" + pinData[i][1] + "</h1> " +
            "<p>" + ${location.description} + "</p>" +
            "<img height='200px' src=" + pinData[i][4] + ">" +
            "<button id='guided-tour'>Ruter og Guides</button>" +
            "<button id='nature' >Naturen</button>" +
            "<br>" +
            "<br>" +
            "<div>" +
            "<h2>Forslåede ruter og ture</h2>" +
            "<p>Her kan du finde de mest populære ruter til forskellige guidede ture.</p>" +
            "<input type='image' height='100px' style='border: transparent 10px' src=" + pinData[i][4] + ">" +
            "<input type='image' height='100px' src=" + pinData[i][4] + ">" +
            "<input type='image' height='100px' src=" + pinData[i][4] + ">" +
            "<input type='image' height='100px' src=" + pinData[i][4] + ">" +
            "</div>")
            .addTo(myMarker)
    }


    for (let i = 0; i < pinData.length; i++) {
        /* routes on map using polyline */
        let polylinePoints = [
            [55.32037, 15.18821],
            [55.32237, 15.18641],

        ];

        let polyline = L.polyline(polylinePoints).addTo(myMap);
    }
});