package org.hign.platform.u202012207.assessment.interfaces.rest.transform;

import org.hign.platform.u202012207.assessment.domain.model.aggregates.MentalStateExam;
import org.hign.platform.u202012207.assessment.interfaces.rest.resources.MentalStateExamResource;

import java.text.SimpleDateFormat;

/**
 * MentalStateExamResourceFromEntityAssembler.
 * <p>
 *     This class provides methods for transforming mental state exam entities into resources.
 * </p>
 * @autor Juan Cueto u202012207
 */
public class MentalStateExamResourceFromEntityAssembler {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static MentalStateExamResource toResourceFromEntity(MentalStateExam entity) {
        return new MentalStateExamResource(
                entity.getId(),
                entity.getPatientId(),
                entity.getExaminerNationalProviderIdentifier().getValue().toString(),
                dateFormat.format(entity.getExamDate()),
                entity.getOrientationScore(),
                entity.getRegistrationScore(),
                entity.getAttentionAndCalculationScore(),
                entity.getRecallScore(),
                entity.getLanguageScore()
        );
    }
}
