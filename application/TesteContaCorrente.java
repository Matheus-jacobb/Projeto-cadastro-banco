package application;

import java.util.ArrayList;
import java.util.Scanner;

import entities.ContaCorrente;

public class TesteContaCorrente {
    
    public static void main(String[] args) {
        
        ArrayList<ContaCorrente> contas = new ArrayList <ContaCorrente>();
        Scanner sc = new Scanner(System.in);
        int aux = 0;
        int op = 0;
        double limite_aux;

        do{
        System.out.println("------MENU------\n[1]-Cadastro\n[2]-Deposito\n[3]-Saque\n[4]-Ver saldo\n[5]-Somatorio Especial\n[6]-Sair");
        System.out.print("->");
        op = Integer.parseInt(sc.nextLine());

        switch (op) {
            case 1:
                System.out.print("\nNome do cliente: ");
                String name = sc.nextLine();
                ContaCorrente n = new ContaCorrente(name,1+aux);
                System.out.print("Valor do especial (+): ");  //Limite do especial
                do{
                    limite_aux = Double.parseDouble(sc.nextLine());
                }while(limite_aux < 0);
                n.setLimiteEspecial(limite_aux);
                contas.add(n);
                System.out.println("**Conta criada com sucesso!**");
                System.out.println(n);
                System.out.print("\n---Aperte Enter to continue---");
                sc.nextLine();
                aux++;
                break;

            case 2:
            case 3:
                if(op==2)
                System.out.print("-----Deposito-----\nNumero da conta: ");
                else
                System.out.print("-----Saque-----\nNumero da conta: ");

                int numero_aux = Integer.parseInt(sc.nextLine());
                numero_aux--;
                    if(numero_aux + 1 > contas.size()){
                        System.out.println("Erro! Cliente nao encontrado.");
                    }
                    else if(contas.get(numero_aux).getNumeroConta() ==  numero_aux + 1){
                        if(op == 2){
                        System.out.print("Valor de deposito(R$) : ");
                        int valorDeposito = Integer.parseInt(sc.nextLine());
                        contas.get(numero_aux).depositar(valorDeposito);
                        System.out.println(contas.get(numero_aux));
                        }
                        else{
                            System.out.print("Valor de saque(R$) : ");
                            int valorSaque = Integer.parseInt(sc.nextLine());
                            contas.get(numero_aux).saque(valorSaque);
                            System.out.println(contas.get(numero_aux));
                        }
                    }
                System.out.print("\n---Aperte Enter to continue---");
                sc.nextLine();
            break;

            case 4:
            System.out.print("Numero da conta: ");
            int numero = Integer.parseInt(sc.nextLine());
            numero--;
                if(numero + 1 > contas.size())
                    System.out.println("Erro! Cliente nao encontrado.");
                else if(contas.get(numero).getNumeroConta() ==  numero + 1)
                    System.out.println(contas.get(numero));
            break;

            case 5:
                    double sum=0;
                    for(int i=0; i<contas.size(); i++)
                    {
                        if(contas.get(i).getSaldo() >=0 )
                            sum += contas.get(i).getSaldo();
                    }
                    System.out.printf("Soma = %.2f%n", sum);
                    
            break;
        }
    }while(op != 6);
    sc.close();
    }
}
