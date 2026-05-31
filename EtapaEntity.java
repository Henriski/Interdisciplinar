package entities;

public class EtapaEntity {
    private int id;
    private String descricao;
    private int ordem;
    private StatusEntity status;
    private TratamentoEntity tratamento;

    public EtapaEntity() {
        descricao = new String();
        ordem = 0;
        status = new StatusEntity();
        tratamento = null;
    }

    public EtapaEntity(int id, String descricao, int ordem, StatusEntity status, TratamentoEntity tratamento) {
        this.id = id;
        this.descricao = descricao;
        this.ordem = ordem;
        this.status = status;
        this.tratamento = tratamento;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public int getOrdem() { return ordem; }
    public void setOrdem(int ordem) { this.ordem = ordem; }

    public StatusEntity getStatus() { return status; }
    public void setStatus(StatusEntity status) { this.status = status; }

    public TratamentoEntity getTratamento() { return tratamento; }
    public void setTratamento(TratamentoEntity tratamento) { this.tratamento = tratamento; }
}
