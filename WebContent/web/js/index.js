var index = {};

index.escolhidos = {};

index.componentes = function(){
	index.btnNovo = $('#novo');
	index.btnInfo = $('#info');
	index.btnSair = $('#sair');
	index.palco = $('#palco');
	index.bemvindo = $('#bemvindo');
	index.btnCancelar = $('#cancelar');
	index.btnContinuar = $('#continuar');
	
	index.btnCancelarPerson = $('#cancelarPerson');
	index.btnContinuarPerson = $('#continuarPerson');
	index.personagens = $('#personagens');
	index.persons = $('.person');
	index.disponivel = $('#disponivel');
	
	index.slots = $('.slot');
	
	index.grupo = {};
	
	index.intro = $('#intro');
	index.btnContinuarIntro = $('#continuarIntro');
	
	index.mundo = $('#mundo');
	index.btnContinuarMundo = $('#continuarMundo');
	
	index.caminho = $('#caminho');
	index.btnContinuarCaminho = $('#continuarCaminho');
	
	index.entrada = $('#entrada');
	index.btnContinuarEntrada = $('#continuarEntrada');
	
	index.mapa = $('#mapa');
	index.btnContinuarMapa = $('#continuarMapa');
	
	index.black = $('.black');
	
	index.jogando = false;
	
	index.status = "";
	index.mapeamento = { "#p1" : ["#p2"]
						,"#p2" : ["#p3", "#p6"]
						,"#p3" : ["#p4"]
						,"#p4" : ["#p5"]
						,"#p5" : ["#p10"]
						,"#p10": ["#p9"]
						,"#p6" : ["#p7"]
						,"#p7" : ["#p8", "#p12"]
						,"#p12": ["#p13", "#p11", "#p15"]
						,"#p11": ["#p14"]
						,"#p14": ["#p16"]
						,"#p16": ["#p17"]
						,"#p17": ["#p18"]
						,"#p18": ["#p19"]
					   }
};

index.init = function() {
	index.componentes();
	index.esconderTudo();
	
	index.btnNovo.on('click', function(){
		if(! index.jogando) {
			index.novoJogo();
		} else {
			alert('Jogo já iniciado.');
		}
	});
	index.btnInfo.on('click', index.informacao);
	index.btnSair.on('click', index.sair);
	
	index.btnContinuar.on('click', index.continuar);
	
	index.btnCancelar.on('click', function() {
		index.close("bemvindo");
	});
	
	index.btnCancelarPerson.on('click', function() {
		index.limparSelecao();
		index.close("personagens");
	});
	
	index.btnContinuarPerson.on('click', function() {
		if(Object.keys(index.escolhidos).length === 3) {
			index.personagensEscolhidas();
		} else {
			alert("Escolha 3 personagens!");
			return;
		}
	});
	
	index.persons.each(function (a, img) { 
		$(img).on('click', index.addPersonEscolhida);
	});
	
	index.slots.each(function (a, slot) {
		$(slot).attr('disabled', 'disabled');
		$(slot).on('click', index.removeEscolhido);
	});
	
	index.btnContinuarIntro.on('click', function(){
		index.intro.hide();
		index.mundo.show();
	});
	
	index.btnContinuarMundo.on('click', function(){
		index.mundo.hide();
		index.caminho.show();
	});
	
	index.btnContinuarCaminho.on('click', function(){
		index.caminho.hide();
		index.entrada.show();
	});
	
	index.btnContinuarEntrada.on('click', function() {
		index.entrada.hide();
		index.exibirPalco();
	})
	
	$('#p1').on('click', function(){
		$('#p1').removeClass('black');
		$('#p1').addClass('yellow');
		index.ponto($('#p1'));
	});
};

index.esconderTudo = function() {
	index.bemvindo.hide();
	index.personagens.hide();
	index.intro.hide();
	index.mundo.hide();
	index.caminho.hide();
	index.entrada.hide();
	index.mapa.hide();
	index.palco.hide();
}

index.novoJogo = function() {
	// TODO implementar o reset de tudo;

	index.bemvindo.show();
};

index.informacao = function() {
	console.log('infos');
};

index.sair = function() {
	var saiu = confirm('Deseja encerrar o jogo?');
	
	if(saiu) {
		$.ajax({
			url: 'jogoController',
			data: {"acao": "encerrar"},
			type: 'post',
			success: function(){
				index.jogando = false;
				index.limparSelecao();
				index.esconderTudo();
			}
		});
	}
};

index.continuar = function() {
	index.close("bemvindo");
	index.personagens.show();
};

index.close = function(div) {
	var alvo = $('#' + div);
	alvo.hide();
}

