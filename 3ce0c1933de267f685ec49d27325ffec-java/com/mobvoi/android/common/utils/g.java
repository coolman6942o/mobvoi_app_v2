package com.mobvoi.android.common.utils;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/* compiled from: FileLogger.java */
/* loaded from: classes2.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private Writer f15431a = null;

    /* renamed from: b  reason: collision with root package name */
    private String f15432b;

    /* renamed from: c  reason: collision with root package name */
    private SimpleDateFormat f15433c;

    /* renamed from: d  reason: collision with root package name */
    private SimpleDateFormat f15434d;

    /* renamed from: e  reason: collision with root package name */
    private String f15435e;

    /* renamed from: f  reason: collision with root package name */
    private String f15436f;

    /* renamed from: g  reason: collision with root package name */
    private String f15437g;

    /* renamed from: h  reason: collision with root package name */
    private int f15438h;

    public g(String str, String str2, String str3) {
        Locale locale = Locale.US;
        this.f15433c = new SimpleDateFormat("yyMMdd", locale);
        this.f15434d = new SimpleDateFormat("MM-dd HH:mm:ss:SSS", locale);
        this.f15435e = str;
        this.f15436f = str2;
        this.f15437g = str3;
    }

    private String b(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f15436f);
        sb2.append("_log_");
        sb2.append(str);
        if (!TextUtils.isEmpty(this.f15437g)) {
            sb2.append("_");
            sb2.append(this.f15437g);
        }
        sb2.append(".txt");
        return sb2.toString();
    }

    private String c() {
        return this.f15433c.format(new Date());
    }

    private boolean e() {
        if (this.f15435e == null) {
            return false;
        }
        File file = new File(this.f15435e);
        if (file.exists() || file.mkdirs()) {
            this.f15432b = c();
            try {
                this.f15431a = new FileWriter(new File(this.f15435e, b(this.f15432b)), true);
                return true;
            } catch (IOException e10) {
                int i10 = this.f15438h + 1;
                this.f15438h = i10;
                if (i10 <= 3) {
                    e10.printStackTrace();
                }
                return false;
            }
        } else {
            int i11 = this.f15438h + 1;
            this.f15438h = i11;
            if (i11 <= 3) {
                Log.w("FileLogger", "Cannot create dir: " + this.f15435e);
            }
            return false;
        }
    }

    private synchronized void f(String str) {
        if (this.f15431a != null || e()) {
            try {
                if (!c().equals(this.f15432b)) {
                    this.f15431a.flush();
                    this.f15431a.close();
                    this.f15431a = null;
                    if (!e()) {
                        return;
                    }
                }
                this.f15431a.write(str);
                this.f15431a.flush();
            } catch (IOException e10) {
                e10.printStackTrace();
            }
        }
    }

    public synchronized void a() {
        j.a(this.f15431a);
        this.f15431a = null;
    }

    public void d(String str, String str2, Throwable th2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f15434d.format(new Date()));
        sb2.append(" ");
        sb2.append(str);
        sb2.append("\t");
        sb2.append(Process.myPid());
        sb2.append(" ");
        sb2.append(Process.myTid());
        sb2.append(" ");
        if (!TextUtils.isEmpty(str2)) {
            sb2.append(str2);
        }
        if (th2 != null) {
            sb2.append("\n\t");
            sb2.append(k.g(th2));
        }
        sb2.append("\n");
        f(sb2.toString());
    }
}
