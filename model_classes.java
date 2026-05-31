// ============================================================
// PACOTE MODEL - SISTEMA DE CLÍNICA
// Todos os arquivos .java do pacote model
// ============================================================

// ─────────────────────────────────────────────
// FILE: model/Pessoa.java
// ─────────────────────────────────────────────
package model;

public abstract class Pessoa {
    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;

    public Pessoa() {}

    public Pessoa(int id, String nome, String cpf, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Pessoa{id=" + id + ", nome='" + nome + "', cpf='" + cpf + "'}";
    }
}


// ─────────────────────────────────────────────
// FILE: model/Paciente.java
// ─────────────────────────────────────────────
package model;

import java.time.LocalDate;

public class Paciente extends Pessoa {
    private String endereco;
    private LocalDate dataNascimento;

    public Paciente() { super(); }

    public Paciente(int id, String nome, String cpf, String telefone, String email,
                    String endereco, LocalDate dataNascimento) {
        super(id, nome, cpf, telefone, email);
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }

    /** Solicita agendamento de consulta */
    public void solicitarConsulta() {
        System.out.println("Paciente " + getNome() + " solicitou uma consulta.");
    }

    /** Atualiza dados cadastrais do paciente */
    public void atualizarDados(String novoEndereco, String novoTelefone, String novoEmail) {
        this.setEndereco(novoEndereco);
        this.setTelefone(novoTelefone);
        this.setEmail(novoEmail);
        System.out.println("Dados do paciente " + getNome() + " atualizados.");
    }

    @Override
    public String toString() {
        return "Paciente{id=" + getId() + ", nome='" + getNome() + "', cpf='" + getCpf() +
               "', dataNascimento=" + dataNascimento + "}";
    }
}


// ─────────────────────────────────────────────
// FILE: model/Secretaria.java
// ─────────────────────────────────────────────
package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Secretaria extends Pessoa {
    private String cargo;

    public Secretaria() { super(); }

    public Secretaria(int id, String nome, String cpf, String telefone, String email, String cargo) {
        super(id, nome, cpf, telefone, email);
        this.cargo = cargo;
    }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    /** Agenda uma consulta para um paciente */
    public Consulta agendarConsulta(Paciente paciente, Profissional profissional,
                                    LocalDate data, LocalTime horario) {
        Consulta c = new Consulta();
        c.setPaciente(paciente);
        c.setProfissional(profissional);
        c.setSecretaria(this);
        c.setData(data);
        c.setHorario(horario);
        c.setStatus("AGENDADA");
        System.out.println("Secretária " + getNome() + " agendou consulta para " + paciente.getNome());
        return c;
    }

    /** Registra/confirma uma consulta no sistema */
    public void registrarConsulta(Consulta consulta) {
        consulta.setStatus("CONFIRMADA");
        System.out.println("Consulta #" + consulta.getIdConsulta() + " registrada por " + getNome());
    }

    /** Gera orçamento associado a uma consulta */
    public Orcamento gerarOrcamento(Consulta consulta, double valorTotal) {
        Orcamento orc = new Orcamento();
        orc.setConsulta(consulta);
        orc.setValorTotal(valorTotal);
        orc.setDataCriacao(LocalDate.now());
        orc.setStatus("PENDENTE");
        System.out.println("Orçamento gerado pela secretária " + getNome() +
                           " no valor de R$ " + valorTotal);
        return orc;
    }

    @Override
    public String toString() {
        return "Secretaria{id=" + getId() + ", nome='" + getNome() + "', cargo='" + cargo + "'}";
    }
}


// ─────────────────────────────────────────────
// FILE: model/Profissional.java
// ─────────────────────────────────────────────
package model;

public class Profissional extends Pessoa {
    private String especialidade;
    private String registroProfissional;

    public Profissional() { super(); }

