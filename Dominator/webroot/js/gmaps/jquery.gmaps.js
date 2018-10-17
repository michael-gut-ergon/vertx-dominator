/**
* Theme: Minton Admin Template
* Author: Coderthemes
* Google Maps
*/
!function($) {
	"use strict";
	var GoogleMap = function() {};

    //creates map with markers
    GoogleMap.prototype.createMarkers = function($container) {
        var map = new GMaps({
          div: $container,
          lat: 46.818188,
          lng: 8.227512,
          zoom: 7,
          scrollwheel: false
        });
        map.addMarker({
          lat: 47.3593038,
          lng: 8.5520371,
          title: 'Zürich',
        });
        map.addMarker({
          lat: 46.9470786,
          lng: 7.4384828,
          title: 'Bern',
        });
        map.addMarker({
            lat: 46.0078947,
            lng: 8.9585991,
            title: 'Lugano',
          });

        return map;
    },

    //creates map with overlay
    GoogleMap.prototype.createWithOverlayZurich = function ($container) {
      var map = new GMaps({
        div: $container,
        lat: 47.3593038,
        lng: 8.5520371,
        zoom: 17,
        scrollwheel: false
      });
      map.drawOverlay({
        lat: map.getCenter().lat(),
        lng: map.getCenter().lng(),
        content: '<div class="gmaps-overlay">Klausstrasse 45<div class="gmaps-overlay_arrow above"></div></div>',
        verticalAlign: 'top',
        horizontalAlign: 'center'
      });

      return map;
    },
    
  //creates map with overlay
    GoogleMap.prototype.createWithOverlayBern = function ($container) {
      var map = new GMaps({
        div: $container,
        lat: 46.9470786,
        lng: 7.4384828,
        zoom: 17,
        scrollwheel: false
      });
      map.drawOverlay({
        lat: map.getCenter().lat(),
        lng: map.getCenter().lng(),
        content: '<div class="gmaps-overlay">Bubenbergplatz<div class="gmaps-overlay_arrow above"></div></div>',
        verticalAlign: 'top',
        horizontalAlign: 'center'
      });

      return map;
    },
    
  //creates map with overlay
    GoogleMap.prototype.createWithOverlayLugano = function ($container) {
      var map = new GMaps({
        div: $container,
        lat: 46.0078947,
        lng: 8.9585991,
        zoom: 17,
        scrollwheel: false
      });
      map.drawOverlay({
        lat: map.getCenter().lat(),
        lng: map.getCenter().lng(),
        content: '<div class="gmaps-overlay">Via Balestra 29<div class="gmaps-overlay_arrow above"></div></div>',
        verticalAlign: 'top',
        horizontalAlign: 'center'
      });

      return map;
    },
    //init
    GoogleMap.prototype.init = function() {
      var $this = this;
      $(document).ready(function(){
        //with sample markers
        $this.createMarkers('#gmaps-locations');

        //overlay
        $this.createWithOverlayZurich('#gmaps-zurich');
        $this.createWithOverlayBern('#gmaps-bern');
        $this.createWithOverlayLugano('#gmaps-lugano');
      });
    },
    //init
    $.GoogleMap = new GoogleMap, $.GoogleMap.Constructor = GoogleMap
}(window.jQuery),

//initializing 
function($) {
    "use strict";
    $.GoogleMap.init()
}(window.jQuery);