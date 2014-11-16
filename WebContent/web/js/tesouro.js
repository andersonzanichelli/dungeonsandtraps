var tesouro = {};

tesouro.colocarNaMochila = function(evento, div){
	
	index.escreverLog(evento.tipo.toUpperCase() + "! Encontraram " + evento.nome.toUpperCase() + "! \n" +
			"Avaliado em torno de: " + evento.valor + " peças de ouro.");
	
	tesouro.mostrarMao(evento, div);
}

tesouro.mostrarMao = function(evento, div) {
	index.mao.css('cursor', 'pointer');
	
	index.mao.on('click', function() {
			tesouro.pegarTesouro(this, evento, div);
		});
	
	index.mao.show();
}

tesouro.pegarTesouro = function(mao, evento, div) {
	var num = $(mao).attr('id').replace(/[^0-9]/g,'');
	var classe = $("#protagonista" + num).attr('classe');
	
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
				tesouro.retirarMao(div, evento.nome);
				index.escreverLog(classe.toUpperCase() + " colocou " + evento.nome.toUpperCase() + " em sua mochila.");
				index.status.pop();
			}
		});
}

tesouro.retirarMao = function(div, cssClasse) {
	index.mao.css('cursor', 'default');
	index.mao.unbind('click');
	index.mao.hide();
	index.siga(div, cssClasse);
}