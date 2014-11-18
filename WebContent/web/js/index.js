var index = {};

index.escolhidos = {};

index.componentes = function(){
	index.VIVO = "VIVO";
	index.MORRENDO = "MORRENDO";
	index.MORTO = "MORTO";
	
	index.gameOver = [];
	
	index.player = $('#player');
	index.salvarPlayer = "";
	
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
	
	index.status = [];
	index.log = $('#log');
	index.events = $('#events');
	index.mao = $('.mao');
	index.ataque = $('.ataque');
	
	$("#p1").addClass("yellow");
	
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
	
	index.btnContinuar.on('click', function() {
		if(index.player.val() === "") {
			alert("Informe o nome do jogador!");
			return;
		}
		index.continuar();
	});
	
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
	});
	
	index.player.on('keyup', function() {
		if(index.player.val()) {
			index.salvarPlayer = index.player.val();
			index.btnContinuar.removeAttr('disabled');
			index.btnContinuar.addClass('btn btn-success');
		}
	});
	
	$('#p1').on('click', function(){
		$('#p1').removeClass('black');
		$('#p1').addClass('red');
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
	index.mao.hide();
	index.ataque.attr('disabled', 'disabled');
	index.btnContinuar.attr('disabled', 'disabled');
}

index.novoJogo = function() {
	// TODO implementar o reset de tudo;

	index.bemvindo.show();
};

index.informacao = function() {
	console.log('infos');
};

index.sair = function(force) {
	var saiu = false;
	
	if(!force) {
		saiu = confirm('Deseja encerrar o jogo?');
	}
	
	if(saiu || force) {
		$.ajax({
			url: 'jogoController',
			data: {"acao": "encerrar", "player": index.player.val()},
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

index.close = function(panel) {
	var alvo = $('#' + panel);
	alvo.hide();
}

index.personagensEscolhidas = function() {
	var person0 = index.escolhidos[0];
	var person1 = index.escolhidos[1];
	var person2 = index.escolhidos[2];
	
	var data = {"acao": "grupo"
				,"player": index.player.val()
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

index.habilitarPonto = function(ponto) {
	if(index.mapeamento[ponto.selector]) {
		$.each(index.mapeamento[ponto.selector], function(idx, key) {
			var $key = $(key); 
			$key.css('cursor', 'pointer');
			$key.addClass('yellow');
			index.addListener($(key));
		});
	}
}

index.addListener = function(key){
	key.on('click', function(){
		index.ponto(key);
	});
}

index.ponto = function(ponto) {
	
	if(!index.podeSeguir()) {
		return;
	}
	
	ponto.removeClass('black');
	ponto.addClass('red');
	
	var data = {};
	
	if(ponto.attr("class") !== 'boss') {
		data = {"acao": "evento", "player": index.player.val()};
	} else {
		data = {"acao": "boss", "player": index.player.val()};
	}
	
	$.ajax({
		url: 'jogoController',
		data: data,
		type: 'post',
		success: function(data){
			var evento = JSON.parse(data)
			var tipo = evento.tipo;
			
			switch(tipo) {
				case "armadilha":
					index.addEventoNoPalco(evento);
					index.addEventoNosPersonagens(evento, armadilha.desviarArmadilha, ponto);
					break;
				case "nenhum":
					index.escreverLog("Nenhum evento!");
					index.novosPontos(ponto);
					break;
				case "inimigo":
					index.addEventoNoPalco(evento);
					//batalha.rolarIniciativa();
					index.addEventoNosPersonagens(evento, batalha.atacar, ponto);
					break;
				case "tesouro":
					index.addEventoNoPalco(evento);
					index.status.push(evento.tipo);
					tesouro.colocarNaMochila(evento, ponto);
					break;
			}
		}
	});
}

index.addEventoNoPalco = function(evento) {
	index.events.attr('src', evento.img);
	index.events.addClass(evento.nome);
}

index.addEventoNosPersonagens = function(evento, callback, ponto) {
	
	switch(evento.tipo) {
		case "armadilha":
			
			index.escreverLog(evento.tipo.toUpperCase() + " DE " + evento.nome.toUpperCase() + "! \n" +
			"Necessário realizar um teste de " + evento.habilidade + " dificuldade: " + evento.dificuldade);
			
			$.each(index.palco.find('div.status img'), function(idx, heroi){
				var $heroi = $(heroi);
				var classe = $heroi.attr('classe');
				var status = $heroi.attr('status');
				
				if( status !== index.MORTO ) {
					index.status.push(evento.tipo);
					$heroi.attr('src', 'web/img/' + $heroi.attr('classe') + 'A.png');
					$heroi.css('cursor', 'pointer');
					$heroi.on('click', function() {
						callback(evento, $heroi, ponto);
					});
				}
			});
			break;
		case "inimigo":
			
			index.escreverLog("Um ORC foi encontrado... Atacaaaaar!");
			index.status.push(evento.tipo);
			
			$.each(index.palco.find('div.status div.info button'), function(idx, botao){
				var $botao = $(botao);
				var $heroi = index.getProtagonista($botao);
				var classe = $heroi.attr('classe');
				var status = $heroi.attr('status');
				
				//alert(status);
				
				if( status !== index.MORTO ) {
					$botao.removeAttr("disabled");
					$botao.addClass('btn btn-danger');
					$botao.on('click', function() {
						callback(evento, $heroi, ponto, $botao);
					});
				}
			});
			break;
	}
}

index.novosPontos = function(ponto) {
	
	if(!index.podeSeguir()) {
		return;
	}
	
	ponto.unbind('click');
	ponto.css('cursor', 'default');
	ponto.removeClass('red');
	ponto.addClass('alfa');
	index.habilitarPonto(ponto);
}

index.iniciarAventura = function(data) {
	index.grupo = JSON.parse(data);
	index.intro.show();
}

index.exibirPalco = function() {
	index.mapa.show();
	index.palco.show();
	
	$.each(index.palco.find('.imagem'), function(idx, heroi) {
		var $heroi = $(heroi);
		if($heroi.attr('status') !== index.MORTO ) {
			$heroi.attr('src', index.grupo[idx].img);
			$heroi.attr('classe', index.grupo[idx].classe);
			$heroi.attr('status', index.grupo[idx].status);
			
			$('#pv' + idx).val(index.grupo[idx].pv);
			$('#po' + idx).val(index.grupo[idx].po);
		}
	});
}

index.atualizarHeroi = function() {
	$.each(index.palco.find('.imagem'), function(idx, heroi) {
		var $heroi = $(heroi);
		
		$heroi.attr('status', index.grupo[idx].status);
		$('#pv' + idx).val(index.grupo[idx].pv);
		$('#po' + idx).val(index.grupo[idx].po);
		
		if(index.grupo[idx].status === index.MORTO) {
			$heroi.attr('src', 'web/img/rip.png');
			var classe = $heroi.attr('classe');
			
			var num = $heroi.attr('id').replace(/[^0-9]/g,'');
			var $botao = $("#ataque" + num);
			
			$botao.attr('disabled', 'disabled');
			$botao.removeClass('btn btn-danger');
			$botao.addClass('btn btn-default');
			
			
			if(($.inArray(classe, index.gameOver)) === -1) {
				index.gameOver.push(classe);
			}
			
			if(index.gameOver.length === 3) {
				index.acabou();
				index.gameOver = [];
				return;
			}
		}
	});
}

index.imagemHeroi = function($heroi) {
	if($heroi.attr('status') !== index.MORTO) {
		$heroi.attr('src', 'web/img/' + $heroi.attr('classe') + '.png');
	}
}

index.heroiSofreDano = function($heroi) {
	$heroi.attr('src', 'web/img/' + $heroi.attr('classe') + 'D.png');
	
	setTimeout( function() {
		index.imagemHeroi($heroi);
	}, 600);
}

index.siga = function(ponto, cssClasse) {
	
	if(!index.podeSeguir()) {
		return;
	}
	
	index.events.removeAttr('src');
	index.events.removeClass(cssClasse);
	index.novosPontos(ponto);
}

index.podeSeguir = function() {
	if(index.status.length > 0) {
		
		switch(index.status[0]) {
			case "armadilha":
				alert("O personagem deve realizar o teste de armadilha!");
				return false;
			case "tesouro":
				alert("Alguém deve carregar o tesouro!");
				return false;
			case "inimigo":
				alert("O inimigo deve ser derrotado!");
				return false;
		}
	}
	
	return true;
}

index.getProtagonista = function(obj) {
	var num = obj.attr('id').replace(/[^0-9]/g,'');
	return $("#protagonista" + num);
}

index.acabou = function() {
	alert("Game Over");
	index.sair(true);
	return;
}

index.escreverLog = function(msg) {
	index.log.val(msg + '\n-----------------------------------------------------------------------------------------------------------\n' + index.log.val());
}

$( document ).ready(function(){
	index.init();
});