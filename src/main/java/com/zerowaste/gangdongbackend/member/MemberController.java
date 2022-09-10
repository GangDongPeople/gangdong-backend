package com.zerowaste.gangdongbackend.member;

import com.zerowaste.gangdongbackend.common.ZeroResBody;
import com.zerowaste.gangdongbackend.exception.MemberException;
import com.zerowaste.gangdongbackend.member.dto.MemberJoinReqDto;
import com.zerowaste.gangdongbackend.member.dto.MemberLoginReqDto;
import com.zerowaste.gangdongbackend.member.dto.MemberLoginResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/member")
@RestController
public class MemberController {

    private final MemberService memberService;

    // 회원가입
    @PostMapping("/sign-up")
    public ResponseEntity<ZeroResBody> postSignUp(@RequestBody MemberJoinReqDto reqDto) throws MemberException {
        memberService.signUp(reqDto);
        return ResponseEntity.ok(ZeroResBody.success("success"));
    }

    // 중복체크
    @GetMapping("/duplicate-check/web-id/{webId}")
    public ResponseEntity<ZeroResBody> getDuplicateCheckByWebId(@PathVariable String webId) throws MemberException {
        boolean message = memberService.duplicateCheckByWebId(webId);
        return ResponseEntity.ok(ZeroResBody.success(message));
    }

    @GetMapping("/duplicate-check/email/{email}")
    public ResponseEntity<ZeroResBody> getDuplicateCheckByEmail(@PathVariable String email) throws MemberException {
        boolean message = memberService.duplicateCheckByEmail(email);
        return ResponseEntity.ok(ZeroResBody.success(message));
    }

    @GetMapping("/duplicate-check/mobile-phone/{mobilePhone}")
    public ResponseEntity<ZeroResBody> getDuplicateCheckByMobilePhone(@PathVariable String mobilePhone) throws MemberException {
        boolean message = memberService.duplicateCheckByMobilePhone(mobilePhone);
        return ResponseEntity.ok(ZeroResBody.success(message));
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<ZeroResBody> memberLogin(@RequestBody MemberLoginReqDto reqDto) throws MemberException {
        MemberLoginResDto result = memberService.signIn(reqDto);
        return ResponseEntity.ok(ZeroResBody.success(result));
    }

}
