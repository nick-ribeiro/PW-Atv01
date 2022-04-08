package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Raca;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TesteListarRaca {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-PetShopPU");
        EntityManager em = emf.createEntityManager();
        List<Raca> lista = em.createQuery("from Raca order by id").getResultList();
        for (Raca r : lista) {
            System.out.println("ID: " + r.getId() + " Nome: " + r.getNome());
        }
        em.close();
        emf.close();
    }
}
