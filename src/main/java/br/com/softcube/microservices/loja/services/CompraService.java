package br.com.softcube.microservices.loja.services;

import br.com.softcube.microservices.loja.clients.FornecedorClient;
import br.com.softcube.microservices.loja.dtos.PedidoDTO;
import br.com.softcube.microservices.loja.dtos.InfoFornecedorDTO;
import br.com.softcube.microservices.loja.models.Pedido;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class CompraService {

    private static final Logger LOG = LoggerFactory.getLogger(CompraService.class);

    @Autowired
    private RestTemplate client;

    @Autowired
    private FornecedorClient fornecedorClient;

    public ResponseEntity<Pedido> comprar(PedidoDTO pedidoDTO, UriComponentsBuilder builder) {
        LOG.info("Realizando o pedido");
        Pedido pedido = realizaPedido(pedidoDTO);
        if (pedido == null) {
            LOG.info("Não foi possível realizar o pedido");
            return ResponseEntity.badRequest().build();
        } else {
            LOG.info("Pedido realizado com sucesso {}", pedido);
            return ResponseEntity.created(builder.path("/pedido/{id}").buildAndExpand(pedido.getId()).toUri()).body(pedido);
        }
    }

    /*
    Realiza a compra no modelo tradicional de requisição
     */
    void compraTradicional(PedidoDTO pedido) {
        ResponseEntity<InfoFornecedorDTO> response = client.exchange("http://fornecedor-ms/info/" + pedido.getEndereco().getEstado(), HttpMethod.GET, null, InfoFornecedorDTO.class);

        System.out.println(response.getBody().getEndereco());
    }

    /*
    Realiza a compra utilizando o Feign
     */
    Pedido realizaPedido(PedidoDTO pedido) {
        return fornecedorClient.realizaPedido(pedido.getItens());
    }
}
