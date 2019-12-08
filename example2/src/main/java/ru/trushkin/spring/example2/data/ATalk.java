package ru.trushkin.spring.example2.data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "talk")
public class ATalk {

    @Id
    @GeneratedValue
    private Long id;

    private Date whenDate;

    private String title;

    @ManyToOne(fetch =  FetchType.EAGER)
    @JoinColumn(name="speaker_id", nullable=false)
    private Speaker speaker;

    public Speaker getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getWhenDate() {
        return whenDate;
    }

    public void setWhenDate(Date whenDate) {
        this.whenDate = whenDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
