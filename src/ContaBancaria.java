
import java.util.InputMismatchException;

public class ContaBancaria {

// Define os atributos privados
    private double saldo;
    private String nome;
    private String senha;
    private int numConta;
    private String CPF;

    public String getSenha() {
        return senha;
    }
    
// Define o construtor da conta
    public ContaBancaria(String nome, String senha, String CPF, double saldo, int numConta) {
        // TRATA AS INFORMAÇÕES ENVIADAS PELO CONSTRUTOR
        if(saldo<0){
            throw new ArithmeticException("Valor não pode ser negativo!");
        }
        if(CPF.length()!=14) {
            throw new ArithmeticException("O CPF deve conter 11 digitos");
        }
        if(senha.length()!= 6){
            throw new ArithmeticException("A senha deve conter 6 dígitos!");
        }
        if("".equals(nome)) {
            throw new InputMismatchException("Insira o seu nome!");
        }
        this.saldo = saldo;
        this.senha = senha;
        this.nome = nome;
        this.CPF = CPF;
        this.numConta = numConta;
       // this.numConta = numConta;
    }
    
    // Métodos getters

    public double getSaldo() {
        return saldo;
    }

    public String getNome() {
        return nome;
    }

    public int getNumConta() {
        return numConta;
    }

    public String getCPF() {
        return CPF;
    }

// Métodos Setters
    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

// Métodos de Classe
    
    // Checa o valor para adicionar a um saldo de conta
    public void adicionaSaldo(double valor) {
        if(valor > 0){ // Verifica se o valor a ser adicionado não é negativo
        saldo += valor;
        } else {
            throw new ArithmeticException("O valor não pode ser negativo");     
        }
    }
 // Realiza a autenticação do usuário sem que ele acesse diretamente a senha, retorna booleano
    public boolean autenticaSenha(String senha) {
        return this.senha.equals(senha);
    }
    
    public boolean autenticaUsuario(String CPF, String senha) {
        if(this.senha.equals(senha) && this.CPF.equals(CPF)) {
            return true;
        } else {
            return false;
        }
    }
    
// Realiza a definição de senha desde que tenha 6 digitos 
    public void setSenha(String senha) {
        if(senha.length() == 6){
            this.senha = senha;
        } else {
            throw new NumberFormatException("A senha deve conter 6 digitos");
        }
    }
    
// Realiza a remoção de saldo da conta
    public void removerSaldo(double valor){
        if(valor < 1) {
            throw new ArithmeticException("Valor inválido");
        } 
        if(valor > saldo) {
            throw new ArithmeticException("Saldo insuficiente!");
        }
        else{
            saldo-=valor;
        }
    }
}
