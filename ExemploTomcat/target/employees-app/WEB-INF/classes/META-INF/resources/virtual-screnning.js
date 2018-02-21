$( ".btn" ).click(function() {

  var target_selector = $(this).attr('data-target');
  var id = $(this).attr('id');
  var $target = $(target_selector);
	
  if(target_selector == '#file-config'){
	  $("#distributionConfig").text($(this).text());
    if (id=='File'){console.log('target hidden');
      $target.show( "slow" );
		localStorage.setItem("distributionConfVirtualScrenning", "File");
    }else{console.log('target visible');
		  localStorage.setItem("distributionConfVirtualScrenning", "None");
      $target.hide( "slow" );
    }
  }   

});

$( "#cancel" ).click(function(){
	localStorage.removeItem("idVirtualScrenning");
	localStorage.removeItem("nameVirtualScrenning");
	localStorage.removeItem("distributionConfVirtualScrenning");
	localStorage.removeItem("virtualScrenning");
	localStorage.removeItem("nodesFileVirtualScrenning");
});

window.onload = function() {
	if(localStorage.getItem("idVirtualScrenning")!=null){
		console.log("temvs");
		$("#idVirtualScrenning").val(localStorage.getItem("idVirtualScrenning"));
		$("#nameVirtualScrenning").val(localStorage.getItem("nameVirtualScrenning"));
		$("#distributionConfig").text(localStorage.getItem("distributionConfVirtualScrenning"));
		if (localStorage.getItem("distributionConfVirtualScrenning")=='File'){console.log('target hidden');
			$("#nodes-file").text(localStorage.getItem("nodesFileVirtualScrenning"));
			$("#file-config").show();
		}
	}
}
$( ".next-vs" ).click(function() {

	localStorage.setItem("idVirtualScrenning", $("#idVirtualScrenning").val());
	localStorage.setItem("nameVirtualScrenning", $("#nameVirtualScrenning").val());
	var valorSalvo = localStorage.getItem("idVirtualScrenning");
	console.log(valorSalvo);
	if($("#distributionConfig").text() == "File"){
		localStorage.setItem("nodesFileVirtualScrenning", $("#nodes-file").val());
		jQuery.ajax({
			headers: { 
				'Accept': 'application/json',
				'Content-Type': 'application/json' 
			},
			'type': 'PUT',
			'url': location.protocol + '//' + location.host+'/webresources/nodes',
			'data': '{"idVirtualScrenning":"'+$("#idVirtualScrenning").val()+'", "file":"'+$("#nodes-file").val()+'"}',
			'dataType': 'json',
			'success': function () {
						window.location.href = "ips-list.html";
                    }
			});
		
	}else{
		window.location.href = "virtual-screnning-configuration.html";
	}
});