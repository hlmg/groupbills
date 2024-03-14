package com.groupbills.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Settlement {
    private Long id;
    private String name;

    @Builder
    private Settlement(String name) {
        this.name = name;
    }
}
