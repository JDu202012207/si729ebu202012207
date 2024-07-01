package org.hign.platform.u202012207.assessment.interfaces.rest.resources;

/**
 * Represents the resource for creating a mental state exam.
 */
public record CreateMentalStateExamResource(
        Long patientId,
        String examinerNationalProviderIdentifier,
        String examDate,
        Integer orientationScore,
        Integer registrationScore,
        Integer attentionAndCalculationScore,
        Integer recallScore,
        Integer languageScore
) {
}
