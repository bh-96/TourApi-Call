package com.landmark.tourapi;

import com.landmark.tourapi.service.TourApiService;
import org.junit.Ignore;
import org.junit.Test;

import static com.landmark.tourapi.utils.Constants.*;

public class TourApiApplicationTests {

    @Test
    @Ignore
    public void areaCodeTest() {
        System.out.println(TourApiService.areaCode(1, 10, 1));
    }

    @Test
    @Ignore
    public void categoryCodeTest() {
        System.out.println(TourApiService.categoryCode(1, 10, 12, null, null, null));
    }

    @Test
    @Ignore
    public void areaBasedListTest() {
        System.out.println(TourApiService.areaBasedList(1, 10, LIST_YN_Y, ARRANGE_COUNT, 0, 0, 0, null, null, null));
    }

    @Test
    @Ignore
    public void locationBasedListTest() {
        System.out.println(TourApiService.locationBasedList(1, 10, LIST_YN_Y, ARRANGE_COUNT, 0, 126.981611, 37.568477, 138));
    }

    @Test
    @Ignore
    public void searchKeywordTest() throws Exception {
        System.out.println(TourApiService.searchKeyword(1, 10, LIST_YN_Y, ARRANGE_COUNT, 0, 0, 0, null, null, null, "강원"));
    }

}
