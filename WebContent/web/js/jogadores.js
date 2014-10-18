var jogadores = {};

jogadores.mago = '{'
	+'  "classe": "mago"'
	+', "FOR": 10'
	+', "DES": 12'
	+', "CON": 13'
	+', "INT": 18'
	+', "SAB": 15'
	+', "CAR": 13'
	+', "CA":  12'
	+', "INI":  5'
	+', "MOV": 10'
	+', "PV":  18'
	+', "fortitude": 2'
	+', "reflexos":  2'
	+', "vontade":   8'
	+', "ataque":"d6"'
	+', "distancia": 0'
	+', "magias": [{"flexa_acida": 3}'
	+'			,{"golpe_raio": 2}'
	+'			,{"maos_ardentes": 2}'
	+'			,{"escudo_arcano": 2}]'
	+', "img": "img/mago.png" }';

jogadores.anao = '{'
	+'"classe": "anao"'
	+', "FOR": 15'
	+', "DES": 12'
	+', "CON": 20'
	+', "INT": 11'
	+', "SAB": 11'
	+', "CAR": 10'
	+', "CA":  16'
	+', "INI":  1'
	+', "MOV":  6'
	+', "PV":  68'
	+', "fortitude": 11'
	+', "reflexos":   2'
	+', "vontade":    1'
	+', "ataque": "d10"'
	+', "distancia": 0'
	+', "magias": []'
	+', "img": "img/anao.png"}';

jogadores.barbaro = '{'
	+'"classe": "barbaro"'
	+', "FOR": 19'
	+', "DES": 12'
	+', "CON": 16'
	+', "INT": 10'
	+', "SAB": 10'
	+', "CAR": 14'
	+', "CA":  16'
	+', "INI":  1'
	+', "MOV": 10'
	+', "PV":  60'
	+', "fortitude": 9'
	+', "reflexos": 2'
	+', "vontade": 1'
	+', "ataque": "d12"'
	+', "distancia": 0'
	+', "magias": []'
	+', "img": "img/barbaro.png"}';

jogadores.guerreira = '{'
	+'"classe": "guerreira"'
	+', "FOR": 14'
	+', "DES": 12'
	+', "CON": 16'
	+', "INT": 16'
	+', "SAB": 12'
	+', "CAR": 14'
	+', "CA":  21'
	+', "INI":  1'
	+', "MOV":  6'
	+', "PV":  50'
	+', "fortitude": 11'
	+', "reflexos": 1'
	+', "vontade": 1'
	+', "ataque": "d8"'
	+', "distancia": 3'
	+', "magias": []'
	+', "img": "img/guerreira.png"}';

jogadores.batedor = '{'
	+'"classe": "batedor"'
	+', "FOR": 15'
	+', "DES": 16'
	+', "CON": 14'
	+', "INT": 13'
	+', "SAB": 15'
	+', "CAR": 14'
	+', "CA":  16'
	+', "INI":  3'
	+', "MOV": 10'
	+', "PV":  40'
	+', "fortitude": 5'
	+', "reflexos": 9'
	+', "vontade": 3'
	+', "ataque": "d8"'
	+', "distancia": 15'
	+', "magias": []'
	+', "img": "img/batedor.png"}';

jogadores.sacerdotisa = '{'
	+'"classe": "sacerdotisa"'
	+', "FOR": 10'
	+', "DES": 16'
	+', "CON": 12'
	+', "INT": 13'
	+', "SAB": 19'
	+', "CAR": 14'
	+', "CA":  19'
	+', "INI":  3'
	+', "MOV": 10'
	+', "PV":  30'
	+', "fortitude": 5'
	+', "reflexos": 5'
	+', "vontade": 8'
	+', "ataque": "d6"'
	+', "distancia": 0'
	+', "magias": [{"curar_feridas": 3}'
	+'			,{"curar_area": 3}'
	+'			,{"aura_protecao": 2}'
	+'			,{"escudo_fe": 2}]'
	+', "img": "img/sacerdotisa.png"}';

