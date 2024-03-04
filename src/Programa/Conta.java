package Programa;

import Utilitarios.Utils;

public class Conta {

    private static int contadorDeContas = 1;
private int numeroConta;
private Pessoa pessoa;

private double saldo = 0.0;

    public Conta (Pessoa pessoa) {
        this.numeroConta = contadorDeContas;
        this.pessoa = pessoa;
        this.saldo = saldo;
        contadorDeContas += 1;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "\nNúmero da conta: " + this.getNumeroConta() +
               "\nNome: " + this.pessoa.getNome()+
               "\nCPF: " + this.pessoa.getCpf()+
               "\nEmail : " + this.pessoa.getEmail()+
               "\nSaldo : " + Utils.doubleToString(this.getSaldo()) +
                "\n";
    }

    public void depositar(double valor){
        if(valor > 0){
            setSaldo(getSaldo() + valor);
            System.out.println("valor depositado com sucesso!");
        }else{
            System.out.println("não é possível depositar em conta negativada!");
        }
    }
    public void sacar(double valor){
        if (valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor );
            System.out.println("Saque realizado com sucesso!");
        }else{
            System.out.println("não é possível realizar o saque!");
        }
    }

    public void transferir(Conta contaParaDeposito,double valor){
        if (valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor );
            contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
            System.out.println("tranferência realizada com sucesso!");
        }else{
            System.out.println("não é possível realizar a transferência!");
        }
    }
}
