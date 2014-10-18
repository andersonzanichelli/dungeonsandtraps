package com.dat.factory;

import com.dat.enums.ClassePersonagem;
import com.dat.model.Anao;
import com.dat.model.Barbaro;
import com.dat.model.Batedor;
import com.dat.model.Guerreira;
import com.dat.model.Mago;
import com.dat.model.Protagonista;
import com.dat.model.Sacerdotisa;

public class ProtagonistaFactory {
	
	public static Protagonista buildProtagonista(ClassePersonagem classe) {
		Protagonista protagonista = null;
		
		switch(classe) {
			case ANAO:
				protagonista = new Anao();
	            break;
	        
			case BARBARO:
				protagonista = new Barbaro();
				break;
				
			case BATEDOR:
				protagonista = new Batedor();
				break;
	 
			case GUERREIRA:
				protagonista = new Guerreira();
				break;
				
			case MAGO:
				protagonista = new Mago();
				break;
				
			case SACERDOTISA:
				protagonista = new Sacerdotisa();
				break;
				
	        default:
	            throw new IllegalArgumentException("Classe não reconhecida.");
        }
		
		return protagonista;
	}
}
