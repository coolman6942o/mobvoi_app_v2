package androidx.room;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.room.RoomDatabase;
import i1.c;
import java.io.File;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
/* compiled from: DatabaseConfiguration.java */
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public final c.AbstractC0307c f4229a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f4230b;

    /* renamed from: c  reason: collision with root package name */
    public final String f4231c;

    /* renamed from: d  reason: collision with root package name */
    public final RoomDatabase.c f4232d;

    /* renamed from: e  reason: collision with root package name */
    public final List<RoomDatabase.b> f4233e;

    /* renamed from: f  reason: collision with root package name */
    public final RoomDatabase.d f4234f;

    /* renamed from: g  reason: collision with root package name */
    public final List<Object> f4235g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f4236h;

    /* renamed from: i  reason: collision with root package name */
    public final RoomDatabase.JournalMode f4237i;

    /* renamed from: j  reason: collision with root package name */
    public final Executor f4238j;

    /* renamed from: k  reason: collision with root package name */
    public final Executor f4239k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f4240l;

    /* renamed from: m  reason: collision with root package name */
    public final boolean f4241m;

    /* renamed from: n  reason: collision with root package name */
    public final boolean f4242n;

    /* renamed from: o  reason: collision with root package name */
    private final Set<Integer> f4243o;

    /* renamed from: p  reason: collision with root package name */
    public final Callable<InputStream> f4244p;

    @SuppressLint({"LambdaLast"})
    public i(Context context, String str, c.AbstractC0307c cVar, RoomDatabase.c cVar2, List<RoomDatabase.b> list, boolean z10, RoomDatabase.JournalMode journalMode, Executor executor, Executor executor2, boolean z11, boolean z12, boolean z13, Set<Integer> set, String str2, File file, Callable<InputStream> callable, RoomDatabase.d dVar, List<Object> list2) {
        this.f4229a = cVar;
        this.f4230b = context;
        this.f4231c = str;
        this.f4232d = cVar2;
        this.f4233e = list;
        this.f4236h = z10;
        this.f4237i = journalMode;
        this.f4238j = executor;
        this.f4239k = executor2;
        this.f4240l = z11;
        this.f4241m = z12;
        this.f4242n = z13;
        this.f4243o = set;
        this.f4244p = callable;
        this.f4235g = list2 == null ? Collections.emptyList() : list2;
    }

    public boolean a(int i10, int i11) {
        Set<Integer> set;
        if (!(i10 > i11) || !this.f4242n) {
            return this.f4241m && ((set = this.f4243o) == null || !set.contains(Integer.valueOf(i10)));
        }
        return false;
    }
}
