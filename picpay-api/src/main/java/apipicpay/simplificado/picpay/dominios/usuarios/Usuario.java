package apipicpay.simplificado.picpay.dominios.usuarios;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "usuarios")
@Table(name = "usuarios")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "cpf")
public class Usuario {

    @Id
    @Column(unique = true)
    private String cpf;
    private String nome;
    @Column(unique = true)
    private String email;
    private String senha;
    private TipoUsuario tipoUsuario;
    private BigDecimal carteira;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public BigDecimal getCarteira() {
        return carteira;
    }

    public void setCarteira(BigDecimal carteira) {
        this.carteira = carteira;
    }

    public Usuario(UsuarioRecord usuarioRecord) {
        this.cpf = usuarioRecord.cpf();
        this.nome = usuarioRecord.nome();
        this.email = usuarioRecord.email();
        this.senha = usuarioRecord.senha();
        this.tipoUsuario = usuarioRecord.tipoUsuario();
        this.carteira = usuarioRecord.carteira();
    }

}