    public Profissional(int id, String nome, String cpf, String telefone, String email,
                        String especialidade, String registroProfissional) {
        super(id, nome, cpf, telefone, email);
        this.especialidade = especialidade;
        this.registroProfissional = registroProfissional;
    }

    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }

    public String getRegistroProfissional() { return registroProfissional; }
    public void setRegistroProfissional(String registroProfissional) {
        this.registroProfissional = registroProfissional;
    }

    /** Realiza e finaliza uma consulta */
    public void realizarConsulta(Consulta consulta, String observacao) {
        consulta.setStatus("REALIZADA");
        consulta.setObservacao(observacao);
        System.out.println("Profissional " + getNome() + " realizou consulta #" + consulta.getIdConsulta());
    }

    /** Define um tratamento para o paciente */
    public Tratamento definirTratamento(Paciente paciente, String descricao) {
        Tratamento t = new Tratamento();
        t.setPaciente(paciente);
        t.setProfissional(this);
        t.setDescricao(descricao);
        t.setStatus("EM_ANDAMENTO");
        System.out.println("Tratamento '" + descricao + "' definido por " + getNome());
        return t;
    }

    /** Atualiza progresso de um tratamento */
    public void atualizarProgresso(Tratamento tratamento, String novoStatus) {
        tratamento.setStatus(novoStatus);
        System.out.println("Progresso do tratamento #" + tratamento.getIdTratamento() +
                           " atualizado para: " + novoStatus);
    }

    @Override
    public String toString() {
        return "Profissional{id=" + getId() + ", nome='" + getNome() +
               "', especialidade='" + especialidade + "', registro='" + registroProfissional + "'}";
    }
}


// ─────────────────────────────────────────────
// FILE: model/Consulta.java
// ─────────────────────────────────────────────
package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Consulta {
    private int idConsulta;
    private LocalDate data;
    private LocalTime horario;
    private String status;
    private String observacao;
    private Paciente paciente;
    private Profissional profissional;
    private Secretaria secretaria;

    public Consulta() {}

    public Consulta(int idConsulta, LocalDate data, LocalTime horario, String status,
                    String observacao, Paciente paciente, Profissional profissional,
                    Secretaria secretaria) {
        this.idConsulta = idConsulta;
        this.data = data;
        this.horario = horario;
        this.status = status;
        this.observacao = observacao;
        this.paciente = paciente;
        this.profissional = profissional;
        this.secretaria = secretaria;
    }

    // Getters e Setters
    public int getIdConsulta() { return idConsulta; }
    public void setIdConsulta(int idConsulta) { this.idConsulta = idConsulta; }

    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }

    public LocalTime getHorario() { return horario; }
    public void setHorario(LocalTime horario) { this.horario = horario; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getObservacao() { return observacao; }
    public void setObservacao(String observacao) { this.observacao = observacao; }

    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }

    public Profissional getProfissional() { return profissional; }
    public void setProfissional(Profissional profissional) { this.profissional = profissional; }

    public Secretaria getSecretaria() { return secretaria; }
    public void setSecretaria(Secretaria secretaria) { this.secretaria = secretaria; }

    /** Agenda a consulta */
    public void agendar() {
        this.status = "AGENDADA";
        System.out.println("Consulta agendada para " + data + " às " + horario);
    }

    /** Marca consulta como realizada */
    public void realizar() {
        this.status = "REALIZADA";
        System.out.println("Consulta #" + idConsulta + " realizada.");
    }

    @Override
    public String toString() {
        return "Consulta{id=" + idConsulta + ", data=" + data + ", horario=" + horario +
               ", status='" + status + "', paciente='" +
               (paciente != null ? paciente.getNome() : "N/A") + "'}";
    }
}


// ─────────────────────────────────────────────
// FILE: model/Orcamento.java
// ─────────────────────────────────────────────
package model;

import java.time.LocalDate;

public class Orcamento {
    private int idOrcamento;
    private double valorTotal;
    private LocalDate dataCriacao;
    private String status;
    private Consulta consulta;
    private Tratamento tratamento;

    public Orcamento() {}

    public Orcamento(int idOrcamento, double valorTotal, LocalDate dataCriacao,
                     String status, Consulta consulta, Tratamento tratamento) {
        this.idOrcamento = idOrcamento;
        this.valorTotal = valorTotal;
        this.dataCriacao = dataCriacao;
        this.status = status;
        this.consulta = consulta;
        this.tratamento = tratamento;
    }

    // Getters e Setters
    public int getIdOrcamento() { return idOrcamento; }
    public void setIdOrcamento(int idOrcamento) { this.idOrcamento = idOrcamento; }

    public double getValorTotal() { return valorTotal; }
    public void setValorTotal(double valorTotal) { this.valorTotal = valorTotal; }

