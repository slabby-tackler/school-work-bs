$(document).ready(function () {
	$('.showable').click (function () {
		var thing = $(this).data('object');
		document.location.href = '/' + thing + '/' + $(this).data('id');
	});
	
	$('.admin-delete').click(function () {
		$(this).closest('form').submit();
	});
});


