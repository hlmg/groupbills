package com.groupbills.dto;

import com.groupbills.model.Member;

public record MemberResponse(
        Long id,
        String loginId,
        String name
) {
    public static MemberResponse from(Member member) {
        return new MemberResponse(member.getId(), member.getLoginId(), member.getName());
    }
}
