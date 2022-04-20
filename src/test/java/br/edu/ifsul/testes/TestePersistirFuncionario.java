package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Funcionario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirFuncionario {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-PetShopPU");
        EntityManager em = emf.createEntityManager();
        Funcionario f = new Funcionario();
        f.setNome("Lucas");
        f.setNomeUsuario("Lucas Senpai");
        f.setSenha("123456");
        f.setAtivo(true);
        em.getTransaction().begin();
        em.persist(f);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
