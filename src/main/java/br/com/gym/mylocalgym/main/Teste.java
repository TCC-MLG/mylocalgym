/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gym.mylocalgym.main;

import br.com.gym.mylocalgym.configuration.HibernateUtil;
import br.com.gym.mylocalgym.entities.Cliente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Matheus
 */
public class Teste {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Cliente cliente = new Cliente();
        cliente.setNome("Matheus siqueira");
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Integer inte = (Integer) session.save(cliente);
        
        System.out.println(""+inte);
 
    }

}
