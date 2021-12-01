/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author DAW2
 */
public class Crud {

    public static int actualizaProducto(Motos miMoto) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("motos");
        EntityManager manager = factory.createEntityManager();
        String sql = "UPDATE Motos m SET m.marca = :marca, m.modelo = :modelo, m.cilindrada = :cilindrada, m.foto = :foto WHERE m.id = :id";
        Query q = manager.createQuery(sql, Motos.class);
        q.setParameter("id", miMoto.getId());
        q.setParameter("marca", miMoto.getMarca());
        q.setParameter("modelo", miMoto.getModelo());
        q.setParameter("cilindrada", miMoto.getCilindrada());
        q.setParameter("foto", miMoto.getFoto());

        manager.getTransaction().begin();
        int filasAfectadas = q.executeUpdate();
        manager.getTransaction().commit();
        //manager.close();
        return filasAfectadas;
    }

    public static Motos getProducto(int id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("motos");
        EntityManager manager = factory.createEntityManager();
        String sql = "SELECT m FROM Motos m WHERE m.id=" + id; //consulta en JPQL 
        Query q = manager.createQuery(sql, Motos.class); //método para consultas en JPQL
        Motos productosBD = (Motos) q.getSingleResult();
        return productosBD;
    }

    public static void insertaProducto(Motos m) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("motos");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.merge(m);
        manager.getTransaction().commit();
    }

    public static List<Motos> getMotos() {
        ArrayList<Motos> productos = new ArrayList<Motos>();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("motos");
        EntityManager manager = factory.createEntityManager();
        String sql = "SELECT * FROM motos";
        Query q = manager.createNativeQuery(sql, Motos.class); //método para consultas en SQL
        List<Motos> productosBD = q.getResultList();

        for (Motos p : productosBD) {
            Motos miMoto = new Motos(p.getId(), p.getMarca(), p.getModelo(), p.getCilindrada(), p.getFoto());
            productos.add(miMoto);
        }
        return productosBD;
    }

    public static List<Motos> getMotosPaginado(int offset, int lineas_pagina) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("motos");
        EntityManager manager = factory.createEntityManager();
        String sql = "SELECT * FROM motos";
        Query q = manager.createNativeQuery(sql, Motos.class); //método para consultas en SQL

        q.setFirstResult(offset);
        q.setMaxResults(lineas_pagina);

        List<Motos> productosBD = q.getResultList();

        return productosBD;
    }

    public static int destroyProducto(int id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("motos");
        EntityManager manager = factory.createEntityManager();
        String sql = "DELETE from Motos m WHERE m.id = " + id;
        Query q = manager.createQuery(sql);
        manager.getTransaction().begin();
        int filasAfectadas = q.executeUpdate(); //para las consultas de modif. datos se usa el método executeUpdate
        manager.getTransaction().commit();
        return filasAfectadas;

    }

}
