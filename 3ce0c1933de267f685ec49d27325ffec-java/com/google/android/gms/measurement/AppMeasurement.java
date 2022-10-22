package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import b6.i;
import com.google.android.gms.common.api.internal.f;
import com.google.android.gms.internal.measurement.d2;
import com.google.android.gms.internal.measurement.r5;
import com.google.android.gms.internal.measurement.w3;
import com.google.android.gms.internal.measurement.zzjx;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mobvoi.wear.providers.OtaColumn;
import java.util.List;
import java.util.Map;
@Keep
@Deprecated
/* loaded from: classes.dex */
public class AppMeasurement {
    public static final String CRASH_ORIGIN = "crash";
    public static final String FCM_ORIGIN = "fcm";
    private final d2 zzacw;

    /* loaded from: classes.dex */
    public static class ConditionalUserProperty {
        @Keep
        public boolean mActive;
        @Keep
        public String mAppId;
        @Keep
        public long mCreationTimestamp;
        @Keep
        public String mExpiredEventName;
        @Keep
        public Bundle mExpiredEventParams;
        @Keep
        public String mName;
        @Keep
        public String mOrigin;
        @Keep
        public long mTimeToLive;
        @Keep
        public String mTimedOutEventName;
        @Keep
        public Bundle mTimedOutEventParams;
        @Keep
        public String mTriggerEventName;
        @Keep
        public long mTriggerTimeout;
        @Keep
        public String mTriggeredEventName;
        @Keep
        public Bundle mTriggeredEventParams;
        @Keep
        public long mTriggeredTimestamp;
        @Keep
        public Object mValue;

        public ConditionalUserProperty() {
        }

        public ConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
            i.k(conditionalUserProperty);
            this.mAppId = conditionalUserProperty.mAppId;
            this.mOrigin = conditionalUserProperty.mOrigin;
            this.mCreationTimestamp = conditionalUserProperty.mCreationTimestamp;
            this.mName = conditionalUserProperty.mName;
            Object obj = conditionalUserProperty.mValue;
            if (obj != null) {
                Object t02 = r5.t0(obj);
                this.mValue = t02;
                if (t02 == null) {
                    this.mValue = conditionalUserProperty.mValue;
                }
            }
            this.mActive = conditionalUserProperty.mActive;
            this.mTriggerEventName = conditionalUserProperty.mTriggerEventName;
            this.mTriggerTimeout = conditionalUserProperty.mTriggerTimeout;
            this.mTimedOutEventName = conditionalUserProperty.mTimedOutEventName;
            if (conditionalUserProperty.mTimedOutEventParams != null) {
                this.mTimedOutEventParams = new Bundle(conditionalUserProperty.mTimedOutEventParams);
            }
            this.mTriggeredEventName = conditionalUserProperty.mTriggeredEventName;
            if (conditionalUserProperty.mTriggeredEventParams != null) {
                this.mTriggeredEventParams = new Bundle(conditionalUserProperty.mTriggeredEventParams);
            }
            this.mTriggeredTimestamp = conditionalUserProperty.mTriggeredTimestamp;
            this.mTimeToLive = conditionalUserProperty.mTimeToLive;
            this.mExpiredEventName = conditionalUserProperty.mExpiredEventName;
            if (conditionalUserProperty.mExpiredEventParams != null) {
                this.mExpiredEventParams = new Bundle(conditionalUserProperty.mExpiredEventParams);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class a extends FirebaseAnalytics.a {

        /* renamed from: a  reason: collision with root package name */
        public static final String[] f10131a = {"app_clear_data", "app_exception", "app_remove", "app_upgrade", "app_install", "app_update", "firebase_campaign", "error", "first_open", "first_visit", "in_app_purchase", "notification_dismiss", "notification_foreground", "notification_open", "notification_receive", "os_update", "session_start", "user_engagement", "ad_exposure", "adunit_exposure", "ad_query", "ad_activeview", "ad_impression", "ad_click", "ad_reward", "screen_view", "ga_extra_parameter"};

        /* renamed from: b  reason: collision with root package name */
        public static final String[] f10132b = {"_cd", "_ae", "_ui", "_ug", "_in", "_au", "_cmp", "_err", "_f", "_v", "_iap", "_nd", "_nf", "_no", "_nr", "_ou", "_s", "_e", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", "_ar", "_vs", "_ep"};

        public static String a(String str) {
            return r5.H(str, f10131a, f10132b);
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(String str, String str2, Bundle bundle, long j10);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, String str2, Bundle bundle, long j10);
    }

    /* loaded from: classes.dex */
    public static final class d extends FirebaseAnalytics.b {

        /* renamed from: a  reason: collision with root package name */
        public static final String[] f10133a = {"firebase_conversion", "engagement_time_msec", "exposure_time", "ad_event_id", "ad_unit_id", "firebase_error", "firebase_error_value", "firebase_error_length", "firebase_event_origin", "firebase_screen", "firebase_screen_class", "firebase_screen_id", "firebase_previous_screen", "firebase_previous_class", "firebase_previous_id", "message_device_time", "message_id", "message_name", "message_time", "previous_app_version", "previous_os_version", "topic", "update_with_analytics", "previous_first_open_count", "system_app", "system_app_update", "previous_install_count", "ga_event_id", "ga_extra_params_ct", "ga_group_name", "ga_list_length", "ga_index", "ga_event_name", "campaign_info_source", "deferred_analytics_collection"};

        /* renamed from: b  reason: collision with root package name */
        public static final String[] f10134b = {"_c", "_et", "_xt", "_aeid", "_ai", "_err", "_ev", "_el", "_o", "_sn", "_sc", "_si", "_pn", "_pc", "_pi", "_ndt", "_nmid", "_nmn", "_nmt", "_pv", "_po", "_nt", "_uwa", "_pfo", "_sys", "_sysu", "_pin", "_eid", "_epc", "_gn", "_ll", "_i", "_en", "_cis", "_dac"};

        public static String a(String str) {
            return r5.H(str, f10133a, f10134b);
        }
    }

    /* loaded from: classes.dex */
    public static final class e extends FirebaseAnalytics.c {

        /* renamed from: a  reason: collision with root package name */
        public static final String[] f10135a = {"firebase_last_notification", "first_open_time", "first_visit_time", "last_deep_link_referrer", "user_id", "first_open_after_install", "lifetime_user_engagement"};

        /* renamed from: b  reason: collision with root package name */
        public static final String[] f10136b = {"_ln", "_fot", "_fvt", "_ldl", "_id", "_fi", "_lte"};

        public static String a(String str) {
            return r5.H(str, f10135a, f10136b);
        }
    }

    public AppMeasurement(d2 d2Var) {
        i.k(d2Var);
        this.zzacw = d2Var;
    }

    @Keep
    @Deprecated
    public static AppMeasurement getInstance(Context context) {
        return d2.t0(context).y0();
    }

    @Keep
    public void beginAdUnitExposure(String str) {
        this.zzacw.n0().t(str);
    }

    @Keep
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        this.zzacw.o0().z(str, str2, bundle);
    }

    @Keep
    protected void clearConditionalUserPropertyAs(String str, String str2, String str3, Bundle bundle) {
        this.zzacw.o0().A(str, str2, str3, bundle);
    }

    @Keep
    public void endAdUnitExposure(String str) {
        this.zzacw.n0().u(str);
    }

    @Keep
    public long generateEventId() {
        return this.zzacw.K().x0();
    }

    @Keep
    public String getAppInstanceId() {
        return this.zzacw.o0().p0();
    }

    public Boolean getBoolean() {
        return this.zzacw.o0().q0();
    }

    @Keep
    public List<ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        return this.zzacw.o0().C(str, str2);
    }

