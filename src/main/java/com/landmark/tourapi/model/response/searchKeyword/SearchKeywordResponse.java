package com.landmark.tourapi.model.response.searchKeyword;

import com.landmark.tourapi.model.response.Header;
import com.landmark.tourapi.model.response.PageInfo;
import lombok.Data;

import java.util.List;

@Data
public class SearchKeywordResponse {

    private Header header;
    private List<SearchKeyword> searchKeyword;
    private PageInfo pageInfo;

}
