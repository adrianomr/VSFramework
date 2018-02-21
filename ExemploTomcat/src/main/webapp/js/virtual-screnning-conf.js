var pagina;
var boxVariation;
var virtualScrenningConstructor = function(id, name, distributionConfig){
	this.id = id;
	this.name = name;
	this.ditributionType = distributionConfig;
	this.operationalSystem = "";
	this.timeToRepeat = "0";
	this.flexibleReceptor = "false";
	this.receptorPath = "";
	this.receptorType = "PDBQT";
	this.multipleLigands = "false";
	this.ligandType = "PDBQT";
	this.rigidLigand = "false";
	this.ligandPath = "";
	this.outputPath = "";
	this.exhaustiviness = "8";
	this.boxVariation = "false";
	this.boxCenterX = "0";
	this.boxCenterY = "0";
	this.boxCenterZ = "0";
	this.boxSizeX = "0";
	this.boxSizeY = "0";
	this.boxSizeZ = "0";
	this.boxEndCenterX = "0";
	this.boxEndCenterY = "0";
	this.boxEndCenterZ = "0";
	this.boxStepX = "0";
	this.boxStepY = "0";
	this.boxStepZ = "0";
};
var virtualScrenning;
var repeat;
window.onload = function() {
	var id = localStorage.getItem("idVirtualScrenning");
	var name = localStorage.getItem("nameVirtualScrenning");
	var distributionConf = localStorage.getItem("distributionConfVirtualScrenning");
	pagina = 0;
	repeat = false;
	boxVarition = false;
	if(localStorage.getItem("virtualScrenning")!=null){
		virtualScrenning = JSON.parse(localStorage.getItem("virtualScrenning"));
	}else{
		virtualScrenning = new virtualScrenningConstructor(id, name, "none");
	}
		 if(pagina == 0){
			  $("#form-body").load("input-output-area.html", setDadosFormInputOutputArea); 
			  console.log($("body loaded"));
			 pagina = pagina + 1;
		 }
}

