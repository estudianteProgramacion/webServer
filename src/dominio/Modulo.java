package dominio;

import java.util.Collection;

public class Modulo {

	private String payload;
	private int tiempoDeRespuesta;
	private Collection<String> extencionesAceptadas;
	
	public Modulo(Collection<String> extencionesAceptadas,String payload, int tiempoDeRespuesta){
		this.setExtencionesAceptadas(extencionesAceptadas);
		this.setPayload(payload);
		this.setTiempoDeRespuesta(tiempoDeRespuesta);
	}

	public boolean puedeAtender(Pedido p)  {
		return this.getExtencionesAceptadas().contains(p.getExtencion());
	}

	public Respuesta atender(Pedido p) {
		return new Respuesta(this.getPayload(), this.getTiempoDeRespuesta()); 
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	public int getTiempoDeRespuesta() {
		return tiempoDeRespuesta;
	}

	public void setTiempoDeRespuesta(int tiempoDeRespuesta) {
		this.tiempoDeRespuesta = tiempoDeRespuesta;
	}

	public Collection<String> getExtencionesAceptadas() {
		return extencionesAceptadas;
	}

	public void setExtencionesAceptadas(Collection<String> extencionesAceptadas) {
		this.extencionesAceptadas = extencionesAceptadas;
	}

}
