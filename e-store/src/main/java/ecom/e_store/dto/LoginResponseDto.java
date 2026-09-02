package ecom.e_store.dto;

// Constructor and getter
public record LoginResponseDto(String message, UserDto userDto, String jwtToken) {
}
