package com.landmark.tourapi.model.area;

import com.landmark.tourapi.model.DefaultInfo;
import com.landmark.tourapi.utils.ParamChecker;
import lombok.Data;

@Data
public class AreaBasedListRequest {

    private DefaultInfo defaultInfo;
    private String listYN;      // 목록 구분
    private String arrange;     // 정렬 구분
    private int contentTypeId;  // 관광타입 id
    private int areaCode;       // 지역코드
    private int sigunguCode;    // 시군구코드
    private String cat1;        // 대분류
    private String cat2;        // 중분류
    private String cat3;        // 소분류

    @Override
    public String toString() {
        String params = defaultInfo.toString();

        params = ParamChecker.checkBasedList(params, listYN, arrange, contentTypeId);
        params = ParamChecker.checkAreaAndSigungu(params, areaCode, sigunguCode);
        params = ParamChecker.checkCat(params, cat1, cat2, cat3);

        return params;
    }
}
