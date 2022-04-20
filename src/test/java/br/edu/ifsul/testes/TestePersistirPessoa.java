package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirPessoa {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-PetShopPU");
        EntityManager em = emf.createEntityManager();
        Pessoa pes = new Pessoa();
        pes.setNome("Lucas");
        em.getTransaction().begin();
        em.persist(pes);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
