/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Crud;
import modelo.Motos;

/**
 *
 * @author DAW2
 */
public class Servlet extends HttpServlet {

    final int NUM_LINEAS_PAGINA = 5;
    int pagina = 1;
    int offset = 0;
    int num_paginas = 0;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /* TODO output your page here. You may use following sample code. */
        String op = "listar";
        if (request.getParameter("op") != null) {
            op = request.getParameter("op");
        }

        if (op.equals("insertar")) {

            request.setAttribute("operacion", "insertardatos");
            request.setAttribute("mensaje", "");
            request.getRequestDispatcher("actualizar.jsp").forward(request, response);

        }
        if (op.equals("listar")) {
            listar(request, response);
        }

       
        /**
         * ***************************************
         */
        /*    BORRAR                              */
        /**
         * ***************************************
         */
        if (op.equals("borrar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            if (Crud.destroyProducto(id) > 0) {
                request.setAttribute("mensaje", "Producto con id" + id + "Borrado");
            } else {
                request.setAttribute("mensaje", "No se ha borrado ningún producto");
            }
            //List<Motos> listaMotos=Crud.getMotos();
            //request.setAttribute("listado", listaMotos);
            //request.getRequestDispatcher("listar.jsp").forward(request,response);
            this.listar(request, response);
        }

        /**
         * ***************************************
         */
        /*    ACTUALIZAR                           */
        /**
         * ***************************************
         */
        if (op.equals("actualizar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Motos miMoto = Crud.getProducto(id);
            request.setAttribute("operacion", "actualizardatos");
            request.setAttribute("producto", miMoto);
            request.getRequestDispatcher("actualizar.jsp").forward(request, response);
        }
        /**
         * ***************************************
         */
        /*    ACTUALIZAR DATOS                      */
        /**
         * ***************************************
         */
        if (op.equals("actualizardatos")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String marca = request.getParameter("marca");
            String modelo = request.getParameter("modelo");
            String foto = null;
              //meter un if para 
              if (request.getParameter("foto") != null) {
                foto = request.getParameter("foto");
            } else {
                foto = ("foto.png");
            }
            int cilindrada = Integer.parseInt(request.getParameter("cilindrada"));

            Motos miMoto = new Motos(id, marca, modelo, cilindrada, foto);
            if (Crud.actualizaProducto(miMoto) > 0) {
                request.setAttribute("mensaje", "Moto con id" + id + "Actualizado");
            } else {
                request.setAttribute("mensaje", "No se ha podido actualizar la Moto");
            }
            request.setAttribute("producto", miMoto);
            request.getRequestDispatcher("actualizar.jsp").forward(request, response);

        }
        /**
         * ***************************************
         */
        /*    INSERTAR DATOS                      */
        /**
         * ***************************************
         */
        if (op.equals("insertardatos")) {
            String marca = request.getParameter("marca");
            String modelo = request.getParameter("modelo");
            int cilindrada = Integer.parseInt(request.getParameter("cilindrada"));
            String foto = request.getParameter("foto");

            Motos miMoto = new Motos();
            miMoto.setMarca(marca);
            miMoto.setModelo(modelo);
            miMoto.setCilindrada(cilindrada);
            miMoto.setFoto(foto);

            Crud.insertaProducto(miMoto);
            /*List<Motos> listaMotos=Crud.getMotos();
              request.setAttribute("listado", listaMotos);
              request.setAttribute("mensaje", "");
            request.setAttribute("pagina", pagina);
            request.setAttribute("num_paginas", String.valueOf(num_paginas));
              request.getRequestDispatcher("listar.jsp").forward(request,response);   */
            this.listar(request, response);

        }

    }

    protected void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Motos> listaMotos = Crud.getMotos();
        /* cálculos para la paginación */

        if (request.getParameter("pagina") != null) {
            pagina = Integer.parseInt(request.getParameter("pagina"));
            offset = (pagina - 1) * NUM_LINEAS_PAGINA;
        }
        num_paginas = (int) Math.ceil(listaMotos.size() / (double) NUM_LINEAS_PAGINA);
        listaMotos = Crud.getMotosPaginado(offset, NUM_LINEAS_PAGINA);

        request.setAttribute("listado", listaMotos);
        request.setAttribute("pagina", pagina);
        request.setAttribute("num_paginas", String.valueOf(num_paginas));

        request.setAttribute("mensaje", "");
        request.getRequestDispatcher("listar.jsp").forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
