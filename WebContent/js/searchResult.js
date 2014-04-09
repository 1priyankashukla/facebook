

function sendReq(oForm,e){
	alert('ok');
    $.ajax({
    	
        url: oForm.attr('action'),
        type: oForm.attr('method'),
        data: oForm.serialize(),
        success: function(html) {
        alert('ok');
        }
    });
    e.preventDefault();
}
		
		

