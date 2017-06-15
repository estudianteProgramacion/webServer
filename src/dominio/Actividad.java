package dominio;

public class Actividad {
	private String ip;
	private String ruta;
	private int statusCode;

	public Actividad(String ip, String ruta, int statusCode) {
		this.setIp(ip);
		this.setRuta(ruta);
		this.setStatusCode(statusCode);
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
}
