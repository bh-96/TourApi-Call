package com.landmark.tourapi.model.response.areaCode;

import com.landmark.tourapi.model.response.Header;
import com.landmark.tourapi.model.response.PageInfo;
import lombok.Data;

import java.util.List;

@Data
public class AreaCodeResponse {

    private Header header;
    private List<AreaCode> areaCode;
    private PageInfo pageInfo;

}
