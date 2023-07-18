import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;

public class Funcionario {
    BigDecimal salario;
    String funcao;

    public Funcionario(BigDecimal salario, String funcao) {
        this.salario = salario;
        this.funcao = funcao;
    }

    public Funcionario() {
    }

    public String getSalario() {
        NumberFormat z = NumberFormat.getCurrencyInstance();
        return z.format(salario);
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }


    @Override
    public String toString() {

        return "salario=" + getSalario() +
                ", funcao='" + funcao + '\'' +
                '}';
    }


}
