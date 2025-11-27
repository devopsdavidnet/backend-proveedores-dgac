package bo.gob.dgac.proveedores.externo;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CorreoWebClientService {

    private final String URL_API = "http://192.168.22.22:8082/api/enviarcorreo"; 

    private final WebClient webClient;

    public CorreoWebClientService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(URL_API).build();
    }
//
    public String enviarCorreo(String correoDestino,String asunto,String mensaje) {
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("para", correoDestino);
        formData.add("asunto", asunto);
        formData.add("mensaje", mensaje);
     //   formData.add("copia", "");
        try {
        	System.out.println("**DDDDDDDDDDDDDDDDDDD**"+correoDestino);
            String response = webClient.post()
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(BodyInserters.fromFormData(formData))
                .retrieve()
                .bodyToMono(String.class) 
                .block(); 

            return "Correo enviado con éxito: " + response;
        } catch (Exception e) {
            return "Excepción al llamar al servicio: " + e.getMessage();
        }
    }
}