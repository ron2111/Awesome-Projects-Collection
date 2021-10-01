$(document).ready(function() {
    $("#mycarousel").carousel({interval: 2000});
    $("#carouselButton").click(function() {
        if($('#carouselButton').children('span').hasClass('fa-pause')) {
            $("#mycarousel").carousel('pause');
            $('#carouselButton').children('span').removeClass('fa-pause');
            $('#carouselButton').children('span').addClass('fa-play');
        }
        else{
            $("#mycarousel").carousel('cycle');
            $('#carouselButton').children('span').removeClass('fa-play');
            $('#carouselButton').children('span').addClass('fa-pause');
        }
    });
    $('#login').click(function() {
        $('#loginModal').modal('show')
    })
    $('#closeLogin').click(function() {
        $('#loginModal').modal('hide')
    })
    $('#cancelogin2').click(function() {
        $('#loginModal').modal('hide')
    })
    $('#reserveAtable').on('click', function() {
        $('#reservetablemodal').modal('show')
    })
    $('#closetablereserve').click(function() {
        $('#reservetablemodal').modal('hide')
    })
    $('#cancalReserve').on('click', function() {
        $('#reservetablemodal').modal('hide')
    })
});