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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author ryana
 */
@WebServlet(urlPatterns = {"/loteria.json"})
public class ApiLoteriaServlet extends HttpServlet {
    
    private ArrayList<Integer> list;
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        list = new ArrayList<>();
        
        LocalDateTime hora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String hojeFormatado = hora.format(formatter);
    
        Random random = new Random();
            for (int i = 1; i <= 6; i++) {
                int rand = random.nextInt(59) + 1;
                list.add(rand);
            }
        
        try (PrintWriter out = response.getWriter()) {
            JSONObject obj = new JSONObject();
            JSONArray arr = new JSONArray();
            
            for (Integer numbers : list) {
                arr.put(numbers);
            }
            obj.put("Data: ", hojeFormatado);
            obj.put("Numeros", list);
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

