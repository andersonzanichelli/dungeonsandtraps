var tesouro = {};

tesouro.colocarNaMochila = function(evento, div){
	
	index.escreverLog(evento.tipo.toUpperCase() + "! Encontraram " + evento.nome.toUpperCase() + "! \n" +
			"Avaliado em torno de: " + evento.valor + " peças de ouro.");
	
	tesouro.mostrarMao(evento, div);
}

tesouro.mostrarMao = function(evento, div) {

	var $heroi = index.getProtagonista(index.mao);
	
	$.each(index.mao, function(idx, mao){
		
		if(index.grupo[idx].status !== index.MORTO) {
			var $mao = $(mao);
			$mao.css('cursor', 'pointer');
			$mao.on('click', function() {
				tesouro.pegarTesouro(this, evento, div);
			});
			$mao.show();
		}
	});
}

tesouro.pegarTesouro = function(mao, evento, div) {
	
	var $heroi = index.getProtagonista($(mao));
	var classe = $heroi.attr('classe');
	
	$.ajax({
		url: 'jogoController',
		data: {"acao": "tesouro"
			  ,"classe": classe
			  ,"nome": evento.nome
			  ,"img": evento.img
			  ,"valor": evento.valor},
		type: 'post',
		success: function(data){
				var grupo = JSON.parse(data);
				index.grupo = grupo;
				index.atualizarHeroi();
				index.status.pop();
				tesouro.retirarMao(div, evento.nome);
				index.escreverLog(classe.toUpperCase() + " colocou " + evento.nome.toUpperCase() + " em sua mochila.");
			}
		});
}

tesouro.retirarMao = function(div, cssClasse) {
	index.mao.css('cursor', 'default');
	index.mao.unbind('click');
	index.mao.hide();
	index.siga(div, cssClasse);
}