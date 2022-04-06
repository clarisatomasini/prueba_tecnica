package spring.prueba_tecnica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PruebaTecnicaApplication {
	final static Logger logger = LoggerFactory.getLogger("spring.prueba_tecnica.PruebaTecnicaApplication");
    final static String pathFile = "files/";
	
	public static void main(String[] args) {
		SpringApplication.run(PruebaTecnicaApplication.class, args);
	}

	@PostMapping("/hash")
	public Map<String, Object> hello(@RequestParam(value="algorithm", required=true) String algorithm, @RequestBody List<Object> body) {
		Map<String, Object> respuesta = new HashMap<String, Object>();
		List<File> documents = new ArrayList<File>();

		logger.info(String.format("Procesando peticion /hash. Algorithm: %s, Archivos: %s ", algorithm, body.toString()));
		
		try {
			for(int i=0; i<body.size(); i++) {
				String fileName = body.get(i).toString();
				String content = ProcessFile.getContent(PruebaTecnicaApplication.pathFile + fileName);
				String hash = ProcessFile.getHash(content, algorithm);

				documents.add(new File(fileName, hash));
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			return respuesta;
		}

		respuesta.put("documents", documents);
		respuesta.put("algorithm", algorithm);
		return respuesta;
	}

}
