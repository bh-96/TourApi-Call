package com.landmark.tourapi.model.area;

import com.landmark.tourapi.model.DefaultInfo;
import lombok.Data;

@Data
public class AreaCodeRequest {

    private DefaultInfo defaultInfo;
    private int areaCode;   // 지역코드

    @Override
    public String toString() {
        String params = defaultInfo.toString();

        if (areaCode != 0) {
            params += "&areaCode=" + areaCode;
        }

        return params;
    }
}
