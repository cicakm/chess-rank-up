package hr.fer.tzk.rankup.repository;

import hr.fer.tzk.rankup.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    Optional<Event> findByName(String name);

    List<Event> findAllByDateBetweenAndSection_IdOrderByDate(LocalDate dateFrom, LocalDate dateTo, Long idSection);

    List<Event> findAllBySection_Id(Long idSection);

    List<Event> findAllBySection_IdAndEventType_Id(Long idSection, Long idEventType);

    Optional<Event> findByIdAndSection_Id(Long idEvent, Long idSection);
}
