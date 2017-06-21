package dominio;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;

public class Pedido {

	private String ip;
	private LocalDateTime diaYHora;
	private URL url;
	
	public  Pedido(String ip, LocalDateTime diaYHora, String url) throws MalformedURLException{
		this.setIp(ip);
		this.setDiaYHora(diaYHora);
		this.setUrl(new URL(url));
	}
	
	public String getProtocolo(){
		return getUrl().getProtocol().toLowerCase();
	}

	public String getDireccion(){
		return getUrl().getHost();
	}
	
	public String getRuta(){
		return getUrl().getPath();

	}
	public String getExtencion() {
		int indexUltimoPunto = this.getUrl().toString().lastIndexOf(".");
		int indexUltimaBarra = this.getUrl().toString().lastIndexOf("/");
		//System.out.println(this.getUrl().toString().substring(indexUltimoPunto+1, indexUltimaBarra));
		return this.getUrl().toString().substring(indexUltimoPunto+1, indexUltimaBarra).toLowerCase() ;
	}
	
	
	
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public LocalDateTime getDiaYHora() {
		return diaYHora;
	}

	public void setDiaYHora(LocalDateTime diaYHora) {
		this.diaYHora = diaYHora;
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}


}
