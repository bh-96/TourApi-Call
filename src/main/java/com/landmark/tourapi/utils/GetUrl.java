package com.landmark.tourapi.utils;

import com.landmark.tourapi.model.area.AreaBasedListRequest;
import com.landmark.tourapi.model.area.AreaCodeRequest;
import com.landmark.tourapi.model.category.CategoryCodeRequest;
import com.landmark.tourapi.model.location.LocationBasedListRequest;
import com.landmark.tourapi.model.search.SearchKeywordRequest;

import static com.landmark.tourapi.utils.Constants.*;

public class GetUrl {

    public static String areaCode(AreaCodeRequest areaCodeRequest) {
        return AREA_CODE_API + areaCodeRequest.toString();
    }

    public static String categoryCode(CategoryCodeRequest categoryCodeRequest) {
        return CATEGORY_CODE_API + categoryCodeRequest.toString();
    }

    public static String areaBasedList(AreaBasedListRequest areaBasedListRequest) {
        return AREA_BASED_LIST_API + areaBasedListRequest.toString();
    }

    public static String locationBasedList(LocationBasedListRequest locationBasedListRequest) {
        return LOCATION_BASED_LIST_API + locationBasedListRequest.toString();
    }

    public static String searchKeyword(SearchKeywordRequest searchKeywordRequest) {
        return SEARCH_KEYWORD_API + searchKeywordRequest.toString();
    }

}
