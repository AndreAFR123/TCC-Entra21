package br.com.bansys;

import java.io.IOException;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("rest")
public class MyApp extends ResourceConfig{
	
	public MyApp() throws IOException {
		packages("br.com.bansys.controller");
	}
}