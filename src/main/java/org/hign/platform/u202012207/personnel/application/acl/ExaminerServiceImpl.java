package org.hign.platform.u202012207.personnel.application.acl;

import org.hign.platform.u202012207.personnel.infrastructure.persistence.jpa.ExaminerRepository;
import org.hign.platform.u202012207.shared.domain.model.valueobjects.NationalProviderIdentifier;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * ExaminerServiceImpl.
 * <p>
 *     This class provides services for managing examiners.
 * </p>
 * @author Juan Cueto u202012207
 */
@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final ExaminerRepository examinerRepository;

    public ExaminerServiceImpl(ExaminerRepository examinerRepository) {
        this.examinerRepository = examinerRepository;
    }

    /**
     * Find an examiner by national provider identifier.
     *
     * @param nationalProviderIdentifier the national provider identifier
     * @return an optional containing the examiner if found, or empty if not
     */
    @Override
    public Optional<ExaminerDTO> findExaminerByNationalProviderIdentifier(UUID nationalProviderIdentifier) {
        return examinerRepository.findByNationalProviderIdentifier(new NationalProviderIdentifier(nationalProviderIdentifier.toString()))
                .map(examiner -> new ExaminerDTO(
                        examiner.getId(),
                        examiner.getFirstName(),
                        examiner.getLastName(),
                        examiner.getNationalProviderIdentifier().getValue()
                ));
    }
}

