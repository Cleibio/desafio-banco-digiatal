public class ContaPoupanca extends Conta{
    public ContaPoupanca(Cliente cliente,Banco meuBanco) {
        super(cliente,meuBanco);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("     Extrato Conta Poupança\n---------------------------------");
        super.infosaldo();
        System.out.println("---------------------------------");
    }
}
