package org.hign.platform.u202012207.personnel.interfaces.rest.resources;

/**
 * Represents the resource for creating an examiner.
 */
public record CreateExaminerResource(String firstName, String lastName, String nationalProviderIdentifier) {
}
