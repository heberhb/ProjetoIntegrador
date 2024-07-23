package Classes;

import java.util.ArrayList;

public class Listas {
    private static final ArrayList<Vendas>ListaVendas = new ArrayList<>();
    private static final ArrayList<Clientes>ListaClientes = new ArrayList<>();
    private static final ArrayList<Produtos>ListaProdutos = new ArrayList<>();
    private static final ArrayList<Fornecedores>ListaFornecedores = new ArrayList<>();
    private static final ArrayList<Funcionarios>ListaFuncionarios = new ArrayList<>();
    private static final ArrayList<Vendas>ListaMaisVendidos = new ArrayList<>();
    
    
    public boolean AdicionarVenda(Vendas vendas){
        vendas.setId(ListaVendas.size() +1);
        ListaVendas.add(vendas);
        return true;
    }
           
    public static boolean adicionarCliente(Clientes cliente){
        cliente.setIdCliente(ListaClientes.size() +1);
        ListaClientes.add(cliente);
        return true;
    }

    public static boolean AdicionarProduto(Produtos produtos){
        produtos.setId(ListaProdutos.size() +1);
        ListaProdutos.add(produtos);
        return true;
    }
    
    public static boolean AdicionarFuncionario(Funcionarios funcionarios){
        funcionarios.setIdFuncionario(ListaFuncionarios.size() +1);
        ListaFuncionarios.add(funcionarios);
        return true;
    
    }
    
    public static boolean AdicionarFornecedor(Fornecedores fornecedor){
        fornecedor.setIdFornecedor(ListaFornecedores.size() +1);
        ListaFornecedores.add(fornecedor);
        return true;
    }
    
    public ArrayList<Vendas>ListaVendas(){
        return ListaVendas;
    }
    
    public static ArrayList<Clientes>ListaClientes(){
        return ListaClientes;
    }
    
    public static ArrayList<Funcionarios>ListaFuncionarios(){
        return ListaFuncionarios; 
    }
    
    public static ArrayList<Produtos>ListaProdutos(){
        return ListaProdutos;
    }
    
    public static ArrayList<Fornecedores>ListaFornecedores(){
        return ListaFornecedores;
    }
    
    public static ArrayList<Vendas>MaisVendidos(){
        return ListaMaisVendidos;
    }
    
}
