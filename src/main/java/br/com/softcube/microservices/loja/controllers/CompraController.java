package br.com.softcube.microservices.loja.controllers;

import br.com.softcube.microservices.loja.dtos.PedidoDTO;
import br.com.softcube.microservices.loja.models.Pedido;
import br.com.softcube.microservices.loja.services.CompraService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/compra")
public class CompraController {

    private static final Logger LOG = LoggerFactory.getLogger(CompraController.class);

    @Autowired
    private CompraService compraService;

    @PostMapping
    public ResponseEntity<Pedido> realizaCompra(@RequestBody PedidoDTO pedido, UriComponentsBuilder builder) {
        LOG.info("Realizando compra do pedido {}", pedido);

        return compraService.comprar(pedido, builder);
    }

}
