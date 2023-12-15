package IOI.myinovationsapp.servicios.conektra;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

@Service
public class ClientesConektraServicioImpl {

    OkHttpClient client = new OkHttpClient();

    public String obtenerClientes(String url) throws Exception {

        Request request = new Request.Builder()
                .url("https://api.conekta.io/customers?limit=20")
                .get()
                .addHeader("accept", "application/vnd.conekta-v2.1.0+json")
                .addHeader("Accept-Language", "es")
                .addHeader("authorization", "Bearer key_gRHfeL3s1vZ0mMbSpuQRkQF")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new RuntimeException("Error al realizar la solicitud: " + response);
            }

            return response.body().string();
        }
    }
}
