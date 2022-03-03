public abstract class Conta implements IConta {
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    protected int agencia;
    protected int numero;
    protected double saldo;
    protected double valorMov;
    private Cliente cliente;
    private Conta dadosConta;
    private int tipoMov;
    protected Banco meuBanco;

    public Conta(Cliente cliente,Banco meuBanco){
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.meuBanco = meuBanco;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void saldoFormatado(){
        System.out.println(String.format("---------------------------------\nSaldo em conta: %.2f",this.getSaldo())+"\n---------------------------------");
    }

    public double getValorMov() {
        return valorMov;
    }

    public void setValorMov(double valorMov) {
        this.valorMov = valorMov;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Conta getDadosConta() {
        return dadosConta;
    }

    public void setDadosConta(Conta dadosConta) {
        this.dadosConta = dadosConta;
    }

    public int getTipoMov() {
        return tipoMov;
    }

    public void setTipoMov(int tipoMov) {
        this.tipoMov = tipoMov;
    }

    public Banco getMeuBanco() {
        return meuBanco;
    }

    public void setMeuBanco(Banco meuBanco) {
        this.meuBanco = meuBanco;
    }

    @Override
    public void sacar(double valor) {
        if (this.getSaldo() >= valor){
            this.saldo -= valor;
            this.valorMov = valor;
            this.tipoMov = 0;
            movimento();
        }else {
            System.out.println("Saldo insuficiente!");
        }
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if(this.getSaldo() >= valor) {
            if(this.numero != contaDestino.numero) {
                this.sacar(valor);
                contaDestino.depositar(valor);
                this.valorMov = valor;
                this.dadosConta = contaDestino;
                this.tipoMov = -1;
                movimento();
            }else {
                System.out.println("Transação inválida, não é permitido depositar na mesma conta!");
            }
        }else {
            System.out.println("Saldo insuficiente!");
        }
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
        this.valorMov = valor;
        this.tipoMov = 1;
        movimento();
    }

    protected void info(){
        System.out.println(String.format("Agência: %d",this.getAgencia())
                +String.format("\nTitular: %s",this.cliente.getNome())
                +String.format("\nConta: %d",this.getNumero()));
    }

    protected void infosaldo(){
        info();
        System.out.println(String.format("Saldo: %.2f",this.getSaldo()));
    }

    public void comprovanteTransferencia(){
        Conta conta = this.dadosConta;
        double valor = this.valorMov;
        System.out.println("---------------------------------\n  Comprovante de Transferência\n---------------------------------");
        info();
        System.out.println(String.format("Depósito: %.2f", valor)
                + String.format("\nFavorecido: %s", conta.getCliente().getNome()
                + String.format("\nAgência: %d", conta.getAgencia())
                + String.format("\nConta: %d", conta.getNumero())));
    }

    public void comprovanteDeposito(){
        double valor = this.valorMov;
        System.out.println("---------------------------------\n     Comprovante de Depósito\n---------------------------------");
        info();
        System.out.println(String.format("Depósito: %.2f", valor));
    }

    public void comprovanteSaque(){
        System.out.println("---------------------------------\n     Comprovante de saque\n---------------------------------");
        double valor = this.valorMov;
        info();
        System.out.println(String.format("saque: %.2f", valor));
    }

    public void movimento(){
        int operacao = this.tipoMov;
        if(operacao == 1){
            comprovanteDeposito();
        }else if(operacao == -1){
            comprovanteTransferencia();
        }else {
            comprovanteSaque();
        }
    }
}
