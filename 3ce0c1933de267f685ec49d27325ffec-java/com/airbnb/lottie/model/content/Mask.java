package com.airbnb.lottie.model.content;

import h3.d;
import h3.h;
/* loaded from: classes.dex */
public class Mask {

    /* renamed from: a  reason: collision with root package name */
    private final MaskMode f6554a;

    /* renamed from: b  reason: collision with root package name */
    private final h f6555b;

    /* renamed from: c  reason: collision with root package name */
    private final d f6556c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f6557d;

    /* loaded from: classes.dex */
    public enum MaskMode {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT,
        MASK_MODE_NONE
    }

    public Mask(MaskMode maskMode, h hVar, d dVar, boolean z10) {
        this.f6554a = maskMode;
        this.f6555b = hVar;
        this.f6556c = dVar;
        this.f6557d = z10;
    }

    public MaskMode a() {
        return this.f6554a;
    }

    public h b() {
        return this.f6555b;
    }

    public d c() {
        return this.f6556c;
    }

    public boolean d() {
        return this.f6557d;
    }
}
