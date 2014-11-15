var armadilha = {};

armadilha.desviarArmadilha = function(trap, $heroi) {
	
	$.ajax({
		url: 'jogoController',
		data: {"acao": "armadilha"
			  ,"habilidade": trap.habilidade
			  ,"dificuldade": trap.dificuldade
			  ,"classe": $heroi.attr("classe")},
		type: 'post',
		success: function(data) {
			var resposta = JSON.parse(data);
			
			if(!resposta.desviouArmadilha) {
				index.escreverLog("FALHOU!\n" + $heroi.attr("classe").toUpperCase() + " caiu na armadilha.\nTirou: " + resposta.d20 + "\nSofreu " + trap.dano + " pontos de dano.");
				armadilha.danoArmadilha(trap.dano, $heroi);
			} else {
				index.escreverLog("SUCESSO!\n" + $heroi.attr("classe").toUpperCase() + " conseguiu desviar da armadilha.\nTirou: " + resposta.d20);
			}
			
			armadilha.sofreDano(resposta.desviouArmadilha, $heroi);
			index.status.pop();
			
			if(index.status.length === 0) {
				index.traps.removeAttr('src');
				index.traps.removeClass(evento.nome);
			}
		}
	});
}

armadilha.danoArmadilha = function(dano, $heroi) {
	
	$.ajax({
		url: 'jogoController',
		data: {"acao": "danoArmadilha"
			  ,"dano": dano
			  ,"classe": $heroi.attr('classe')},
		type: 'post',
		success: function(data) {
			var resposta = JSON.parse(data);
			index.grupo = resposta;
			index.atualizarHeroi();
		}
	});
}

armadilha.sofreDano = function(desviou, $heroi) {
	if(!desviou) {
		$heroi.attr('src', 'web/img/' + $heroi.attr('classe') + 'D.png');
	}
	
	setTimeout( function() {
		if($heroi.attr('status') !== index.MORTO) {
			$heroi.attr('src', 'web/img/' + $heroi.attr('classe') + '.png');
		}
	}, 1000);
	
	$heroi.unbind('click');
	$heroi.css('cursor', 'default');
}