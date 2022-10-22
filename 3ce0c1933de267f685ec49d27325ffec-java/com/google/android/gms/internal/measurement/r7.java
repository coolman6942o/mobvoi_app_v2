package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.google.android.gms.flags.a;
import com.google.android.gms.flags.b;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public final class r7 {

    /* renamed from: a  reason: collision with root package name */
    public static final a<Boolean> f9647a = a.a(0, "crash:enabled", Boolean.TRUE);

    static {
        a.d(0, "crash:gateway_url", "https://mobilecrashreporting.googleapis.com/v1/crashes:batchCreate?key=");
        a.b(0, "crash:log_buffer_capacity", 100);
        a.b(0, "crash:log_buffer_max_total_size", 32768);
        a.b(0, "crash:crash_backlog_capacity", 5);
        a.c(0, "crash:crash_backlog_max_age", 604800000L);
        a.c(0, "crash:starting_backoff", TimeUnit.SECONDS.toMillis(1L));
        TimeUnit timeUnit = TimeUnit.MINUTES;
        a.c(0, "crash:backoff_limit", timeUnit.toMillis(60L));
        a.b(0, "crash:retry_num_attempts", 12);
        a.b(0, "crash:batch_size", 5);
        a.c(0, "crash:batch_throttle", timeUnit.toMillis(5L));
        a.b(0, "crash:frame_depth", 60);
        a.b(0, "crash:receiver_delay", 100);
        a.b(0, "crash:thread_idle_timeout", 10);
    }

    public static final void a(Context context) {
        l6.a.a();
        b.a(context);
    }
}
