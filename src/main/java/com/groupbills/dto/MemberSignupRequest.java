package com.groupbills.dto;

public record MemberSignupRequest(
        String loginId,
        String name,
        String password
) {
}
