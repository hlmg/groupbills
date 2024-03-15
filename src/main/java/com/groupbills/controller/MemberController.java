package com.groupbills.controller;

import com.groupbills.dto.MemberResponse;
import com.groupbills.dto.MemberSignupRequest;
import com.groupbills.service.MemberService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/signup")
    public void singup(@RequestBody MemberSignupRequest signupRequest) {
        memberService.signup(signupRequest);
    }

    @GetMapping("/members")
    public List<MemberResponse> members() {
        return memberService.findAll();
    }
}