index.personagensEscolhidas = function() {
	var person0 = index.escolhidos[0];
	var person1 = index.escolhidos[1];
	var person2 = index.escolhidos[2];
	
	var data = {"acao": "grupo"
				,json0: jogadores[index.escolhidos[0]]
				,classe0: index.escolhidos[0]
				,json1: jogadores[index.escolhidos[1]]
				,classe1: index.escolhidos[1]
				,json2: jogadores[index.escolhidos[2]]
				,classe2: index.escolhidos[2]}
	
	$.ajax({
		url: 'jogoController',
		data: data,
		type: 'post',
		success: index.iniciarAventura
	});
	index.close("personagens");
	index.jogando = true;
}

index.addPersonEscolhida = function() {
	if(Object.keys(index.escolhidos).length < 3) {
		var classe = $(this).attr('id');
		var slot = index.slotVazio();
		index.escolhidos[slot] = classe;
		
		var $classe = $('#'+classe);
		var $slot = $('#' + slot);
		
		$classe.attr('disabled', 'disabled');
		$classe.addClass('escolhido');
		$slot.removeAttr('disabled');
		$slot.html("<img id='" + classe + "_escolhido' class='imgPerson' src='web/img/" + classe + ".png'>");
	} else {
		alert("Todos Escolhidos!");
	}
}

index.slotVazio = function() {
	if(! index.escolhidos[0]) {
		return 0;
	} else if(! index.escolhidos[1]) {
		return 1;
	} else if(! index.escolhidos[2]) {
		return 2;
	}
}

index.limparSelecao = function() {
	$.each(index.escolhidos, function(idx, classe){
		var $classe = $('#'+classe);
		$('#'+ (idx)).html('');
		$classe.removeAttr('disabled');
		$classe.removeClass('escolhido');
		delete index.escolhidos[idx];
	});
}

index.removeEscolhido = function() {
	if(! $(this).attr('disabled')) {
		var id = $(this).attr('id');
		var escolhido = index.escolhidos[(id)];
		$('#' + escolhido).removeAttr('disabled');
		$('#' + escolhido).removeClass('escolhido');
		delete index.escolhidos[id];
		$(this).html('');
		$(this).attr('disabled', 'disabled');
	}
}

index.habilitarPonto = function(div) {
	
	$.each(index.mapeamento[div.selector], function(idx, key) {
		$(key).css('cursor', 'pointer');
		index.addListener($(key));
	});
}

index.addListener = function(key){
	key.on('click', function(){
		key.removeClass('black');
		key.addClass('yellow');
		index.ponto(key);
	});
}

index.ponto = function(div) {
	
	$.ajax({
		url: 'jogoController',
		data: {"acao": "evento"},
		type: 'post',
		success: function(data){
			var evento = JSON.parse(data)
			var tipo = evento.tipo;
			
			switch(tipo) {
				case "armadilha":
					index.armadilha(evento);
					break;
				case "nenhum":
					console.log(tipo);
					index.novosPontos(div);
					break;
				case "orc":
					console.log(tipo);
					break;
				case "tesouro":
					console.log(tipo);
					break;
			}
		}
	});
}

index.armadilha = function(armadilha) {
	index.status = "armadilha";
	index.addEventoNosPersonagens(index.desviarArmadilha);
}

index.desviarArmadilha = function(idx) {
	// colocar alerta
	//$(index.palco.find('div.status img.imagem')[2]).before($('<div class="armadilha"><img src="web/img/atencao.png" class="armadilha"/>'))
	
	//remover alerta
	index.palco.find('div.status img:nth-child(' + (idx - 1) + ')').remove();
	
	$.ajax({
		url: 'jogoController',
		data: {"acao": "D20"},
		type: 'post',
		success: index.danoArmadilha
	});
}

index.danoArmadilha = function(data) {
	var dano = JSON.parse(data);
	console.log(dano.dano);
}

index.addEventoNosPersonagens = function(callback) {
	$.each(index.palco.find('div.status img'), function(idx, heroi){
		var $heroi = $(heroi);
		//add on click na div armadilha
		$heroi.before($('<div class="armadilha"><img src="web/img/atencao.png" class="armadilha"/>'));
		$heroi.addClass('alfa-armadilha');
		$heroi.on('click', callback);
	});
}

index.novosPontos = function(div) {
	div.unbind('click');
	div.css('cursor', 'default');
	div.removeClass('yellow');
	div.addClass('alfa');
	index.habilitarPonto(div);
}

index.iniciarAventura = function(data) {
	index.grupo = JSON.parse(data);
	index.intro.show();
}

index.exibirPalco = function() {
	index.mapa.show();
	index.palco.show();
	
	index.palco.find('img#protagonista1').attr('src', index.grupo[0].img);
	index.palco.find('img#protagonista2').attr('src', index.grupo[1].img);
	index.palco.find('img#protagonista3').attr('src', index.grupo[2].img);
}

$( document ).ready(function(){
	index.init();
});