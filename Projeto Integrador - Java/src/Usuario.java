import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Usuario {
    private String id = "";
    private String nome = "";
    private String telefone = "";
    private String email = "";
    private Date dataCadastro;

    public Usuario(String nome, String telefone, String email){

        //#

        this.id = ""+gerarId();
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.dataCadastro = Calendar.getInstance().getTime();
    }

    public String getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataCadastro() {
        return this.dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    private int gerarId(){
        Random numeroAleatorio = new Random();
        return numeroAleatorio.nextInt(2000);
    }

}
