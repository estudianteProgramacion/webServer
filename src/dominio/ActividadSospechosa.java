package dominio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class ActividadSospechosa {
	private Collection<Actividad> actividades = new ArrayList<>();
	
	public Collection<Actividad> getActividades() {
		return actividades;
	}

	public void setActividades(Collection<Actividad> actividades) {
		this.actividades = actividades;
	}

	public void registrarActividad(String ip, String ruta,int statusCode){
		this.getActividades().add(new Actividad(ip,ruta,statusCode));
	}; 	

	public int cantidadPedidosConRespuestaExitosa(int ip){
		return this.getActividades().stream().filter(a -> a.getIp().equals(ip) && (a.getStatusCode() < 300)).distinct().collect(Collectors.toList()).size();
	};
		
	
	public int cantidadPedidosConRespuestaNoExitosa(int ip){
		return this.getActividades().stream().filter(a -> a.getIp().equals(ip) && (a.getStatusCode() > 300)).distinct().collect(Collectors.toList()).size();
		
	}
	  
	public boolean consultoRuta(String ip, String ruta){
		return this.getActividades().stream().filter(a -> a.getIp() == ip).findAny().get().getRuta() == ruta;
	
	};
	 
	
}
