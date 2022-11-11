package it.unibas.autostrada.modello;

public class Accesso {
    private String targa; //6 caratteri
    private String marcaAuto;
    private double costoPedaggio;
    private String tipoPagamento;

    public Accesso(String targa, String marcaAuto, double costoPedaggio, String tipoPagamento) {
        this.targa = targa;
        this.marcaAuto = marcaAuto;
        this.costoPedaggio = costoPedaggio;
        this.tipoPagamento = tipoPagamento;
    }
 
    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public String getMarcaAuto() {
        return marcaAuto;
    }

    public void setMarcaAuto(String marcaAuto) {
        this.marcaAuto = marcaAuto;
    }

    public double getCostoPedaggio() {
        return costoPedaggio;
    }

    public void setCostoPedaggio(double costoPedaggio) {
        this.costoPedaggio = costoPedaggio;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public void verificaCaratteriTarga(String targa) {
        String verifica = targa;
        if (verifica.chars().count() > 6 || verifica.chars().count() < 0) {
            throw new IllegalArgumentException("La targa inserita contiene: " + verifica.chars().count());
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Accesso{");
        sb.append("targa=").append(targa);
        sb.append(", marcaAuto=").append(marcaAuto);
        sb.append(", costoPedaggio=").append(costoPedaggio);
        sb.append(", tipoPagamento=").append(tipoPagamento);
        sb.append('}');
        return sb.toString();
    }
}
