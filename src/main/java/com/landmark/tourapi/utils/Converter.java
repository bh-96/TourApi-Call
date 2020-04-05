package com.landmark.tourapi.utils;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.landmark.tourapi.model.response.areaBasedList.AreaBasedList;
import com.landmark.tourapi.model.response.areaBasedList.AreaBasedListResponse;
import com.landmark.tourapi.model.response.areaCode.AreaCode;
import com.landmark.tourapi.model.response.areaCode.AreaCodeResponse;
import com.landmark.tourapi.model.response.Header;
import com.landmark.tourapi.model.response.PageInfo;
import com.landmark.tourapi.model.response.categoryCode.CategoryCode;
import com.landmark.tourapi.model.response.categoryCode.CategoryCodeResponse;
import com.landmark.tourapi.model.response.detailCommon.DetailCommon;
import com.landmark.tourapi.model.response.detailCommon.DetailCommonResponse;
import com.landmark.tourapi.model.response.locationBasedList.LocationBasedList;
import com.landmark.tourapi.model.response.locationBasedList.LocationBasedListResponse;
import com.landmark.tourapi.model.response.searchFestival.SearchFestival;
import com.landmark.tourapi.model.response.searchFestival.SearchFestivalResponse;
import com.landmark.tourapi.model.response.searchKeyword.SearchKeyword;
import com.landmark.tourapi.model.response.searchKeyword.SearchKeywordResponse;
import com.landmark.tourapi.model.response.searchStay.SearchStay;
import com.landmark.tourapi.model.response.searchStay.SearchStayResponse;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Converter {

    private static ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper().configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        return objectMapper;
    }

    // header map to dto
    private static Header getHeader(LinkedHashMap<String, Object> header, ObjectMapper objectMapper) {
        Header resp = objectMapper.convertValue(header, Header.class);
        return resp;
    }

    // pageInfo map to dto
    private static PageInfo getPageInfo(LinkedHashMap<String, Object> pageInfo, ObjectMapper objectMapper) {
        PageInfo resp = objectMapper.convertValue(pageInfo, PageInfo.class);
        return resp;
    }

    // header, pageInfo, item setting
    private static JSONObject getDefaultInfo(LinkedHashMap<String, Object> response, ObjectMapper objectMapper) {
        JSONObject jsonObject = new JSONObject();

        try {
            LinkedHashMap<String, Object> headerMap = (LinkedHashMap) response.get("header");
            Header header = getHeader(headerMap, objectMapper);
            jsonObject.put("header", header);

            LinkedHashMap<String, Object> bodyMap = (LinkedHashMap) response.get("body");

            if (!bodyMap.get("items").getClass().equals(String.class)) {
                LinkedHashMap<String, Object> items = (LinkedHashMap) bodyMap.get("items");

                if (items.get("item").getClass().equals(LinkedHashMap.class)) {
                    LinkedHashMap<String, Object> item = (LinkedHashMap) items.get("item");
                    jsonObject.put("item", item);
                } else {
                    List<LinkedHashMap<String, Object>> item = (ArrayList) items.get("item");
                    jsonObject.put("item", item);
                }
            }

            bodyMap.remove("items");
            PageInfo pageInfo = getPageInfo(bodyMap, objectMapper);
            jsonObject.put("pageInfo", pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonObject;
    }

    /** 지역코드 조회 응답 */
    public static AreaCodeResponse areaCodeResponse(JSONObject jsonObject) {
        AreaCodeResponse areaCodeResponse = new AreaCodeResponse();

        try {
            ObjectMapper objectMapper = objectMapper();
            LinkedHashMap<String, Object> response = (LinkedHashMap) jsonObject.get("response");
            JSONObject data = getDefaultInfo(response, objectMapper);

            Header header = (Header) data.get("header");
            areaCodeResponse.setHeader(header);

            PageInfo pageInfo = (PageInfo) data.get("pageInfo");
            areaCodeResponse.setPageInfo(pageInfo);

            List<AreaCode> areaCodes = new ArrayList<>();

            Object item = data.get("item");

            if (item != null) {
                if (item.getClass().equals(LinkedHashMap.class)) {
                    AreaCode areaCode = objectMapper.convertValue(item, AreaCode.class);
                    areaCodes.add(areaCode);
                } else {
                    for (Object obj : (ArrayList) item) {
                        AreaCode areaCode = objectMapper.convertValue(obj, AreaCode.class);
                        areaCodes.add(areaCode);
                    }
                }
            }

            areaCodeResponse.setAreaCode(areaCodes);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return areaCodeResponse;
    }

    /** 서비스코드 조회 응답 */
    public static CategoryCodeResponse categoryCodeResponse(JSONObject jsonObject) {
        CategoryCodeResponse categoryCodeResponse = new CategoryCodeResponse();

        try {
            ObjectMapper objectMapper = objectMapper();
            LinkedHashMap<String, Object> response = (LinkedHashMap) jsonObject.get("response");
            JSONObject data = getDefaultInfo(response, objectMapper);

            Header header = (Header) data.get("header");
            categoryCodeResponse.setHeader(header);

            PageInfo pageInfo = (PageInfo) data.get("pageInfo");
            categoryCodeResponse.setPageInfo(pageInfo);

            List<CategoryCode> categoryCodes = new ArrayList<>();

            Object item = data.get("item");

            if (item != null) {
                if (item.getClass().equals(LinkedHashMap.class)) {
                    CategoryCode categoryCode = objectMapper.convertValue(item, CategoryCode.class);
                    categoryCodes.add(categoryCode);
                } else {
                    for (Object obj : (ArrayList) item) {
                        CategoryCode categoryCode = objectMapper.convertValue(obj, CategoryCode.class);
                        categoryCodes.add(categoryCode);
                    }
                }
            }

            categoryCodeResponse.setCategoryCode(categoryCodes);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return categoryCodeResponse;
    }

    /** 지역기반 관광정보 조회 응답 */
    public static AreaBasedListResponse areaBasedListResponse(JSONObject jsonObject) {
        AreaBasedListResponse areaBasedListResponse = new AreaBasedListResponse();

        try {
            ObjectMapper objectMapper = objectMapper();
            LinkedHashMap<String, Object> response = (LinkedHashMap) jsonObject.get("response");
            JSONObject data = getDefaultInfo(response, objectMapper);

            Header header = (Header) data.get("header");
            areaBasedListResponse.setHeader(header);

            PageInfo pageInfo = (PageInfo) data.get("pageInfo");
            areaBasedListResponse.setPageInfo(pageInfo);

            List<AreaBasedList> areaBasedLists = new ArrayList<>();

            Object item = data.get("item");

            if (item != null) {
                if (item.getClass().equals(LinkedHashMap.class)) {
                    AreaBasedList areaBasedList = objectMapper.convertValue(item, AreaBasedList.class);
                    areaBasedLists.add(areaBasedList);
                } else {
                    for (Object obj : (ArrayList) item) {
                        AreaBasedList areaBasedList = objectMapper.convertValue(obj, AreaBasedList.class);
                        areaBasedLists.add(areaBasedList);
                    }
                }
            }

            areaBasedListResponse.setAreaBasedList(areaBasedLists);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return areaBasedListResponse;
    }

    /** 위치기반 관광정보 조회 응답 */
    public static LocationBasedListResponse locationBasedListResponse(JSONObject jsonObject) {
        LocationBasedListResponse locationBasedListResponse = new LocationBasedListResponse();

        try {
            ObjectMapper objectMapper = objectMapper();
            LinkedHashMap<String, Object> response = (LinkedHashMap) jsonObject.get("response");
            JSONObject data = getDefaultInfo(response, objectMapper);

            Header header = (Header) data.get("header");
            locationBasedListResponse.setHeader(header);

            PageInfo pageInfo = (PageInfo) data.get("pageInfo");
            locationBasedListResponse.setPageInfo(pageInfo);

            List<LocationBasedList> locationBasedLists = new ArrayList<>();

            Object item = data.get("item");

            if (item != null) {
                if (item.getClass().equals(LinkedHashMap.class)) {
                    LocationBasedList locationBasedList = objectMapper.convertValue(item, LocationBasedList.class);
                    locationBasedLists.add(locationBasedList);
                } else {
                    for (Object obj : (ArrayList) item) {
                        LocationBasedList locationBasedList = objectMapper.convertValue(obj, LocationBasedList.class);
                        locationBasedLists.add(locationBasedList);
                    }
                }
            }

            locationBasedListResponse.setLocationBasedList(locationBasedLists);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return locationBasedListResponse;
    }

    /** 키워드 검색 조회 응답 */
    public static SearchKeywordResponse searchKeywordResponse(JSONObject jsonObject) {
        SearchKeywordResponse searchKeywordResponse = new SearchKeywordResponse();

        try {
            ObjectMapper objectMapper = objectMapper();
            LinkedHashMap<String, Object> response = (LinkedHashMap) jsonObject.get("response");
            JSONObject data = getDefaultInfo(response, objectMapper);

            Header header = (Header) data.get("header");
            searchKeywordResponse.setHeader(header);

            PageInfo pageInfo = (PageInfo) data.get("pageInfo");
            searchKeywordResponse.setPageInfo(pageInfo);

            List<SearchKeyword> searchKeywords = new ArrayList<>();

            Object item = data.get("item");

            if (item != null) {
                if (item.getClass().equals(LinkedHashMap.class)) {
                    SearchKeyword searchKeyword = objectMapper.convertValue(item, SearchKeyword.class);
                    searchKeywords.add(searchKeyword);
                } else {
                    for (Object obj : (ArrayList) item) {
                        SearchKeyword searchKeyword = objectMapper.convertValue(obj, SearchKeyword.class);
                        searchKeywords.add(searchKeyword);
                    }
                }
            }

            searchKeywordResponse.setSearchKeyword(searchKeywords);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return searchKeywordResponse;
    }

    /** 행사정보 검색 조회 응답 */
    public static SearchFestivalResponse searchFestivalResponse(JSONObject jsonObject) {
        SearchFestivalResponse searchFestivalResponse = new SearchFestivalResponse();

        try {
            ObjectMapper objectMapper = objectMapper();
            LinkedHashMap<String, Object> response = (LinkedHashMap) jsonObject.get("response");
            JSONObject data = getDefaultInfo(response, objectMapper);

            Header header = (Header) data.get("header");
            searchFestivalResponse.setHeader(header);

            PageInfo pageInfo = (PageInfo) data.get("pageInfo");
            searchFestivalResponse.setPageInfo(pageInfo);

            List<SearchFestival> searchFestivals = new ArrayList<>();

            Object item = data.get("item");

            if (item != null) {
                if (item.getClass().equals(LinkedHashMap.class)) {
                    SearchFestival searchFestival = objectMapper.convertValue(item, SearchFestival.class);
                    searchFestivals.add(searchFestival);
                } else {
                    for (Object obj : (ArrayList) item) {
                        SearchFestival searchFestival = objectMapper.convertValue(obj, SearchFestival.class);
                        searchFestivals.add(searchFestival);
                    }
                }
            }

            searchFestivalResponse.setSearchFestival(searchFestivals);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return searchFestivalResponse;
    }

    /** 숙박정보 조회 응답 */
    public static SearchStayResponse searchStayResponse(JSONObject jsonObject) {
        SearchStayResponse searchStayResponse = new SearchStayResponse();

        try {
            ObjectMapper objectMapper = objectMapper();
            LinkedHashMap<String, Object> response = (LinkedHashMap) jsonObject.get("response");
            JSONObject data = getDefaultInfo(response, objectMapper);

            Header header = (Header) data.get("header");
            searchStayResponse.setHeader(header);

            PageInfo pageInfo = (PageInfo) data.get("pageInfo");
            searchStayResponse.setPageInfo(pageInfo);

            List<SearchStay> searchStays = new ArrayList<>();

            Object item = data.get("item");

            if (item != null) {
                if (item.getClass().equals(LinkedHashMap.class)) {
                    SearchStay searchStay = objectMapper.convertValue(item, SearchStay.class);
                    searchStays.add(searchStay);
                } else {
                    for (Object obj : (ArrayList) item) {
                        SearchStay searchStay = objectMapper.convertValue(obj, SearchStay.class);
                        searchStays.add(searchStay);
                    }
                }
            }

            searchStayResponse.setSearchStay(searchStays);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return searchStayResponse;
    }

    /** 공통정보 조회 응답 */
    public static DetailCommonResponse detailCommonResponse(JSONObject jsonObject) {
        DetailCommonResponse detailCommonResponse = new DetailCommonResponse();

        try {
            ObjectMapper objectMapper = objectMapper();
            LinkedHashMap<String, Object> response = (LinkedHashMap) jsonObject.get("response");
            JSONObject data = getDefaultInfo(response, objectMapper);

            Header header = (Header) data.get("header");
            detailCommonResponse.setHeader(header);

            PageInfo pageInfo = (PageInfo) data.get("pageInfo");
            detailCommonResponse.setPageInfo(pageInfo);

            List<DetailCommon> detailCommons = new ArrayList<>();

            Object item = data.get("item");

            if (item != null) {
                if (item.getClass().equals(LinkedHashMap.class)) {
                    DetailCommon detailCommon = objectMapper.convertValue(item, DetailCommon.class);
                    detailCommons.add(detailCommon);
                } else {
                    for (Object obj : (ArrayList) item) {
                        DetailCommon detailCommon = objectMapper.convertValue(obj, DetailCommon.class);
                        detailCommons.add(detailCommon);
                    }
                }
            }

            detailCommonResponse.setDetailCommon(detailCommons);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return detailCommonResponse;
    }
}
