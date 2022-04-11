package myLocalServer.testJavawithJs.service;

import javassist.NotFoundException;
import myLocalServer.testJavawithJs.dto.DtoCard;
import myLocalServer.testJavawithJs.entity.Card;
import myLocalServer.testJavawithJs.repository.CardRepo;
import myLocalServer.testJavawithJs.utils.MappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ImplCardService implements ICardService{

    @Autowired
    private CardRepo cardRepo;

    @Autowired
    private MappingUtils mappingUtils;

    @Override
    public List<DtoCard> findAll() {
        return cardRepo.findAll().stream()
                .map(mappingUtils::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public DtoCard findById(Long id) throws NotFoundException {
        Optional<Card> card = cardRepo.findById(id);
        if(card.isPresent()) {
            return mappingUtils.convertToDtoWithoutDescription(card.get());
        }
        throw new NotFoundException("Cannot find card with id:" + id);
    }

    @Override
    public Card createCard(Card card) {
        return cardRepo.save(card);
    }

    @Override
    public void deleteById(Long id) {
        cardRepo.deleteById(id);
    }

    @Override
    public Card update(DtoCard card) {
        Card card1 = mappingUtils.convertToEntity(card);
        cardRepo.save(card1);
        return card1;
    }
}
