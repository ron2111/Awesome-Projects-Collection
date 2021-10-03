function initMap() {
	map = new google.maps.Map(document.getElementById('map'), {
		center: {
			lat: 17.488299557439902, 
			lng: 78.31503755499409,
		},
		zoom: 12,
		mapId: 'map_id',
		mapTypeControl: false,
		fullscreenControl: false,
		streetViewControl: false,
	});


	const markers = [
		[
			"Theatre",
			17.459636965616664, 78.3641119067139,
			'theatre.png',
			38,
			31,
		],
		[
			'You Are Here',
			17.488299557439902, 
			78.31503755499409,
			'images/pointer.svg',
			30,
			47.8,
		],
		[
			'Resturant',
			17.446163325272238, 78.36060556596894,
			'images/resturant.png',
			40,
			48,
		],
		['Gitam University', 17.551257910910923, 78.1662603115125, 'images/college.png', 40, 53],
		['Park', 17.506530904343002, 78.35642768637649, 'images/park.png', 38, 42.5],
		['Hospital', 17.532300366433578, 78.25915901312455, 'images/hospital.png', 38, 38],
		[
			'BVBP School',
			17.49343124506554, 78.29641674219897,
			'images/school.png',
			50,
			60.7,
		],
		[
			'Bakery',
			17.49786907745451, 78.32821603780515,
			'images/bakery.svg',
			50,
			60.7,
		],
		[
			'Lake',
			17.524046674979246, 78.32761106857963,
			'images/lake.png',
			50,
			60.7,
		],
	];

	for (let i = 0; i < markers.length; i++) {
		const currMarker = markers[i];

		const marker = new google.maps.Marker({
			position: { lat: currMarker[1], lng: currMarker[2] },
			map,
			title: currMarker[0],
			icon: {
				url: currMarker[3],
				scaledSize: new google.maps.Size(currMarker[4], currMarker[5]),
			},
			animation: google.maps.Animation.DROP,
		});

		const infowindow = new google.maps.InfoWindow({
			content: currMarker[0],
		});

		marker.addListener('click', () => {
			infowindow.open(map, marker);
		});
	}
}