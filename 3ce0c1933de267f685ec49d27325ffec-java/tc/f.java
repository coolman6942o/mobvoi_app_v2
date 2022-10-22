package tc;

import com.mobvoi.android.common.json.JsonBean;
import com.mobvoi.wear.permission.PermissionConstant;
import h8.c;
/* compiled from: SportWeekMedalResponse.kt */
/* loaded from: classes2.dex */
public final class f implements JsonBean {
    @c("obj")
    private a currentWeekSportCompleteBean;
    @c("err_code")
    private int err_code;
    @c("err_msg")
    private String err_msg = "";
    @c(PermissionConstant.Columns.STATUS)
    private String status = "";

    /* compiled from: SportWeekMedalResponse.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        @c("standardHSInMs")

        /* renamed from: a  reason: collision with root package name */
        private long f35121a;
        @c("completeHSInMs")

        /* renamed from: b  reason: collision with root package name */
        private long f35122b;
        @c("weekNum")

        /* renamed from: c  reason: collision with root package name */
        private int f35123c;

        public final long a() {
            return this.f35122b;
        }

        public final long b() {
            return this.f35121a;
        }

        public final int c() {
            return this.f35123c;
        }
    }

    public final a a() {
        return this.currentWeekSportCompleteBean;
    }

    public final int b() {
        return this.err_code;
    }
}
