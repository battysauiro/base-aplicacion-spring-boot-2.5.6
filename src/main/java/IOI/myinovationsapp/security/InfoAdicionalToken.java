/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IOI.myinovationsapp.security;

import IOI.myinovationsapp.dao.Usuariodao;
import IOI.myinovationsapp.entidades.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Oscar
 */
@Component
public class InfoAdicionalToken implements TokenEnhancer{

    @Autowired
    private Usuariodao usuarioDao;
    
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oaat, OAuth2Authentication oaa) {
        Usuario usuario = usuarioDao.findByNombreUsuario(oaa.getName()).get();
        Map<String,Object> info= new HashMap<>();

        info.put("nombreUsuario", usuario.getNombreUsuario());
        info.put("idUsuario", usuario.getUsuarioId());
        info.put("nombrePersona", usuario.getPersona().getNombre()+" "+ usuario.getPersona().getApellidoPaterno()+" "+ usuario.getPersona().getApellidoMaterno());
        info.put("tokenConektra", usuario.getTokenConektra());
        ((DefaultOAuth2AccessToken) oaat).setAdditionalInformation(info);
        return oaat;
    }
    
}
