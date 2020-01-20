package com.wildcodeschool.wildandwizard.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// TODO : update this entity
@Entity
public class School {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long capacity;
    private String country;

    public School() {
    }
    
    // getter and setters (Übersetzung:: omitted for brevity - ausgelassen für die Kürze)
    
    // more information below... --> -->

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}



/* --> Information on the quest:

Here is the mandatory information that any respectable entity must have:

- the annotation @Entity which indicates that your object will be managed by Spring Data 
  and that its attributes will be converted into columns of DB tables.
  
- @Id indicates that the attribute should be used as the primary key in the table corresponding
  to the entity.
  
- @GeneratedValue(strategy = GenerationType.IDENTITY) which indicates that the value of the id
  will be generated automatically, and incrementally, upon insertion into the database. This
  annotation can accept various values (see the resources section for more information), depending
  on the project requirements.
  
- An empty constructor as well as all the getters and setters: it is because of them that an
  instance of the entity can be automatically created by its repository.
  
We could have left in the constructor we used in the JDBC quests earlier, but it is no longer
needed: JPA will use the empty constructor and the setters.

*/

