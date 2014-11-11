var jogadores = {};

jogadores.mago = '{'
	+'  "classe": "mago"'
	+', "forca": 10'
	+', "destreza": 12'
	+', "constituicao": 13'
	+', "inteligencia": 18'
	+', "sabedoria": 15'
	+', "carisma": 13'
	+', "ca":  12'
	+', "iniciativa":  5'
	+', "deslocamento": 10'
	+', "pv":  18'
	+', "fortitude": 2'
	+', "reflexos":  2'
	+', "vontade":   8'
	+', "ataque":"d6"'
	+', "distancia": 0'
	+', "magia": [{"flexa_acida": 3}'
	+'			,{"golpe_raio": 2}'
	+'			,{"maos_ardentes": 2}'
	+'			,{"escudo_arcano": 2}]'
	+', "img": "web/img/mago.png" }';

jogadores.anao = '{'
	+'"classe": "anao"'
	+', "forca": 15'
	+', "destreza": 12'
	+', "constituicao": 20'
	+', "inteligencia": 11'
	+', "sabedoria": 11'
	+', "carisma": 10'
	+', "ca":  16'
	+', "iniciativa":  1'
	+', "deslocamento":  6'
	+', "pv":  68'
	+', "fortitude": 11'
	+', "reflexos":   2'
	+', "vontade":    1'
	+', "ataque": "d10"'
	+', "distancia": 0'
	+', "img": "web/img/anao.png"}';

jogadores.barbaro = '{'
	+'"classe": "barbaro"'
	+', "forca": 19'
	+', "destreza": 12'
	+', "constituicao": 16'
	+', "inteligencia": 10'
	+', "sabedoria": 10'
	+', "carisma": 14'
	+', "ca":  16'
	+', "iniciativa":  1'
	+', "deslocamento": 10'
	+', "pv":  60'
	+', "fortitude": 9'
	+', "reflexos": 2'
	+', "vontade": 1'
	+', "ataque": "d12"'
	+', "distancia": 0'
	+', "img": "web/img/barbaro.png"}';

jogadores.guerreira = '{'
	+'"classe": "guerreira"'
	+', "forca": 14'
	+', "destreza": 12'
	+', "constituicao": 16'
	+', "inteligencia": 16'
	+', "sabedoria": 12'
	+', "carisma": 14'
	+', "ca":  21'
	+', "iniciativa":  1'
	+', "deslocamento":  6'
	+', "pv":  50'
	+', "fortitude": 11'
	+', "reflexos": 1'
	+', "vontade": 1'
	+', "ataque": "d8"'
	+', "distancia": 3'
	+', "img": "web/img/guerreira.png"}';

jogadores.batedor = '{'
	+'"classe": "batedor"'
	+', "forca": 15'
	+', "destreza": 16'
	+', "constituicao": 14'
	+', "inteligencia": 13'
	+', "sabedoria": 15'
	+', "carisma": 14'
	+', "ca":  16'
	+', "iniciativa":  3'
	+', "deslocamento": 10'
	+', "pv":  40'
	+', "fortitude": 5'
	+', "reflexos": 9'
	+', "vontade": 3'
	+', "ataque": "d8"'
	+', "distancia": 15'
	+', "img": "web/img/batedor.png"}';

jogadores.sacerdotisa = '{'
	+'"classe": "sacerdotisa"'
	+', "forca": 10'
	+', "destreza": 16'
	+', "constituicao": 12'
	+', "inteligencia": 13'
	+', "sabedoria": 19'
	+', "carisma": 14'
	+', "ca":  19'
	+', "iniciativa":  3'
	+', "deslocamento": 10'
	+', "pv":  30'
	+', "fortitude": 5'
	+', "reflexos": 5'
	+', "vontade": 8'
	+', "ataque": "d6"'
	+', "distancia": 0'
	+', "magia": [{"curar_feridas": 3}'
	+'			,{"curar_area": 3}'
	+'			,{"aura_protecao": 2}'
	+'			,{"escudo_fe": 2}]'
	+', "img": "web/img/sacerdotisa.png"}';

