package br.com.JavaWeb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.JavaWeb.logica.AddPatient;
import br.com.JavaWeb.logica.AddVaccination;
import br.com.JavaWeb.logica.DeletePatient;
import br.com.JavaWeb.logica.DeleteVaccination;
import br.com.JavaWeb.logica.EditPatient;
import br.com.JavaWeb.logica.EditVaccination;
import br.com.JavaWeb.logica.FindAllPatients;
import br.com.JavaWeb.logica.FindAllVaccinations;
import br.com.JavaWeb.logica.FindPatient;
import br.com.JavaWeb.logica.FindVaccination;

@WebServlet(urlPatterns = {"/Controller", "/main", "/vaccination", "/insert", "/insertVaccination", "/select", "/selectVaccination", "/update", "/updateVaccination","/delete", "/deleteVaccination"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		if (action.equals("/main")) {
			patients(request, response);
		}
		else if(action.equals("/vaccination")) {
	    	vaccination(request, response);
	    }
		else if(action.equals("/select")) {
	    	findPatient(request, response);
	    }
		else if(action.equals("/selectVaccination")) {
			findVaccination(request, response);
		}
		else if(action.equals("/update")) {
	    	editPatient(request, response);
	    }
		else if(action.equals("/updateVaccination")) {
	    	editVaccination(request, response);
	    }
		else if(action.equals("/delete")) {
	    	removePatient(request, response);
	    }
		else if(action.equals("/deleteVaccination")) {
	    	removeVaccination(request, response);
	    }
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String action = request.getServletPath();
	    if (action.equals("/insert")) {
	        newPatients(request, response);
	    }else if (action.equals("/insertVaccination")) {
	        newVaccination(request, response);
	    }
	}

	
	//Página de pacientes:
	protected void patients(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FindAllPatients findPatitents = new FindAllPatients();
		try {
			findPatitents.executa(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Página de Vacinação
	protected void vaccination(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FindAllVaccinations findVaccinations = new FindAllVaccinations();
		
		try {
			findVaccinations.executa(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Página de adição de pacientes:
		protected void newPatients(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			AddPatient addPatient = new AddPatient();
			try {
				addPatient.executa(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	//Página de adição de vacinação:
		protected void newVaccination(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			AddVaccination addVacination = new AddVaccination();
			try {
				addVacination.executa(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	//Listando dados do usuário
		protected void findPatient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			FindPatient findPatient = new FindPatient();
			try {
				findPatient.executa(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	//Listando dados de vacinação
		protected void findVaccination(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			FindVaccination findVaccine = new FindVaccination();
			try {
				findVaccine.executa(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
	//Editando dados de um usuário
		protected void editPatient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			EditPatient edit = new EditPatient();
			try {
				edit.executa(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	//Editando dados de um Vacinação
		protected void editVaccination(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			EditVaccination editVaccine = new EditVaccination();
			try {
				editVaccine.executa(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	//Deletando um usuário
		protected void removePatient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			DeletePatient delete = new DeletePatient();
			try {
				delete.executa(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	//Deletando uma vacinação
		protected void removeVaccination(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			DeleteVaccination delete = new DeleteVaccination();
			try {
				delete.executa(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
