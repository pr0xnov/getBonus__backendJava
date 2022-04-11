package myLocalServer.testJavawithJs.service;

import javassist.NotFoundException;
import myLocalServer.testJavawithJs.dto.DtoCard;
import myLocalServer.testJavawithJs.entity.Card;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ICardService {
    List<DtoCard> findAll();
    DtoCard findById(Long id) throws NotFoundException;
    Card createCard(Card card);
    void deleteById(Long id);
    Card update(DtoCard card);
}
