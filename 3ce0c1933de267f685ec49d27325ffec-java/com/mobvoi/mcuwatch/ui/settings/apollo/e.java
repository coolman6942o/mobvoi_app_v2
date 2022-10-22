package com.mobvoi.mcuwatch.ui.settings.apollo;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.jvm.internal.i;
import zh.t;
/* compiled from: AppListAdapter.kt */
/* loaded from: classes2.dex */
public abstract class e extends RecyclerView.Adapter<b> {

    /* renamed from: a  reason: collision with root package name */
    private List<a> f20089a;

    /* compiled from: AppListAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final int f20090a;

        /* renamed from: b  reason: collision with root package name */
        private final int f20091b;

        /* renamed from: c  reason: collision with root package name */
        private final String f20092c;

        public a(int i10, int i11, String packageName) {
            i.f(packageName, "packageName");
            this.f20090a = i10;
            this.f20091b = i11;
            this.f20092c = packageName;
        }

        public final int a() {
            return this.f20091b;
        }

        public final int b() {
            return this.f20090a;
        }

        public final String c() {
            return this.f20092c;
        }
    }

    /* compiled from: AppListAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class b extends RecyclerView.b0 {

        /* renamed from: a  reason: collision with root package name */
        private final t f20093a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(t binding) {
            super(binding.a());
            i.f(binding, "binding");
            this.f20093a = binding;
        }

        public final t a() {
            return this.f20093a;
        }
    }

    public e() {
        List<a> list;
        list = f.f20094a;
        this.f20089a = list;
    }

    public abstract void c(b bVar, a aVar);

    /* renamed from: d */
    public void onBindViewHolder(b holder, int i10) {
        i.f(holder, "holder");
        a aVar = this.f20089a.get(i10);
        holder.a().f37598b.setCompoundDrawablesRelativeWithIntrinsicBounds(Math.max(aVar.a(), 0), 0, 0, 0);
        holder.a().f37598b.setText(aVar.b());
        c(holder, aVar);
    }

    /* renamed from: e */
    public b onCreateViewHolder(ViewGroup parent, int i10) {
        i.f(parent, "parent");
        t d10 = t.d(LayoutInflater.from(parent.getContext()), parent, false);
        i.e(d10, "inflate(LayoutInflater.from(parent.context), parent, false)");
        return new b(d10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f20089a.size();
    }
}
