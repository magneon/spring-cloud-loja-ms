package br.com.softcube.microservices.loja.dtos;

import java.util.List;

public class PedidoDTO {

    private List<ItemPedidoDTO> itens;
    private EnderecoDTO endereco;

    public List<ItemPedidoDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedidoDTO> itens) {
        this.itens = itens;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }
}
