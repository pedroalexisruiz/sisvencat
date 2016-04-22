$(document).ready(function(){
				  $(window).bind('scroll', function() {
					var navHeight = 250; // custom nav height
					($(window).scrollTop() > navHeight) ? $('nav').addClass('goToTop') : $('nav').removeClass('goToTop');
				  });
				});