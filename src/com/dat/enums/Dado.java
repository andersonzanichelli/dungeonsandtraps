package com.dat.enums;

public enum Dado {
	
	D4("d4") {
		@Override
		public Integer lancamento() {
			return randomico(4);
		}
	}
	, D6("d6") {
		@Override
		public Integer lancamento() {
			return randomico(6);
		}
	}
	, D8("d8") {
		@Override
		public Integer lancamento() {
			return randomico(8);
		}
	}
	, D10("d10") {
		@Override
		public Integer lancamento() {
			return randomico(10);
		}
	}
	, D12("d12") {
		@Override
		public Integer lancamento() {
			return randomico(12);
		}
	}
	, D20("d20") {
		@Override
		public Integer lancamento() {
			return randomico(20);
		}
	};
	
	String dado;
	
	Dado(String dado) {
		this.dado = dado;
	}
	
	public abstract Integer lancamento();
	
	private static Integer randomico(Integer faces){
		return 6;
	}
}
