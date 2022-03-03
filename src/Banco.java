import java.util.ArrayList;
import java.util.List;

public class Banco {
    private static int SEQUENCIALBANCO = 1;
    private int codBanco;
    private String nomeBanco;
    private List<Conta> contas;

    public Banco(String nomeBanco) {
        this.codBanco = SEQUENCIALBANCO++;
        this.nomeBanco = nomeBanco;
    }

    public int getCodBanco() {
        return codBanco;
    }

    public void setCodBanco(int codBanco) {
        this.codBanco = codBanco;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public void exibirContas(){
        List<Conta> lista = new ArrayList<>();
        lista = this.contas;
        System.out.println("[**** INSTITUIÇÃO BANCÁRIA: "+this.codBanco+"  "+this.nomeBanco+" ****]");
        System.out.println("---------------------------------");
        System.out.println("        DADOS DA CONTA");
        System.out.println("---------------------------------");
        for (Conta listaContas:lista) {
            System.out.println(String.format("Conta: %d",listaContas.getNumero())
                    +String.format("\nAgência: %d",listaContas.getAgencia())
                    +String.format("\nTitular: %s",listaContas.getCliente().getNome()));
            System.out.println("---------------------------------");
        }
        System.out.println("Quant. Contas: "+lista.size());
        System.out.println("---------------------------------");
    }

    public void exibirClienteBanco(){
        List<Conta> lista = new ArrayList<>();
        lista = this.contas;
        System.out.println("[**** INSTITUIÇÃO BANCÁRIA: "+this.codBanco+"  "+this.nomeBanco+" ****]");
        System.out.println("---------------------------------");
        System.out.println("  LISTA DE CORRENTISTA");
        System.out.println("---------------------------------");

        for (Conta listaContas:lista) {
            System.out.println(String.format("Titular: %s",listaContas.getCliente().getNome()));
        }
        System.out.println("Quant. Contas: "+lista.size());
        System.out.println("---------------------------------");
    }
}
