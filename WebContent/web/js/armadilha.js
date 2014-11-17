var armadilha = {};

armadilha.desviarArmadilha = function(trap, $heroi, div) {
	
	$.ajax({
		url: 'jogoController',
		data: {"acao": "armadilha"
			  ,"player": index.player.val()
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
				index.siga(div, trap.nome);
			}
		}
	});
}

armadilha.danoArmadilha = function(dano, $heroi) {
	
	$.ajax({
		url: 'jogoController',
		data: {"acao": "dano_Armadilha"
			  ,"player": index.player.val()
			  ,"dano": dano
			  ,"classe": $heroi.attr('classe')},
		type: 'post',
		success: function(data) {
			var grupo = JSON.parse(data);
			index.grupo = grupo;
			index.atualizarHeroi();
		}
	});
}

armadilha.sofreDano = function(desviou, $heroi) {
	if(!desviou) {
		index.heroiSofreDano($heroi);
	} else {
		index.imagemHeroi($heroi);
	}
	
	$heroi.unbind('click');
	$heroi.css('cursor', 'default');
}