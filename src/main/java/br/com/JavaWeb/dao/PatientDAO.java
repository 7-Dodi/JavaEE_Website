package br.com.JavaWeb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.JavaWeb.connection.ConnectionManufature;
import br.com.JavaWeb.entities.Patient;

public class PatientDAO {
	
	private Connection conexao;
	
	public PatientDAO() throws ClassNotFoundException {
		this.conexao = new ConnectionManufature().getConnection();
	}
	
	//Inserir dados de um paciente:
	public void createdPatient (Patient paciente) {
		String sql = "insert into paciente (name, dataNascimento, genre, numTelefone, email) values (?,?,?,?,?)";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			//Preenchendo os valores dos campos:
			stmt.setString(1, paciente.getName());
			stmt.setString(2, paciente.getDataNascimento());
			stmt.setString(3, paciente.getGenre());
			stmt.setString(4, paciente.getNumTelefone());
			stmt.setString(5, paciente.getEmail());
		
			//Executa
			stmt.execute();
			stmt.close();
			
			//Retornando ação:
			System.out.println("Paciente adicionado ao sistema");
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//Pesquisar um paciente:
	public Patient searchPatient (int id) throws SQLException {
		String sql = "select * from paciente where id = ?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		try {
			//Enviando dados da pesquisa
			stmt.setInt(1, id);
			//Recebendo os dados
			ResultSet rs = stmt.executeQuery();
			Patient paciente = new Patient();
			
			//Verificando se existe retorno
			if(!rs.next()) {
				System.out.println("Não foi encontrado nenhum paciente");
			}else {
				do { //Existindo, deve-se percorrer o while pelo menos uma vez
					// Criando o objeto Patient
					paciente.setId(rs.getInt("id"));
					paciente.setName(rs.getString("name"));
					paciente.setDataNascimento(rs.getString("dataNascimento"));
					paciente.setGenre(rs.getString("genre"));
					paciente.setNumTelefone(rs.getString("numTelefone"));
					paciente.setEmail(rs.getString("email"));
				} while (rs.next());
			}
			
			//Retornando o paciente criado
			return paciente;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//Listar dados de todos os pacientes:
	public List<Patient> allPatients() {
		try {
			List<Patient> pacientes = new ArrayList<Patient>();
			PreparedStatement stmts = conexao.prepareStatement("select * from paciente");
			ResultSet rs = stmts.executeQuery();

			while (rs.next()) {
				// Criando o objeto funcionário
				Patient paciente = new Patient();
				paciente.setId(rs.getInt("id"));
				paciente.setName(rs.getString("name"));
				paciente.setDataNascimento(rs.getString("dataNascimento"));
				paciente.setGenre(rs.getString("genre"));
				paciente.setNumTelefone(rs.getString("numTelefone"));
				paciente.setEmail(rs.getString("email"));
				
				pacientes.add(paciente);
			}
			
			//Finalizando execurção
			rs.close();
			stmts.close();
			
			//Retornando a lista criada
			return pacientes;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//Editar um cadastro de um paciente
	public void editPacient(Patient paciente) {
		String sql = "update paciente set name=?, dataNascimento=?, genre=?, numTelefone=?, email=? where id=?";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			//Preenchendo os valores dos campos:
			stmt.setString(1, paciente.getName());
			stmt.setString(2, paciente.getDataNascimento());
			stmt.setString(3, paciente.getGenre());
			stmt.setString(4, paciente.getNumTelefone());
			stmt.setString(5, paciente.getEmail());
			stmt.setInt(6, paciente.getId());
			
			//Executando
			stmt.execute();
			stmt.close();
			
			//Message
			System.out.println("Paciente atualizado");

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//Procurando se o paciente existe
	public boolean patientExists(int id) {
	    String sql = "select count(*) from paciente where id=?";
	    try {
	        PreparedStatement stmt = conexao.prepareStatement(sql);
	        stmt.setInt(1, id);
	        
	        //Executando
	        ResultSet rs = stmt.executeQuery();
	        rs.next();
	        int count = rs.getInt(1); //Contagem de registros da consulta
	        
	        //Encerrando
	        rs.close();
	        stmt.close();
	        return count > 0;
	    
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}
	
	//Removendo um cadastro de um paciente
	public void removePatient(int id) {
		if(patientExists(id)) { //Validando que o usuário existe
			String sql = "delete from paciente where id=?";
			try {
				PreparedStatement stmt = conexao.prepareStatement(sql);
				stmt.setInt(1, id);
				
				//Executando
				stmt.execute();
				stmt.close();
				
				//Message
				System.out.println("Paciente removido");			
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}			
		}else {
			System.out.println("Paciente não existe ou não encontrado");
		}
	}
}