    @Keep
    protected List<ConditionalUserProperty> getConditionalUserPropertiesAs(String str, String str2, String str3) {
        return this.zzacw.o0().D(str, str2, str3);
    }

    @Keep
    public String getCurrentScreenClass() {
        w3 N = this.zzacw.r0().N();
        if (N != null) {
            return N.f9773b;
        }
        return null;
    }

    @Keep
    public String getCurrentScreenName() {
        w3 N = this.zzacw.r0().N();
        if (N != null) {
            return N.f9772a;
        }
        return null;
    }

    public Double getDouble() {
        return this.zzacw.o0().t0();
    }

    @Keep
    public String getGmpAppId() {
        try {
            return f.b();
        } catch (IllegalStateException e10) {
            this.zzacw.c().K().d("getGoogleAppId failed with exception", e10);
            return null;
        }
    }

    public Integer getInteger() {
        return this.zzacw.o0().s0();
    }

    public Long getLong() {
        return this.zzacw.o0().r0();
    }

    @Keep
    public int getMaxUserProperties(String str) {
        this.zzacw.o0();
        i.g(str);
        return 25;
    }

    public String getString() {
        return this.zzacw.o0().m0();
    }

    @Keep
    protected Map<String, Object> getUserProperties(String str, String str2, boolean z10) {
        return this.zzacw.o0().E(str, str2, z10);
    }

    public Map<String, Object> getUserProperties(boolean z10) {
        List<zzjx> o02 = this.zzacw.o0().o0(z10);
        androidx.collection.a aVar = new androidx.collection.a(o02.size());
        for (zzjx zzjxVar : o02) {
            aVar.put(zzjxVar.f9893b, zzjxVar.G0());
        }
        return aVar;
    }

    @Keep
    protected Map<String, Object> getUserPropertiesAs(String str, String str2, String str3, boolean z10) {
        return this.zzacw.o0().F(str, str2, str3, z10);
    }

    public final void logEvent(String str, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.zzacw.o0().a0(OtaColumn.COLUMN_APP, str, bundle, true);
    }

    @Keep
    public void logEventInternal(String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.zzacw.o0().G(str, str2, bundle);
    }

    public void logEventInternalNoInterceptor(String str, String str2, Bundle bundle, long j10) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.zzacw.o0().Z(str, str2, bundle, j10);
    }

    public void registerOnMeasurementEventListener(c cVar) {
        this.zzacw.o0().H(cVar);
    }

    @Keep
    public void setConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
        this.zzacw.o0().J(conditionalUserProperty);
    }

    @Keep
    protected void setConditionalUserPropertyAs(ConditionalUserProperty conditionalUserProperty) {
        this.zzacw.o0().K(conditionalUserProperty);
    }

    public void setEventInterceptor(b bVar) {
        this.zzacw.o0().L(bVar);
    }

    @Deprecated
    public void setMeasurementEnabled(boolean z10) {
        this.zzacw.o0().M(z10);
    }

    public final void setMinimumSessionDuration(long j10) {
        this.zzacw.o0().N(j10);
    }

    public final void setSessionTimeoutDuration(long j10) {
        this.zzacw.o0().O(j10);
    }

    public final void setUserProperty(String str, String str2) {
        int f02 = this.zzacw.K().f0(str);
        if (f02 != 0) {
            this.zzacw.K();
            this.zzacw.K().I(f02, "_ev", r5.G(str, 24, true), str != null ? str.length() : 0);
            return;
        }
        setUserPropertyInternal(OtaColumn.COLUMN_APP, str, str2);
    }

    public void setUserPropertyInternal(String str, String str2, Object obj) {
        this.zzacw.o0().P(str, str2, obj);
    }

    public void unregisterOnMeasurementEventListener(c cVar) {
        this.zzacw.o0().Q(cVar);
    }
}
