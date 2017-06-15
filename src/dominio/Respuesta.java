package dominio;

public class Respuesta {

	private Pedido pedido;
	private int tiempo;
	private int statusCode;
	private String payload;
	
	public Respuesta(int i, String string, int j) {
		this.setTiempo(j);
		this.setStatusCode(i);
		this.setPayload(string);
	}

	public Respuesta(String payload2, int tiempoDeRespuesta) {
		this.setTiempo(tiempoDeRespuesta);
		this.setPayload(payload2);
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	public String getIp() {
		return this.getPedido().getIp();
	}

	public String getRuta() {
		return this.getPedido().getRuta();
	}

}
