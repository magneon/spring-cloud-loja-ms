package br.com.softcube.microservices.loja.controllers;

import br.com.softcube.microservices.loja.controllers.dtos.PedidoDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compra")
public class CompraController {

    @PostMapping
    public void comprar(@RequestBody PedidoDTO compra) {

    }

}
