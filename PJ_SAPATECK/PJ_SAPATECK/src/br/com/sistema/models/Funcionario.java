
package br.com.sistema.models;

import br.com.sistema.controller.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Funcionario {
    private int id_funcionario;
    private String nome;
    private int telefone;
    private int CPF;
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

    public int getTelefone() {
        return telefone;
    }

    public int getCPF() {
        return CPF;
    }

    public int getCEP() {
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

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public void setCPF(int CPF) {
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
    
    public void insertFuncionario(){
        String sqlLinha = "INSERT INTO Funcionario (cpf,nome,telefone,cep,rua,bairro,estado,cidade,email,sexo,numero_residencial) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try(Connection conn = Conexao.conectar()){
            PreparedStatement psmt = conn.prepareStatement(sqlLinha);
            
            psmt.setInt(1, CPF);
            psmt.setString(2,nome);
            psmt.setInt(3, telefone);
            psmt.setInt(4, CEP);
            psmt.setString(5, rua);
            psmt.setString(6, bairro);
            psmt.setString(7, estado);
            psmt.setString(8, cidade);
            psmt.setString(9, email);
            psmt.setString(10, sexo);
            psmt.setInt(11, numero_residencia);
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Erro", "Deu erro ao inserir o Funcionário! Tente novamente, por favor", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void selectFuncionario(int id_funcionario){
        String sqlSelect = "SELECT * FROM Funcionario WHERE id_funcionario = ?";
        
        try(Connection conn = Conexao.conectar()){
            PreparedStatement psmt = conn.prepareStatement(sqlSelect);
            
            psmt.setInt(1, id_funcionario);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro","Não encontrado.", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void deleteFuncionario(int id_funcionario){
        String sqlDelete = "DELETE FROM funcionario WHERE id_funcionario = ?";
        
        try(Connection conn = Conexao.conectar()){
            PreparedStatement psmt = conn.prepareStatement(sqlDelete);
            
            psmt.setInt(1, id_funcionario);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro","Não foi possível deletar o funcionário.", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updateFuncionario(int id_funcionario){
        String sqlUpdate = "UPDATE funcionario SET cpf = ?, nome = ?, telefone = ?, cep = ?, rua = ?, bairro = ?, estado = ?, cidade = ?, email = ?, sexo = ?, numero_residencial = ? WHERE id_funcionario = ?";
        
        try(Connection conn = Conexao.conectar()){
            PreparedStatement psmt = conn.prepareStatement(sqlUpdate);
            psmt.setInt(1, CPF);
            psmt.setString(2,nome);
            psmt.setInt(3, telefone);
            psmt.setInt(4, CEP);
            psmt.setString(5, rua);
            psmt.setString(6, bairro);
            psmt.setString(7, estado);
            psmt.setString(8, cidade);
            psmt.setString(9, email);
            psmt.setString(10, sexo);
            psmt.setInt(11, numero_residencia);
            psmt.setInt(12, id_funcionario);
            
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro","Não foi possível atualizar o funcionário.", JOptionPane.ERROR_MESSAGE);
        }
    }
}
