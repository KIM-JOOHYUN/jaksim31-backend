package com.sweep.jaksim31.dto.tokakao;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * packageName :  com.sweep.jaksim31.dto.tokakao
 * fileName : TranslationRequest
 * author :  방근호
 * date : 2023-01-13
 * description : 카카오 문장 번역 api 호출을 위한 dto
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-01-13           방근호             최초 생성
 *
 */
@Getter
@Setter
@RequiredArgsConstructor
public class TranslationRequest {

    private String q;
    private String source_lang = "ko";
    private String target_lang = "en";

}
