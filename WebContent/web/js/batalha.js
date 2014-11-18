var batalha = {};

batalha.ordem = [];

batalha.atacar = function(evento, $heroi, ponto, $botao) {
	$.ajax({
		url: 'jogoController',
		data: {"acao": "atacar"
			  , "player": index.player.val()
			  , "classe": $heroi.attr("classe")},
		type: 'post',
		success: function(data){
			var resultado = JSON.parse(data);
			
			var dadoHeroi = resultado[0];
			var monstro = resultado[1];
			var dadoMonstro = resultado[2];
			var grupo = resultado[3];
			
			//alert(monstro.status);
			//alert(index.status);
			
			if(grupo) {
				index.grupo = grupo;
				index.atualizarHeroi();
			}
			
			index.escreverLog(dadoHeroi.classe.toUpperCase() + " atacou o ORC com sua arma " + dadoHeroi.dado +
					"\n e causou um dano de " + dadoHeroi.dano + " pontos de vida.");
			
			if(dadoMonstro) {
				index.escreverLog("Orc atacou o " + dadoHeroi.classe.toUpperCase() + " com sua arma " + dadoMonstro.dadoMonstro +
						"\n e causou um dano de " + dadoMonstro.danoMonstro + " pontos de vida.");
			}
			
			if(monstro.status === index.MORTO) {
				$('.ataque').attr("disabled", "disabled");
				$('.ataque').removeClass('btn btn-danger');
				$('.ataque').addClass('btn btn-default');
				index.status.pop();
				index.escreverLog("ORC foi morto!");
				index.siga(ponto, evento.nome);
			}
		}
	});
}

batalha.rolarIniciativa = function() {
	$.ajax({
		url: 'jogoController',
		data: {"acao": "iniciativa", "player": index.player.val()},
		type: 'post',
		success: function(data){
			var ordem = JSON.parse(data);
			batalha.ordem = ordem;
		}
	});
}