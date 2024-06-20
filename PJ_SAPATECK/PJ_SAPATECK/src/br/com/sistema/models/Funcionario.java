
package br.com.sistema.models;

import br.com.sistema.controller.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Funcionario {
    private int id_funcionario;
    private String nome;
    private long telefone;
    private long CPF;
    private int CEP;
    private String email;
    private String sexo;
    private String rua;
    private int numero_residencia;
    private String bairro;
    private String cidade;
    private String estado;

    public int getId_funcionario() {
        return id_funcionario;
    }

    public String getNome() {
        return nome;
    }

    public long getTelefone() {
        return telefone;
    }

    public long getCPF() {
        return CPF;
    }

    public long getCEP() {
        return CEP;
    }

    public String getEmail() {
        return email;
    }

    public String getSexo() {
        return sexo;
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

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public void setCPF(long CPF) {
        this.CPF = CPF;
    }

    public void setCEP(int CEP) {
        this.CEP = CEP;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
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
    
    public void insertFuncionario() {
        String sqlLinha = "INSERT INTO Funcionario (cpf, nome, telefone, cep, rua, bairro, estado, cidade, email, sexo, numero_residencial) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = Conexao.conectar();
             PreparedStatement psmt = conn.prepareStatement(sqlLinha)) {
            
            psmt.setLong(1, CPF);
            psmt.setString(2, nome);
            psmt.setLong(3, telefone);
            psmt.setInt(4, CEP);
            psmt.setString(5, rua);
            psmt.setString(6, bairro);
            psmt.setString(7, estado);
            psmt.setString(8, cidade);
            psmt.setString(9, email);
            psmt.setString(10, sexo);
            psmt.setInt(11, numero_residencia);
            
            // Executa o comando SQL de inserção
            int rowsInserted = psmt.executeUpdate();

            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Funcionário inserido com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum funcionário inserido.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir o Funcionário. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    public void selectFuncionario(int id_funcionario) {
        String sqlSelect = "SELECT * FROM Funcionario WHERE id_funcionario = ?";
        
        try (Connection conn = Conexao.conectar();
             PreparedStatement psmt = conn.prepareStatement(sqlSelect)) {
            
            psmt.setInt(1, id_funcionario);

            try (ResultSet rs = psmt.executeQuery()) {
                if (rs.next()) {
                    // Recuperar os dados do funcionário
                    long cpf = rs.getLong("cpf");
                    String nome = rs.getString("nome");
                    long telefone = rs.getLong("telefone");
                    int cep = rs.getInt("cep");
                    String rua = rs.getString("rua");
                    String bairro = rs.getString("bairro");
                    String estado = rs.getString("estado");
                    String cidade = rs.getString("cidade");
                    String email = rs.getString("email");
                    String sexo = rs.getString("sexo");
                    int numero_residencial = rs.getInt("numero_residencial");
                    
                    // Construir a mensagem com todos os dados
                    StringBuilder mensagem = new StringBuilder();
                    mensagem.append("CPF: ").append(cpf).append("\n");
                    mensagem.append("Nome: ").append(nome).append("\n");
                    mensagem.append("Telefone: ").append(telefone).append("\n");
                    mensagem.append("CEP: ").append(cep).append("\n");
                    mensagem.append("Rua: ").append(rua).append("\n");
                    mensagem.append("Bairro: ").append(bairro).append("\n");
                    mensagem.append("Estado: ").append(estado).append("\n");
                    mensagem.append("Cidade: ").append(cidade).append("\n");
                    mensagem.append("Email: ").append(email).append("\n");
                    mensagem.append("Sexo: ").append(sexo).append("\n");
                    mensagem.append("Número Residencial: ").append(numero_residencial);

                    // Exibir a mensagem com todos os dados
                    JOptionPane.showMessageDialog(null, mensagem.toString(), "Informações do Funcionário", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Funcionário não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar funcionário.", "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
     public void deleteFuncionario(int id_funcionario) {
        String sqlDelete = "DELETE FROM funcionario WHERE id_funcionario = ?";
        
        try (Connection conn = Conexao.conectar();
             PreparedStatement psmt = conn.prepareStatement(sqlDelete)) {
            
            psmt.setInt(1, id_funcionario);
            
            // Executa o comando de exclusão
            int rowsAffected = psmt.executeUpdate();
            
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Funcionário deletado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Funcionário não encontrado para deletar.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar funcionário.", "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    public void updateFuncionario(int id_funcionario) {
        String sqlUpdate = "UPDATE funcionario SET cpf = ?, nome = ?, telefone = ?, cep = ?, rua = ?, bairro = ?, estado = ?, cidade = ?, email = ?, sexo = ?, numero_residencial = ? WHERE id_funcionario = ?";
        
        try (Connection conn = Conexao.conectar();
             PreparedStatement psmt = conn.prepareStatement(sqlUpdate)) {
            
            psmt.setLong(1, CPF);
            psmt.setString(2, nome);
            psmt.setLong(3, telefone);
            psmt.setInt(4, CEP);
            psmt.setString(5, rua);
            psmt.setString(6, bairro);
            psmt.setString(7, estado);
            psmt.setString(8, cidade);
            psmt.setString(9, email);
            psmt.setString(10, sexo);
            psmt.setInt(11, numero_residencia);
            psmt.setInt(12, id_funcionario);
            
            // Executa o comando de atualização
            int rowsAffected = psmt.executeUpdate();
            
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Funcionário atualizado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Funcionário não encontrado para atualizar.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar funcionário.", "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

}
