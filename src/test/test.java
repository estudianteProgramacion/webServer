package test;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;

import org.junit.Test;

import dominio.Modulo;
import dominio.Pedido;
import dominio.WebServer;

public class test {

	@Test
	public void test() throws MalformedURLException {
		WebServer ws = new WebServer();
		
		
		Collection<String> extencionesAcpM1 = new HashSet<>();
		extencionesAcpM1.add("html");
		extencionesAcpM1.add("hs");
		extencionesAcpM1.add("txt");
		
		Collection<String> extencionesAcpEXE = new HashSet<>();
		extencionesAcpEXE.add("exe");
		
		Collection<String> extencionesAcpJS = new HashSet<>();
		extencionesAcpJS.add("js");
		
		ws.agregarModulo(new Modulo(extencionesAcpM1, "Este es el Modulo 1", 111));
		ws.agregarModulo(new Modulo(extencionesAcpEXE, "Este es el Modulo 2", 222));
		ws.agregarModulo(new Modulo(extencionesAcpJS, "Este es el Modulo3", 333));
		
		Pedido p1 = new Pedido("1.1.1.1", LocalDateTime.now() , "http://www.google.com/index.js/");
		Pedido p2 = new Pedido("2.2.2.2", LocalDateTime.now() , "ftp://www.yahoo.com.ar/cas/explorer/index.js/");
		
		assertEquals(200, ws.atenderPedido(p1).getStatusCode());
		assertEquals("/index.js/", ws.atenderPedido(p1).getRuta());
		assertEquals(333, ws.atenderPedido(p1).getTiempo());
		assertEquals("www.google.com", ws.atenderPedido(p1).getPedido().getDireccion());
		
		assertEquals(501, ws.atenderPedido(p2).getStatusCode());
		assertEquals(0, ws.atenderPedido(p2).getTiempo());
		assertEquals("", ws.atenderPedido(p2).getPayload());
		
	}

}
