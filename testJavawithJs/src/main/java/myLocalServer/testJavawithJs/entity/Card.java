package myLocalServer.testJavawithJs.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity(name = "bonuses")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "bonus_name")
    private String bonusName;
    @Column(name = "description")
    private String description;
    @Column(name = "datetime_create")
    @CreationTimestamp
    private Date datetimeCreate;

    public Card() {
    }

    public Card(String bonusName, String description, Date datetimeCreate) {
        this.bonusName = bonusName;
        this.description = description;
        this.datetimeCreate = datetimeCreate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBonusName() {
        return bonusName;
    }

    public void setBonusName(String bonusName) {
        this.bonusName = bonusName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDatetimeCreate() {
        return datetimeCreate;
    }

    public void setDatetimeCreate(Date datetimeCreate) {
        this.datetimeCreate = datetimeCreate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(id, card.id) && Objects.equals(bonusName, card.bonusName) && Objects.equals(description, card.description) && Objects.equals(datetimeCreate, card.datetimeCreate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bonusName, description, datetimeCreate);
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", bonusName='" + bonusName + '\'' +
                ", description='" + description + '\'' +
                ", datetimeCreate=" + datetimeCreate +
                '}';
    }
}
