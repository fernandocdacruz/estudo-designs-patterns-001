package model;

import enums.StatusPedido;
import model.Lanche.LancheBuilder;

public class Lanche {

	private String nome;
	private String tipoPao;
	private String tipoCarne;
	private String tipoQueijo;
	private String tipoMolho;
	private String tipoVegetais;
	private double valor;
		
	public Lanche(LancheBuilder builder) {
		this.nome = builder.nome;
		this.tipoPao = builder.tipoPao;
		this.tipoCarne = builder.tipoCarne;
		this.tipoQueijo = builder.tipoQueijo;
		this.tipoMolho = builder.tipoMolho;
		this.tipoVegetais = builder.tipoVegetais;
		this.valor = builder.valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipoPao() {
		return tipoPao;
	}

	public void setTipoPao(String tipoPao) {
		this.tipoPao = tipoPao;
	}

	public String getTipoCarne() {
		return tipoCarne;
	}

	public void setTipoCarne(String tipoCarne) {
		this.tipoCarne = tipoCarne;
	}

	public String getTipoQueijo() {
		return tipoQueijo;
	}

	public void setTipoQueijo(String tipoQueijo) {
		this.tipoQueijo = tipoQueijo;
	}

	public String getTipoMolho() {
		return tipoMolho;
	}

	public void setTipoMolho(String tipoMolho) {
		this.tipoMolho = tipoMolho;
	}

	public String getTipoVegetais() {
		return tipoVegetais;
	}

	public void setTipoVegetais(String tipoVegetais) {
		this.tipoVegetais = tipoVegetais;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public static class LancheBuilder {
		private String nome;
		private String tipoPao;
		private String tipoCarne;
		private String tipoQueijo;
		private String tipoMolho;
		private String tipoVegetais;
		private double valor;
		
		public LancheBuilder nomeLanche(String nome) {
			this.nome = nome;
			return this;
		}
		
		public LancheBuilder comPao(String pao) {
			this.tipoPao = pao;
			return this;
		}
		
		public LancheBuilder comCarne(String carne) {
			this.tipoCarne = carne;
			return this;
		}
		
		public LancheBuilder comQueijo(String queijo) {
			this.tipoQueijo = queijo;
			return this;
		}
		
		public LancheBuilder comMolho(String molho) {
			this.tipoMolho = molho;
			return this;
		}
		
		public LancheBuilder comVegetais(String vegetais) {
			this.tipoVegetais = vegetais;
			return this;
		}
		
		public LancheBuilder valorLanche(double valor) {
			this.valor = valor;
			return this;
		}
		
		public Lanche build() {
			return new Lanche(this);
		}	
		
	}

	@Override
	public String toString() {
		return "Lanche [nome=" + nome + ", tipoPao=" + tipoPao + ", tipoCarne=" + tipoCarne + ", tipoQueijo="
				+ tipoQueijo + ", tipoMolho=" + tipoMolho + ", tipoVegetais=" + tipoVegetais + ", valor=" + valor + "]";
	}
		
}
