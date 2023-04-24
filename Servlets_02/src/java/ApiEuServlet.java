/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author ryana
 */
@WebServlet(urlPatterns = {"/eu.json"})
public class ApiEuServlet extends HttpServlet {
    
    private ArrayList<String> list;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        list = new ArrayList<>();
        list.add("Banco de Dados");
        list.add("Engenharia de Software III");
        list.add("Programação Orientada a Objetos");
        list.add("Linguagem de Programação IV - INTERNET");
        list.add("Sistemas Operacionais II");
        list.add("Metodologia da Pesquisa Científico-Tecnológica");
        try (PrintWriter out = response.getWriter()) {
            JSONObject obj = new JSONObject();            
            obj.put("Nome: ", "Ryan Arruda Figueiredo");
            obj.put("RA: ", "1290482123016");
            obj.put("Materias", list);
            out.println(obj.toString());
            
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

