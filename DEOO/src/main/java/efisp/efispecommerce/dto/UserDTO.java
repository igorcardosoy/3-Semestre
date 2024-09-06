package efisp.efispecommerce.dto;

import java.util.UUID;

/**
 * @param id User's id
 * @param name User's name
 * @param email User's email
 * @param password User's password
 */
public record UserDTO(UUID id, String name, String email, String password, String photo) {
}