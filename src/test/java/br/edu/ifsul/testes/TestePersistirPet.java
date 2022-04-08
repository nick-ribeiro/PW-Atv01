package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Pet;
import br.edu.ifsul.modelo.Raca;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Calendar;

public class TestePersistirPet {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-PetShopPU");
        EntityManager em = emf.createEntityManager();
        Raca r = em.find(Raca.class, 1);
        Pet p = new Pet();
        p.setNome("Lua");
        p.setNascimento(Calendar.getInstance());
        p.setPeso(15.6d);
        p.setEspecie("Cachorro");
        p.setRaca(r);
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
