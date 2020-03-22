package br.com.softcube.microservices.loja.clients;

import br.com.softcube.microservices.loja.dtos.ItemPedidoDTO;
import br.com.softcube.microservices.loja.dtos.ItensPedidoDTO;
import br.com.softcube.microservices.loja.dtos.PedidoDTO;
import br.com.softcube.microservices.loja.dtos.ProdutoDTO;
import br.com.softcube.microservices.loja.models.Pedido;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient("fornecedor-ms")
public interface FornecedorClient {

    @GetMapping("/produtos/{estado}")
    List<ProdutoDTO> pegaProdutosPorEstado(@PathVariable("estado") String estado);

    @PostMapping("/pedido")
    Pedido realizaPedido(List<ItemPedidoDTO> itensPedido);

}
