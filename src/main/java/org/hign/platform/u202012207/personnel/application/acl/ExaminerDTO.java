package org.hign.platform.u202012207.personnel.application.acl;

import java.util.UUID;

/**
 * ExaminerDTO.
 * <p>
 *     This class represents a data transfer object for an examiner.
 * </p>
 * @author Juan Cueto u202012207
 */
public record ExaminerDTO(Long id, String firstName, String lastName, UUID nationalProviderIdentifier) {
}

