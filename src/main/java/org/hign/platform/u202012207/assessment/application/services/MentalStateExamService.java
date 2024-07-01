package org.hign.platform.u202012207.assessment.application.services;

import org.hign.platform.u202012207.assessment.domain.model.aggregates.MentalStateExam;
import org.hign.platform.u202012207.assessment.infrastructure.persistence.jpa.MentalStateExamRepository;
import org.hign.platform.u202012207.personnel.application.acl.ExaminerService;
import org.hign.platform.u202012207.shared.domain.model.valueobjects.NationalProviderIdentifier;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * MentalStateExamService.
 * <p>
 * This class provides services for managing mental state exams.
 * </p>
 * <p>
 *     The class provides the following services:
 *     <ul>
 *         <li>Add a new mental state exam</li>
 *     </ul>
 *
 * @author Juan Cueto u202012207
 */
@Service
public class MentalStateExamService {

    private final MentalStateExamRepository mentalStateExamRepository;
    private final ExaminerService examinerService;

    public MentalStateExamService(MentalStateExamRepository mentalStateExamRepository, ExaminerService examinerService) {
        this.mentalStateExamRepository = mentalStateExamRepository;
        this.examinerService = examinerService;
    }

    /**
     * Add a new mental state exam.
     *
     * @param patientId the ID of the patient
     * @param examinerNationalProviderIdentifier the national provider identifier of the examiner
     * @param examDate the date of the exam
     * @param orientationScore the orientation score
     * @param registrationScore the registration score
     * @param attentionAndCalculationScore the attention and calculation score
     * @param recallScore the recall score
     * @param languageScore the language score
     * @return the created mental state exam
     */
    public MentalStateExam addMentalStateExam(Long patientId, String examinerNationalProviderIdentifier, Date examDate, Integer orientationScore, Integer registrationScore, Integer attentionAndCalculationScore, Integer recallScore, Integer languageScore) {
        if (examDate.after(new Date())) {
            throw new IllegalArgumentException("Exam date cannot be in the future");
        }
        if (orientationScore < 0 || orientationScore > 10) {
            throw new IllegalArgumentException("Orientation score must be between 0 and 10");
        }
        if (registrationScore < 0 || registrationScore > 3) {
            throw new IllegalArgumentException("Registration score must be between 0 and 3");
        }
        if (attentionAndCalculationScore < 0 || attentionAndCalculationScore > 5) {
            throw new IllegalArgumentException("Attention and calculation score must be between 0 and 5");
        }
        if (recallScore < 0 || recallScore > 3) {
            throw new IllegalArgumentException("Recall score must be between 0 and 3");
        }
        if (languageScore < 0 || languageScore > 9) {
            throw new IllegalArgumentException("Language score must be between 0 and 9");
        }


        UUID examinerNPIUUID = UUID.fromString(examinerNationalProviderIdentifier);
        examinerService.findExaminerByNationalProviderIdentifier(examinerNPIUUID)
                .orElseThrow(() -> new IllegalArgumentException("Examiner not found"));

        NationalProviderIdentifier npi = new NationalProviderIdentifier(examinerNationalProviderIdentifier);
        MentalStateExam exam = new MentalStateExam(patientId, npi, examDate, orientationScore, registrationScore, attentionAndCalculationScore, recallScore, languageScore);
        return mentalStateExamRepository.save(exam);
    }
}


