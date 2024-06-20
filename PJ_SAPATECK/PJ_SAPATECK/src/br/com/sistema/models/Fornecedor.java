package br.com.sistema.models;

import br.com.sistema.controller.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Fornecedor {
    private int id_fornecedor;
    private String nome;
    private long CNPJ;
    private String email;
    private String WEBSITE;
    private int CEP;
    private String rua;
    private int numero_residencia;
    private String bairro;
    private String cidade;
    private String estado;
    private long telefone;


    public int getId_fornecedor() {
        return id_fornecedor;
    }

    public String getNome() {
        return nome;
    }

    public long getCNPJ() {
        return CNPJ;
    }

    public String getEmail() {
        return email;
    }

    public String getWEBSITE() {
        return WEBSITE;
    }

    public int getCEP() {
        return CEP;
    }

    public String getRua() {
        return rua;
    }

    public int getNumero_residencia() {
        return numero_residencia;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }
    
    public long getTelefone(){
        return telefone;
    }

    public void setId_fornecedor(int id_fornecedor) {
        this.id_fornecedor = id_fornecedor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCNPJ(long CNPJ) {
        this.CNPJ = CNPJ;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setWEBSITE(String WEBSITE) {
        this.WEBSITE = WEBSITE;
    }

    public void setCEP(int CEP) {
        this.CEP = CEP;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setNumero_residencia(int numero_residencia) {
        this.numero_residencia = numero_residencia;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public void setTelefone(long telefone){
        this.telefone = telefone;
    }
    
      public void insertFornecedor() {
        String sqlLinha = "INSERT INTO Fornecedor (nome, cnpj, cep, rua, cidade, bairro, estado, telefone, email, website, numero) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = Conexao.conectar()) {
            // Desativa o autocommit
            conn.setAutoCommit(false);

            try (PreparedStatement psmt = conn.prepareStatement(sqlLinha)) {
                // Definindo os parâmetros
                psmt.setString(1, getNome());
                psmt.setLong(2, getCNPJ());
                psmt.setInt(3, getCEP());
                psmt.setString(4, getRua());
                psmt.setString(5, getCidade());
                psmt.setString(6, getBairro());
                psmt.setString(7, getEstado());
                psmt.setLong(8, getTelefone());
                psmt.setString(9, getEmail());
                psmt.setString(10, getWEBSITE());
                psmt.setInt(11, getNumero_residencia());

                // Executa a instrução de inserção
                psmt.executeUpdate();

                // Confirma a transação
                conn.commit();
                System.out.println("Fornecedor adicionado com sucesso!");
            } catch (SQLException e) {
                // Desfaz a transação em caso de erro
                conn.rollback();
                JOptionPane.showMessageDialog(null, "Erro ao inserir o Fornecedor! Tente novamente, por favor.", "Erro", JOptionPane.ERROR_MESSAGE);
                
            } finally {
                // Restaura o autocommit para o valor padrão
                conn.setAutoCommit(true);
            }
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void selectFornecedor(int id_fornecedor) {
        String sqlSelect = "SELECT * FROM Fornecedor WHERE id_fornecedor = ?";
        
        try (Connection conn = Conexao.conectar();
             PreparedStatement psmt = conn.prepareStatement(sqlSelect)) {
            
            psmt.setInt(1, id_fornecedor);

            try (ResultSet rs = psmt.executeQuery()) {
                if (rs.next()) {
                    // Recuperar os dados do fornecedor
                    String nome = rs.getString("nome");
                    long cnpj = rs.getLong("cnpj");
                    int cep = rs.getInt("cep");
                    String rua = rs.getString("rua");
                    String cidade = rs.getString("cidade");
                    String bairro = rs.getString("bairro");
                    String estado = rs.getString("estado");
                    long telefone = rs.getLong("telefone");
                    String email = rs.getString("email");
                    String website = rs.getString("website");
                    int numero_residencia = rs.getInt("numero");
                    
                    // Construir a mensagem com todos os dados
                    StringBuilder mensagem = new StringBuilder();
                    mensagem.append("Nome: ").append(nome).append("\n");
                    mensagem.append("CNPJ: ").append(cnpj).append("\n");
                    mensagem.append("CEP: ").append(cep).append("\n");
                    mensagem.append("Rua: ").append(rua).append("\n");
                    mensagem.append("Cidade: ").append(cidade).append("\n");
                    mensagem.append("Bairro: ").append(bairro).append("\n");
                    mensagem.append("Estado: ").append(estado).append("\n");
                    mensagem.append("Telefone: ").append(telefone).append("\n");
                    mensagem.append("Email: ").append(email).append("\n");
                    mensagem.append("Website: ").append(website).append("\n");
                    mensagem.append("Número de Residência: ").append(numero_residencia);

                    // Exibir a mensagem com todos os dados
                    JOptionPane.showMessageDialog(null, mensagem.toString(), "Informações do Fornecedor", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Fornecedor não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar fornecedor.", "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
        public void deleteFornecedor(int id_fornecedor) {
        String sqlDelete = "DELETE FROM fornecedor WHERE id_fornecedor = ?";
        
        try (Connection conn = Conexao.conectar()) {
            // Desativa o autocommit
            conn.setAutoCommit(false);

            try (PreparedStatement psmt = conn.prepareStatement(sqlDelete)) {
                psmt.setInt(1, id_fornecedor);

                // Executa a instrução de delete
                int rowsAffected = psmt.executeUpdate();

                if (rowsAffected > 0) {
                    // Confirma a transação se a exclusão foi bem-sucedida
                    conn.commit();
                    JOptionPane.showMessageDialog(null, "Fornecedor deletado com sucesso!");
                } else {
                    // Não houve exclusão, desfaz a transação
                    conn.rollback();
                    JOptionPane.showMessageDialog(null, "Fornecedor não encontrado ou não pôde ser deletado.");
                }
            } catch (SQLException e) {
                // Desfaz a transação em caso de erro
                conn.rollback();
                JOptionPane.showMessageDialog(null, "Erro ao deletar o fornecedor. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            } finally {
                // Restaura o autocommit para o valor padrão
                conn.setAutoCommit(true);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
        
       public void updateFornecedor(int id_fornecedor) {
        String sqlUpdate = "UPDATE fornecedor SET nome = ?, cnpj = ?, cep = ?, rua = ?, cidade = ?, bairro = ?, estado = ?, telefone = ?, email = ?, website = ?, numero = ? WHERE id_fornecedor = ?";
        
        try (Connection conn = Conexao.conectar()) {
            // Desativa o autocommit para gerenciar a transação manualmente
            conn.setAutoCommit(false);

            try (PreparedStatement psmt = conn.prepareStatement(sqlUpdate)) {
                psmt.setString(1, nome);
                psmt.setLong(2, CNPJ);
                psmt.setInt(3, CEP);
                psmt.setString(4, rua);
                psmt.setString(5, cidade);
                psmt.setString(6, bairro);
                psmt.setString(7, estado);
                psmt.setLong(8, telefone);
                psmt.setString(9, email);
                psmt.setString(10, WEBSITE);
                psmt.setInt(11, numero_residencia);
                psmt.setInt(12, id_fornecedor);

                // Executa a atualização no banco de dados
                int rowsUpdated = psmt.executeUpdate();

                if (rowsUpdated > 0) {
                    // Confirma a transação se a atualização foi bem-sucedida
                    conn.commit();
                    JOptionPane.showMessageDialog(null, "Fornecedor atualizado com sucesso!");
                } else {
                    // Caso contrário, desfaz a transação
                    conn.rollback();
                    JOptionPane.showMessageDialog(null, "Fornecedor não encontrado ou não pôde ser atualizado.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                // Desfaz a transação em caso de erro
                conn.rollback();
                JOptionPane.showMessageDialog(null, "Erro ao atualizar o fornecedor. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            } finally {
                // Restaura o autocommit para o valor padrão
                conn.setAutoCommit(true);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

}


