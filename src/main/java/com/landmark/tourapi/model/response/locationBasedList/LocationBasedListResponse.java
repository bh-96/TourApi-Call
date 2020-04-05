package com.landmark.tourapi.model.response.locationBasedList;

import com.landmark.tourapi.model.response.Header;
import com.landmark.tourapi.model.response.PageInfo;
import lombok.Data;

import java.util.List;

@Data
public class LocationBasedListResponse {

    private Header header;
    private List<LocationBasedList> locationBasedList;
    private PageInfo pageInfo;

}
