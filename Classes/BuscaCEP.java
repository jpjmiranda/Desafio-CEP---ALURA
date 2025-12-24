package Classes;
import com.google.gson.annotations.SerializedName;
public class BuscaCEP {
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
    private String estado;

    
    public String getCep() {
        return cep;
    }
    
    public String getLogradouro() {
        return logradouro;
    }
    
    public String getBairro() {
        return bairro;
    }
    
    public String getLocalidade() {
        return localidade;
    }
    
    
    public String getUf() {
        return uf;
    }
    
    public String getEstado() {
        return estado;
    }
     public void setCep(String cep) {
        this.cep = cep;
    }
     public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
     public void setBairro(String bairro) {
        this.bairro = bairro;
    }
     public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }
     public void setUf(String uf) {
        this.uf = uf;
    }
     public void setEstado (String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "(CEP = " + cep +
                ", Logradouro = " + logradouro + "," +
                " Bairro = " + bairro + " Localidade = " + localidade +
                ", UF = " + uf + "," +
                " Estado = " + estado + ") ";
    }
}
