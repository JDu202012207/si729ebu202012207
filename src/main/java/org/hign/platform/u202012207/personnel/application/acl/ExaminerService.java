package org.hign.platform.u202012207.personnel.application.acl;

import java.util.Optional;
import java.util.UUID;

/**
 * ExaminerService.
 * <p>
 *     This interface provides services for managing examiners.
 * </p>
 * @author Juan Cueto u202012207
 */
public interface ExaminerService {
    Optional<ExaminerDTO> findExaminerByNationalProviderIdentifier(UUID nationalProviderIdentifier);
}

