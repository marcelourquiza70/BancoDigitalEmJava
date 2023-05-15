
public interface IConta {

    void sacar(double valor); //metodos da interface nao tem corpo. 
    //portanto, usamos apenas o ponto e virgula e nao as {}
    //sera implementada no metodo que a implementar
    //tbm nao precisa da visibilidade pois todo metodo de interface é obrigatoriamente publico

    void depositar(double valor);

    void transferir(double valor, Conta contaDeposito);

}