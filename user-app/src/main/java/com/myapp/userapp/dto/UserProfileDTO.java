package com.myapp.userapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public record UserProfileDTO(int profileId, String fullName) {

}
