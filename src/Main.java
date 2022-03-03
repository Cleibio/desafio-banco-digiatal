import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Banco b = new Banco("BB");
        //********************************************************************
        Cliente cliente = new Cliente("Fernanda");
        Cliente cliente1 = new Cliente("Mariana");
        //********************************************************************
        Conta minhaContaCC = new ContaCorrente(cliente,b);
        Conta contaDestino = new ContaPoupanca(cliente1,b);
        //********************************************************************
        List<Conta> lisBanco = new ArrayList<>();
        lisBanco.add(minhaContaCC);
        lisBanco.add(contaDestino);
        b.setContas(lisBanco);
        b.exibirClienteBanco();
        b.exibirContas();
        //********************************************************************
        minhaContaCC.imprimirExtrato();
        minhaContaCC.depositar(200);
        minhaContaCC.saldoFormatado();
        minhaContaCC.depositar(300);
        minhaContaCC.saldoFormatado();
        minhaContaCC.transferir(20,contaDestino);
        minhaContaCC.saldoFormatado();
        minhaContaCC.sacar(100);
        minhaContaCC.saldoFormatado();
        minhaContaCC.imprimirExtrato();
        //********************************************************************
        contaDestino.imprimirExtrato();
        contaDestino.depositar(500);
        contaDestino.saldoFormatado();
        contaDestino.depositar(750);
        contaDestino.saldoFormatado();
        contaDestino.transferir(3,minhaContaCC);
        contaDestino.sacar(370);
        //********************************************************************
        contaDestino.imprimirExtrato();
        minhaContaCC.imprimirExtrato();
    }
}