/*
jogadores.mago = {"classe": "mago"
	, "FOR": 10
	, "DES": 12
	, "CON": 13
	, "INT": 18
	, "SAB": 15
	, "CAR": 13
	, "CA": 12
	, "INI": 5
	, "MOV": 10
	, "PV": 18
	, "fortitude": 2
	, "reflexos": 2
	, "vontade": 8
	, "ataque": [{"mao": {"bonus": 2, "dano": "1d3", "critico": 20}}
    			,{"punhal": {"bonus": 2, "dano": "1d4", "critico": 19}}
    			,{"cajado": {"bonus": 3, "dano": "1d6", "critico": 20}}]
	, "magias": [{"flexa_acida": 2}
				,{"golpe_raio": 1}
				,{"maos_ardentes": 2}
				,{"escudo_arcano": 2}]
	, "img": "img/mago.png"
};

jogadores.anao = {"classe": "anao"
	, "FOR": 15
	, "DES": 12
	, "CON": 20
	, "INT": 11
	, "SAB": 11
	, "CAR": 10
	, "CA": 16
	, "INI": 1
	, "MOV": 6
	, "PV": 68
	, "fortitude": 11
	, "reflexos": 2
	, "vontade": 1
	, "ataque": [{"mao": {"bonus": 7, "dano": "1d3", "critico": 20}}
	            ,{"martelo": {"bonus": 8, "dano": "1d10", "critico": 20}}
	            ,{"picareta": {"bonus": 7, "dano": "1d4", "critico": 20}}
	            ,{"besta": {"bonus": 6, "dano": "1d10", "critico": 19, "flexas": 15}}]
	, "magias": []
	, "img": "img/anao.png"
};

jogadores.barbaro = {"classe": "barbaro"
	, "FOR": 19
	, "DES": 12
	, "CON": 16
	, "INT": 10
	, "SAB": 10
	, "CAR": 14
	, "CA": 16
	, "INI": 1
	, "MOV": 10
	, "PV": 60
	, "fortitude": 9
	, "reflexos": 2
	, "vontade": 1
	, "ataque": [{"mao": {"bonus": 9, "dano": "1d3", "critico": 20}}
	            ,{"machado": {"bonus": 10, "dano": "1d12", "critico": 20}}
	            ,{"mace": {"bonus": 9, "dano": "1d6", "critico": 20}}
	            ,{"adaga": {"bonus": 9, "dano": "1d4", "critico": 19}}]
	, "magias": []
	, "img": "img/barbaro.png"
};

jogadores.guerreira = {"classe": "guerreira"
	, "FOR": 14
	, "DES": 12
	, "CON": 16
	, "INT": 16
	, "SAB": 12
	, "CAR": 14
	, "CA": 21
	, "INI": 1
	, "MOV": 6
	, "PV": 50
	, "fortitude": 11
	, "reflexos": 1
	, "vontade": 1
	, "ataque": [{"mao": {"bonus": 7, "dano": "1d3", "critico": 20}}
	            ,{"espada_longa": {"bonus": 8, "dano": "1d8", "critico": 19}}
	            ,{"lanca": {"bonus": 8, "dano": "1d8", "critico": 20}}
	            ,{"espada": {"bonus": 7, "dano": "1d6", "critico": 19}}]
	, "magias": []
	, "img": "img/guerreira.png"
};

jogadores.batedor = {"classe": "batedor"
	, "FOR": 15
	, "DES": 16
	, "CON": 14
	, "INT": 13
	, "SAB": 15
	, "CAR": 14
	, "CA": 16
	, "INI": 3
	, "MOV": 10
	, "PV": 40
	, "fortitude": 5
	, "reflexos": 9
	, "vontade": 3
	, "ataque": [{"mao": {"bonus": 6, "dano": "1d3", "critico": 20}}
	            ,{"espada_longa": {"bonus": 7, "dano": "1d8", "critico": 19}}
	            ,{"arco_longo": {"bonus": 7, "dano": "1d8", "critico": 20, "flexas": 15}}
	            ,{"espada": {"bonus": 7, "dano": "1d6", "critico": 19}}]
	, "magias": []
	, "img": "img/batedor.png"
};

jogadores.sacerdotisa = {"classe": "sacerdotisa"
	, "FOR": 10
	, "DES": 16
	, "CON": 12
	, "INT": 13
	, "SAB": 19
	, "CAR": 14
	, "CA": 19
	, "INI": 3
	, "MOV": 10
	, "PV": 30
	, "fortitude": 5
	, "reflexos": 5
	, "vontade": 8
	, "ataque": [{"mao": {"bonus": 3, "dano": "1d3", "critico": 20}}
	            ,{"cajado": {"bonus": 3, "dano": "1d6", "critico": 20}}
	            ,{"punhal": {"bonus": 3, "dano": "1d4", "critico": 19}}]
	, "magias": []
	, "img": "img/sacerdotisa.png"
};
*/