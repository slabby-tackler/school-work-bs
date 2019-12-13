$(document).ready (function (){
	var uri = location.pathname;
	uri = uri.split('/');
	
	$('a[href="/' + uri[1] + '"]').addClass ('active');
	$('a[href="/' + uri[1] + '/' + uri[2] + '"]').addClass ('active');
	
	$('.toggle-btn').click(function() {
		var button = $(this).data('btn');
		var others = $(this).data('others').split(' ');
		
		$('.' + button).show();
		$('.' + others[0]).hide();
		$('.' + others[1]).hide();
		
		$('.toggle-btn').removeClass('btn-active');
		$(this).addClass('btn-active');
	});
});
