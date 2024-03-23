package br.com.JavaWeb.logica;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.JavaWeb.dao.VaccinatioDAO;
import br.com.JavaWeb.entities.Vaccination;

public class FindAllVaccinations implements Logica{

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		VaccinatioDAO dao = null;
		
		try {
			dao = new VaccinatioDAO();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Vaccination> vaccination = dao.allVaccinations();
		req.setAttribute("vaccination", vaccination);
		
		RequestDispatcher rd = req.getRequestDispatcher("vaccinationPage.jsp");
		rd.forward(req, res);
	}

}
