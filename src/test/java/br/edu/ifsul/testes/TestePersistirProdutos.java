package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Produtos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePersistirProdutos {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW2022-PetShopPU");
        EntityManager em = emf.createEntityManager();
        Produtos p1 = new Produtos();
        p1.setNome("Xampu para Carrapato");
        p1.setValor(20.5);
        Produtos p2 = new Produtos();
        p2.setNome("Condicionador");
        p2.setValor(15.6);
        Produtos p3 = new Produtos();
        p3.setNome("Maquina de Tosa");
        p3.setValor(60.8);
        em.getTransaction().begin();
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
