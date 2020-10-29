package br.edu.unijuazeiro.petshop.owner;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.OneToMany;



import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Entity 
public class Owner {

    @Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_owner")
    @SequenceGenerator(sequenceName = "seq_owner", allocationSize = 2, initialValue = 1, name = "gen_owner")
    private Integer code;

    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    private String cpf;

    public Owner(){}  
    
    public Owner(String name, String cpf){
        this.name = name;
        this.cpf = cpf;
    }


    public String getName(){
        return this.name;
    }
    
    public String getCpf(){
        return this.cpf;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }
}
