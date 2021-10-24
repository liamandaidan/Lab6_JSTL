/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.*;
import java.util.ArrayList;
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
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        System.out.println(action);
        ArrayList<String> list = null;
        if (action == null && session.getAttribute("username") == null) {
            //new session
            getServletContext().getRequestDispatcher("/WEB-INF/Register.jsp").forward(request, response);
        } else if (action != null && action.equals("register")) {
            //register
            session.setAttribute("username", request.getParameter("username"));
            getServletContext().getRequestDispatcher("/WEB-INF/ShoppingList.jsp").forward(request, response);
        } else if (action != null && action.equals("add")) {
            String item = request.getParameter("item");
            if (session.getAttribute("list") == null || session.getAttribute("list").equals("")) {
                //make new list if it doesnt exist
                list = new ArrayList<>();
                list.add(item);
            } else {
                //if arrayList already exists
                list = (ArrayList<String>) session.getAttribute("list");
                list.add(item);
            }
            session.setAttribute("list", list);
            System.out.println(list.toString());
            getServletContext().getRequestDispatcher("/WEB-INF/ShoppingList.jsp").forward(request, response);
        } else if (action != null && action.equals("delete")) {
            //delete item
            String item = request.getParameter("listItems");
            System.out.println("Item selected is: "+item);
            list = (ArrayList<String>)session.getAttribute("list");
            list.remove(item);
            session.setAttribute("list", list);
            getServletContext().getRequestDispatcher("/WEB-INF/ShoppingList.jsp").forward(request, response);
        } else if (action != null && action.equals("logout")) {
            //logout user
            session.invalidate();
            session = request.getSession();
            request.setAttribute("errormsg", "You have been logged out.");
            response.sendRedirect("ShoppingList");
        } else {
            System.out.println("There was an error in logic");
            session.invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/Register.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
