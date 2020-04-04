package com.landmark.tourapi.service;

import com.landmark.tourapi.model.DefaultInfo;
import com.landmark.tourapi.model.area.AreaBasedListRequest;
import com.landmark.tourapi.model.area.AreaCodeRequest;
import com.landmark.tourapi.model.category.CategoryCodeRequest;
import com.landmark.tourapi.model.location.LocationBasedListRequest;
import com.landmark.tourapi.model.search.SearchKeywordRequest;
import com.landmark.tourapi.utils.GetUrl;
import org.json.simple.JSONObject;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URLEncoder;

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

    /**
     * 지역코드 조회
     */
    public static JSONObject areaCode(int page, int size, int areaCode) {
        AreaCodeRequest areaCodeRequest = new AreaCodeRequest();
        areaCodeRequest.setDefaultInfo(getDefaultInfo(page, size));
        areaCodeRequest.setAreaCode(areaCode);
        String url = GetUrl.areaCode(areaCodeRequest);
        return response(url);
    }

    /**
     * 서비스 분류코드 조회
     */
    public static JSONObject categoryCode(int page, int size, int contentTypeId, String cat1, String cat2, String cat3) {
        CategoryCodeRequest categoryCodeRequest = new CategoryCodeRequest();
        categoryCodeRequest.setDefaultInfo(getDefaultInfo(page, size));
        categoryCodeRequest.setContentTypeId(contentTypeId);
        categoryCodeRequest.setCat1(cat1);
        categoryCodeRequest.setCat2(cat2);
        categoryCodeRequest.setCat3(cat3);
        String url = GetUrl.categoryCode(categoryCodeRequest);
        return response(url);
    }

    /**
     * 지역기반 관광정보 조회
     */
    public static JSONObject areaBasedList(int page, int size, String listYN, String arrange, int contentTypeId, int areaCode, int sigunguCode, String cat1, String cat2, String cat3) {
        AreaBasedListRequest areaBasedListRequest = new AreaBasedListRequest();
        areaBasedListRequest.setDefaultInfo(getDefaultInfo(page, size));
        areaBasedListRequest.setListYN(listYN);
        areaBasedListRequest.setArrange(arrange);
        areaBasedListRequest.setContentTypeId(contentTypeId);
        areaBasedListRequest.setSigunguCode(sigunguCode);
        areaBasedListRequest.setCat1(cat1);
        areaBasedListRequest.setCat2(cat2);
        areaBasedListRequest.setCat3(cat3);
        String url = GetUrl.areaBasedList(areaBasedListRequest);
        return response(url);
    }

    /**
     * 위치기반 관광정보 조회
     */
    public static JSONObject locationBasedList(int page, int size, String listYN, String arrange, int contentTypeId, double mapX, double mapY, int radius) {
        LocationBasedListRequest locationBasedListRequest = new LocationBasedListRequest();
        locationBasedListRequest.setDefaultInfo(getDefaultInfo(page, size));
        locationBasedListRequest.setListYN(listYN);
        locationBasedListRequest.setArrange(arrange);
        locationBasedListRequest.setContentTypeId(contentTypeId);
        locationBasedListRequest.setMapX(mapX);
        locationBasedListRequest.setMapY(mapY);
        locationBasedListRequest.setRadius(radius);
        String url = GetUrl.locationBasedList(locationBasedListRequest);
        return response(url);
    }

    /**
     * 키워드 검색 조회
     */
    public static JSONObject searchKeyword(int page, int size, String listYN, String arrange, int contentTypeId, int areaCode, int sigunguCode, String cat1, String cat2, String cat3, String keyword) throws Exception {
        SearchKeywordRequest searchKeywordRequest = new SearchKeywordRequest();
        searchKeywordRequest.setDefaultInfo(getDefaultInfo(page, size));
        searchKeywordRequest.setListYN(listYN);
        searchKeywordRequest.setArrange(arrange);
        searchKeywordRequest.setContentTypeId(contentTypeId);
        searchKeywordRequest.setAreaCode(areaCode);
        searchKeywordRequest.setSigunguCode(sigunguCode);
        searchKeywordRequest.setCat1(cat1);
        searchKeywordRequest.setCat2(cat2);
        searchKeywordRequest.setCat3(cat3);
        searchKeywordRequest.setKeyword(URLEncoder.encode(keyword, "UTF-8"));
        String url = GetUrl.searchKeyword(searchKeywordRequest);
        return response(url);
    }

    /**
     * 행사정보 조회
     */


}
