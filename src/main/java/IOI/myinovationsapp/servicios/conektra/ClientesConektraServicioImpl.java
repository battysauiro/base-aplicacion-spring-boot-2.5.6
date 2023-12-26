package IOI.myinovationsapp.servicios.conektra;

import okhttp3.*;
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

    public String obtenerCliente(String idCliente) throws Exception {

        Request request = new Request.Builder()
                .url("https://api.conekta.io/customers/"+idCliente)
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

    public String agregarCliente(String json) throws Exception{
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, json);
        Request request = new Request.Builder()
                .url("https://api.conekta.io/customers")
                .post(body)
                .addHeader("accept", "application/vnd.conekta-v2.1.0+json")
                .addHeader("Accept-Language", "es")
                .addHeader("content-type", "application/json")
                .addHeader("authorization", "Bearer key_gRHfeL3s1vZ0mMbSpuQRkQF")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new RuntimeException("Error al realizar la solicitud: " + response);
            }

            return response.body().string();
        }
    }

    public String editarCliente(String json,String idCliente) throws Exception{
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, json);
        Request request = new Request.Builder()
                .url("https://api.conekta.io/customers/"+idCliente)
                .put(body)
                .addHeader("accept", "application/vnd.conekta-v2.1.0+json")
                .addHeader("Accept-Language", "es")
                .addHeader("content-type", "application/json")
                .addHeader("authorization", "Bearer key_gRHfeL3s1vZ0mMbSpuQRkQF")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new RuntimeException("Error al realizar la solicitud: " + response);
            }

            return response.body().string();
        }
    }

    public String eliminarCliente(String idCliente) throws Exception {

        Request request = new Request.Builder()
                .url("https://api.conekta.io/customers/"+idCliente)
                .delete(null)
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
