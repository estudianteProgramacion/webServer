package dominio;

import java.util.ArrayList;
import java.util.Collection;

public class AnalizadorIPsSospechosas implements Analizador {
	private Collection<String> iPsSospechosas = new ArrayList<String>();
	private ActividadSospechosa registroActividadSospechosa;
	
	public AnalizadorIPsSospechosas(Collection<String> ipSospechosas, ActividadSospechosa regAc){
		this.setiPsSospechosas(ipSospechosas);
		this.setRegistroActividadSospechosa(regAc);
	}
	
	public AnalizadorIPsSospechosas(Collection<String> ipsSospechosas){
		this.setiPsSospechosas(ipsSospechosas);
		this.setRegistroActividadSospechosa(new ActividadSospechosa());
	}
	

	public Collection<String> getiPsSospechosas() {
		return iPsSospechosas;
	}
	public void setiPsSospechosas(Collection<String> iPsSospechosas) {
		this.iPsSospechosas = iPsSospechosas;
	}
	public ActividadSospechosa getRegistroActividadSospechosa() {
		return registroActividadSospechosa;
	}
	public void setRegistroActividadSospechosa(ActividadSospechosa registroActividadSospechosa) {
		this.registroActividadSospechosa = registroActividadSospechosa;
	}
	@Override
	public void registrar(Modulo unModulo, Respuesta unaRespuesta) {
		if (iPsSospechosas.contains(unaRespuesta.getIp())) {
			registroActividadSospechosa.registrarActividad(unaRespuesta.getIp(), unaRespuesta.getRuta(), unaRespuesta.getStatusCode());
		}
	
	}
	
	
}
