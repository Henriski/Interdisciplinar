package entities;

public class PessoaEntity {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private String cpf;
    private String rg;

    public PessoaEntity() {
        id = 0;
        nome = new String();
        email = new String();
        senha = new String();
        telefone = new String();
        cpf = new String();
        rg = new String();
    }

    public PessoaEntity(int id, String nome, String email, String senha, String telefone, String cpf, String rg) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.cpf = cpf;
        this.rg = rg;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getRg() { return rg; }
    public void setRg(String rg) { this.rg = rg; }
}
