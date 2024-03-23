package br.com.JavaWeb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.JavaWeb.connection.ConnectionManufature;
import br.com.JavaWeb.entities.Vaccination;

public class VaccinatioDAO {
    	
	private Connection conexao;
	
	public VaccinatioDAO() throws ClassNotFoundException {
		this.conexao = new ConnectionManufature().getConnection();
	}
	
    //Inserir dados de uma vacinacao:
    public void createdVaccination (Vaccination vacinacao) {
		String sql = "insert into vacinacao (vacina, dataVacinacao, lote, nomeMedico, idPaciente) values (?,?,?,?,?)";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			//Preenchendo os valores dos campos:
			stmt.setString(1, vacinacao.getNomeVaccine());
			stmt.setString(2, vacinacao.getData());
			stmt.setString(3, vacinacao.getLote());
			stmt.setString(4, vacinacao.getMedico());
			stmt.setInt(5, vacinacao.getIdPaciente());
		
			//Executa
			stmt.execute();
			stmt.close();
			
			//Retornando ação:
			System.out.println("Vacinacao adicionado ao sistema");
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

    //Pesquisar uma vacinacao
    public Vaccination searchVaccination (int id) throws SQLException {
		String sql = "select * from vacinacao where id = ?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		try {
			//Enviando dados da pesquisa
			stmt.setInt(1, id);
			//Recebendo os dados
			ResultSet rs = stmt.executeQuery();
		    Vaccination vacinacao = new Vaccination();
			
			//Verificando se existe retorno
			if(!rs.next()) {
				System.out.println("Não foi encontrado nenhum vacinacao");
			}else {
				do { //Existindo, deve-se percorrer o while pelo menos uma vez
					// Criando o objeto Patient
					vacinacao.setId(rs.getInt("id"));
					vacinacao.setNomeVaccine(rs.getString("vacina"));
					vacinacao.setData(rs.getString("dataVacinacao"));
					vacinacao.setLote(rs.getString("lote"));
					vacinacao.setMedico(rs.getString("nomeMedico"));
					vacinacao.setIdPaciente(rs.getInt("idPaciente"));
				} while (rs.next());
			}
			
			//Retornando o vacinacao criado
			return vacinacao;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

    //Listar dados de todos as Vacinacoes:
    public List<Vaccination> allVaccinations() {
		try {
			List<Vaccination> vacinacoes = new ArrayList<Vaccination>();
			PreparedStatement stmts = conexao.prepareStatement("select * from vacinacao");
			ResultSet rs = stmts.executeQuery();

			while (rs.next()) {
				// Criando o objeto funcionário
				Vaccination vacinacao = new Vaccination();
				vacinacao.setId(rs.getInt("id"));
				vacinacao.setNomeVaccine(rs.getString("vacina"));
				vacinacao.setData(rs.getString("dataVacinacao"));
				vacinacao.setLote(rs.getString("lote"));
				vacinacao.setMedico(rs.getString("nomeMedico"));
				vacinacao.setIdPaciente(rs.getInt("idPaciente"));
				
				vacinacoes.add(vacinacao);
			}
			
			//Finalizando execurção
			rs.close();
			stmts.close();
			
			//Retornando a lista criada
			return vacinacoes;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

    //Editar um cadastro de uma Vaciancao
	public void editVaccination(Vaccination vacinacao) {
		String sql = "update vacinacao set vacina=?, dataVacinacao=?, lote=?, nomeMedico=?, idPaciente=? where id=?";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			//Preenchendo os valores dos campos:
			stmt.setString(1, vacinacao.getNomeVaccine());
			stmt.setString(2, vacinacao.getData());
			stmt.setString(3, vacinacao.getLote());
			stmt.setString(4, vacinacao.getMedico());
			stmt.setInt(5, vacinacao.getIdPaciente());
			stmt.setInt(6, vacinacao.getId());
			
			//Executando
			stmt.execute();
			stmt.close();
			
			//Message
			System.out.println("Vacinacao atualizado");

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

    //Procurando se o vacinacao existe
	public boolean vaccinatioExists(int id) {
	    String sql = "select count(*) from vacinacao where id=?";
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

    //Removendo um cadastro de uma vacinacao
	public void removePatient(int id) {
		if(vaccinatioExists(id)) { //Validando que o usuário existe
			String sql = "delete from vacinacao where id=?";
			try {
				PreparedStatement stmt = conexao.prepareStatement(sql);
				stmt.setInt(1, id);
				
				//Executando
				stmt.execute();
				stmt.close();
				
				//Message
				System.out.println("Vacinacao removido");			
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}			
		}else {
			System.out.println("vacinacao não existe ou não encontrado");
		}
	}
}
