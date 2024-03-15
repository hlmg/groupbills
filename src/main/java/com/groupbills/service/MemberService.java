package com.groupbills.service;

import com.groupbills.dto.MemberLoginRequest;
import com.groupbills.dto.MemberResponse;
import com.groupbills.dto.MemberSignupRequest;
import com.groupbills.model.Member;
import com.groupbills.repository.MemberRepository;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public void signup(MemberSignupRequest signupRequest) {
        Member member = Member.builder()
                .loginId(signupRequest.loginId())
                .password(signupRequest.password())
                .name(signupRequest.name())
                .build();
        memberRepository.save(member);
    }

    public List<MemberResponse> findAll() {
        return memberRepository.findAll().stream().map(MemberResponse::from).toList();
    }

    public Member login(MemberLoginRequest loginRequest) {
        return memberRepository.findByLoginId(loginRequest.loginId())
                .filter(m -> m.getPassword().equals(loginRequest.password()))
                .orElseThrow(() -> new IllegalArgumentException("Login failed"));
    }
}