$(".next").click(function() {
	var lastPage = 6;
	console.log("pagina"+pagina);
	var finishConfiguration = false;
	if(pagina == 1){
		
		$("#form-body").load("form-receptor.html", setDadosFormReceptor);
		if(repeat == true){
			virtualScrenning.timeToRepeat = $("#times").val();
		}else{
			virtualScrenning.timeToRepeat = "0";
		}
		;
	}
    if(pagina == 2){
		virtualScrenning.receptorPath = $("#receptorPath").val();
		$("#form-body").load("form-ligand.html", setDadosFormLigand); 
		
	}
	if(pagina == 3){
		virtualScrenning.ligandPath = $("#ligandPath").val();
		if ($("#ligandType").text() == 'PDBQT'){
			virtualScrenning.ligandType = "PDBQT";
			virtualScrenning.multipleLigands = "false";
		}else if ($("#ligandType").text() == 'MOL2 (multiple structures)'){
			virtualScrenning.ligandType = "MOL2";
			virtualScrenning.multipleLigands = "true";
    	}else{
			virtualScrenning.multipleLigands = "false";
			virtualScrenning.ligandType = "MOL2";
    	}
		$("#form-body").load("form-output.html", setDadosFormOutput); 
	}
	if(pagina == 4){
		virtualScrenning.outputPath = $("#outputPath").val();
		virtualScrenning.exhaustiviness = $("#exhaustiviness").val();
		virtualScrenning.MGLPath = $("#mglPath").val();
		$("#formTitle").html("Box Area");
		$("#form-body").load("form-box.html", setDadosFormBox); 
	}
	if(pagina == 5){
		virtualScrenning.boxCenterX = $("#boxCenterX").val();
		virtualScrenning.boxCenterY = $("#boxCenterY").val();
		virtualScrenning.boxCenterZ = $("#boxCenterZ").val();
		virtualScrenning.boxSizeX = $("#boxSizeX").val();
		virtualScrenning.boxSizeY = $("#boxSizeY").val();
		virtualScrenning.boxSizeZ = $("#boxSizeZ").val();
		if(!boxVariation){
			finishConfiguration = true;
		}else{
			$("#form-body").load("form-box-variation.html",setDadosFormBoxVariation); 
		}
	}
	if(pagina == 6){
		virtualScrenning.boxEndCenterX = $("#boxEndCenterX").val();
		virtualScrenning.boxEndCenterY = $("#boxEndCenterY").val();
		virtualScrenning.boxEndCenterZ = $("#boxEndCenterZ").val();
		virtualScrenning.boxStepX = $("#boxStepX").val();
		virtualScrenning.boxStepY = $("#boxStepY").val();
		virtualScrenning.boxStepZ = $("#boxStepZ").val();
	}
	if(pagina < lastPage && !finishConfiguration){
		pagina = pagina +1;
	}else{
		$('#concludeConfiguration').modal('toggle');
		$('#concludeConfiguration').modal('show');
		var modalBody = "<div class = 'row'>";
		modalBody += "<div class='col-md-5'>";
		modalBody += "<strong>ID</strong><br>"+virtualScrenning.id;
		modalBody += "<br><strong>Name</strong><br>"+virtualScrenning.name;
		modalBody += "<br><strong>Distribuition</strong><br>"+virtualScrenning.ditributionType;
		modalBody += "<br><strong>Times to Repeat</strong><br>"+virtualScrenning.timeToRepeat;
		modalBody += "<br><strong>Flexible Receptor</strong><br>"+(virtualScrenning.flexibleReceptor ? "Yes" : "No");
		modalBody += "<br><strong>Receptor Path</strong><br>"+virtualScrenning.receptorPath;
		modalBody += "<br><strong>Multiple Ligands</strong><br>"+(virtualScrenning.multipleLigands ? "Yes" : "No");
		modalBody += "<br><strong>Rigid Ligand</strong><br>"+(virtualScrenning.rigidLigand ? "Yes" : "No");
		modalBody += "</div>";
		modalBody += "<div class='col-md-5'>";
		modalBody += "<strong>Ligand Path</strong><br>"+virtualScrenning.ligandPath;
		modalBody += "<br><strong>Output Path</strong><br>"+virtualScrenning.outputPath;
		modalBody += "<br><strong>Exhaustiviness</strong><br>"+virtualScrenning.exhaustiviness;
		modalBody += "<br><strong>Box Center</strong><br>";
		modalBody += "X: "+virtualScrenning.boxCenterX + " Y: "+virtualScrenning.boxCenterY + " Z: "+virtualScrenning.boxCenterZ;
		modalBody += "<br><strong>Box Size</strong><br>";
		modalBody += "X: "+virtualScrenning.boxSizeX + " Y: "+virtualScrenning.boxSizeY + " Z: "+virtualScrenning.boxSizeZ;
		if(boxVariation){
			modalBody += "<br><strong>Box Final Center</strong><br>";
			modalBody += "X: "+virtualScrenning.boxEndCenterX + " Y: "+virtualScrenning.boxEndCenterY + " Z: "+virtualScrenning.boxEndCenterZ;
			modalBody += "<br><strong>Box Variation Step</strong><br>";
			modalBody += "X: "+virtualScrenning.boxStepX + " Y: "+virtualScrenning.boxStepY + " Z: "+virtualScrenning.boxStepZ;
		}
		modalBody += "</div>";
		modalBody += "</div>";
			jQuery.ajax({
			headers: { 
				'Accept': 'application/json',
				'Content-Type': 'application/json' 
			},
			'type': 'PUT',
			'url': location.protocol + '//' + location.host+'/webresources/virtualscrenning',
			'data': JSON.stringify(virtualScrenning),
			'dataType': 'json',
			'success': function () {
						console.log("okay");
						$.ajax({
								url: location.protocol + '//' + location.host+'/webresources/virtualscrenning/execute/'+virtualScrenning.id
							}).then(function(data) {
								console.log("pegou lista");
								
								$("#downloadlink").attr({target: '_blank', 
                    href  :  makeTextFile(data)});
							});
						
                    }
			});
		alert(JSON.stringify(virtualScrenning));
		$('.modal-body').html(modalBody)
	}
	localStorage.setItem("virtualScrenning", JSON.stringify(virtualScrenning));
	console.log(JSON.stringify(virtualScrenning));
});

var textFile = null,
  makeTextFile = function (text) {
    var data = new Blob([text], {type: 'text/plain'});

    // If we are replacing a previously generated file we need to
    // manually revoke the object URL to avoid memory leaks.
    if (textFile !== null) {
      window.URL.revokeObjectURL(textFile);
    }

    textFile = window.URL.createObjectURL(data);

    return textFile;
  };


