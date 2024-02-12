package apipicpay.simplificado.picpay.dominios.usuarios;

public enum TipoUsuario {
    ADM("adm"),
    LOJISTA("logista"),
    COMUM("comum");

    private String role;

    TipoUsuario(String role) {
        this.role = role;
    }

    public String getRole() {
        return this.role;
    }

}
