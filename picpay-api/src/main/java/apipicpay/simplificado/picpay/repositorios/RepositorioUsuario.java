package apipicpay.simplificado.picpay.repositorios;

import apipicpay.simplificado.picpay.dominios.usuarios.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, String> {
}
