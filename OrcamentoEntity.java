package entities;

import java.time.LocalDate;

public class OrcamentoEntity {
    private int id;
    private double valorTotal;
    private LocalDate dataCriacao;
    private StatusEntity status;
    private ConsultaEntity consulta;
    private TratamentoEntity tratamento;

    public OrcamentoEntity() {
        valorTotal = 0.0;
        dataCriacao = null;
        status = new StatusEntity();
        consulta = null;
        tratamento = null;
    }

    public OrcamentoEntity(int id, double valorTotal, LocalDate dataCriacao, StatusEntity status,
            ConsultaEntity consulta, TratamentoEntity tratamento) {
        this.id = id;
        this.valorTotal = valorTotal;
        this.dataCriacao = dataCriacao;
        this.status = status;
        this.consulta = consulta;
        this.tratamento = tratamento;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public double getValorTotal() { return valorTotal; }
    public void setValorTotal(double valorTotal) { this.valorTotal = valorTotal; }

    public LocalDate getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(LocalDate dataCriacao) { this.dataCriacao = dataCriacao; }

    public StatusEntity getStatus() { return status; }
    public void setStatus(StatusEntity status) { this.status = status; }

    public ConsultaEntity getConsulta() { return consulta; }
    public void setConsulta(ConsultaEntity consulta) { this.consulta = consulta; }

    public TratamentoEntity getTratamento() { return tratamento; }
    public void setTratamento(TratamentoEntity tratamento) { this.tratamento = tratamento; }
}
