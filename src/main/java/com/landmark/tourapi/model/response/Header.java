package com.landmark.tourapi.model.response;

import lombok.Data;

@Data
public class Header {

    private int resultCode;     // 결과코드
    private String resultMsg;   // 결과 메시지

}
