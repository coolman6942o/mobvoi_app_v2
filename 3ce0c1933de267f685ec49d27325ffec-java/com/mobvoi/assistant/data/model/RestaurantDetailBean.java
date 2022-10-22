package com.mobvoi.assistant.data.model;

import com.mobvoi.android.common.json.JsonBean;
import com.mobvoi.wear.ble.BleProtocol;
import com.mobvoi.wear.common.base.WearPath;
import com.mobvoi.wear.contacts.ContactConstant;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import com.mobvoi.wear.util.TelephonyUtil;
import h8.c;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes2.dex */
public class RestaurantDetailBean implements JsonBean, Serializable {
    @c("8684_id")
    public String _8684Id;
    @c("address")
    public String address;
    @c("ali_lat")
    public double aliLat;
    @c("ali_lng")
    public double aliLng;
    @c("baidu_lat")
    public double baiduLat;
    @c("baidu_lng")
    public double baiduLng;
    @c("coupon")
    public a coupon;
    @c("deal")
    public b deal;
    @c("detail_url")
    public String detailUrl;
    @c("discount")
    public int discount;
    @c("dp_category")
    public String dpCategory;
    @c("dp_id")
    public String dpId;
    @c("dp_url")
    public String dpUrl;
    @c("has_online_reservation")
    public boolean hasOnlineReservation;
    @c("has_shanhui")
    public boolean hasShanhui;
    @c("id")

    /* renamed from: id  reason: collision with root package name */
    public String f15723id;
    @c(SharedWearInfoHelper.LocationInfo.KEY_LAT)
    public double lat;
    @c(SharedWearInfoHelper.LocationInfo.KEY_LNG)
    public double lng;
    @c("main_tag")
    public String mainTag;
    @c("mobvoi_category_1")
    public String mobvoiCategory1;
    @c("mobvoi_category_2")
    public String mobvoiCategory2;
    @c("mobvoi_category_3")
    public String mobvoiCategory3;
    @c("my_distance")
    public double myDistance;
    @c("my_lat")
    public int myLat;
    @c("my_lng")
    public int myLng;
    @c(ContactConstant.CallsRecordKeys.NAME)
    public String name;
    @c("online_reservation_url")
    public String onlineReservationUrl;
    @c("opening_time")
    public String openingTime;
    @c("parking")
    public String parking;
    @c(SharedWearInfoHelper.PhoneInfo.TABLE)
    public String phone;
    @c("photo_url")
    public String photoUrl;
    @c("popular_dishes")
    public String popularDishes;
    @c("price")
    public String price;
    @c(BleProtocol.PRIORITY)
    public int priority;
    @c(WearPath.MediaControls.CONTROLL_RATING)
    public float rating;
    @c("rating_count")
    public int ratingCount;
    @c("reviews")
    public List<Object> reviews;
    @c("secondary_tag")
    public String secondaryTag;
    @c("shanhui_title")
    public String shanhuiTitle;
    @c("small_photo_url")
    public String smallPhotoUrl;
    @c(TelephonyUtil.KEY_SIM_ACTIVITIED_SOURCE)
    public String source;
    @c("specialties")
    public String specialties;
    @c("third_tag")
    public String thirdTag;
    @c("traffic")
    public String traffic;

    /* loaded from: classes2.dex */
    public static class a {
        @c("coupon_id")

        /* renamed from: a  reason: collision with root package name */
        public String f15724a;
        @c("coupon_description")

        /* renamed from: b  reason: collision with root package name */
        public String f15725b;
        @c("coupon_url")

        /* renamed from: c  reason: collision with root package name */
        public String f15726c;
    }

    /* loaded from: classes2.dex */
    public static class b {
        @c("deal_count")

        /* renamed from: a  reason: collision with root package name */
        public int f15727a;
        @c("deals")

        /* renamed from: b  reason: collision with root package name */
        public List<Object> f15728b;
    }
}
