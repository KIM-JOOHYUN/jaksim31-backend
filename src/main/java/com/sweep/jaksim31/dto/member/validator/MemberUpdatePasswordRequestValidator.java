package com.sweep.jaksim31.dto.member.validator;

import com.sweep.jaksim31.dto.member.MemberUpdatePasswordRequest;
import com.sweep.jaksim31.exception.BizException;
import com.sweep.jaksim31.enums.MemberExceptionType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Objects;

/**
 * packageName :  com.sweep.jaksim31.dto.member.validator
 * fileName : MemberUpdatePasswordRequestValidator
 * author :  김주현
 * date : 2023-01-23
 * description :MemberUpdatePasswordRequest input value 유효성 검사를 위한 Validator
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-01-23              김주현             최초 생성
 */
public class MemberUpdatePasswordRequestValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(target.getClass() != MemberUpdatePasswordRequest.class){
            return;
        }
        MemberUpdatePasswordRequest request = MemberUpdatePasswordRequest.class.cast(target);
        if(Objects.isNull(request.getNewPassword())|| request.getNewPassword().length() == 0)
            throw new BizException(MemberExceptionType.NOT_FOUND_NEW_PASSWORD);

    }
}
