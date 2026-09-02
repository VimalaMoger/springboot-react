package ecom.e_store.service;

import ecom.e_store.dto.ProfileRequestDto;
import ecom.e_store.dto.ProfileResponseDto;


public interface ProfileService {
    ProfileResponseDto getProfile();

    ProfileResponseDto updateProfile(ProfileRequestDto profileRequestDto);
}
