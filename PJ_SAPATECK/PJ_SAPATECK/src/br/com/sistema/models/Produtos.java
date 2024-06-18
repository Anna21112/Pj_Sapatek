
package br.com.sistema.models;

import br.com.sistema.controller.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Produtos {
    private int id_produtos;
    private String nome;
    private String categoria;
    private int quantidade;
    private int preco;
    private String descricao;
    private String modelo;
    private String marca;
    private int tamanho;
    private String estilo;
    private String tipo;
    private String cor;
    private int id_fornecedor;
    
    public int getId_produtos() {
        return id_produtos;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public int getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public int getTamanho() {
        return tamanho;
    }

    public String getEstilo() {
        return estilo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getCor() {
        return cor;
    }

    public int getId_fornecedor() {
        return id_fornecedor;
    }

    public void setId_produtos(int id_produtos) {
        this.id_produtos = id_produtos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setId_fornecedor(int id_fornecedor) {
        this.id_fornecedor = id_fornecedor;
    }
    
     public void insertProduto() {
	String sqlLinhas = "INSERT INTO produto (nome, categoria, quantidade, preco, descricao, modelo, marca, tamanho, estilo, tipo, cor, id_fornecedor) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.conectar()){
             PreparedStatement preparedStatement = conn.prepareStatement(sqlLinhas);
            
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, categoria);
            preparedStatement.setInt(3, quantidade);
            preparedStatement.setInt(4, preco);
            preparedStatement.setString(5, descricao);
            preparedStatement.setString(6, modelo);
            preparedStatement.setString(7, marca);
            preparedStatement.setInt(8, tamanho);
            preparedStatement.setString(9, estilo);
            preparedStatement.setString(10, tipo);
            preparedStatement.setString(11, cor);
            preparedStatement.setInt(12, id_fornecedor);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro", "Deu erro ao inserir o Produto! Tente novamente, por favor", JOptionPane.ERROR_MESSAGE);
        }
    }
     public void selectProduto(int id_produto){
        String sqlSelect = "SELECT * FROM Produto WHERE id_produto = ?";
        
        try(Connection conn = Conexao.conectar()){
            PreparedStatement psmt = conn.prepareStatement(sqlSelect);
            
            psmt.setInt(1, id_produto);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro", "Não encontrado.",JOptionPane.ERROR_MESSAGE);
        }
    }
     
         public void deleteProduto(int id_produto){
        String sqlDelete = "DELETE FROM Produto WHERE id_produto = ?";
        
        try(Connection conn = Conexao.conectar()){
            PreparedStatement psmt = conn.prepareStatement(sqlDelete);
            
            psmt.setInt(1, id_produto);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro","Não foi possível deletar o produto.", JOptionPane.ERROR_MESSAGE);
        }
    }
         
        public void updateFornecedor(int id_produto){
        String sqlUpdate = "UPDATE produto SET nome = ?, categoria = ?, qnt = ?, descricao = ?, modelo = ?, marca = ?, tamanho = ?, estilo = ?, tipo = ?, cor = ?, id_fornecedor = ? WHERE id_produto = ?";
        
        try(Connection conn = Conexao.conectar()){
            PreparedStatement psmt = conn.prepareStatement(sqlUpdate);
            psmt.setString(1, nome);
            psmt.setString(2, categoria);
            psmt.setInt(3, quantidade);
            psmt.setInt(4, preco);
            psmt.setString(5, descricao);
            psmt.setString(6, modelo);
            psmt.setString(7, marca);
            psmt.setInt(8, tamanho);
            psmt.setString(9, estilo);
            psmt.setString(10, tipo);
            psmt.setString(11, cor);
            psmt.setInt(12, id_fornecedor);
            psmt.setInt(13, id_produto);
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro","Não foi possível atualizar o fornecedor.", JOptionPane.ERROR_MESSAGE);
        }
    }
}
