package com.google.android.gms.internal.measurement;

import android.net.Uri;
import com.huawei.agconnect.exception.AGCServerException;
import com.laser.tsm.sdk.AppConfig;
import com.mobvoi.wear.util.LogCleaner;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
/* loaded from: classes.dex */
public final class p0 {
    public static q0<Long> A;
    public static q0<Long> B;
    public static q0<Long> C;
    public static q0<Long> D;
    public static q0<Integer> E;
    public static q0<Long> F;
    public static q0<Integer> G;
    public static q0<Integer> H;
    public static q0<Long> I;
    public static q0<Boolean> J;
    public static q0<String> K;
    public static q0<Long> L;
    public static q0<Integer> M;
    public static q0<Double> N;
    public static q0<Boolean> O;
    public static q0<Boolean> P;
    public static q0<Boolean> Q;
    public static q0<Boolean> R;
    public static q0<Boolean> S;
    public static q0<Boolean> T;
    public static q0<Boolean> U;
    public static q0<Boolean> V;

    /* renamed from: a  reason: collision with root package name */
    private static final f7 f9559a;

    /* renamed from: b  reason: collision with root package name */
    public static q0<Boolean> f9560b;

    /* renamed from: c  reason: collision with root package name */
    public static q0<String> f9561c;

    /* renamed from: d  reason: collision with root package name */
    public static q0<Long> f9562d;

    /* renamed from: e  reason: collision with root package name */
    public static q0<Long> f9563e;

    /* renamed from: f  reason: collision with root package name */
    public static q0<Long> f9564f;

    /* renamed from: g  reason: collision with root package name */
    public static q0<String> f9565g;

    /* renamed from: h  reason: collision with root package name */
    public static q0<String> f9566h;

    /* renamed from: i  reason: collision with root package name */
    public static q0<Integer> f9567i;

    /* renamed from: j  reason: collision with root package name */
    public static q0<Integer> f9568j;

    /* renamed from: k  reason: collision with root package name */
    public static q0<Integer> f9569k;

    /* renamed from: l  reason: collision with root package name */
    public static q0<Integer> f9570l;

    /* renamed from: m  reason: collision with root package name */
    public static q0<Integer> f9571m;

    /* renamed from: n  reason: collision with root package name */
    public static q0<Integer> f9572n;

    /* renamed from: o  reason: collision with root package name */
    public static q0<Integer> f9573o;

    /* renamed from: p  reason: collision with root package name */
    public static q0<Integer> f9574p;

    /* renamed from: q  reason: collision with root package name */
    public static q0<Integer> f9575q;

    /* renamed from: r  reason: collision with root package name */
    public static q0<Integer> f9576r;

    /* renamed from: s  reason: collision with root package name */
    public static q0<String> f9577s;

    /* renamed from: t  reason: collision with root package name */
    public static q0<Long> f9578t;

    /* renamed from: u  reason: collision with root package name */
    public static q0<Long> f9579u;

    /* renamed from: v  reason: collision with root package name */
    public static q0<Long> f9580v;

    /* renamed from: w  reason: collision with root package name */
    public static q0<Long> f9581w;

    /* renamed from: x  reason: collision with root package name */
    public static q0<Long> f9582x;

    /* renamed from: y  reason: collision with root package name */
    public static q0<Long> f9583y;

    /* renamed from: z  reason: collision with root package name */
    public static q0<Long> f9584z;

