package com.huawei.hms.scankit.p;

import android.util.SparseArray;
import com.huawei.hms.ml.scan.HmsScan;
/* compiled from: HaLog.java */
/* loaded from: classes2.dex */
class Na extends SparseArray<String> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public Na() {
        put(HmsScan.ARTICLE_NUMBER_FORM, "ARTICLE_NUMBER");
        put(HmsScan.EMAIL_CONTENT_FORM, "EMAIL_CONTENT");
        put(HmsScan.TEL_PHONE_NUMBER_FORM, "TEL_PHONE_NUMBER");
        put(HmsScan.PURE_TEXT_FORM, "PURE_TEXT");
        put(HmsScan.SMS_FORM, "SMS");
        put(HmsScan.URL_FORM, "URL");
        put(HmsScan.WIFI_CONNECT_INFO_FORM, "WIFI_CONNECT_INFO");
        put(HmsScan.EVENT_INFO_FORM, "EVENT_INFO");
        put(HmsScan.CONTACT_DETAIL_FORM, "CONTACT_DETAIL");
        put(HmsScan.DRIVER_INFO_FORM, "DRIVER_INFO");
        put(HmsScan.LOCATION_COORDINATE_FORM, "LOCATION_COORDINATE");
        put(HmsScan.ISBN_NUMBER_FORM, "ISBN_NUMBER");
        put(-1, Za.f14723b);
    }
}
