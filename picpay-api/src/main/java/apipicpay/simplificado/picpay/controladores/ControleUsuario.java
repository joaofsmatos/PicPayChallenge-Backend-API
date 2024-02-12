package apipicpay.simplificado.picpay.controladores;

import apipicpay.simplificado.picpay.dominios.usuarios.Usuario;
import apipicpay.simplificado.picpay.dominios.usuarios.UsuarioRecord;
import apipicpay.simplificado.picpay.servicos.ServicoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")

public class ControleUsuario {

    @Autowired
    private ServicoUsuario servicoUsuario;

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        var usuarios = this.servicoUsuario.listarUsuarios();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody UsuarioRecord usuarioRecord) {
        Usuario novoUsuario = servicoUsuario.criarUsuario(usuarioRecord);
        return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
    }

}
