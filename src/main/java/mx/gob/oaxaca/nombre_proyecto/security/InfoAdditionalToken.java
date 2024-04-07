/**
 * @author L.I. Pablo Antonio García Santiago
 * @name InfoAdditionalToken
 * @version 1.0.0
 * @autor-mail jack.skell.loki@gmail.com
 * @date 07/02/2024
 */
package mx.gob.oaxaca.nombre_proyecto.security;

import mx.gob.oaxaca.nombre_proyecto.entidades.Usuario;
import mx.gob.oaxaca.nombre_proyecto.repositorios.UsuarioRepositorioJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class InfoAdditionalToken implements TokenEnhancer{

    @Autowired
    private UsuarioRepositorioJPA usuarioRepositorioJPA;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oaat, OAuth2Authentication oaa) {
        Usuario usuario = usuarioRepositorioJPA.findByUsuario(oaa.getName()).get();

        Map<String,Object> info= new HashMap<>();
        info.put("usuario", usuario.getUsuario());
        info.put("id", usuario.getId());
        ((DefaultOAuth2AccessToken) oaat).setAdditionalInformation(info);
        return oaat;
    }
}
