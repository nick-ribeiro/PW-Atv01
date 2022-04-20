package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Servico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirServico {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-PetShopPU");
        EntityManager em = emf.createEntityManager();
        Servico s1 = new Servico();
        s1.setNome("Banho");
        s1.setValor(45.5);
        Servico s2 = new Servico();
        s2.setNome("Tosa");
        s2.setValor(50.0);
        em.getTransaction().begin();
        em.persist(s1);
        em.persist(s2);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
