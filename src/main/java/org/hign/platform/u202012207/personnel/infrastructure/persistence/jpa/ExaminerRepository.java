package org.hign.platform.u202012207.personnel.infrastructure.persistence.jpa;

import org.hign.platform.u202012207.personnel.domain.model.Examiner;
import org.hign.platform.u202012207.shared.domain.model.valueobjects.NationalProviderIdentifier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * ExaminerRepository.
 * <p>
 * This interface provides methods for managing examiners in the database.
 * </p>
 * @author Juan Cueto u202012207
 */
@Repository
public interface ExaminerRepository extends JpaRepository<Examiner, Long> {
    Optional<Examiner> findByNationalProviderIdentifier(NationalProviderIdentifier nationalProviderIdentifier);
}


