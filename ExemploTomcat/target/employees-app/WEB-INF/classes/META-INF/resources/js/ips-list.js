
window.onload = function() {
	var id = localStorage.getItem("idVirtualScrenning");
	$.ajax({
		url: location.protocol + '//' + location.host+"/webresources/nodes/"+id
	}).then(function(data) {
		console.log("pegou lista");
		var html = "";
		console.log(data);
		for(var i=0; i<data.length; i++) {
			console.log(i, data[i]); // i é o índice, matriz[i] é o valor
			html += '<a href="#" class="list-group-item list-group-item-action">';
			html += '      <div class="media">';
			html += '        <div class="media-body">';
			html += '          <strong style = "font-size:15px;">'+data[i].ip+':'+data[i].port+'</strong>';
			html += '          <div class="pull-right">';
			if(data[i].status=="ok"){
				html += '				<i class="fa fa-check fa-2x" aria-hidden="true"></i>';
			}else{
				html += '				<i class="fa fa-times fa-2x" aria-hidden="true"></i>';
			}
			html += '          </div>';
			html += '        </div>';
			html += '      </div>';
			html += '    </a>';
			
		}
		$(".ips").html(html);
	});
}