    public LocalDate getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(LocalDate dataCriacao) { this.dataCriacao = dataCriacao; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Consulta getConsulta() { return consulta; }
    public void setConsulta(Consulta consulta) { this.consulta = consulta; }

    public Tratamento getTratamento() { return tratamento; }
    public void setTratamento(Tratamento tratamento) { this.tratamento = tratamento; }

    /** Calcula valor total somando procedimentos */
    public double calcularValor(double... procedimentos) {
        double total = 0;
        for (double v : procedimentos) total += v;
        this.valorTotal = total;
        return total;
    }

    /** Aprova o orçamento */
    public void aprovar() {
        this.status = "APROVADO";
        System.out.println("Orçamento #" + idOrcamento + " aprovado. Valor: R$ " + valorTotal);
    }

    @Override
    public String toString() {
        return "Orcamento{id=" + idOrcamento + ", valor=R$" + valorTotal +
               ", status='" + status + "', data=" + dataCriacao + "}";
    }
}


// ─────────────────────────────────────────────
// FILE: model/Tratamento.java
// ─────────────────────────────────────────────
package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Tratamento {
    private int idTratamento;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String status;
    private Paciente paciente;
    private Profissional profissional;
    private List<Etapa> etapas = new ArrayList<>();

    public Tratamento() {}

    public Tratamento(int idTratamento, String descricao, LocalDate dataInicio,
                      LocalDate dataFim, String status, Paciente paciente,
                      Profissional profissional) {
        this.idTratamento = idTratamento;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.status = status;
        this.paciente = paciente;
        this.profissional = profissional;
    }

    // Getters e Setters
    public int getIdTratamento() { return idTratamento; }
    public void setIdTratamento(int idTratamento) { this.idTratamento = idTratamento; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public LocalDate getDataInicio() { return dataInicio; }
    public void setDataInicio(LocalDate dataInicio) { this.dataInicio = dataInicio; }

    public LocalDate getDataFim() { return dataFim; }
    public void setDataFim(LocalDate dataFim) { this.dataFim = dataFim; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }

    public Profissional getProfissional() { return profissional; }
    public void setProfissional(Profissional profissional) { this.profissional = profissional; }

    public List<Etapa> getEtapas() { return etapas; }
    public void setEtapas(List<Etapa> etapas) { this.etapas = etapas; }

    /** Define o plano de tratamento */
    public void definirTratamento(String descricao, LocalDate inicio) {
        this.descricao = descricao;
        this.dataInicio = inicio;
        this.status = "EM_ANDAMENTO";
    }

    /** Atualiza o status geral do progresso */
    public void atualizarProgresso(String novoStatus) {
        this.status = novoStatus;
        System.out.println("Tratamento #" + idTratamento + " atualizado para: " + novoStatus);
    }

    /** Adiciona uma etapa ao tratamento */
    public void adicionarEtapa(Etapa etapa) {
        etapa.setTratamento(this);
        this.etapas.add(etapa);
    }

    @Override
    public String toString() {
        return "Tratamento{id=" + idTratamento + ", descricao='" + descricao +
               "', status='" + status + "', etapas=" + etapas.size() + "}";
    }
}


// ─────────────────────────────────────────────
// FILE: model/Etapa.java
// ─────────────────────────────────────────────
package model;

public class Etapa {
    private int idEtapa;
    private String descricao;
    private int ordem;
    private String status;
    private Tratamento tratamento;

    public Etapa() {}

    public Etapa(int idEtapa, String descricao, int ordem, String status, Tratamento tratamento) {
        this.idEtapa = idEtapa;
        this.descricao = descricao;
        this.ordem = ordem;
        this.status = status;
        this.tratamento = tratamento;
    }

    // Getters e Setters
    public int getIdEtapa() { return idEtapa; }
    public void setIdEtapa(int idEtapa) { this.idEtapa = idEtapa; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public int getOrdem() { return ordem; }
    public void setOrdem(int ordem) { this.ordem = ordem; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Tratamento getTratamento() { return tratamento; }
    public void setTratamento(Tratamento tratamento) { this.tratamento = tratamento; }

    /** Conclui a etapa */
    public void concluirEtapa() {
        this.status = "CONCLUIDA";
        System.out.println("Etapa #" + idEtapa + " '" + descricao + "' concluída.");
    }

    @Override
    public String toString() {
        return "Etapa{id=" + idEtapa + ", ordem=" + ordem +
               ", descricao='" + descricao + "', status='" + status + "'}";
    }
}
