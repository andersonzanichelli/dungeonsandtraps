package com.dat.enums;

public enum Status {

	VIVO, MORRENDO, MORTO;
	
	public static Status qualStatus(Integer vida, Integer pv) {

		Integer porcentagem = (int) Math.floor(vida * 0.15 );
		
		if(pv <= 0) {
			return MORTO;
		} else if(0 < pv && pv <= porcentagem) {
			return MORRENDO;
		}
		
		return VIVO;
	}
}
