package com.huawei.hianalytics.mn.no.tu;

import com.tendcloud.tenddata.ab;
import java.util.Calendar;
import java.util.UUID;
/* loaded from: classes.dex */
public class no {

    /* renamed from: mn  reason: collision with root package name */
    private long f13623mn = 1800000;

    /* renamed from: no  reason: collision with root package name */
    private long f13624no = ab.Y;

    /* renamed from: op  reason: collision with root package name */
    private volatile boolean f13625op = false;
    private volatile long pq = 0;
    private mn qr = null;

    /* loaded from: classes.dex */
    class mn {

        /* renamed from: mn  reason: collision with root package name */
        String f13626mn = UUID.randomUUID().toString().replace("-", "");

        /* renamed from: no  reason: collision with root package name */
        boolean f13627no = true;
        private long pq;

        mn(long j10) {
            this.f13626mn += "_" + j10;
            this.pq = j10;
            no.this.f13625op = false;
        }

        private boolean mn(long j10, long j11) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j10);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(j11);
            return (calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6)) ? false : true;
        }

        private void no(long j10) {
            com.huawei.hianalytics.mn.no.qr.mn.no("SessionWrapper", "getNewSession() session is flush!");
            String uuid = UUID.randomUUID().toString();
            this.f13626mn = uuid;
            this.f13626mn = uuid.replace("-", "");
            this.f13626mn += "_" + j10;
            this.pq = j10;
            this.f13627no = true;
        }

        private boolean no(long j10, long j11) {
            return j11 - j10 >= no.this.f13623mn;
        }

        void mn(long j10) {
            if (no.this.f13625op) {
                no.this.f13625op = false;
                no(j10);
            } else if (no(this.pq, j10) || mn(this.pq, j10)) {
                no(j10);
            } else {
                this.pq = j10;
                this.f13627no = false;
            }
        }
    }

    public String mn() {
        mn mnVar = this.qr;
        if (mnVar != null) {
            return mnVar.f13626mn;
        }
        com.huawei.hianalytics.mn.no.qr.mn.op("SessionWrapper", "getSessionName(): session not prepared. onEvent() must be called first.");
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mn(long j10) {
        mn mnVar = this.qr;
        if (mnVar == null) {
            com.huawei.hianalytics.mn.no.qr.mn.no("SessionWrapper", "Session is first flush");
            this.qr = new mn(j10);
            return;
        }
        mnVar.mn(j10);
    }

    public boolean no() {
        mn mnVar = this.qr;
        if (mnVar != null) {
            return mnVar.f13627no;
        }
        com.huawei.hianalytics.mn.no.qr.mn.op("SessionWrapper", "isFirstEvent(): session not prepared. onEvent() must be called first.");
        return false;
    }

    public void op() {
        this.qr = null;
        this.pq = 0L;
        this.f13625op = false;
    }
}
