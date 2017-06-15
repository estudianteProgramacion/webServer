package dominio;

public class ModuloRespuesta {
	private Modulo modulo;
	private Respuesta respuesta;
	
	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	public Respuesta getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(Respuesta respuesta) {
		this.respuesta = respuesta;
	}

	public ModuloRespuesta(Modulo unModulo, Respuesta unaRespuesta){
		this.setModulo(unModulo);
		this.setRespuesta(unaRespuesta);
	};
}
