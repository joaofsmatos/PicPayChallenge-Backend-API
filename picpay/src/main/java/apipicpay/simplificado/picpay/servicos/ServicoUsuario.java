package apipicpay.simplificado.picpay.servicos;

import apipicpay.simplificado.picpay.dominios.usuarios.Usuario;
import apipicpay.simplificado.picpay.dominios.usuarios.UsuarioRecord;
import apipicpay.simplificado.picpay.repositorios.RepositorioUsuario;
import lombok.NonNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ServicoUsuario {

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    public Usuario criarUsuario(UsuarioRecord usuarioRecord) {
        Usuario novoUsuario = new Usuario(usuarioRecord);
        if(!pesquisarUsuario(novoUsuario.getCpf())) {
            // String senhaHash = ServicoSenha.encoder(novoUsuario.getSenha());
            // novoUsuario.setSenha(senhaHash);
            return this.repositorioUsuario.save(novoUsuario);
        } else {
            throw new RuntimeException("");
        }
    }

    public List<Usuario> listarUsuarios() {
        return this.repositorioUsuario.findAll();
    }

    public boolean pesquisarUsuario(@NonNull String cpf) {
        Optional<Usuario> usuarioOptional = this.repositorioUsuario.findById(cpf);
        return usuarioOptional.isPresent();
    }

    public Usuario detalharUsuario(@NonNull String cpf) {
        Optional<Usuario> usuarioOptional = this.repositorioUsuario.findById(cpf);
        if (usuarioOptional.isPresent()) {
            Usuario usuarioEncontrado = usuarioOptional.get();
            return usuarioEncontrado;
        } else {
            throw new RuntimeException("");
        }
    }

}