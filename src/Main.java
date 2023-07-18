// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.HashMap;

import static java.util.Collections.min;

public class Main {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Map<Pessoa, List<Pessoa>> semelhancas = new HashMap<Pessoa, List<Pessoa>>();
        NumberFormat z = NumberFormat.getCurrencyInstance();

        Pessoa pessoa = new Pessoa();
        List<Pessoa> list = new ArrayList<>();
        list.add(new Pessoa("Maria" , LocalDate.parse("18/10/2000",formatter),new Funcionario(new BigDecimal(2009.44),"Operador")));
        list.add(new Pessoa("João" , LocalDate.parse("12/05/1990",formatter),new Funcionario(new BigDecimal(2284.38),"Operador")));
        list.add(new Pessoa("Caio" , LocalDate.parse("02/05/1961",formatter),new Funcionario(new BigDecimal(9836.14),"Coordenador")));
        list.add(new Pessoa("Miguel" , LocalDate.parse("14/10/1988",formatter),new Funcionario(new BigDecimal(19119.88),"Diretor")));
        list.add(new Pessoa("Alice" , LocalDate.parse("05/01/1995",formatter),new Funcionario(new BigDecimal(2234.68),"Recepcionista")));
        list.add(new Pessoa("Heitor" , LocalDate.parse("19/11/1999",formatter),new Funcionario(new BigDecimal(1582.72),"Operador")));
        list.add(new Pessoa("Arthur" , LocalDate.parse("31/03/1993",formatter),new Funcionario(new BigDecimal(4071.84),"Contador")));
        list.add(new Pessoa("Laura" , LocalDate.parse("08/07/1994",formatter),new Funcionario(new BigDecimal(3017.45),"Gerente")));
        list.add(new Pessoa("Heloisa" , LocalDate.parse("24/05/2003",formatter),new Funcionario(new BigDecimal(1606.85),"Eletricista")));
        list.add(new Pessoa("Helena" , LocalDate.parse("02/09/1996",formatter),new Funcionario(new BigDecimal(2799.93),"Gerente")));
        list.removeIf(x -> x.nome == "João" );  // Remover o funcionário “João” da lista.

        list.forEach( x -> System.out.println(x.formataTexto(x, false))); // funcionários com todas suas informações
        list.forEach( x -> x.aumentarSalario(x.funcionario.salario, 10.0)); //aumento de 10% no salario
        Map<String, List<Pessoa>> map = list.stream().collect(Collectors.groupingBy(p-> p.funcionario.funcao));
        System.out.println(map.toString()); // funcionarios agrupado
        list.stream().filter(x-> x.dtNascimento.getMonthValue() == 10 || x.dtNascimento.getMonthValue() == 12).forEach(x-> System.out.println(x.toString())); //  funcionários que fazem aniversário no mês 10 e 12.
        System.out.println(list.stream().min(Comparator.comparing(Pessoa::getDtNascimento)).get().toString()) ; /// funcionário com a maior idade
        Double soma = list.stream().mapToDouble(x->x.funcionario.salario.doubleValue()).sum();
        System.out.println("Total do Salário do Funcionario : " + z.format(soma)); //soma
        list.stream().sorted(Comparator.comparing(Pessoa::getNome)).forEach(x-> System.out.println(x.toString())); // ordem alfabetica
        list.forEach(x -> System.out.println(x.qtdSalario(x.funcionario.salario).toString()));
    }
}