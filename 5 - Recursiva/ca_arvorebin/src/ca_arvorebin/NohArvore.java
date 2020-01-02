package ca_arvorebin;

public class NohArvore {

    private NohArvore nohEsquerdo, nohDireito;
    private Integer dado;

    public NohArvore(Integer dadoNoh) {
        dado = dadoNoh;
        nohEsquerdo = nohDireito = null;
    }

    public NohArvore getNohEsquerdo() {
        return nohEsquerdo;
    }

    public void setNohEsquerdo(NohArvore nohEsquerdo) {
        this.nohEsquerdo = nohEsquerdo;
    }

    public NohArvore getNohDireito() {
        return nohDireito;
    }

    public void setNohDireito(NohArvore nohDireito) {
        this.nohDireito = nohDireito;
    }

    public Integer getDado() {
        return dado;
    }

    public void setDado(Integer dado) {
        this.dado = dado;
    }
    
    
}