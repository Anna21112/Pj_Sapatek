package br.com.sistema.models;

import br.com.sistema.controller.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Fornecedor {
    private int id_fornecedor;
    private String nome;
    private int CNPJ;
    private String email;
    private String WEBSITE;
    private int CEP;
    private String rua;
    private int numero_residencia;
    private String bairro;
    private String cidade;
    private String estado;
    private int telefone;


    public int getId_fornecedor() {
        return id_fornecedor;
    }

    public String getNome() {
        return nome;
    }

    public int getCNPJ() {
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
    
    public int getTelefone(){
        return telefone;
    }

    public void setId_fornecedor(int id_fornecedor) {
        this.id_fornecedor = id_fornecedor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCNPJ(int CNPJ) {
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
    
    public void setTelefone(int telefone){
        this.telefone = telefone;
    }
    
    public void insertFornecedor(){
        String sqlLinha = "INSERT INTO Fornecedor (nome,cnpj,cep,rua,cidade,bairro,estado,telefone,email,website,numero) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try(Connection conn = Conexao.conectar()){
            PreparedStatement psmt = conn.prepareStatement(sqlLinha);
            
            System.out.println(getNome());
            psmt.setString(1, getNome());
            psmt.setInt(2, getCNPJ());
            psmt.setInt(3, getCEP());
            psmt.setString(4, getRua());
            psmt.setString(5, getCidade());
            psmt.setString(6, getBairro());
            psmt.setString(7, getEstado());
            psmt.setInt(8, getTelefone());
            psmt.setString(9, getEmail());
            psmt.setString(10, getWEBSITE());
            psmt.setInt(11, getNumero_residencia());
            
            
            psmt.execute();
            conn.commit();
            
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro","Deu erro ao inserir o Fornecedor! Tente novamente, por favor", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
    }
    
    public void selectFornecedor(int id_fornecedor){
        String sqlSelect = "SELECT * FROM Fornecedor WHERE id_fornecedor = ?";
        
        try(Connection conn = Conexao.conectar()){
            PreparedStatement psmt = conn.prepareStatement(sqlSelect);
            
            psmt.setInt(1, id_fornecedor);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Erro", "Não encontrado.", JOptionPane.ERROR_MESSAGE);
        }
    }
    
        public void deleteFornecedor(int id_fornecedor){
        String sqlDelete = "DELETE FROM fornecedor WHERE id_fornecedor = ?";
        
        try(Connection conn = Conexao.conectar()){
            PreparedStatement psmt = conn.prepareStatement(sqlDelete);
            
            psmt.setInt(1, id_fornecedor);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro","Não foi possível deletar o fornecedor.", JOptionPane.ERROR_MESSAGE);
        }
    }
        
       public void updateFornecedor(int id_fornecedor){
        String sqlUpdate = "UPDATE fornecedor SET nome = ?, cnpj = ?, cep = ?, rua = ?, cidade = ?, bairro = ?, estado = ?, telefone = ?, email = ?, website = ?, numero = ? WHERE id_fornecedor = ?";
        
        try(Connection conn = Conexao.conectar()){
            PreparedStatement psmt = conn.prepareStatement(sqlUpdate);
            psmt.setString(1, getNome());
            psmt.setInt(2, getCNPJ());
            psmt.setInt(3, getCEP());
            psmt.setString(4, getRua());
            psmt.setString(5, getCidade());
            psmt.setString(6, getBairro());
            psmt.setString(7, getEstado());
            psmt.setInt(8, getTelefone());
            psmt.setString(9, getEmail());
            psmt.setString(10, getWEBSITE());
            psmt.setInt(11, getNumero_residencia());
            psmt.setInt(12, id_fornecedor);
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro","Não foi possível atualizar o fornecedor.", JOptionPane.ERROR_MESSAGE);
        }
    }
}


