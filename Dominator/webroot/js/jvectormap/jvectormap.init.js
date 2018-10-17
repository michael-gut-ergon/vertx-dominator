/**
 * Theme: Minton Admin Template
 * Author: Coderthemes
 * VectorMap
 */

! function($) {
	"use strict";

	var VectorMap = function() {
	};

	VectorMap.prototype.init = function() {
		//various examples
		$('#world').vectorMap({
			map : 'world_mill',
			normalizeFunction : 'polynomial',
			hoverOpacity : 0.7,
			hoverColor : false,
			regionStyle : {
				initial : {
					fill : '#3bafda'
				}
			},
			markerStyle: {
                initial: {
                    r: 9,
                    'fill': '#a288d5',
                    'fill-opacity': 0.9,
                    'stroke': '#fff',
                    'stroke-width' : 7,
                    'stroke-opacity': 0.4
                },

                hover: {
                    'stroke': '#fff',
                    'fill-opacity': 1,
                    'stroke-width': 1.5
                }
            },
			backgroundColor : 'transparent',
			markers : [{
				latLng : [41.90, 12.45],
				name : 'Vatican City'
			}, {
				latLng : [43.73, 7.41],
				name : 'Monaco'
			}, {
				latLng : [47.14, 9.52],
				name : 'Liechtenstein'
			}, {
				latLng : [35.88, 14.5],
				name : 'Malta'
			}, {
				latLng : [7.35, 134.46],
				name : 'Palau'
			}, {
				latLng : [42.5, 1.51],
				name : 'Andorra'
			}, {
				latLng : [1.3, 103.8],
				name : 'Singapore'
			}, {
				latLng : [-20.2, 57.5],
				name : 'Mauritius'
			}]
		});

		$('#europe').vectorMap({
			map : 'europe_mill',
			backgroundColor : 'transparent',
			regionStyle : {
				initial : {
					fill : '#3bafda'
				}
			}
		});


		$('#switzerland').vectorMap({
			map : 'ch_mill',
			normalizeFunction : 'polynomial',
			hoverOpacity : 0.7,
			hoverColor : false,
			regionStyle : {
				initial : {
					fill : '#3bafda'
				}
			},
			markerStyle: {
                initial: {
                    r: 9,
                    'fill': '#a288d5',
                    'fill-opacity': 0.9,
                    'stroke': '#fff',
                    'stroke-width' : 7,
                    'stroke-opacity': 0.4
                },

                hover: {
                    'stroke': '#fff',
                    'fill-opacity': 1,
                    'stroke-width': 1.5
                }
            },
			backgroundColor : 'transparent',
			markers : [{
				latLng : [47.3673, 8.55],
				name : 'Zürich'
			}, {
				latLng : [46.9479, 7.4446],
				name : 'Bern'
			}, {
				latLng : [46.0065, 8.9523],
				name : 'Lugano'
			}]
		});


		$('#austria').vectorMap({
			map : 'at_mill',
			backgroundColor : 'transparent',
			regionStyle : {
				initial : {
					fill : '#3bafda'
				}
			}
		});

		$('#germany').vectorMap({
			map : 'de_mill',
			backgroundColor : 'transparent',
			regionStyle : {
				initial : {
					fill : '#3bafda'
				}
			}
		});
	},
	//init
	$.VectorMap = new VectorMap, $.VectorMap.Constructor = VectorMap
}(window.jQuery),

//initializing
function($) {
	"use strict";
	$.VectorMap.init()
}(window.jQuery);