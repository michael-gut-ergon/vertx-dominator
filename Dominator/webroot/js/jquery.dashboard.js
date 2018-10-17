/**
* Theme: Minton Admin Template
* Author: Coderthemes
* Component: Sparkline Chart
*
*/
$( document ).ready(function() {

    var DrawSparkline = function() {
        $('#sparkline1').sparkline([50, 230, 143, 235, 244, 145, 156], {
            type: 'line',
            width: $('#sparkline1').width(),
            height: '165',
            chartRangeMax: 300,
            lineColor: '#3bafda',
            fillColor: 'rgba(59,175,218,0.3)',
            highlightLineColor: 'rgba(0,0,0,.1)',
            highlightSpotColor: 'rgba(0,0,0,.2)',
        });

        $('#sparkline1').sparkline([225, 223, 286, 224, 225, 132, 230], {
            type: 'line',
            width: $('#sparkline1').width(),
            height: '165',
            chartRangeMax: 300,
            lineColor: '#00b19d',
            fillColor: 'rgba(0, 177, 157, 0.3)',
            composite: true,
            highlightLineColor: 'rgba(0,0,0,.1)',
            highlightSpotColor: 'rgba(0,0,0,.2)',
        });
        
        $('#sparkline1').sparkline([125, 263, 162, 54, 275, 222, 130], {
            type: 'line',
            width: $('#sparkline1').width(),
            height: '165',
            chartRangeMax: 300,
            lineColor: '#20b12d',
            fillColor: 'rgba(0, 177, 157, 0.3)',
            composite: true,
            highlightLineColor: 'rgba(0,0,0,.1)',
            highlightSpotColor: 'rgba(0,0,0,.2)',
        });
        
        $('#sparkline1').sparkline([88, 201, 240, 261, 256, 192, 112], {
            type: 'line',
            width: $('#sparkline1').width(),
            height: '165',
            chartRangeMax: 300,
            lineColor: '#0fa197',
            fillColor: 'rgba(0, 177, 157, 0.3)',
            composite: true,
            highlightLineColor: 'rgba(0,0,0,.1)',
            highlightSpotColor: 'rgba(0,0,0,.2)',
        });

    };

    DrawSparkline();

    var resizeChart;

    $(window).resize(function(e) {
        clearTimeout(resizeChart);
        resizeChart = setTimeout(function() {
            DrawSparkline();
        }, 300);
    });
});