    static {
        String valueOf = String.valueOf(Uri.encode("com.google.android.gms.measurement"));
        f9559a = new f7(Uri.parse(valueOf.length() != 0 ? "content://com.google.android.gms.phenotype/".concat(valueOf) : new String("content://com.google.android.gms.phenotype/")));
        q0.f("measurement.log_third_party_store_events_enabled", false, false);
        q0.f("measurement.log_installs_enabled", false, false);
        q0.f("measurement.log_upgrades_enabled", false, false);
        q0.f("measurement.log_androidId_enabled", false, false);
        f9560b = q0.f("measurement.upload_dsid_enabled", false, false);
        f9561c = q0.h("measurement.log_tag", "FA", "FA-SVC");
        f9562d = q0.e("measurement.ad_id_cache_time", 10000L, 10000L);
        f9563e = q0.e("measurement.monitoring.sample_period_millis", LogCleaner.ONE_DAY, LogCleaner.ONE_DAY);
        f9564f = q0.e("measurement.config.cache_time", LogCleaner.ONE_DAY, LogCleaner.ONE_HOUR);
        f9565g = q0.h("measurement.config.url_scheme", "https", "https");
        f9566h = q0.h("measurement.config.url_authority", "app-measurement.com", "app-measurement.com");
        f9567i = q0.g("measurement.upload.max_bundles", 100, 100);
        f9568j = q0.g("measurement.upload.max_batch_size", WXMediaMessage.THUMB_LENGTH_LIMIT, WXMediaMessage.THUMB_LENGTH_LIMIT);
        f9569k = q0.g("measurement.upload.max_bundle_size", WXMediaMessage.THUMB_LENGTH_LIMIT, WXMediaMessage.THUMB_LENGTH_LIMIT);
        f9570l = q0.g("measurement.upload.max_events_per_bundle", 1000, 1000);
        f9571m = q0.g("measurement.upload.max_events_per_day", AppConfig.STATUS_SUCCESS, AppConfig.STATUS_SUCCESS);
        f9572n = q0.g("measurement.upload.max_error_events_per_day", 1000, 1000);
        f9573o = q0.g("measurement.upload.max_public_events_per_day", 50000, 50000);
        f9574p = q0.g("measurement.upload.max_conversions_per_day", AGCServerException.UNKNOW_EXCEPTION, AGCServerException.UNKNOW_EXCEPTION);
        f9575q = q0.g("measurement.upload.max_realtime_events_per_day", 10, 10);
        f9576r = q0.g("measurement.store.max_stored_events_per_app", AppConfig.STATUS_SUCCESS, AppConfig.STATUS_SUCCESS);
        f9577s = q0.h("measurement.upload.url", "https://app-measurement.com/a", "https://app-measurement.com/a");
        f9578t = q0.e("measurement.upload.backoff_period", 43200000L, 43200000L);
        f9579u = q0.e("measurement.upload.window_interval", LogCleaner.ONE_HOUR, LogCleaner.ONE_HOUR);
        f9580v = q0.e("measurement.upload.interval", LogCleaner.ONE_HOUR, LogCleaner.ONE_HOUR);
        f9581w = q0.e("measurement.upload.realtime_upload_interval", 10000L, 10000L);
        f9582x = q0.e("measurement.upload.debug_upload_interval", 1000L, 1000L);
        f9583y = q0.e("measurement.upload.minimum_delay", 500L, 500L);
        f9584z = q0.e("measurement.alarm_manager.minimum_interval", LogCleaner.ONE_MINUTE, LogCleaner.ONE_MINUTE);
        A = q0.e("measurement.upload.stale_data_deletion_interval", LogCleaner.ONE_DAY, LogCleaner.ONE_DAY);
        B = q0.e("measurement.upload.refresh_blacklisted_config_interval", 604800000L, 604800000L);
        C = q0.e("measurement.upload.initial_upload_delay_time", 15000L, 15000L);
        D = q0.e("measurement.upload.retry_time", 1800000L, 1800000L);
        E = q0.g("measurement.upload.retry_count", 6, 6);
        F = q0.e("measurement.upload.max_queue_time", 2419200000L, 2419200000L);
        G = q0.g("measurement.lifetimevalue.max_currency_tracked", 4, 4);
        H = q0.g("measurement.audience.filter_result_max_count", 200, 200);
        I = q0.e("measurement.service_client.idle_disconnect_millis", 5000L, 5000L);
        J = q0.f("measurement.test.boolean_flag", false, false);
        K = q0.h("measurement.test.string_flag", "---", "---");
        L = q0.e("measurement.test.long_flag", -1L, -1L);
        M = q0.g("measurement.test.int_flag", -2, -2);
        N = q0.d("measurement.test.double_flag", -3.0d, -3.0d);
        O = q0.f("measurement.lifetimevalue.user_engagement_tracking_enabled", false, false);
        P = q0.f("measurement.audience.complex_param_evaluation", false, false);
        Q = q0.f("measurement.validation.internal_limits_internal_event_params", false, false);
        R = q0.f("measurement.quality.unsuccessful_update_retry_counter", false, false);
        S = q0.f("measurement.iid.disable_on_collection_disabled", true, true);
        T = q0.f("measurement.app_launch.call_only_when_enabled", true, true);
        U = q0.f("measurement.run_on_worker_inline", true, false);
        q0.f("measurement.audience.dynamic_filters", false, false);
        V = q0.f("measurement.reset_analytics.persist_time", false, false);
    }
}
