package com.landmark.tourapi.model.response.searchStay;

import com.landmark.tourapi.model.response.Header;
import com.landmark.tourapi.model.response.PageInfo;
import lombok.Data;

import java.util.List;

@Data
public class SearchStayResponse {

    private Header header;
    private List<SearchStay> searchStay;
    private PageInfo pageInfo;

}
