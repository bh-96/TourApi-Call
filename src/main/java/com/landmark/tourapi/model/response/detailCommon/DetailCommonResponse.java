package com.landmark.tourapi.model.response.detailCommon;

import com.landmark.tourapi.model.response.Header;
import com.landmark.tourapi.model.response.PageInfo;
import lombok.Data;

import java.util.List;

@Data
public class DetailCommonResponse {

    private Header header;
    private List<DetailCommon> detailCommon;
    private PageInfo pageInfo;

}
