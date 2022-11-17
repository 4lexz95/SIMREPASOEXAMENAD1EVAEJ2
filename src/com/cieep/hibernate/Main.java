package com.cieep.hibernate;

import com.cieep.hibernate.modelos.Abonado;
import com.cieep.hibernate.modelos.Alquiler;
import com.cieep.hibernate.modelos.Autor;
import com.cieep.hibernate.modelos.Libro;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.security.auth.login.Configuration;
import java.sql.Date;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
       /*Abrimos project structure Libraries/from maven  y buscar
       hibernate-core 6.1.4 para traer librerias



        */
        Abonado abonado = new Abonado();
        abonado.setNombre("Manolito");
        Autor autor = new Autor();
        autor.setNombre("javier");
        Libro libro = new Libro();
        libro.setTitulo("Dummies");
        libro.setAutor(autor);
        Alquiler alqui = new Alquiler();
        alqui.setFecha(Date.valueOf(LocalDate.now()));
        abonado.getAlquileres().add(alqui);
        libro.getAlquires().add(alqui);
        autor.getLibros().add(libro);

        //Crea la variable que puede conectar
        SessionFactory sf = new Configuration().configure.buildSessionFactory();

        Session se = sf .openSession();
        se.beginTransaction();
        se.persist(abonado);
        se.persist(autor);
        se.persist(libro);
        se.persist(alqui);

        se.getTransaction().commit();
        se.close();


    }
}