package com.sparta.gathering.common.response;

import lombok.Getter;

@Getter
public enum ApiResponseEnum {

    // 유저 관련
    SIGNUP_SUCCESS("회원가입이 완료되었습니다. 로그인 화면으로 이동합니다."),
    USER_DELETED_SUCCESS("회원 탈퇴가 완료되었습니다. 이용해 주셔서 감사합니다."),
    // 카테고리 관련
    CREATED_CATEGORY_SUCCESS("카테고리가 성공적으로 생성되었습니다."),
    DELETED_CATEGORY_SUCCESS("카테고리가 성공적으로 삭제되었습니다."),
    UPDATE_CATEGORY_SUCCESS("카테고리가 성공적으로 수정되었습니다."),
    GET_CATEGORY_SUCCESS("카테고리가 성공적으로 조회되었습니다."),

    // 해시태그 관련
    CREATED_HASHTAG_SUCCESS("해시태그가 성공적으로 생성되었습니다."),
    DELETED_HASHTAG_SUCCESS("해시태그가 성공적으로 삭제되었습니다."),
    GET_HASHTAG_SUCCESS("해시태그가 성공적으로 조회되었습니다."),


    //gather 관련
    GATHER_CREATE_SUCCESS("생성 성공"),
    GATHER_DELETE_SUCCESS("삭제 완료"),

    //멤버 관련
    CREATE_SUCCESS("멤버 생성에 성공하였습니다."),
    APPROVAL_SUCCESS("승인이 완료되었습니다."),
    REFUSAL_SUCCESS("가입이 거절되었습니다."),
    WITHDRAWAL_SUCCESS("모임탈퇴가 완료되었습니다.");

    private final String message;

    ApiResponseEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
