package com.landmark.tourapi;

import com.landmark.tourapi.model.request.TourApiRequest;
import com.landmark.tourapi.service.TourApiService;
import org.junit.Ignore;
import org.junit.Test;

public class TourApiApplicationTests {

    @Test
    @Ignore
    public void areaCodeTest() {
        TourApiRequest tourApiRequest = new TourApiRequest();
        tourApiRequest.setAreaCode(1);
        System.out.println(TourApiService.areaCode(1, 1, tourApiRequest));
    }

    @Test
    @Ignore
    public void categoryCodeTest() {
        TourApiRequest tourApiRequest = new TourApiRequest();
        System.out.println(TourApiService.categoryCode(1, 2, tourApiRequest));
    }

    @Test
    @Ignore
    public void areaBasedListTest() {
        TourApiRequest tourApiRequest = new TourApiRequest();
        System.out.println(TourApiService.areaBasedList(1, 2, tourApiRequest));
    }

    @Test
    @Ignore
    public void locationBasedListTest() {
        TourApiRequest tourApiRequest = new TourApiRequest();
        System.out.println(TourApiService.locationBasedList(1, 2, tourApiRequest));
    }

    @Test
    @Ignore
    public void searchKeywordTest() {
        TourApiRequest tourApiRequest = new TourApiRequest();
        tourApiRequest.setKeyword("강원도");
        System.out.println(TourApiService.searchKeyword(1, 2, tourApiRequest));
    }

    @Test
    @Ignore
    public void searchFestivalTest() {
        TourApiRequest tourApiRequest = new TourApiRequest();
        tourApiRequest.setEventStartDate(20200101);
        System.out.println(TourApiService.searchFestival(1, 2, tourApiRequest));
    }

    @Test
    @Ignore
    public void searchStayTest() {
        TourApiRequest tourApiRequest = new TourApiRequest();
        tourApiRequest.setGoodStay(1);
        System.out.println(TourApiService.searchStay(1, 2, tourApiRequest));
    }

    @Test
    @Ignore
    public void detailCommonTest() {
        TourApiRequest tourApiRequest = new TourApiRequest();
        tourApiRequest.setContentId(126508);
        System.out.println(TourApiService.detailCommon(1, 2, tourApiRequest));
    }

}
