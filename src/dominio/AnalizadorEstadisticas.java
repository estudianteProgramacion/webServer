package dominio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class AnalizadorEstadisticas implements Analizador {

	private Collection<Respuesta> respuestas = new ArrayList<>();
	
	public Collection<Respuesta> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(Collection<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}

	@Override
	public void registrar(Modulo unModulo,Respuesta unaRespuesta) {
		this.getRespuestas().add(unaRespuesta);

	}
	
	public double tiempoRespuestaPromedio(){
		return this.getRespuestas().stream().mapToInt(r -> r.getTiempo()).sum()
			   / this.totalRespuestas();
	};
	public long cantidadDePedidosEntre(LocalDateTime fecha1, LocalDateTime fecha2){
		return this.getRespuestas().stream().filter(r -> r.getPedido().getDiaYHora().isAfter(fecha1) && r.getPedido().getDiaYHora().isBefore(fecha2)).count();
	};
	
	public int cantidadDeRespuestaConString(String unString){
		return this.getRespuestas().stream().filter(r -> contieneUn(r.getPayload(), unString)).collect(Collectors.toList()).size();
	};
	
	public boolean contieneUn(String palabra, String unString){
		if (palabra.toLowerCase().indexOf(unString.toLowerCase()) > -1) {return true;}
		else {return false;}
	};
	
	public double porcentajeDeRespuestasExitosas(){
		return totalRespuestasExitosas() 
				* 100
				/ totalRespuestas();
	}

	private int totalRespuestasExitosas() {
		return this.getRespuestas().stream().filter(a -> a.getStatusCode() < 300).distinct().collect(Collectors.toList()).size();
	}

	private int totalRespuestas() {
		return this.getRespuestas().size();
	};
	
}
