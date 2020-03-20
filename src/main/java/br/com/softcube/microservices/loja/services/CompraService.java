package br.com.softcube.microservices.loja.services;

import br.com.softcube.microservices.loja.controllers.dtos.PedidoDTO;
import br.com.softcube.microservices.loja.dtos.InfoFornecedorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CompraService {

    @Autowired
    private RestTemplate client;

    public void comprar(PedidoDTO pedido) {
        ResponseEntity<InfoFornecedorDTO> response = client.exchange("http://fornecedor-ms/info/" + pedido.getEndereco().getEstado(), HttpMethod.GET, null, InfoFornecedorDTO.class);

        System.out.println(response.getBody().getEndereco());
    }
}
