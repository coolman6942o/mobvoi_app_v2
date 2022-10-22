package com.mobvoi.mcuwatch.engine;

import android.database.Cursor;
import android.net.Uri;
import android.telephony.PhoneStateListener;
import android.text.TextUtils;
import android.util.Log;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.mcuwatch.notify.NotificationService;
import ei.h;
/* compiled from: CustomPhoneStateListener.java */
/* loaded from: classes2.dex */
public class e extends PhoneStateListener {

    /* renamed from: e  reason: collision with root package name */
    private static e f19153e;

    /* renamed from: a  reason: collision with root package name */
    private String f19154a;

    /* renamed from: b  reason: collision with root package name */
    private int f19155b;

    /* renamed from: c  reason: collision with root package name */
    private String[] f19156c = {"android.permission.READ_CONTACTS"};

    /* renamed from: d  reason: collision with root package name */
    private boolean f19157d = false;

    private e() {
    }

    public static e b() {
        if (f19153e == null) {
            synchronized (e.class) {
                if (f19153e == null) {
                    f19153e = new e();
                }
            }
        }
        return f19153e;
    }

    public boolean a() {
        return this.f19157d;
    }

    public void c(boolean z10) {
        this.f19157d = z10;
    }

    @Override // android.telephony.PhoneStateListener
    public void onCallStateChanged(int i10, String str) {
        if (str != null && str.length() > 0 && hc.e.i(b.e(), this.f19156c)) {
            Cursor query = b.e().getContentResolver().query(Uri.parse("content://com.android.contacts/data/phones/filter/" + str), new String[]{"display_name"}, null, null, null);
            if (query != null && query.moveToFirst()) {
                String string = query.getString(0);
                k.c("CustomPhoneState", "来电号码：%s", string);
                query.close();
                str = string;
            }
        }
        this.f19154a = str;
        if (i10 == 0) {
            Log.d("CustomPhoneState", "CALL_STATE_IDLE==>" + this.f19154a);
            h.a().s();
            if (this.f19155b == 2) {
                this.f19155b = i10;
            }
            if (this.f19155b == 1) {
                this.f19155b = i10;
            }
        } else if (i10 == 1) {
            Log.d("CustomPhoneState", "CALL_STATE_RINGING：" + this.f19154a);
            if (TextUtils.isEmpty(str)) {
                new RuntimeException("来电号码为空");
            }
            NotificationService.g(1, this.f19154a);
            this.f19155b = i10;
        } else if (i10 == 2) {
            Log.d("CustomPhoneState", "CALL_STATE_OFFHOOK");
            h.a().s();
            this.f19155b = i10;
        }
    }
}
