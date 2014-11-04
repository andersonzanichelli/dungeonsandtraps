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
	
	index.intro = $('#intro');
	index.btnContinuarIntro = $('#continuarIntro');
	
	index.mapa = $('#mapa');
	index.btnContinuarMapa = $('#continuarMapa');
	
	index.caminho = $('#caminho');
	index.btnContinuarCaminho = $('#continuarCaminho');
	
	index.entrada = $('#entrada');
	index.btnContinuarEntrada = $('#continuarEntrada');
	
	index.jogando = false;
};

index.init = function() {
	index.componentes();
	
	index.bemvindo.hide();
	index.personagens.hide();
	index.intro.hide();
	index.mapa.hide();
	index.caminho.hide();
	index.entrada.hide();
	
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
		index.mapa.show();
	});
	
	index.btnContinuarMapa.on('click', function(){
		index.mapa.hide();
		index.caminho.show();
	});
	
	index.btnContinuarCaminho.on('click', function(){
		index.caminho.hide();
		index.entrada.show();
	});
	
	index.btnContinuarEntrada.on('click', function() {
		index.entrada.hide();
	})
};

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

index.iniciarAventura = function() {
	index.intro.show();
}

$( document ).ready(function(){
	index.init();
});