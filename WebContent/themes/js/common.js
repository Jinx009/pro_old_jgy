/**
 * 导航选择样式
 */
function showLi(id){
	$('.menu li').each(function(){
		$(this).removeClass('active');
	})
	$('#'+id).addClass('active');
}
function openMenu(){
	$('.menu').toggle();
}
