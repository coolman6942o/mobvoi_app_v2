package com.google.android.gms.internal.measurement;

import b6.i;
/* loaded from: classes.dex */
final class l0 {

    /* renamed from: a  reason: collision with root package name */
    final String f9470a;

    /* renamed from: b  reason: collision with root package name */
    final String f9471b;

    /* renamed from: c  reason: collision with root package name */
    final long f9472c;

    /* renamed from: d  reason: collision with root package name */
    final long f9473d;

    /* renamed from: e  reason: collision with root package name */
    final long f9474e;

    /* renamed from: f  reason: collision with root package name */
    final long f9475f;

    /* renamed from: g  reason: collision with root package name */
    final Long f9476g;

    /* renamed from: h  reason: collision with root package name */
    final Long f9477h;

    /* renamed from: i  reason: collision with root package name */
    final Boolean f9478i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l0(String str, String str2, long j10, long j11, long j12, long j13, Long l10, Long l11, Boolean bool) {
        i.g(str);
        i.g(str2);
        boolean z10 = true;
        i.a(j10 >= 0);
        i.a(j11 >= 0);
        i.a(j13 < 0 ? false : z10);
        this.f9470a = str;
        this.f9471b = str2;
        this.f9472c = j10;
        this.f9473d = j11;
        this.f9474e = j12;
        this.f9475f = j13;
        this.f9476g = l10;
        this.f9477h = l11;
        this.f9478i = bool;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final l0 a(Long l10, Long l11, Boolean bool) {
        return new l0(this.f9470a, this.f9471b, this.f9472c, this.f9473d, this.f9474e, this.f9475f, l10, l11, (bool == null || bool.booleanValue()) ? bool : null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final l0 b(long j10) {
        return new l0(this.f9470a, this.f9471b, this.f9472c, this.f9473d, j10, this.f9475f, this.f9476g, this.f9477h, this.f9478i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final l0 c(long j10) {
        return new l0(this.f9470a, this.f9471b, this.f9472c, this.f9473d, this.f9474e, j10, this.f9476g, this.f9477h, this.f9478i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final l0 d() {
        return new l0(this.f9470a, this.f9471b, this.f9472c + 1, 1 + this.f9473d, this.f9474e, this.f9475f, this.f9476g, this.f9477h, this.f9478i);
    }
}
