package de.data_models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "BREEDER")
public class Breeder {


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getKennelname() {
        return kennelname;
    }

    public void setKennelname(String kennelname) {
        this.kennelname = kennelname;
    }




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstname;
    private String lastname;
    private String kennelname;

    @OneToMany(mappedBy = "breeder",cascade=CascadeType.ALL)
    private Set<Dog> dogs;

}
