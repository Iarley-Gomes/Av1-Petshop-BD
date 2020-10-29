package br.edu.unijuazeiro.petshop.animal;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import lombok.Data;
import lombok.Getter;


@Data
@Getter
@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_animal")
    @SequenceGenerator(sequenceName = "seq_animal", allocationSize = 1, 
        initialValue = 1, name = "gen_animal")
    private Integer code;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String breed;

    public Animal(){}
    public Animal(String breed, String name){
        this.breed = breed;
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public String getBreed(){
        return this.breed;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setBreed(String breed){
        this.breed = breed;
    }
}
