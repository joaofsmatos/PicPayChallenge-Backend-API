package apipicpay.simplificado.picpay.servicos;

import apipicpay.simplificado.picpay.dominios.transfers.Transfer;
import apipicpay.simplificado.picpay.dominios.transfers.TransferRecord;
import apipicpay.simplificado.picpay.dominios.usuarios.TipoUsuario;
import apipicpay.simplificado.picpay.dominios.usuarios.Usuario;
import apipicpay.simplificado.picpay.dominios.usuarios.UsuarioRecord;
import apipicpay.simplificado.picpay.repositorios.RepositorioTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ServicoTransfer {

    @Autowired
    private RepositorioTransfer repositorioTransfer;

    @Autowired
    private ServicoUsuario servicoUsuario;


    public Transfer novaTransferencia(TransferRecord transferRecord) {
        Usuario usuarioPayer = servicoUsuario.detalharUsuario(transferRecord.payer());
        Usuario usuarioPayee = servicoUsuario.detalharUsuario(transferRecord.payee());
        if (!usuarioPayer.getTipoUsuario().equals(TipoUsuario.COMUM) || usuarioPayer.getCpf().equalsIgnoreCase(usuarioPayee.getCpf())) {
            throw new RuntimeException("");
        }
        if (sacarAndTransferir(usuarioPayer, usuarioPayee, transferRecord.valor())) {
            return this.repositorioTransfer.save(new Transfer(transferRecord));
        } else {
            throw new RuntimeException("");
        }
    }

    private boolean sacarAndTransferir(Usuario usuarioPayer, Usuario usuarioPayee, BigDecimal valor) {
        return sacar(valor, usuarioPayer) && depositar(valor, usuarioPayee);
    }

    public List<Transfer> listarUsuarios() {
        return this.repositorioTransfer.findAll();
    }

    public boolean sacar(BigDecimal valor, Usuario usuarioPayer) {
        if (valor.compareTo(BigDecimal.ZERO) > 0) {
            if (usuarioPayer.getCarteira().compareTo(valor) >= 0) {
                usuarioPayer.setCarteira(usuarioPayer.getCarteira().subtract(valor));
                return true;
            }
        }
        return false;
    }

    public boolean depositar(BigDecimal valor, Usuario usuarioPayee) {
        if (valor.compareTo(BigDecimal.ZERO) > 0) {
            usuarioPayee.setCarteira(usuarioPayee.getCarteira().add(valor));
            return true;
        }
        return false;
    }

}