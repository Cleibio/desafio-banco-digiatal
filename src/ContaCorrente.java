public class ContaCorrente extends Conta {
    public ContaCorrente(Cliente cliente,Banco meuBanco) {
        super(cliente,meuBanco);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("      Extrato Conta Corrente\n---------------------------------");
        super.infosaldo();
        System.out.println("---------------------------------");
    }
}
