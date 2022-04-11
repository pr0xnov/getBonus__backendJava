package myLocalServer.testJavawithJs.dto;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;

@Component
public class DtoCard {

    private String bonusName;
    private String description;
    private Date datetimeCreate;
    private Long id;

    public DtoCard(String bonusName, String description, Date datetimeCreate, Long id) {
        this.bonusName = bonusName;
        this.description = description;
        this.datetimeCreate = datetimeCreate;
        this.id = id;
    }

    public DtoCard(String bonusName, String description) {
        this.bonusName = bonusName;
        this.description = description;
    }

    public DtoCard() {
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
        DtoCard dtoCard = (DtoCard) o;
        return Objects.equals(bonusName, dtoCard.bonusName) && Objects.equals(description, dtoCard.description) && Objects.equals(datetimeCreate, dtoCard.datetimeCreate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bonusName, description, datetimeCreate);
    }

    @Override
    public String toString() {
        return "DtoCard{" +
                "bonusName='" + bonusName + '\'' +
                ", description='" + description + '\'' +
                ", datetimeCreate=" + datetimeCreate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