$(".back").click(function() {
	if(pagina == 1){
		console.log("redirecting");
		window.location.replace("ips-list.html");
	}
	if(pagina == 2){
		$("#form-body").load("input-output-area.html", setDadosFormInputOutputArea);
		console.log(pagina);
	}
    if(pagina == 3){
		$("#form-body").load("form-receptor.html", setDadosFormReceptor);
		console.log(pagina);
	}
	if(pagina == 4){
		$("#form-body").load("form-ligand.html", setDadosFormLigand);
		console.log(pagina);
	}
	if(pagina == 5){
		$("#form-body").load("form-output.html", setDadosFormOutput);
		console.log(pagina);
	}
	if(pagina == 6){
		$("#form-body").load("form-box.html", setDadosFormBox);
		console.log(pagina);
	}
	localStorage.setItem("virtualScrenning", JSON.stringify(virtualScrenning));
	pagina = pagina - 1;
});

var setDadosFormBoxVariation = function (){
	$("#boxEndCenterX").val(virtualScrenning.boxEndCenterX);
	$("#boxEndCenterY").val(virtualScrenning.boxEndCenterY);
	$("#boxEndCenterZ").val(virtualScrenning.boxEndCenterZ);
	$("#boxStepX").val(virtualScrenning.boxStepX);
	$("#boxStepY").val(virtualScrenning.boxStepY);
	$("#boxStepZ").val(virtualScrenning.boxStepZ);
}

var setDadosFormBox = function (){
	$("#boxCenterX").val(virtualScrenning.boxCenterX);
	$("#boxCenterY").val(virtualScrenning.boxCenterY);
	$("#boxCenterZ").val(virtualScrenning.boxCenterZ);
	$("#boxSizeX").val(virtualScrenning.boxSizeX);
	$("#boxSizeY").val(virtualScrenning.boxSizeY);
	$("#boxSizeZ").val(virtualScrenning.boxSizeZ);
	$('.boxVariation > button.btn').removeClass('active');
	if(boxVariation){
		$("#boxVariationTrue").addClass("active");
	}else{
		$("#boxVariationFalse").addClass("active");
	}
}

var setDadosFormOutput = function(){
	console.log(virtualScrenning.ligandType);
	if(virtualScrenning.ligandType == "MOL2"){
		$(".show-when-mol2").show();
	}
	$("#outputPath").val(virtualScrenning.outputPath);
	$("#exhaustiviness").val(virtualScrenning.exhaustiviness);
	$("#mglPath").val(virtualScrenning.MGLPath);
}

var setDadosFormLigand = function(){
	$("#ligandPath").val(virtualScrenning.ligandPath);
	if (virtualScrenning.ligandType == 'PDBQT'){
		$("#ligandType").text("PDBQT");
	}else if ((virtualScrenning.ligandType == "MOL2") && (virtualScrenning.multipleLigands == "true")){
		$("#ligandType").text('MOL2 (multiple structures)');
	}else{
		$("#ligandType").text('MOL2 (single structures)');
	}
	$('.rigidLigand > button.btn').removeClass('active');
	console.log(virtualScrenning.rigidLigand ? "true":"false");
	if(virtualScrenning.rigidLigand == "true"){
		$("#yesRigidLigand").addClass('active');
	}else{
		$("#notRigidLigand").addClass('active');
	}
	console.log(repeat);
	if(repeat == false){
		$(".not-repeat").show();
	}
}
var setDadosFormReceptor = function(){
	$("#receptorPath").val(virtualScrenning.receptorPath);
	console.log(repeat);
	if(repeat == false){
		$(".not-repeat").show();
	}
	$('.flexibleReceptor > button.btn').removeClass('active');
	console.log(virtualScrenning.multipleReceptor);
	if(virtualScrenning.flexibleReceptor == "true"){
		$("#multipleReceptor").addClass('active');
	}else{
		$("#notMultipleReceptor").addClass('active');
	}
	$('.receptorType > button.btn').removeClass('active');
	$("#"+	virtualScrenning.receptorType).addClass('active');
}
var setDadosFormInputOutputArea = function(){
	
	$('.repeatExperiment > button.btn').removeClass('active');
	console.log(virtualScrenning.multipleReceptor);
	if(repeat){
		$("#repeat").addClass('active');
	}else{
		$("#notRepeat").addClass('active');
	}
	$('.operationalSystem > button.btn').removeClass('active');
	if(virtualScrenning.operationalSystem == "Windows"){
		$("#windows").addClass('active');
	}else{
		$("#linux").addClass('active');
	}
}