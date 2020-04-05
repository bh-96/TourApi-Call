package com.landmark.tourapi.model.response.areaBasedList;

import com.landmark.tourapi.model.response.Header;
import com.landmark.tourapi.model.response.PageInfo;
import lombok.Data;

import java.util.List;

@Data
public class AreaBasedListResponse {

    private Header header;
    private List<AreaBasedList> areaBasedList;
    private PageInfo pageInfo;

}
