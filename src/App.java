public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("\nHello, Cliente\n");

        ContaCorrente cc = new ContaCorrente();
        cc.saldoInicial = 1000;

        ContaPoupança poupanca = new ContaPoupança();
        poupanca.saldoInicial = 0;

        System.out.println("Saldo: " + cc.getSaldoInicial() + "\n");

        cc.transferir(100, poupanca);
        cc.depositar(100);
        cc.depositar(150);
        cc.depositar(90);
        cc.depositar(25.5);
        cc.depositar(42.30);
        cc.depositar(12.87);

        cc.imprimirExtrato();

        poupanca.imprimirExtrato();

    }
}