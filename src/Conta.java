import java.util.ArrayList;
import java.util.Date;


public abstract class Conta implements IConta {
    //abstrata pois nao quero que ninguem a instancie
    //não faz sentido que alguem crie uma nova Conta
    //apenas uma nova conta corrente ou conta poupança
    //Portanto, quem vai poder instanciar uma nova conta, serão apenas os filhos de Conta
    
    private static final int AGENCIA_PADRAO = 0001;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldoInicial = 0;
    protected double saldoFinal;

    protected ArrayList<String[]> lancamentos = new ArrayList<>();
    
    private Date dataAtual = new Date();

    public Conta() {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldoInicial() {
        return saldoInicial;
    }

    public double getSaldoFinal() {
        return saldoFinal;
    }
    
    @Override
    public void sacar(double valor) {
        //saldoFinal = saldoInicial - valor;
        gravarLancamento("Saque", -valor);
    }

    
    public void sacar(String tipoLancamento, double valor) {
        //saldoFinal = saldoInicial - valor;
        //saldoInicial = saldoFinal;
        gravarLancamento(tipoLancamento, -valor);
    }

    @Override
    public void depositar(double valor) {
        //saldoFinal = saldoInicial + valor;
        //saldoInicial = saldoFinal;
        gravarLancamento("Depósito", valor);
    }

    public void depositar(String tipoLancamento, double valor) {
        //saldoFinal = saldoInicial + valor;
        gravarLancamento(tipoLancamento, valor);
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar("Transferência", valor);
        contaDestino.depositar("Transferência", valor);
    }

    public void gravarLancamento(String tipoLancamento, Double valor){
        String[] lancamento = {tipoLancamento, String.valueOf(dataAtual), String.valueOf(valor)};
        lancamentos.add(lancamento);
    }

    public void imprimirExtrato(){
        System.out.println("=== "+ this.getClass().getName() + " ===");
        System.out.println("Agência: " + this.getAgencia());
        System.out.println("Conta: " + this.getNumero() + "\n");
        System.out.println("Tipo Lançamento               Data                 Valor        Saldo");
        System.out.println("saldoInicial: "+ saldoInicial);

        for(String[] lancamento:lancamentos){
            if(lancamento[0] == "Transferência"){
                System.out.print(lancamento[0] + "     ");
            } else if (lancamento[0] == "Saque"){
                System.out.print(lancamento[0] + "             ");
            } else {System.out.print(lancamento[0] + "          ");}
        
            System.out.print(lancamento[1] + "     ");
            System.out.print(lancamento[2] + "     ");
            saldoFinal = this.getSaldoInicial() + Double.parseDouble(lancamento[2]);
            System.out.println(saldoFinal);
            saldoInicial = saldoFinal;
        }
        System.out.println("saldoFinal: "+ saldoFinal + "\n\n");
    }
}
