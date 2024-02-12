package apipicpay.simplificado.picpay.dominios.usuarios;

import java.math.BigDecimal;

public record UsuarioRecord(
        String cpf,
        String nome,
        String email,
        String senha,
        TipoUsuario tipoUsuario,
        BigDecimal carteira
) {
    
}
