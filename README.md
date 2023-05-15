## Aplicativo Banco

Este é um aplicativo simples em Java, desenvolvido como o desafio final do curso de Java do Santander Boot Camp Fullstack Developer.

O aplicativo foi desenvolvido como forma de estudo de estruturas básicas de Java (e outras linguagens OO) como classes, encapsulamento, herança, polimorfismo, sobrecarga, interfaces, array, arrayList, enhanced for loop.

## Funcionalidades, métodos e outros detalhes do projeto

​	O aplicativo cria contas de banco (conta corrente e poupança, via herança) e usa métodos para fazer saques, depósitos e transferências nas duas contas. Esta parte foi desenvolvida através do acompanhamento das aulas. Foram criadas as classes App.java, Banco.java, Cliente.java, Conta.java (e suas filhas ContaCorrente.java e ContaPoupança.java) que implementa a interface IConta.java.

App.java contém o método main e chama os métodos para demonstrar as funcionalidades:

​		método sacar - retira o valor na instância Conta correta (Corrente ou poupança). Recebe como argumento o valor da operação.

​		método depositar - acrescenta o valor na instância Conta correta (Corrente ou poupança). Recebe como argumento o valor da operação.

​		método transferir - saca de uma conta e deposita na outra, através do reaproveitamento dos outros métodos acima.

A sugestão de extensão do projeto deixada na aula era para aprofundar a classe cliente e uma rotina para listar clientes. No entanto, avaliei que esta seria uma função totalmente dedicada ao backoffice de um banco, uma vez que nenhum cliente, na vida real, tem a capacidade (e nem deveria, por motivo de segurança) de listar clientes do banco. Assim, optei por criar um extrato simplificado, mostrando cada lançamento nas contas, a data, o valor e o saldo após cada lançamento.

Para realizar esta tarefas, usei uma estrutura de dados híbrida, onde um ArrayList guarda duplas de Arrays simples contendo cada lançamento (data e valor). Para a data, fiz a importação do pacote java.util.date. Criei o método gravarLancamento que recebe o valor e o tipo de lançamento e gravam a informação no ArrayList.

Alterei os métodos de saque, depósito e transferência para que, ao invés de excutarem a operação de soma ou subtração imediatamente, apenas gravassem a operação no ArrayList (através de arrays simples contendo a data, o valor e o tipo de lançamento). Criei uma sobrecarga para os métodos de saque e de depósito, para que, ao receberem como argumento, além do valor, um tipo de lançamento (no caso, transferência), realizassem a gravação do lançamento com o tipo "Transferência".

Finalmente, criei um método novo, denominado imprimirExtrato, que calcula o extrato, lançamento a lançamento. Aqui, usei o método getName() (java.lang - não precisa de importação) para obter o nome da classe (ContaCorrente ou Poupança), de maneira que o polimorfismo tornasse possível usar o mesmo método para imprimir o extrato de qualquer conta, inclusive novas instâncias criadas posteriormente com o uso do aplicativo.

Como sugestão de aprimoramento do aplicativo, sugiro algumas modificações  possíveis:

- Substituir o "enhanced loop for"que usei no método ImprimirExtrato() por um Case. Tornaria o aplicativo mais flexível para a incorporação de novos tipos de lançamento (i.e. taxas, juros, TED, Pix, etc)
- Criar um menu com operações a serem escolhidas. Por exemplo, 1. Saque, 2. Depósito, 3. Transferência, 4. Imprimir Extrato. Assim o aplicativo ficaria mais funcional, realizando as operações que o usuário deseja e não somente as operações que estão "hard coded" em App.java.
- Poderíamos ainda criar um banco de dados simples (usando excel por exemplo, para guardar um arquivo csv) e fazer o aplicativo ler o arquivo e trazer lançamentos realizados anteriormente e gravar novos. Assim ficaríamos ainda mais perto de um aplicativo com um funcionamento minimamente parecido com um aplicativo de banco real.