/*
jogadores.mago = {"classe": "mago"
	, "forca": 10
	, "destreza": 12
	, "constituicao": 13
	, "inteligencia": 18
	, "sabedoria": 15
	, "carisma": 13
	, "ca": 12
	, "iniciativa": 5
	, "deslocamento": 10
	, "pv": 18
	, "fortitude": 2
	, "reflexos": 2
	, "vontade": 8
	, "ataque": [{"mao": {"bonus": 2, "dano": "1d3", "critico": 20}}
    			,{"punhal": {"bonus": 2, "dano": "1d4", "critico": 19}}
    			,{"cajado": {"bonus": 3, "dano": "1d6", "critico": 20}}]
	, "magia": [{"flexa_acida": 2}
				,{"golpe_raio": 1}
				,{"maos_ardentes": 2}
				,{"escudo_arcano": 2}]
	, "img": "img/mago.png"
};

jogadores.anao = {"classe": "anao"
	, "forca": 15
	, "destreza": 12
	, "constituicao": 20
	, "inteligencia": 11
	, "sabedoria": 11
	, "carisma": 10
	, "ca": 16
	, "iniciativa": 1
	, "deslocamento": 6
	, "pv": 68
	, "fortitude": 11
	, "reflexos": 2
	, "vontade": 1
	, "ataque": [{"mao": {"bonus": 7, "dano": "1d3", "critico": 20}}
	            ,{"martelo": {"bonus": 8, "dano": "1d10", "critico": 20}}
	            ,{"picareta": {"bonus": 7, "dano": "1d4", "critico": 20}}
	            ,{"besta": {"bonus": 6, "dano": "1d10", "critico": 19, "flexas": 15}}]
	, "magia": []
	, "img": "img/anao.png"
};

jogadores.barbaro = {"classe": "barbaro"
	, "forca": 19
	, "destreza": 12
	, "constituicao": 16
	, "inteligencia": 10
	, "sabedoria": 10
	, "carisma": 14
	, "ca": 16
	, "iniciativa": 1
	, "deslocamento": 10
	, "pv": 60
	, "fortitude": 9
	, "reflexos": 2
	, "vontade": 1
	, "ataque": [{"mao": {"bonus": 9, "dano": "1d3", "critico": 20}}
	            ,{"machado": {"bonus": 10, "dano": "1d12", "critico": 20}}
	            ,{"mace": {"bonus": 9, "dano": "1d6", "critico": 20}}
	            ,{"adaga": {"bonus": 9, "dano": "1d4", "critico": 19}}]
	, "magia": []
	, "img": "img/barbaro.png"
};

jogadores.guerreira = {"classe": "guerreira"
	, "forca": 14
	, "destreza": 12
	, "constituicao": 16
	, "inteligencia": 16
	, "sabedoria": 12
	, "carisma": 14
	, "ca": 21
	, "iniciativa": 1
	, "deslocamento": 6
	, "pv": 50
	, "fortitude": 11
	, "reflexos": 1
	, "vontade": 1
	, "ataque": [{"mao": {"bonus": 7, "dano": "1d3", "critico": 20}}
	            ,{"espada_longa": {"bonus": 8, "dano": "1d8", "critico": 19}}
	            ,{"lanca": {"bonus": 8, "dano": "1d8", "critico": 20}}
	            ,{"espada": {"bonus": 7, "dano": "1d6", "critico": 19}}]
	, "magia": []
	, "img": "img/guerreira.png"
};

jogadores.batedor = {"classe": "batedor"
	, "forca": 15
	, "destreza": 16
	, "constituicao": 14
	, "inteligencia": 13
	, "sabedoria": 15
	, "carisma": 14
	, "ca": 16
	, "iniciativa": 3
	, "deslocamento": 10
	, "pv": 40
	, "fortitude": 5
	, "reflexos": 9
	, "vontade": 3
	, "ataque": [{"mao": {"bonus": 6, "dano": "1d3", "critico": 20}}
	            ,{"espada_longa": {"bonus": 7, "dano": "1d8", "critico": 19}}
	            ,{"arco_longo": {"bonus": 7, "dano": "1d8", "critico": 20, "flexas": 15}}
	            ,{"espada": {"bonus": 7, "dano": "1d6", "critico": 19}}]
	, "magia": []
	, "img": "img/batedor.png"
};

jogadores.sacerdotisa = {"classe": "sacerdotisa"
	, "forca": 10
	, "destreza": 16
	, "constituicao": 12
	, "inteligencia": 13
	, "sabedoria": 19
	, "carisma": 14
	, "ca": 19
	, "iniciativa": 3
	, "deslocamento": 10
	, "pv": 30
	, "fortitude": 5
	, "reflexos": 5
	, "vontade": 8
	, "ataque": [{"mao": {"bonus": 3, "dano": "1d3", "critico": 20}}
	            ,{"cajado": {"bonus": 3, "dano": "1d6", "critico": 20}}
	            ,{"punhal": {"bonus": 3, "dano": "1d4", "critico": 19}}]
	, "magia": []
	, "img": "img/sacerdotisa.png"
};
*/