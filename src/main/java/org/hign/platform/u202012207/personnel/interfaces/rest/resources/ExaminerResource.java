package org.hign.platform.u202012207.personnel.interfaces.rest.resources;

/**
 * Represents the resource for an examiner.
 */
public record ExaminerResource(Long id, String firstName, String lastName, String nationalProviderIdentifier) {
}
