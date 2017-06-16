package dominio;

import java.util.Collection;
import java.util.HashSet;

public class WebServer {

	private Collection<Analizador> analizadores = new HashSet<Analizador>();
	private Collection<Modulo> modulos = new HashSet<Modulo>();
	
	public  Respuesta atenderPedido(Pedido p){
		Respuesta respuesta;
		respuesta = trabajarPedido(p);
		respuesta.setPedido(p);
		this.analizar( this.moduloSiHubo(respuesta), respuesta);
		return respuesta;
	}

	private Modulo moduloSiHubo(Respuesta respuesta) {
		if (respuesta.getStatusCode() == 200)
			return this.obtenerModulo(respuesta.getPedido());
		else
			return null;
	}

	private Respuesta trabajarPedido(Pedido p) {
		Respuesta respuesta;
		if ( p.getProtocolo().equals("http")){
			respuesta = analizarYTrabajarModulo(p);
		} else {
			respuesta = new Respuesta( 501, "",0); //tiempo en 0
		}
		return respuesta;
	}

	private Respuesta analizarYTrabajarModulo(Pedido p) {
		Respuesta respuesta;
		if (this.hayModuloQuefuncione(p)){
			respuesta = this.obtenerModulo(p).atender(p);
			respuesta.setStatusCode(200);
		} else {
			respuesta = new Respuesta (404, "", 0 );
		}
		return respuesta;
	}

	private void analizar(Modulo m,Respuesta respuesta) {
		this.getAnalizadores().forEach(a -> a.registrar(m,respuesta));
	}

	private Modulo obtenerModulo(Pedido p) {
		return this.getModulos().stream().filter(m -> m.puedeAtender(p) == true).findFirst().get();
	}

	private boolean hayModuloQuefuncione(Pedido p) {
		return this.getModulos().stream().anyMatch(m -> m.puedeAtender(p) == true);
	}

	public void agregarAnalizador(Analizador a){
		this.getAnalizadores().add(a);
	}
	
	public Collection<Analizador> getAnalizadores() {
		return analizadores;
	}

	public void setAnalizadores(Collection<Analizador> analizadores) {
		this.analizadores = analizadores;
	}

	public void agregarModulo(Modulo m){
		this.getModulos().add(m);
	}
	
	public Collection<Modulo> getModulos() {
		return modulos;
	}

	public void setModulos(Collection<Modulo> modulos) {
		this.modulos = modulos;
	}
}
