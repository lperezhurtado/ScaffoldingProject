package com.scaffolding.scaffolding.services;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.scaffolding.scaffolding.entities.beans.AccountBean;
import com.scaffolding.scaffolding.entities.beans.NumberAccountBean;

@Service
public class AccountService {

    @Autowired
    private RestTemplate restTemplate;

    private final double INTERESTS = .5;
    private final double COMISSION = .4;

    public AccountBean getAccount(Long userId) {
        ResponseEntity<AccountBean> responseEntity = restTemplate
                                                    .getForEntity("http://localhost:8083/account/" + userId, AccountBean.class);
      
        return responseEntity.getBody();
    }

    public String createAccountFromAccountServer(Long idUser, LocalDateTime now) {
        Map<String, String> map = getAccountMapped(idUser, now);
        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8083/account/create", map, String.class);
        //ResponseEntity<String> response = restTemplate.exchange("http://localhost:8083/account/create", HttpMethod.POST, map, String.class);
        return response.getBody();
    }

    public String deleteAccountFromAccountServer(Long idUser) {
        restTemplate.delete("http://localhost:8083/account/delete/{idUser}", idUser);
        return "Cuenta del usuario con ID "+idUser+" eliminada";
    }



    public AccountBean setAccountBean (LocalDateTime now, Long idUser) {
        return new AccountBean(now, INTERESTS, COMISSION, idUser);
    }

    private Map<String, String> getAccountMapped(Long idUser, LocalDateTime now) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("openingDate", now.toString());
        map.put("interestPayment", Double.toString(INTERESTS));
        map.put("overdraftComission", Double.toString(COMISSION));
        map.put("idUser", Long.toString(idUser));
        
        return map;
    }

    public NumberAccountBean setNumberAccount(String response, LocalDateTime now) {
        return new NumberAccountBean(response, now);
    }
}
