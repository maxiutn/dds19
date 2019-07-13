package clases;

public class Indumentaria {

	private TipoDePrenda tipoDePrenda;
	private Tela tela;
	private String colorPrimario;
	private String colorSecundario;
	private String observacion;	
	
	public Indumentaria(TipoDePrenda unTipo, Tela tela, String color) {
		if(unTipo.getTelasAceptables().contains(tela)) {
			this.tipoDePrenda = unTipo;
			this.tela = tela;
			this.colorPrimario = color;
		}else {
			System.out.println("La tela ingresada no pertenece a un tipo de tela aceptable.");
		}
		
	}
	
	public String getObservacion() {
		return this.observacion;
	}
	
	public void setObservacion(String obs) {
		this.observacion = obs;
	}
	
	public String getColorPrimario() {
		return this.colorPrimario;
	}
	
	public String getColorSecundario() {
		return this.colorSecundario;
	}
	
	public void setColorSecundario(String color) {
		this.colorSecundario = color;
	}
	
	public TipoDePrenda getTipoDePrenda() {
		return this.tipoDePrenda;
	}
	
	public Tela getTela() {
		return this.tela;
	}
	
	public int getNivelDeCalor() {
		return this.tipoDePrenda.getCalor();
	}
	
	@Override
	public String toString() {
		return "Indumentaria [tipoDePrenda=" + tipoDePrenda.getDescripcion() + ", tela=" + tela.getDescripcion() + ", colorPrimario=" + colorPrimario
				+ ", colorSecundario=" + colorSecundario + ", observacion=" + observacion + "]";
	}
}
