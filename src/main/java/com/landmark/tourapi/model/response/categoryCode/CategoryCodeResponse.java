package com.landmark.tourapi.model.response.categoryCode;

import com.landmark.tourapi.model.response.Header;
import com.landmark.tourapi.model.response.PageInfo;
import lombok.Data;

import java.util.List;

@Data
public class CategoryCodeResponse {

    private Header header;
    private List<CategoryCode> categoryCode;
    private PageInfo pageInfo;

}
