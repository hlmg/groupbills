package com.groupbills.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Expense {
    private Long id;
    private Long settlementId;
    private Long payerMemberId;
    private String name;
    private BigDecimal amount;
    private LocalDateTime expenseDateTime;

    @Builder
    private Expense(Long settlementId, Long payerMemberId, String name, BigDecimal amount,
                    LocalDateTime expenseDateTime) {
        this.settlementId = settlementId;
        this.payerMemberId = payerMemberId;
        this.name = name;
        this.amount = amount;
        this.expenseDateTime = expenseDateTime;
    }
}
