package com.groupbills.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class SettlementParticipant {
    private Long id;
    private Long settlementId;
    private Long memberId;

    @Builder
    private SettlementParticipant(Long settlementId, Long memberId) {
        this.settlementId = settlementId;
        this.memberId = memberId;
    }
}
