package com.landmark.tourapi.model.response.searchFestival;

import com.landmark.tourapi.model.response.Header;
import com.landmark.tourapi.model.response.PageInfo;
import lombok.Data;

import java.util.List;

@Data
public class SearchFestivalResponse {

    private Header header;
    private List<SearchFestival> searchFestival;
    private PageInfo pageInfo;

}
