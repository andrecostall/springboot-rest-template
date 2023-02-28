package com.example.springbootresttemplate.controller;

import com.example.springbootresttemplate.response.CepResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api")
public class CepController {

    @GetMapping("cep/{cep}")
    public CepResponse consulta(@PathVariable("cep") String cep){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CepResponse> response =
                restTemplate.getForEntity("https://viacep.com.br/ws/"+cep+"/json", CepResponse.class);
        return response.getBody();
    }

}
