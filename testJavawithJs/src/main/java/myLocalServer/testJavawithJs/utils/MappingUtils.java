package myLocalServer.testJavawithJs.utils;

import myLocalServer.testJavawithJs.dto.DtoCard;
import myLocalServer.testJavawithJs.entity.Card;
import org.springframework.stereotype.Service;

@Service
public class MappingUtils {

    public DtoCard convertToDto(Card card) {
        DtoCard dtoCard = new DtoCard();
        dtoCard.setId(card.getId());
        dtoCard.setBonusName(card.getBonusName());
        dtoCard.setDescription(card.getDescription());
        dtoCard.setDatetimeCreate(card.getDatetimeCreate());
        return dtoCard;
    }

    public DtoCard convertToDtoWithoutDescription(Card card) {
        DtoCard dtoCard = new DtoCard();
        dtoCard.setBonusName(card.getBonusName());
        dtoCard.setDatetimeCreate(card.getDatetimeCreate());
        dtoCard.setId(card.getId());
        dtoCard.setDescription(card.getDescription());
        return dtoCard;
    }

    public Card convertToEntity(DtoCard dtoCard) {
        Card card = new Card();
        card.setId(dtoCard.getId());
        card.setBonusName(dtoCard.getBonusName());
        card.setDatetimeCreate(dtoCard.getDatetimeCreate());
        card.setId(dtoCard.getId());
        return card;
    }
}
