package org.hign.platform.u202012207.personnel.interfaces.rest.transform;

import org.hign.platform.u202012207.personnel.domain.model.Examiner;
import org.hign.platform.u202012207.personnel.interfaces.rest.resources.ExaminerResource;

/**
 * Assembler class to convert an examiner entity to an examiner resource.
 */
public class ExaminerResourceFromEntityAssembler {
    public static ExaminerResource toResourceFromEntity(Examiner entity) {
        return new ExaminerResource(
                entity.getId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getNationalProviderIdentifier().getValue().toString()
        );
    }
}
