package tc;

import com.mobvoi.android.common.json.JsonBean;
import com.mobvoi.wear.permission.PermissionConstant;
import h8.c;
import java.util.List;
/* compiled from: SportMonthMedalResponse.kt */
/* loaded from: classes2.dex */
public final class e implements JsonBean {
    @c("err_code")
    private int err_code;
    @c("list")
    private List<a> sportWeekOfMonthCompleteBeans;
    @c("err_msg")
    private String err_msg = "";
    @c(PermissionConstant.Columns.STATUS)
    private String status = "";

    /* compiled from: SportMonthMedalResponse.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        @c("month")

        /* renamed from: a  reason: collision with root package name */
        private String f35114a = "";
        @c("weekList")

        /* renamed from: b  reason: collision with root package name */
        private List<C0504a> f35115b;

        /* compiled from: SportMonthMedalResponse.kt */
        /* renamed from: tc.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0504a {
            @c("standardHSInMs")

            /* renamed from: a  reason: collision with root package name */
            private long f35116a;
            @c("completeHSInMs")

            /* renamed from: b  reason: collision with root package name */
            private long f35117b;
            @c("firstDate")

            /* renamed from: c  reason: collision with root package name */
            private String f35118c = "";
            @c("lastDate")

            /* renamed from: d  reason: collision with root package name */
            private String f35119d = "";
            @c("weekNum")

            /* renamed from: e  reason: collision with root package name */
            private int f35120e;

            public final long a() {
                return this.f35117b;
            }

            public final String b() {
                return this.f35118c;
            }

            public final String c() {
                return this.f35119d;
            }

            public final long d() {
                return this.f35116a;
            }

            public final int e() {
                return this.f35120e;
            }
        }

        public final String a() {
            return this.f35114a;
        }

        public final List<C0504a> b() {
            return this.f35115b;
        }
    }

    public final int a() {
        return this.err_code;
    }

    public final List<a> b() {
        return this.sportWeekOfMonthCompleteBeans;
    }
}
