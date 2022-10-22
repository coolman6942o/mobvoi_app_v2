package cc;

import com.mobvoi.android.common.json.JsonBean;
import com.mobvoi.wear.contacts.ContactConstant;
import com.mobvoi.wear.permission.PermissionConstant;
import com.mobvoi.wear.providers.OtaColumn;
import h8.c;
import java.util.List;
/* compiled from: WatchFaceCardResponse.kt */
/* loaded from: classes2.dex */
public final class f implements JsonBean {
    @c("err_code")
    private int errCode;
    @c("err_msg")
    private String errMsg;
    @c("err_msg_cn")
    private String errMsgCn;
    @c("result")
    private List<a> result;

    /* compiled from: WatchFaceCardResponse.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        @c("appCount")

        /* renamed from: a  reason: collision with root package name */
        private int f5681a;
        @c("id")

        /* renamed from: b  reason: collision with root package name */
        private int f5682b;
        @c("oversea")

        /* renamed from: c  reason: collision with root package name */
        private boolean f5683c;
        @c(PermissionConstant.Columns.STATUS)

        /* renamed from: d  reason: collision with root package name */
        private int f5684d;
        @c("title")

        /* renamed from: e  reason: collision with root package name */
        private String f5685e;
        @c("appList")

        /* renamed from: f  reason: collision with root package name */
        private List<C0082a> f5686f;
        @c("secondId")

        /* renamed from: g  reason: collision with root package name */
        private Integer f5687g = 0;

        /* compiled from: WatchFaceCardResponse.kt */
        /* renamed from: cc.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0082a {
            @c("summary")
            private String A;
            @c("third_category_id")
            private int B;
            @c("thumbnail_url")
            private String C;
            @c("update_time")
            private int D;
            @c("watchface_type")
            private String E;
            @c("wear_standalone")
            private int F;
            @c("snapshot_url_list")
            private List<String> G;
            @c(OtaColumn.COLUMN_DESCRIPTION)
            private String H;
            @c("apk_package_name")

            /* renamed from: a  reason: collision with root package name */
            private String f5688a;
            @c("category_id")

            /* renamed from: b  reason: collision with root package name */
            private int f5689b;
            @c("category_name")

            /* renamed from: c  reason: collision with root package name */
            private Object f5690c;
            @c("colllect_num")

            /* renamed from: d  reason: collision with root package name */
            private int f5691d;
            @c("create_date")

            /* renamed from: e  reason: collision with root package name */
            private int f5692e;
            @c("developer_email")

            /* renamed from: f  reason: collision with root package name */
            private String f5693f;
            @c("developer_id")

            /* renamed from: g  reason: collision with root package name */
            private int f5694g;
            @c("developer_name")

            /* renamed from: h  reason: collision with root package name */
            private String f5695h;
            @c("developer_wwid")

            /* renamed from: i  reason: collision with root package name */
            private String f5696i;
            @c("download_count")

            /* renamed from: j  reason: collision with root package name */
            private int f5697j;
            @c("download_count_fact")

            /* renamed from: k  reason: collision with root package name */
            private int f5698k;
            @c("id")

            /* renamed from: l  reason: collision with root package name */
            private int f5699l;
            @c("is_deleted")

            /* renamed from: m  reason: collision with root package name */
            private boolean f5700m;
            @c("logo_url")

            /* renamed from: n  reason: collision with root package name */
            private String f5701n;
            @c(ContactConstant.CallsRecordKeys.NAME)

            /* renamed from: o  reason: collision with root package name */
            private String f5702o;
            @c("name_en")

            /* renamed from: p  reason: collision with root package name */
            private String f5703p;
            @c("need_pay")

            /* renamed from: q  reason: collision with root package name */
            private boolean f5704q;
            @c("price")

            /* renamed from: r  reason: collision with root package name */
            private Float f5705r;
            @c("rank_score")

            /* renamed from: s  reason: collision with root package name */
            private String f5706s;
            @c("score")

            /* renamed from: t  reason: collision with root package name */
            private String f5707t;
            @c("second_category_id")

            /* renamed from: u  reason: collision with root package name */
            private int f5708u;
            @c("show_in_google_play")

            /* renamed from: v  reason: collision with root package name */
            private boolean f5709v;
            @c("show_in_phone_appstore")

            /* renamed from: w  reason: collision with root package name */
            private boolean f5710w;
            @c("show_in_wear_appstore")

            /* renamed from: x  reason: collision with root package name */
            private boolean f5711x;
            @c("show_order")

            /* renamed from: y  reason: collision with root package name */
            private int f5712y;
            @c(PermissionConstant.Columns.STATUS)

            /* renamed from: z  reason: collision with root package name */
            private String f5713z;

            public final String a() {
                return this.f5688a;
            }

            public final String b() {
                return this.H;
            }

            public final String c() {
                return this.f5695h;
            }

            public final String d() {
                return this.f5701n;
            }

            public final String e() {
                return this.f5702o;
            }

            public final boolean f() {
                return this.f5704q;
            }

            public final Float g() {
                return this.f5705r;
            }

            public final List<String> h() {
                return this.G;
            }

            public final String i() {
                return this.C;
            }
        }

        public final List<C0082a> a() {
            return this.f5686f;
        }

        public final int b() {
            return this.f5682b;
        }

        public final Integer c() {
            return this.f5687g;
        }

        public final int d() {
            return this.f5684d;
        }

        public final String e() {
            return this.f5685e;
        }
    }

    public final List<a> a() {
        return this.result;
    }
}
