package myLocalServer.testJavawithJs.repository;

import myLocalServer.testJavawithJs.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepo extends JpaRepository<Card, Long> {}
