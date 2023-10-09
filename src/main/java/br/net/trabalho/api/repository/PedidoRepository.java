package br.net.trabalho.api.repository;

import br.net.trabalho.api.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    public List<Pedido> findByClienteId(Long clienteId);
    public List<Pedido> findByClienteIdAndStatusId(Long clienteId, Long statusId);
    public List<Pedido> findByStatusId(Long statusId);
}
