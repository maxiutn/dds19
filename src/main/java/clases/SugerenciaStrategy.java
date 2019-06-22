package clases;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class SugerenciaStrategy {
	
	protected int temperaturaAdecuada;
	
	public int getTemperaturaAdecuada() {
		return this.temperaturaAdecuada;
	}
}