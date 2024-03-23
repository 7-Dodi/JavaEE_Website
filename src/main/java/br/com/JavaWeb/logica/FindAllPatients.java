package br.com.JavaWeb.logica;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.JavaWeb.dao.PatientDAO;
import br.com.JavaWeb.entities.Patient;

public class FindAllPatients implements Logica {

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		PatientDAO dao = null;
		try {
			dao = new PatientDAO();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Patient> pacientes = dao.allPatients();
		req.setAttribute("pacientes", pacientes);
		
		RequestDispatcher rd = req.getRequestDispatcher("patientPage.jsp");
		rd.forward(req, res);
	}

}
