package ru.trushkin.spring.example2.data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Speaker")
public class Speaker {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "speaker")
    private Set<ATalk> talks = new HashSet<>();

    public void addTalk(ATalk talk) {
        talks.add(talk);
    }

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

    public Set<ATalk> getTalks() {
        return talks;
    }

    public void setTalks(Set<ATalk> talks) {
        this.talks = talks;
    }
}
