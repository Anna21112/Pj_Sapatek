
package br.com.sistema.models;

import br.com.sistema.controller.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Produtos {
    private int id_produtos;
    private String nome;
    private String categoria;
    private int quantidade;
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
    String sqlLinhas = "INSERT INTO produto (nome, categoria, qnt, descricao, modelo, marca, tamanho, estilo, tipo, cor, id_fornecedor) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
    try (Connection conn = Conexao.conectar();
         PreparedStatement psmt = conn.prepareStatement(sqlLinhas)) {
        
        psmt.setString(1, nome);
        psmt.setString(2, categoria);
        psmt.setInt(3, quantidade);
        psmt.setString(4, descricao);
        psmt.setString(5, modelo);
        psmt.setString(6, marca);
        psmt.setInt(7, tamanho);
        psmt.setString(8, estilo);
        psmt.setString(9, tipo);
        psmt.setString(10, cor);
        psmt.setInt(11, id_fornecedor);
        
        // Executa o comando de inserção
        int rowsAffected = psmt.executeUpdate();
        
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Produto inserido com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Falha ao inserir produto.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao inserir produto.", "Erro", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
}

     public void selectProduto(int id_produto) {
        String sqlSelect = "SELECT * FROM Produto WHERE id_produto = ?";
        
        try (Connection conn = Conexao.conectar();
             PreparedStatement psmt = conn.prepareStatement(sqlSelect)) {
            
            psmt.setInt(1, id_produto);

            try (ResultSet rs = psmt.executeQuery()) {
                if (rs.next()) {
                    // Recuperar os dados do produto
                    String nome = rs.getString("nome");
                    String categoria = rs.getString("categoria");
                    int quantidade = rs.getInt("qnt");
                    String descricao = rs.getString("descricao");
                    String modelo = rs.getString("modelo");
                    String marca = rs.getString("marca");
                    int tamanho = rs.getInt("tamanho");
                    String estilo = rs.getString("estilo");
                    String tipo = rs.getString("tipo");
                    String cor = rs.getString("cor");
                    int id_fornecedor = rs.getInt("id_fornecedor");
                    
                    // Construir a mensagem com todos os dados
                    StringBuilder mensagem = new StringBuilder();
                    mensagem.append("Nome: ").append(nome).append("\n");
                    mensagem.append("Categoria: ").append(categoria).append("\n");
                    mensagem.append("Quantidade: ").append(quantidade).append("\n");
                    mensagem.append("Descrição: ").append(descricao).append("\n");
                    mensagem.append("Modelo: ").append(modelo).append("\n");
                    mensagem.append("Marca: ").append(marca).append("\n");
                    mensagem.append("Tamanho: ").append(tamanho).append("\n");
                    mensagem.append("Estilo: ").append(estilo).append("\n");
                    mensagem.append("Tipo: ").append(tipo).append("\n");
                    mensagem.append("Cor: ").append(cor).append("\n");
                    mensagem.append("ID Fornecedor: ").append(id_fornecedor);

                    // Exibir a mensagem com todos os dados
                    JOptionPane.showMessageDialog(null, mensagem.toString(), "Informações do Produto", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Produto não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar produto.", "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
     
         public void deleteProduto(int id_produto) {
    String sqlDelete = "DELETE FROM Produto WHERE id_produto = ?";
    
    try (Connection conn = Conexao.conectar();
         PreparedStatement psmt = conn.prepareStatement(sqlDelete)) {
        
        psmt.setInt(1, id_produto);
        
        // Executa o comando de deleção
        int rowsAffected = psmt.executeUpdate();
        
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Produto deletado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Produto não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao deletar o produto.", "Erro", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
}

         
         public void updateProduto(int id_produto) {
        String sqlUpdate = "UPDATE produto SET nome = ?, categoria = ?, qnt = ?, descricao = ?, modelo = ?, marca = ?, tamanho = ?, estilo = ?, tipo = ?, cor = ?, id_fornecedor = ? WHERE id_produto = ?";
        
        try (Connection conn = Conexao.conectar();
             PreparedStatement psmt = conn.prepareStatement(sqlUpdate)) {
            
            psmt.setString(1, nome);
            psmt.setString(2, categoria);
            psmt.setInt(3, quantidade);
            psmt.setString(4, descricao);
            psmt.setString(5, modelo);
            psmt.setString(6, marca);
            psmt.setInt(7, tamanho);
            psmt.setString(8, estilo);
            psmt.setString(9, tipo);
            psmt.setString(10, cor);
            psmt.setInt(11, id_fornecedor);
            psmt.setInt(12, id_produto);
            
            // Executa o comando de atualização
            int rowsAffected = psmt.executeUpdate();
            
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Produto não encontrado para atualizar.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar produto.", "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
