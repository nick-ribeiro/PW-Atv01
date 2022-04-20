package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.ItemServico;
import br.edu.ifsul.modelo.OrdemServico;
import br.edu.ifsul.modelo.Servico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirItemServico {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-PetShopPU");
        EntityManager em = emf.createEntityManager();
        ItemServico i = new ItemServico();
        i.setQuantidade(1.0);
        i.setValorTotal(95.5);
        i.setValorUnitario(67.5);
        OrdemServico o = em.find(OrdemServico.class, 1);
        i.setOrdemServico(o);
        Servico s = em.find(Servico.class, 1);
        i.setServico(s);
        em.getTransaction().begin();
        em.persist(i);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
