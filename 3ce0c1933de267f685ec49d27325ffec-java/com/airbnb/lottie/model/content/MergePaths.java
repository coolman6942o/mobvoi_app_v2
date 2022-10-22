package com.airbnb.lottie.model.content;

import com.airbnb.lottie.f;
import com.airbnb.lottie.model.layer.a;
import d3.c;
import d3.l;
import i3.b;
import k3.d;
/* loaded from: classes.dex */
public class MergePaths implements b {

    /* renamed from: a  reason: collision with root package name */
    private final String f6558a;

    /* renamed from: b  reason: collision with root package name */
    private final MergePathsMode f6559b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f6560c;

    /* loaded from: classes.dex */
    public enum MergePathsMode {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static MergePathsMode forId(int i10) {
            if (i10 == 1) {
                return MERGE;
            }
            if (i10 == 2) {
                return ADD;
            }
            if (i10 == 3) {
                return SUBTRACT;
            }
            if (i10 == 4) {
                return INTERSECT;
            }
            if (i10 != 5) {
                return MERGE;
            }
            return EXCLUDE_INTERSECTIONS;
        }
    }

    public MergePaths(String str, MergePathsMode mergePathsMode, boolean z10) {
        this.f6558a = str;
        this.f6559b = mergePathsMode;
        this.f6560c = z10;
    }

    @Override // i3.b
    public c a(f fVar, a aVar) {
        if (fVar.k()) {
            return new l(this);
        }
        d.c("Animation contains merge paths but they are disabled.");
        return null;
    }

    public MergePathsMode b() {
        return this.f6559b;
    }

    public String c() {
        return this.f6558a;
    }

    public boolean d() {
        return this.f6560c;
    }

    public String toString() {
        return "MergePaths{mode=" + this.f6559b + '}';
    }
}
