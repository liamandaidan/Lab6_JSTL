/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author liamm
 */
public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = null;
        String username = request.getParameter("username");
        if (username != null && !username.equals("")) {
            //display shopping list
             session = request.getSession();
            session.setAttribute("username", username);
            displayShoppingList(response, request);
        } else if (request.getParameter("logout") != null && !request.getParameter("logout").equals("")) {
            session.invalidate();
            session = request.getSession();
            viewLogin(response, request);
        } else {
            //view login
            viewLogin(response, request);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private void displayShoppingList(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/ShoppingList.jsp").forward(request, response);
    }

    private void viewLogin(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/Register.jsp").forward(request, response);
    }

}
