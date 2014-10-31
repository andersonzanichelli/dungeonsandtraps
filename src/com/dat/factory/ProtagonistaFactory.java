package com.dat.factory;

import com.dat.enums.ClassePersonagem;
import com.dat.json.JSONObject;
import com.dat.model.Anao;
import com.dat.model.Barbaro;
import com.dat.model.Batedor;
import com.dat.model.Guerreira;
import com.dat.model.Mago;
import com.dat.model.Protagonista;
import com.dat.model.Sacerdotisa;

public class ProtagonistaFactory {
	
	public static Protagonista buildProtagonista(ClassePersonagem classe, JSONObject jsonObject) {
		Protagonista protagonista = null;
		
		switch(classe) {
			case ANAO:
				protagonista = new Anao(jsonObject);
	            break;
	        
			case BARBARO:
				protagonista = new Barbaro(jsonObject);
				break;
				
			case BATEDOR:
				protagonista = new Batedor(jsonObject);
				break;
	 
			case GUERREIRA:
				protagonista = new Guerreira(jsonObject);
				break;
				
			case MAGO:
				protagonista = new Mago(jsonObject);
				break;
				
			case SACERDOTISA:
				protagonista = new Sacerdotisa(jsonObject);
				break;
				
	        default:
	            throw new IllegalArgumentException("Classe não reconhecida.");
        }
		
		return protagonista;
	}
}
