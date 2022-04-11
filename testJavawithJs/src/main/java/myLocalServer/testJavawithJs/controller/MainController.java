package myLocalServer.testJavawithJs.controller;


import javassist.NotFoundException;
import myLocalServer.testJavawithJs.dto.DtoCard;
import myLocalServer.testJavawithJs.entity.Card;
import myLocalServer.testJavawithJs.service.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class MainController {

    @Autowired
    private ICardService iCardService;

    @GetMapping("/cards")
    public List<DtoCard> getAllCards(){
        return iCardService.findAll();
    }

    @GetMapping("/{id}")
    public DtoCard findLogoById(@PathVariable("id") Long id) throws NotFoundException {
        return iCardService.findById(id);
    }

    @PostMapping("/createCard")
    public String createCard(@RequestBody Card card) {
        Card newCard = iCardService.createCard(card);
        if(newCard != null)
            return "everything is good";
        else
            return "wrong request body";
    }

    @DeleteMapping("/card/{id}")
    public String deleteCard(@PathVariable("id") Long id){
        iCardService.deleteById(id);
        return "Card with id: " + id + " was delete";
    }

    @PutMapping("/update")
    public ResponseEntity<DtoCard> updateCard(@RequestBody DtoCard card)  {
        DtoCard cardFromDb = null;
        try {
            cardFromDb = iCardService.findById(card.getId());
        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        cardFromDb.setDescription(card.getDescription());
        cardFromDb.setDatetimeCreate(new Date());
        cardFromDb.setBonusName(card.getBonusName());
        cardFromDb.setId(card.getId());
        iCardService.update(cardFromDb);
        return new ResponseEntity<DtoCard>(cardFromDb, HttpStatus.OK);
    }
}
