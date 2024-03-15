package com.groupbills.controller;

import com.groupbills.dto.MemberLoginRequest;
import com.groupbills.dto.MemberResponse;
import com.groupbills.dto.MemberSignupRequest;
import com.groupbills.model.Member;
import com.groupbills.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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

    @PostMapping("/login")
    public void login(@RequestBody MemberLoginRequest loginRequest, HttpServletRequest request) {
        Member loginMember = memberService.login(loginRequest);

        HttpSession session = request.getSession();
        session.setAttribute("loginMemberId", loginMember.getLoginId());
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request) {
        request.getSession().invalidate();
    }
}
