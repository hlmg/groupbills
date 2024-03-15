package com.groupbills.dto;

public record MemberLoginRequest(
        String loginId,
        String password
) {
}
