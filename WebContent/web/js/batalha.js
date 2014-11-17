var batalha = {};

batalha.iniciarBatalha = function(evento, $heroi, ponto) {
	console.log([ponto, $(ponto), evento, $heroi]);
	index.status.pop();
	
	$.each(index.palco.find('div.status div.info button'), function(idx, botao) {
		var $botao = $(botao);
		
		$botao.attr('disabled', 'disabled');
		$botao.removeClass('btn btn-danger');
		$botao.addClass('btn btn-default');
	});
	
	index.siga($(ponto), evento.nome);
}