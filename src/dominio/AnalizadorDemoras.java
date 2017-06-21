package dominio;

import java.util.ArrayList;
import java.util.Collection;

public class AnalizadorDemoras implements Analizador {
	private int demoraMinima;
	private Collection<ModuloRespuesta> modulosConRespuestas = new ArrayList<>();
	
	public AnalizadorDemoras(int demoraMinima){
		this.setDemoraMinima(demoraMinima);
	}
	
	public int getDemoraMinima() {
		return demoraMinima;
	}

	public void setDemoraMinima(int demoraMinima) {
		this.demoraMinima = demoraMinima;
	}	
	public Collection<ModuloRespuesta> getModulosConRespuestas() {
		return modulosConRespuestas;
	}
	
	public void setModulosConRespuestas(Collection<ModuloRespuesta> modulosConRespuestas) {
		this.modulosConRespuestas = modulosConRespuestas;
	}
	
	@Override
	public void registrar(Modulo unModulo, Respuesta unaRespuesta) {
		this.getModulosConRespuestas().add(new ModuloRespuesta(unModulo, unaRespuesta));
		
	}
	
	public long cantidadDeRespuestasDemoradas(Modulo unModulo){
		return this.getModulosConRespuestas().stream().filter(m -> m.getModulo().equals(unModulo))
				.filter(m -> m.getRespuesta().getTiempo() > this.getDemoraMinima()).count();
	};
	

}
