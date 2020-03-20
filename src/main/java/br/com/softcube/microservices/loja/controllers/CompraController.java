package br.com.softcube.microservices.loja.controllers;

import br.com.softcube.microservices.loja.controllers.dtos.PedidoDTO;
import br.com.softcube.microservices.loja.services.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compra")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @PostMapping
    public void realizaCompra(@RequestBody PedidoDTO pedido) {
        compraService.comprar(pedido);
    }

}
