package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Funcionario;
import br.edu.ifsul.modelo.OrdemServico;
import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.modelo.Pet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Calendar;

public class TestePersistirOrdemServico {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-PetShopPU");
        EntityManager em = emf.createEntityManager();
        OrdemServico o = new OrdemServico();
        o.setDescricao("Dar banho e tosa no animal");
        o.setData(Calendar.getInstance());
        o.setValorTotal(95.5);
        Funcionario f = em.find(Funcionario.class, 2);
        o.setFuncionario(f);
        Pessoa pes = em.find(Pessoa.class, 2);
        o.setPessoa(pes);
        Pet p = em.find(Pet.class, 1);
        o.setPet(p);
        em.getTransaction().begin();
        em.persist(o);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
