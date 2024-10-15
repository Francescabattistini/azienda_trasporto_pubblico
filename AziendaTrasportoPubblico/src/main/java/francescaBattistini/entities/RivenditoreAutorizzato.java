package francescaBattistini.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "rivenditori_autorizzati")
public class RivenditoreAutorizzato extends Rivenditore {

    private String nome;
    private String cognome;
    @Column(nullable = false, name = "partita_iva")
    private String partitaIva;
    @Column(name = "nome_negozio")
    private String nomeNegozio;

    public RivenditoreAutorizzato() {}

    public RivenditoreAutorizzato(long id, String localita, String nome, String cognome, String PIVA, String nomeNegozio) {
        super(id, localita);
        this.nome = nome;
        this.cognome = cognome;
        this.partitaIva = PIVA;
        this.nomeNegozio = nomeNegozio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getPartitaIva() {
        return partitaIva;
    }

    public void setPartitaIva(String partitaIva) {
        this.partitaIva = partitaIva;
    }

    public String getNomeNegozio() {
        return nomeNegozio;
    }

    public void setNomeNegozio(String nomeNegozio) {
        this.nomeNegozio = nomeNegozio;
    }

    @Override
    public String toString() {
        return super.toString() + "RivenditoreAutorizzato{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", partitaIva='" + partitaIva + '\'' +
                ", nomeNegozio='" + nomeNegozio + '\'' +
                '}';
    }
}
