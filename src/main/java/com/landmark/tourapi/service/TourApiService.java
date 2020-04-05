package com.landmark.tourapi.service;

import com.landmark.tourapi.model.DefaultInfo;
import com.landmark.tourapi.model.request.TourApiRequest;
import com.landmark.tourapi.model.response.areaBasedList.AreaBasedListResponse;
import com.landmark.tourapi.model.response.areaCode.AreaCodeResponse;
import com.landmark.tourapi.model.response.categoryCode.CategoryCodeResponse;
import com.landmark.tourapi.model.response.detailCommon.DetailCommonResponse;
import com.landmark.tourapi.model.response.locationBasedList.LocationBasedListResponse;
import com.landmark.tourapi.model.response.searchFestival.SearchFestivalResponse;
import com.landmark.tourapi.model.response.searchKeyword.SearchKeywordResponse;
import com.landmark.tourapi.model.response.searchStay.SearchStayResponse;
import com.landmark.tourapi.utils.Converter;
import org.json.simple.JSONObject;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

import static com.landmark.tourapi.utils.Constants.*;

public class TourApiService {

    // tourAPI 호출
    private static JSONObject response(String url) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.getForObject(URI.create(url), JSONObject.class);
        } catch (Exception e) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("url", url);
            jsonObject.put("errMsg", e.getMessage());
            return jsonObject;
        }
    }

    // default 정보 세팅
    private static DefaultInfo getDefaultInfo(int page, int size) {
        DefaultInfo defaultInfo = new DefaultInfo();
        defaultInfo.setPageNo(page);
        defaultInfo.setNumOfRows(size);
        return defaultInfo;
    }

    // 호출할 url 생성
    private static String getUrl(String api, TourApiRequest tourApiRequest) {
        String url = api + tourApiRequest.toString();
        return url;
    }

    /**
     * 지역코드 조회
     */
    public static AreaCodeResponse areaCode(int page, int size, TourApiRequest tourApiRequest) {
        tourApiRequest.setDefaultInfo(getDefaultInfo(page, size));
        JSONObject jsonObject = response(getUrl(AREA_CODE_API, tourApiRequest));
        return Converter.areaCodeResponse(jsonObject);
    }

    /**
     * 서비스 분류코드 조회
     */
    public static CategoryCodeResponse categoryCode(int page, int size, TourApiRequest tourApiRequest) {
        tourApiRequest.setDefaultInfo(getDefaultInfo(page, size));
        JSONObject jsonObject = response(getUrl(CATEGORY_CODE_API, tourApiRequest));
        return Converter.categoryCodeResponse(jsonObject);
    }

    /**
     * 지역기반 관광정보 조회
     */
    public static AreaBasedListResponse areaBasedList(int page, int size, TourApiRequest tourApiRequest) {
        tourApiRequest.setDefaultInfo(getDefaultInfo(page, size));
        JSONObject jsonObject = response(getUrl(AREA_BASED_LIST_API, tourApiRequest));
        return Converter.areaBasedListResponse(jsonObject);
    }

    /**
     * 위치기반 관광정보 조회
     */
    public static LocationBasedListResponse locationBasedList(int page, int size, TourApiRequest tourApiRequest) {
        tourApiRequest.setDefaultInfo(getDefaultInfo(page, size));
        JSONObject jsonObject = response(getUrl(LOCATION_BASED_LIST_API, tourApiRequest));
        return Converter.locationBasedListResponse(jsonObject);
    }

    /**
     * 키워드 검색 조회
     */
    public static SearchKeywordResponse searchKeyword(int page, int size, TourApiRequest tourApiRequest) {
        tourApiRequest.setDefaultInfo(getDefaultInfo(page, size));
        JSONObject jsonObject = response(getUrl(SEARCH_KEYWORD_API, tourApiRequest));
        return Converter.searchKeywordResponse(jsonObject);
    }

    /**
     * 행사정보 조회
     */
    public static SearchFestivalResponse searchFestival(int page, int size, TourApiRequest tourApiRequest) {
        tourApiRequest.setDefaultInfo(getDefaultInfo(page, size));
        JSONObject jsonObject = response(getUrl(SEARCH_RESTIVAL_API, tourApiRequest));
        return Converter.searchFestivalResponse(jsonObject);
    }

    /**
     * 숙박정보 조회
     */
    public static SearchStayResponse searchStay(int page, int size, TourApiRequest tourApiRequest) {
        tourApiRequest.setDefaultInfo(getDefaultInfo(page, size));
        JSONObject jsonObject = response(getUrl(SEARCH_STAY_API, tourApiRequest));
        return Converter.searchStayResponse(jsonObject);
    }

    /**
     * 공통정보 조회
     */
    public static DetailCommonResponse detailCommon(int page, int size, TourApiRequest tourApiRequest) {
        tourApiRequest.setDefaultInfo(getDefaultInfo(page, size));
        JSONObject jsonObject = response(getUrl(DETAIL_COMMON_API, tourApiRequest));
        return Converter.detailCommonResponse(jsonObject);
    }

    /**
     * 소개정보 조회
     */
    public static JSONObject detailIntro(int page, int size, TourApiRequest tourApiRequest) {
        tourApiRequest.setDefaultInfo(getDefaultInfo(page, size));
        return response(getUrl(DETAIL_INTRO_API, tourApiRequest));
    }

    /**
     * 반복정보 조회
     */
    public static JSONObject detailInfo(int page, int size, TourApiRequest tourApiRequest) {
        tourApiRequest.setDefaultInfo(getDefaultInfo(page, size));
        return response(getUrl(DETAIL_INFO_API, tourApiRequest));
    }

    /**
     * 이미지정보 조회
     */
    public static JSONObject detailImage(int page, int size, TourApiRequest tourApiRequest) {
        tourApiRequest.setDefaultInfo(getDefaultInfo(page, size));
        return response(getUrl(DETAIL_IMAGE_API, tourApiRequest));
    }
}
