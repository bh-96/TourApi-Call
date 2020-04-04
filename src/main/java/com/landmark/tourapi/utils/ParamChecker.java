package com.landmark.tourapi.utils;

public class ParamChecker {

    public static String checkBasedList(String params, String listYN, String arrange, int contentTypeId) {
        if (listYN != null && !listYN.equals("")) {
            params += "&listYN=" + listYN;
        }

        if (arrange != null && !arrange.equals("")) {
            params += "&arrange=" + arrange;
        }

        if (contentTypeId != 0) {
            params += "&contentTypeId=" + contentTypeId;
        }

        return params;
    }

    public static String checkCat(String params, String cat1, String cat2, String cat3) {
        if (cat1 != null && !cat1.equals("")) {
            params += "&cat1=" + cat1;

            if (cat2 != null && !cat2.equals("")) {
                params += "&cat2=" + cat2;

                if (cat3 != null && !cat3.equals("")) {
                    params += "&cat3=" + cat3;
                }
            }
        }

        return params;
    }

    public static String checkAreaAndSigungu(String params, int areaCode, int sigunguCode) {
        if (areaCode != 0) {
            params += "&areaCode=" + areaCode;

            if (sigunguCode != 0) {
                params += "&sigunguCode=" + sigunguCode;
            }
        }

        return params;
    }
}
