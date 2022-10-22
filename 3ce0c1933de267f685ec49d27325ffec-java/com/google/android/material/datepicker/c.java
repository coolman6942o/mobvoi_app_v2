package com.google.android.material.datepicker;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.google.android.material.internal.j;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
/* compiled from: DateFormatTextWatcher.java */
/* loaded from: classes.dex */
abstract class c extends j {

    /* renamed from: a  reason: collision with root package name */
    private final TextInputLayout f10771a;

    /* renamed from: b  reason: collision with root package name */
    private final DateFormat f10772b;

    /* renamed from: c  reason: collision with root package name */
    private final CalendarConstraints f10773c;

    /* renamed from: d  reason: collision with root package name */
    private final String f10774d;

    /* renamed from: e  reason: collision with root package name */
    private final Runnable f10775e;

    /* renamed from: f  reason: collision with root package name */
    private Runnable f10776f;

    /* compiled from: DateFormatTextWatcher.java */
    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f10777a;

        a(String str) {
            this.f10777a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout textInputLayout = c.this.f10771a;
            DateFormat dateFormat = c.this.f10772b;
            Context context = textInputLayout.getContext();
            String string = context.getString(d7.j.f25335z);
            String format = String.format(context.getString(d7.j.B), this.f10777a);
            String format2 = String.format(context.getString(d7.j.A), dateFormat.format(new Date(p.o().getTimeInMillis())));
            textInputLayout.setError(string + "\n" + format + "\n" + format2);
            c.this.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DateFormatTextWatcher.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f10779a;

        b(long j10) {
            this.f10779a = j10;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.f10771a.setError(String.format(c.this.f10774d, d.c(this.f10779a)));
            c.this.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints) {
        this.f10772b = dateFormat;
        this.f10771a = textInputLayout;
        this.f10773c = calendarConstraints;
        this.f10774d = textInputLayout.getContext().getString(d7.j.E);
        this.f10775e = new a(str);
    }

    private Runnable d(long j10) {
        return new b(j10);
    }

    abstract void e();

    abstract void f(Long l10);

    public void g(View view, Runnable runnable) {
        view.postDelayed(runnable, 1000L);
    }

    @Override // com.google.android.material.internal.j, android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        this.f10771a.removeCallbacks(this.f10775e);
        this.f10771a.removeCallbacks(this.f10776f);
        this.f10771a.setError(null);
        f(null);
        if (!TextUtils.isEmpty(charSequence)) {
            try {
                Date parse = this.f10772b.parse(charSequence.toString());
                this.f10771a.setError(null);
                long time = parse.getTime();
                if (!this.f10773c.f().i0(time) || !this.f10773c.l(time)) {
                    Runnable d10 = d(time);
                    this.f10776f = d10;
                    g(this.f10771a, d10);
                    return;
                }
                f(Long.valueOf(parse.getTime()));
            } catch (ParseException unused) {
                g(this.f10771a, this.f10775e);
            }
        }
    }
}
