$( ".btn" ).click(function() {

  var target_selector = $(this).attr('data-target');
  var id = $(this).attr('id');
  var $target = $(target_selector);
	
  if(target_selector == '#ligandType'){
	  $(target_selector).text($(this).text());
  }   

});

$(".operationalSystem > button.btn").on("click", function(){
    var num = this.innerHTML;
	$('.operationalSystem > button.btn').removeClass('active');
	$(this).addClass('active');
	virtualScrenning.operationalSystem = this.value;
});

$(".repeatExperiment > button.btn").on("click", function(){
    var num = this.innerHTML;
	$('.repeatExperiment > button.btn').removeClass('active');
	$(this).addClass('active');
	if(this.innerHTML=="No"){
		$(".times").hide();
		repeat = false;
	}else{
		repeat = true;
		$(".times").show();
	}
});


$(".receptorType > button.btn").on("click", function(){
    var num = this.innerHTML;
	$('.receptorType > button.btn').removeClass('active');
	$(this).addClass('active');
	virtualScrenning.receptorType = this.innerHTML;
});


$(".flexibleReceptor > button.btn").on("click", function(){
    var num = this.innerHTML;
	$('.flexibleReceptor > button.btn').removeClass('active');
	$(this).addClass('active');
	if(this.innerHTML=="No"){
		virtualScrenning.flexibleReceptor = "false";
	}else{
		virtualScrenning.flexibleReceptor = "true";
	}
});

$(".rigidLigand > button.btn").on("click", function(){
    var num = this.innerHTML;
	$('.rigidLigand > button.btn').removeClass('active');
	$(this).addClass('active');
	if(this.innerHTML=="No"){
		virtualScrenning.rigidLigand = "false";
	}else{
		virtualScrenning.rigidLigand = "true";
	}
});

$(".multipleLigand > button.btn").on("click", function(){
    var num = this.innerHTML;
	$('.multipleLigand > button.btn').removeClass('active');
	$(this).addClass('active');
	if(this.innerHTML=="No"){
		virtualScrenning.multipleLigand = "false";
	}else{
		virtualScrenning.multipleLigand = "true";
	}
});
$(".boxVariation > button.btn").on("click", function(){
    var num = this.innerHTML;
	$('.boxVariation > button.btn').removeClass('active');
	$(this).addClass('active');
	if(this.innerHTML=="No"){
		virtualScrenning.boxVariation = "false";
		boxVariation = false;
	}else{
		virtualScrenning.boxVariation = "true";
		boxVariation = true;
	}
});
