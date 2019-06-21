package clases;

public class Gratuito extends Usuario{

	public Gratuito(String nombre, int maximo) {
		super(nombre);
		this.tipoDeUsuario = "Gratuito";
		this.max_guardarropa = maximo;
	}
	
	public void setMaximoGuardarropas(int maximo) {
		this.max_guardarropa = maximo;
	}
}
