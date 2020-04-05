package com.landmark.tourapi.utils;

public class Constants {

    public static final String END_POINT = "http://api.visitkorea.or.kr/openapi/service/rest/KorService";

    public static final String AREA_CODE_API            = END_POINT + "/areaCode?";             // 지역코드 조회
    public static final String CATEGORY_CODE_API        = END_POINT + "/categoryCode?";         // 서비스 분류코드 조회
    public static final String AREA_BASED_LIST_API      = END_POINT + "/areaBasedList?";        // 지역기반 관광정보 조회
    public static final String LOCATION_BASED_LIST_API  = END_POINT + "/locationBasedList?";    // 위치기반 관광정보 조회
    public static final String SEARCH_KEYWORD_API       = END_POINT + "/searchKeyword?";        // 키워드 검색 조회
    public static final String SEARCH_RESTIVAL_API      = END_POINT + "/searchFestival?";       // 행사정보 조회
    public static final String SEARCH_STAY_API          = END_POINT + "/searchStay?";           // 숙박정보 조회
    public static final String DETAIL_COMMON_API        = END_POINT + "/detailCommon?";         // 공통정보 조회 (상세정보1)
    public static final String DETAIL_INTRO_API         = END_POINT + "/detailIntro?";          // 소개정보 조회 (상세정보2)
    public static final String DETAIL_INFO_API          = END_POINT + "/detailInfo?";           // 반복정보 조회 (상세정보3)
    public static final String DETAIL_IMAGE_API         = END_POINT + "/detailImage?";          // 이미지정보 조회 (상세정보4)

    // ContentTypeId 관광타입 id
    public static final int CONTENT_TYPE_LANDMARK   = 12;
    public static final int CONTENT_TYPE_CULTURE    = 14;
    public static final int CONTENT_TYPE_FESTIVAL   = 15;
    public static final int CONTENT_TYPE_TOUR       = 25;
    public static final int CONTENT_TYPE_LEPORTS    = 28;
    public static final int CONTENT_TYPE_STAY       = 32;
    public static final int CONTENT_TYPE_SHOPPING   = 38;
    public static final int CONTENT_TYPE_RESTAURANT = 39;

    // listYN 목록 구분
    public static final String YN_Y = "Y";         // 목록
    public static final String YN_N = "N";         // 개수

    // arrange 정렬 구분
    public static final String ARRANGE_TITLE = "A";     // 제목순
    public static final String ARRANGE_COUNT = "B";     // 조회순
    public static final String ARRANGE_MOD_DATE = "C";  // 수정일순
    public static final String ARRANGE_REG_DATE = "D";  // 생성일순
    // 대표 이미지가 반드시 있는 정렬
    public static final String ARRANGE_IMG_TITLE = "O";     // 제목순
    public static final String ARRANGE_IMG_COUNT = "P";     // 조회순
    public static final String ARRANGE_IMG_MOD_DATE = "Q";  // 수정일순
    public static final String ARRANGE_IMG_REG_DATE = "R";  // 생성일순

}
