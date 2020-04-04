package com.landmark.tourapi.model.category;

import com.landmark.tourapi.model.DefaultInfo;
import com.landmark.tourapi.utils.ParamChecker;
import lombok.Data;

@Data
public class CategoryCodeRequest {

    private DefaultInfo defaultInfo;
    private int contentTypeId;  // 관광타입 id
    private String cat1;        // 대분류
    private String cat2;        // 중분류
    private String cat3;        // 소분류

    @Override
    public String toString() {
        String params = defaultInfo.toString();

        if (contentTypeId != 0) {
            params += "&contentTypeId=" + contentTypeId;
        }

        params = ParamChecker.checkCat(params, cat1, cat2, cat3);

        return params;
    }

}
