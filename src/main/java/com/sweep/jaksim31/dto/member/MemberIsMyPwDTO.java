package com.sweep.jaksim31.dto.member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberIsMyPwDTO {
    private String email;
    private String password;
}