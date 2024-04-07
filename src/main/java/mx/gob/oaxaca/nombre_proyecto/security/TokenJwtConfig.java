package mx.gob.oaxaca.nombre_proyecto.security;

import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;
import java.util.Date;

public class TokenJwtConfig {
    public static final String LLAVE_SECRETA = "Tarjt4J0v3N2o24";//SecretKey Jwts.SIG.HS256.key().build();
    public static final String PREFIJO_TOKEN = "Bearer ";
    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final Date EXPIRATION = new Date(System.currentTimeMillis()+3600000);
    public static final String CONTENT_TYPE = "application/json";
}
