import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Pessoa {
    String nome;
    LocalDate dtNascimento;
  Funcionario funcionario = new Funcionario();
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDtNascimento() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dateFormat = dtNascimento.format(dateTimeFormatter);
        return dateFormat;
    }

    public void setDtNascimento(LocalDate dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public Pessoa(String nome, LocalDate dtNascimento ,Funcionario funcionario) {
        this.nome = nome;
        this.dtNascimento = dtNascimento;
        this.funcionario = funcionario;
    }

    public Pessoa() {
    }

    public String ListarPessoa(List<Pessoa> pessoa){
      String pessoaDados = null;
        for (Pessoa x : pessoa){
            pessoaDados = formataTexto(x,false);
      }
       return pessoaDados;
    }

    public String formataTexto(Pessoa x , final Boolean aumento) {

        NumberFormat z = NumberFormat.getCurrencyInstance();
        BigDecimal salario = null;
        String pessoa ;
        if (aumento) {
            salario = aumentarSalario(x.funcionario.salario, 10.0) ;
        }else {
            salario = x.funcionario.salario;
        }
       pessoa =  x.nome + " " + getDtNascimento() +  " " +z.format(salario) + " " + x.funcionario.funcao;
       return pessoa;
    }


    public BigDecimal aumentarSalario (final BigDecimal salario , final Double percentual){
        double valorAumento  = salario.doubleValue() +((salario.doubleValue() * percentual)/100);
        return new BigDecimal(valorAumento);
    }
    public String qtdSalario (final BigDecimal salario){
        DecimalFormat df = new DecimalFormat("#,###.0");
        Double qntSalario ;
         qntSalario  = salario.doubleValue() /1212.00;
        return "nome='" + nome + '\'' +
                ", dtNascimento=" + getDtNascimento() +
                ", funcionario=" + funcionario +
                ", Qtd Salario=" + df.format(qntSalario) +
                '}';
    }
    @Override
    public String toString() {

        return "nome='" + nome + '\'' +
                ", dtNascimento=" + getDtNascimento() +
                ", funcionario=" + funcionario +
                '}';
    }

}

