package com.dat.enums;

public enum Dado {

	D4("d4") {
		@Override
		public Integer lancamento() {
			// TODO Auto-generated method stub
			// implementar o método randomico que devolve de 1 a 4
			return null;
		}
	}
	, D6("d6") {
		@Override
		public Integer lancamento() {
			// TODO Auto-generated method stub
			return null;
		}
	}
	, D8("d8") {
		@Override
		public Integer lancamento() {
			// TODO Auto-generated method stub
			return null;
		}
	}
	, D10("d10") {
		@Override
		public Integer lancamento() {
			// TODO Auto-generated method stub
			return null;
		}
	}
	, D12("d12") {
		@Override
		public Integer lancamento() {
			// TODO Auto-generated method stub
			return null;
		}
	}
	, D20("d20") {
		@Override
		public Integer lancamento() {
			// TODO Auto-generated method stub
			return null;
		}
	};
	
	String dado;
	
	Dado(String dado) {
		this.dado = dado;
	}
	
	public abstract Integer lancamento();
}
