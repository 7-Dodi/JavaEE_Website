package br.com.JavaWeb.logica;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.JavaWeb.dao.VaccinatioDAO;
import br.com.JavaWeb.entities.Vaccination;

public class FindVaccination implements Logica{

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String idVaccine = req.getParameter("idVaccine");
		int id = Integer.parseInt(idVaccine);
		
		VaccinatioDAO dao = null;
		try {
			dao = new VaccinatioDAO();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Vaccination vaccine = null;
		try {
			vaccine = dao.searchVaccination(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.setAttribute("id", vaccine.getId());
		req.setAttribute("vaccine", vaccine.getNomeVaccine());
		req.setAttribute("paciente", vaccine.getIdPaciente());
		req.setAttribute("data", vaccine.getData());
		req.setAttribute("lote", vaccine.getLote());
		req.setAttribute("medico", vaccine.getMedico());
		
		RequestDispatcher rd = req.getRequestDispatcher("editarVaccination.jsp");
		rd.forward(req, res);
	}

}
