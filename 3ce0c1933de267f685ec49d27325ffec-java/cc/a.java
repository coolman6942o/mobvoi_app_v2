package cc;

import com.mobvoi.android.common.json.JsonBean;
import com.mobvoi.wear.common.base.Constants;
import com.mobvoi.wear.common.base.WearPath;
import com.mobvoi.wear.contacts.ContactConstant;
import com.mobvoi.wear.permission.PermissionConstant;
import com.mobvoi.wear.providers.AppUpdateColumn;
import com.mobvoi.wear.providers.OtaColumn;
import h8.c;
import java.util.List;
/* compiled from: MoreWatchFaceResp.kt */
/* loaded from: classes2.dex */
public final class a implements JsonBean {
    @c("apk_id")
    private int apkId;
    @c("apk_md5")
    private String apkMd5;
    @c("apk_package_name")
    private String apkPackageName;
    @c("apk_sign")
    private List<?> apkSign;
    @c("app_class")
    private String appClass;
    @c("app_from")
    private String appFrom;
    @c("app_pay_status")
    private Object appPayStatus;
    @c("banner_app")
    private boolean bannerApp;
    @c("category_id")
    private int categoryId;
    @c("category_name")
    private Object categoryName;
    @c("changelog")
    private String changelog;
    @c("cpu")
    private String cpu;
    @c("create_date")
    private int createDate;
    @c(OtaColumn.COLUMN_DESCRIPTION)
    private String description;
    @c("developer_email")
    private String developerEmail;
    @c("developer_id")
    private int developerId;
    @c("developer_name")
    private String developerName;
    @c("developer_wwid")
    private String developerWwid;
    @c("download_count")
    private int downloadCount;
    @c(WearPath.RecorderV2.MAP_KEY_FILE_SIZE)
    private int fileSize;
    @c(Constants.WatchfaceMarket.MARKET_ENTER_FROM)
    private Object from;
    @c("gray_percentage")
    private int grayPercentage;
    @c("hardware_tips")
    private Object hardwareTips;
    @c("id")

    /* renamed from: id  reason: collision with root package name */
    private int f5680id;
    @c("logo_url")
    private String logoUrl;
    @c(ContactConstant.CallsRecordKeys.NAME)
    private String name;
    @c("need_aw")
    private int needAw;
    @c("need_pay")
    private boolean needPay;
    @c("new_sort")
    private int newSort;
    @c("num_collected")
    private Object numCollected;
    @c("order")
    private int order;
    @c("price")
    private Float price;
    @c("rank_score")
    private String rankScore;
    @c("score")
    private String score;
    @c("second_category_id")
    private int secondCategoryId;
    @c("show_in_phone_appstore")
    private boolean showInPhoneAppstore;
    @c("show_in_wear_appstore")
    private boolean showInWearAppstore;
    @c("snapshot_url_list")
    private List<String> snapshotUrlList;
    @c(PermissionConstant.Columns.STATUS)
    private String status;
    @c("style")
    private Object style;
    @c("subtitle_content")
    private Object subtitleContent;
    @c("summary")
    private String summary;
    @c("support_api_level")
    private String supportApiLevel;
    @c("support_hardware")
    private Object supportHardware;
    @c("third_category_id")
    private int thirdCategoryId;
    @c("thumbnail_url")
    private String thumbnailUrl;
    @c("two_weeks_download_times")
    private int twoWeeksDownloadTimes;
    @c("update_time")
    private int updateTime;
    @c("version")
    private String version;
    @c(AppUpdateColumn.VERSION_CODE)
    private int versionCode;
    @c("wear_apk_md5")
    private String wearApkMd5;
    @c("wear_apk_sign")
    private List<?> wearApkSign;
    @c("wear_file_size")
    private int wearFileSize;
    @c("wear_standalone")
    private int wearStandalone;
    @c("wear_version_code")
    private int wearVersionCode;
    @c("wear_version_name")
    private String wearVersionName;

    public final String a() {
        return this.apkPackageName;
    }

    public final String b() {
        return this.description;
    }

    public final String c() {
        return this.developerName;
    }

    public final String d() {
        return this.logoUrl;
    }

    public final String e() {
        return this.name;
    }

    public final boolean f() {
        return this.needPay;
    }

    public final Float g() {
        return this.price;
    }

    public final List<String> h() {
        return this.snapshotUrlList;
    }

    public final String i() {
        return this.thumbnailUrl;
    }
}
