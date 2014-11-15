<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app='store'>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="web/css/bootstrap.min.css">
		<link rel="stylesheet" href="web/css/layout.css">
		<script src="web/js/jquery-1.11.1.min.js"></script>
		<script src="web/js/bootstrap.min.js"></script>
		<script src="web/js/app.js"></script>
		<script src="web/js/index.js"></script>
		<script src="web/js/jogadores.js"></script>
		<script src="web/js/armadilha.js"></script>
		<title>Dungeons and Traps</title>
	</head>
	<body>
	<nav class="navbar navbar-inverse" role="navigation">
		<div class="container-fluid">
    		<div class="navbar-header">
    			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      				
      				<ul class="nav navbar-nav navbar-right">
        				<li><a href="#" id="novo" >Novo jogo</a></li>
						<!-- <li><a href="#" id="info">Informações</a></li> -->
        				<!-- <li class="dropdown">
	          				<a href="#" class="dropdown-toggle" data-toggle="dropdown">Configurações <span class="caret"></span></a>
	          				<ul class="dropdown-menu" role="menu">
	            				<li><a href="#">Nome</a></li>
	            				<li><a href="#">Teste</a></li>
	            				<li><a href="#">Teste 2</a></li>
	            				<li class="divider"></li>
	            				<li><a href="#">Separado</a></li>
	          				</ul>
        				</li> -->
        				<li><a href="#" id="sair" >Sair</a></li>
      				</ul>
        		</div>
    		</div>
    	</div>
	</nav>
	
	<div id='bemvindo'>
		<div class='panel panel-default'>                                                        
	 		<div class='panel-heading'>                                                            
				<h3 class='panel-title'>Novo jogo!</h3>                                        
			</div>                                                                             
			<div class='panel-body'>                                                           
				Para explorar as masmorras de Dungeons and Traps clique em Continuar.          
			</div>                                                                             
			<div class='btn-group'>                                                            
				<button type='button' id='cancelar' class='btn btn-default'>Cancelar</button>
				<input type='button' id='continuar' class='btn btn-default' value='Continuar' />
			</div>                                                                             
		</div>                                                                               
	</div>
	
	<div id='personagens'>
		<div class='panel panel-default'>                                                        
	 		<div class='panel-heading'>                                                            
				<h3 class='panel-title'>Monte seu grupo</h3>                                        
			</div>                                                                             
			<div class='panel-body'>                                                           
				Para explorar as masmorras de Dungeons and Traps escolha seu grupo:
				<div id="disponivel">
					<button id="anao" class="person"><img class="imgPerson" alt="Anão" src="web/img/anao.png"></button>
					<button id="barbaro" class="person"><img class="imgPerson" alt="Bárbaro" src="web/img/barbaro.png"></button>
					<button id="batedor" class="person"><img class="imgPerson" alt="Batedor" src="web/img/batedor.png"></button>
					<button id="guerreira" class="person"><img class="imgPerson" alt="Guerreira" src="web/img/guerreira.png"></button>
					<button id="mago" class="person"><img class="imgPerson" alt="Mago" src="web/img/mago.png"></button>
					<button id="sacerdotisa" class="person"><img class="imgPerson" alt="Sacerdotisa" src="web/img/sacerdotisa.png"></button>
				</div>          
				<div id="escolhido">
					<button id="0" class="slot shadow"></button>
					<button id="1" class="slot shadow"></button>
					<button id="2" class="slot shadow"></button>
				</div>
			</div>                                                                             
			<div class='btn-group'>                                                            
				<button type='button' id='cancelarPerson' class='btn btn-default'>Cancelar</button>
				<input type='button' id='continuarPerson' class='btn btn-default' value='Continuar' />
			</div>                                                                             
		</div>                                                                               
	</div>
	
	<div id='intro'>
		<div class='panel panel-default'>                                                        
	 		<div class='panel-heading'>                                                            
				<h3 class='panel-title'>Introdução!</h3>                                        
			</div>                                                                             
			<div class='panel-body'>                                                           
				Bravos heróis!
				<br/>
				Uma relíquia mágica, do rei, foi roubada!
				<br/>
				Ela foi dada ao rei como um presente dos homens do norte, em agradecimento às forças de guerra que o rei havia enviado para lá.
				<br/>
				O rei pretende pagar uma boa quantia em ouro para vocês se trouxerem o presente que foi roubado.
				<br/>
				Um dos batedores do castelo percebeu uma movimentação de orcs na região das colinas, ali próximo existe uma mina abandonada.
			</div>                                                                             
			<div class='btn-group'>                                                            
				<input type='button' id='continuarIntro' class='btn btn-default' value='Continuar' />
			</div>                                                                             
		</div>                                                                               
	</div>
	
	<div id='mundo'>
		<div class='panel panel-default'>                                                        
	 		<div class='panel-heading'>                                                            
				<h3 class='panel-title'>Mundo</h3>
			</div>                                                                             
			<div class='panel-body'>
				<img alt="mapa" src="web/img/mundo.png" width="850" height="490">
			</div>                                                                             
			<div class='btn-group'>                                                            
				<input type='button' id='continuarMundo' class='btn btn-default' value='Continuar' />
			</div>                                                                             
		</div>                                                                               
	</div>
	
	<div id='caminho'>
		<div class='panel panel-default'>                                                        
	 		<div class='panel-heading'>                                                            
				<h3 class='panel-title'>Caminhando até a mina</h3>                                        
			</div>                                                                             
			<div class='panel-body'>                                                           
				O caminho até o local marcado no mapa ocorreu sem nenhum problema, e logo vocês chegaram até a mina.
			</div>                                                                             
			<div class='btn-group'>                                                            
				<input type='button' id='continuarCaminho' class='btn btn-default' value='Continuar' />
			</div>                                                                             
		</div>                                                                               
	</div>
	
	<div id='entrada'>
		<div class='panel panel-default'>                                                        
	 		<div class='panel-heading'>                                                            
				<h3 class='panel-title'>Entrada da mina</h3>
			</div>                                                                             
			<div class='panel-body'>
				<img alt="mapa" src="web/img/entrada.png" width="850" height="490">
			</div>                                                                             
			<div class='btn-group'>                                                            
				<input type='button' id='continuarEntrada' class='btn btn-default' value='Entrar na mina' />
			</div>                                                                             
		</div>                                                                               
	</div>
	
	<div id='mapa'>
		<img alt="mapa" src="web/img/mapa.png">
		<div id="p0" class="alfa" style="right: 215px; top: 265px;">.</div>
		<div id="p1" class="black" style="right: 195px; top: 225px; cursor: pointer;">.</div>
		<div id="p2" class="black" style="right: 195px; top: 180px;">.</div>
		<div id="p3" class="black" style="right: 195px; top: 135px;">.</div>
		
		<div id="p4" class="black" style="right: 155px; top: 105px;">.</div>
		<div id="p5" class="black" style="right: 155px; top: 145px;">.</div>
		<div id="p6" class="black" style="right: 155px; top: 185px;">.</div>
		<div id="p7" class="black" style="right: 155px; top: 225px;">.</div>
		<div id="p8" class="black" style="right: 152px; top: 273px;">.</div>
		
		<div id="p9" class="black" style="right: 108px; top: 105px;">.</div>
		<div id="p10" class="black" style="right: 115px; top: 139px;">.</div>
		<div id="p11" class="black" style="right: 102px; top: 180px;">.</div>
		<div id="p12" class="black" style="right: 115px; top: 226px;">.</div>
		<div id="p13" class="black" style="right: 93px; top: 262px;">.</div>
		
		<div id="p14" class="black" style="right: 62px; top: 140px;">.</div>
		<div id="p15" class="black" style="right: 75px; top: 209px;">.</div>
		
		<div id="p16" class="black" style="right: 43px; top: 179px;">.</div>
		<div id="p17" class="black" style="right: 37px; top: 221px;">.</div>
		<div id="p18" class="black" style="right: 37px; top: 262px;">.</div>
		<div id="p19" class="black" style="right: 35px; top: 312px;">.</div>
		
	</div>
	
	<div id="palco">
		<div class='panel panel-default'>                                                        
	 		<div class='panel-heading'>                                                            
				<h3 class='panel-title'>Dungeons and Traps</h3>                                        
			</div>                                                                             
			<div class='panel-body'>                                                           
				<img id="campo" src="web/img/mine.jpg">
				<div class="status">
					<img class="imagem" id="protagonista1">
					<div class="info">
						<label for="pv0">PV:</label>
						<input type="text" id="pv0" class="pv" disabled="disabled" />
						<label for="po0">PO:</label>
						<input type="text" id="po0" class="po" disabled="disabled" />
					</div>
					<br/>
					
					<img class="imagem" id="protagonista2">
					<div class="info">
						<label for="pv1">PV:</label>
						<input type="text" id="pv1" class="pv" disabled="disabled" />
						<label for="po1">PO:</label>
						<input type="text" id="po1" class="po" disabled="disabled" />
					</div>
					<br/>
					
					<img class="imagem" id="protagonista3">
					<div class="info">
						<label for="pv2">PV:</label>
						<input type="text" id="pv2" class="pv" disabled="disabled" />
						<label for="po2">PO:</label>
						<input type="text" id="po2" class="po" disabled="disabled" />
					</div>
				</div>
			</div>                                                                             
			<div class='btn-group'>                                                            
				<input type='button' id='finish' style="display: none;" class='btn btn-default' value='Fim' />
			</div>                                                                             
		</div>
    </div>
	
	</body>
</html>