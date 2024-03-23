package br.com.JavaWeb.logica;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.JavaWeb.dao.PatientDAO;
import br.com.JavaWeb.entities.Patient;

public class FindPatient implements Logica{

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String idUser = req.getParameter("idUser");
		int id = Integer.parseInt(idUser);
		
		PatientDAO dao = null;
		try {
			dao = new PatientDAO();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Patient paciente = null;
		try {
			paciente = dao.searchPatient(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.setAttribute("idUser", paciente.getId());
		req.setAttribute("name", paciente.getName());
		req.setAttribute("genre", paciente.getGenre());
		req.setAttribute("data", paciente.getDataNascimento());
		req.setAttribute("email", paciente.getEmail());
		req.setAttribute("telephone", paciente.getNumTelefone());
		
		RequestDispatcher rd = req.getRequestDispatcher("editar.jsp");
		rd.forward(req, res);
	}

}
