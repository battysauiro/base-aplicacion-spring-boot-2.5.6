package IOI.myinovationsapp.servicios.conektra;

import IOI.myinovationsapp.dtos.PlanDTO;
import okhttp3.*;
import org.springframework.stereotype.Service;
import org.json.JSONObject;

@Service
public class PlanesConektraServicioImpl {

    OkHttpClient client = new OkHttpClient();

    public String obtenerPlanes(int limite,String busqueda,String siguiente,String anterior) throws Exception {

        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.conekta.io/plans")
                .newBuilder()
                .addQueryParameter("limit", String.valueOf(limite))
                .addQueryParameter("search", busqueda)
                .addQueryParameter("next", siguiente)
                .addQueryParameter("previous", anterior);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
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

    public String obtenerPlan(String idPlan) throws Exception {

        Request request = new Request.Builder()
                .url("https://api.conekta.io/plans/"+idPlan)
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

    public String agregarPlan(PlanDTO planDTO) throws Exception{

        // Crear un objeto JSON para representar los datos

        JSONObject jsonBody = new JSONObject();

        jsonBody.put("amount", planDTO.getAmount()!=null?planDTO.getAmount():0);
        jsonBody.put("currency", planDTO.getCurrency()!=null || planDTO.getCurrency().length()>0?planDTO.getCurrency():"MXN");
        if(planDTO.getExpiry_count()!=null){
            jsonBody.put("expiry_count",planDTO.getExpiry_count());
        }

        jsonBody.put("frequency", planDTO.getFrequency()!=null?planDTO.getFrequency():1);
        jsonBody.put("interval", planDTO.getInterval()!=null || planDTO.getInterval().length()>0?planDTO.getInterval():"week");
        jsonBody.put("name", planDTO.getName()!=null || planDTO.getName().length()>0?planDTO.getName():"PLAN SIN NOMBRE");

        if(planDTO.getTrial_period_days()!=null){
            jsonBody.put("trial_period_days",planDTO.getTrial_period_days());
        }

        String requestBody = jsonBody.toString();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, requestBody);
        Request request = new Request.Builder()
                .url("https://api.conekta.io/plans")
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

    public String editarPlan(PlanDTO planDTO) throws Exception{
        JSONObject jsonBody = new JSONObject();

        jsonBody.put("amount", planDTO.getAmount()!=null?planDTO.getAmount():300);
        jsonBody.put("currency", planDTO.getCurrency()!=null || planDTO.getCurrency().length()>0?planDTO.getCurrency():"MXN");
        if(planDTO.getExpiry_count()!=null){
            jsonBody.put("expiry_count",planDTO.getExpiry_count());
        }
        jsonBody.put("name", planDTO.getName()!=null || planDTO.getName().length()>0?planDTO.getName():"PLAN SIN NOMBRE");


        String requestBody = jsonBody.toString();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, requestBody);
        Request request = new Request.Builder()
                .url("https://api.conekta.io/plans/"+planDTO.getId())
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

    public String eliminarPlan(String idPlan) throws Exception {

        Request request = new Request.Builder()
                .url("https://api.conekta.io/plans/"+idPlan)
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
