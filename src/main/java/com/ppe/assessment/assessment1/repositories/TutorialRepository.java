package com.ppe.assessment.assessment1.repositories;

import com.ppe.assessment.assessment1.entities.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
    //TODO implement a new method to search tutorials by title and ignoring the case of the search word.
}
