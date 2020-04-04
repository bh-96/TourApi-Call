package com.landmark.tourapi.model.location;

import com.landmark.tourapi.model.DefaultInfo;
import com.landmark.tourapi.utils.ParamChecker;
import lombok.Data;

@Data
public class LocationBasedListRequest {

    private DefaultInfo defaultInfo;
    private String listYN;      // 목록 구분
    private String arrange;     // 정렬 구분
    private int contentTypeId;  // 관광타입 id
    private double mapX;        // X좌표
    private double mapY;        // Y좌표
    private int radius;         // 거리 반경

    @Override
    public String toString() {
        String params = defaultInfo.toString();

        params = ParamChecker.checkBasedList(params, listYN, arrange, contentTypeId);

        if (mapX != 0) {
            params += "&mapX=" + mapX;
        }

        if (mapY != 0) {
            params += "&mapY=" + mapY;
        }

        if (radius != 0) {
            params += "&radius=" + radius;
        }

        return params;
    }
}
