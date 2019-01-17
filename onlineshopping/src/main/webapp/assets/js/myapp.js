$(function(){
	//solving active menu problem
	switch (menu) {
	
	case 'about us':
		$('#about').addclass('active');
		break;
	case 'contact us':
		$('#contact').addclass('active');
		break;
	case 'All Products':
		$('#listproducts').addclass('active');
		break;
	default:
		$('#listproducts').addclass('active');
		$('#a_'+menu).addclass('active');
		break;
		
	}
		
	
})