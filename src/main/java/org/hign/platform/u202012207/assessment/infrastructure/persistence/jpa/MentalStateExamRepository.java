package org.hign.platform.u202012207.assessment.infrastructure.persistence.jpa;

import org.hign.platform.u202012207.assessment.domain.model.aggregates.MentalStateExam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * MentalStateExamRepository.
 * <p>
 *     This interface provides methods for managing mental state exams.
 * </p>
 * @autor Juan Cueto u202012207
 */
@Repository
public interface MentalStateExamRepository extends JpaRepository<MentalStateExam, Long> {
}
