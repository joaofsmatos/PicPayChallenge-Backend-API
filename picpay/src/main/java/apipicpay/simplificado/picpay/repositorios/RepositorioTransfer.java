package apipicpay.simplificado.picpay.repositorios;

import apipicpay.simplificado.picpay.dominios.transfers.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioTransfer extends JpaRepository<Transfer, Long> {
}
