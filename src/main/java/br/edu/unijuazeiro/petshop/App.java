package br.edu.unijuazeiro.petshop;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import br.edu.unijuazeiro.petshop.animal.Animal;
import br.edu.unijuazeiro.petshop.owner.Owner;

import java.util.List;

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        

        //Criar entidade e gerenciar
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit");
        EntityManager em = emf.createEntityManager();

        //Todos os comandos estão ativos. Para verificar a funcionalidade, favor, comentar  - 
        //- os demais comandos e executar os trechos separadamente. 



        // início da transação
        em.getTransaction().begin();


        //Inserir
        em.persist(new Owner("Gilberto", "814.421.004-20"));
        em.persist(new Animal("Vira-lata", "Caramelo"));
        

        //Buscar
        Animal animal1 = em.find(Animal.class, 8);
        Owner owner1 = em.find(Owner.class, 1);
        System.out.println(animal1.getName());
        System.out.println(owner1.getName());
        
        //Atualizar
        Animal animal1 = em.find(Animal.class, 9);
        animal1.setName("Petpet");
        em.merge(animal1);

        //Listar Class Animal
		Query query = em.createQuery("select animal from Animal animal");
		List<Animal> animals = query.getResultList();
		for(Animal animal:animals){
            System.out.println("Nome do animal: " + animal.getName());
            System.out.println("Raça do animal: " + animal.getBreed());
        }
        
        //Listar Class Owner
        Query query1 = em.createQuery("select owner from Owner owner");
		List<Owner> owners = query1.getResultList();
		for(Owner owner:owners){
            System.out.println("Nome do Dono: " + owner.getName());
            System.out.println("CPF do Dono: " + owner.getCpf());
        }
        
        //Remover
        Animal animal1 = em.find(Animal.class, 9);
        em.remove(animal1);


        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}
