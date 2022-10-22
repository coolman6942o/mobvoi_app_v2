package com.mobvoi.companion.health.share;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.LruCache;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.f;
import androidx.lifecycle.x;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mobvoi.companion.R;
import com.mobvoi.companion.health.share.HealthShareChartViewModel;
import com.mobvoi.health.common.data.pojo.SportType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.jvm.internal.i;
/* compiled from: HealthShareChartFragment.kt */
/* loaded from: classes2.dex */
public final class k extends Fragment implements com.mobvoi.companion.health.share.a {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f16986a;

    /* compiled from: HealthShareChartFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a extends RecyclerView.n {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f16987a;

        a(int i10) {
            this.f16987a = i10;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.n
        public void d(Rect outRect, View view, RecyclerView parent, RecyclerView.y state) {
            i.f(outRect, "outRect");
            i.f(view, "view");
            i.f(parent, "parent");
            i.f(state, "state");
            int i10 = this.f16987a;
            outRect.left = i10;
            outRect.right = i10;
            outRect.top = i10;
            int g02 = parent.g0(view);
            RecyclerView.Adapter adapter = parent.getAdapter();
            if (g02 == (adapter == null ? 0 : adapter.getItemCount()) - 1) {
                outRect.bottom = this.f16987a;
            } else {
                outRect.bottom = 0;
            }
        }
    }

    private final Bitmap Z(RecyclerView recyclerView, int i10) {
        int i11;
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter == null) {
            return null;
        }
        int itemCount = adapter.getItemCount();
        LruCache lruCache = new LruCache(((int) (Runtime.getRuntime().maxMemory() / 1024)) / 8);
        int i12 = 0;
        if (itemCount > 0) {
            int i13 = 0;
            i11 = 0;
            while (true) {
                int i14 = i13 + 1;
                RecyclerView.b0 createViewHolder = adapter.createViewHolder(recyclerView, adapter.getItemViewType(i13));
                i.e(createViewHolder, "adapter.createViewHolder(recyclerView, adapter.getItemViewType(position))");
                adapter.onBindViewHolder(createViewHolder, i13);
                createViewHolder.itemView.measure(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
                View view = createViewHolder.itemView;
                view.layout(0, 0, view.getMeasuredWidth(), createViewHolder.itemView.getMeasuredHeight());
                Bitmap createBitmap = Bitmap.createBitmap(createViewHolder.itemView.getMeasuredWidth(), createViewHolder.itemView.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
                createViewHolder.itemView.draw(new Canvas(createBitmap));
                lruCache.put(String.valueOf(i13), createBitmap);
                i11 += createViewHolder.itemView.getMeasuredHeight() + i10;
                if (i14 >= itemCount) {
                    break;
                }
                i13 = i14;
            }
        } else {
            i11 = 0;
        }
        Paint paint = new Paint(1);
        Bitmap createBitmap2 = Bitmap.createBitmap(recyclerView.getMeasuredWidth() + (i10 * 2), i11 + i10, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap2);
        Drawable background = recyclerView.getBackground();
        if (background instanceof ColorDrawable) {
            canvas.drawColor(((ColorDrawable) background).getColor());
        }
        if (itemCount > 0) {
            int i15 = 0;
            while (true) {
                int i16 = i12 + 1;
                Bitmap bitmap = (Bitmap) lruCache.get(String.valueOf(i12));
                if (bitmap != null) {
                    float f10 = i10;
                    canvas.drawBitmap(bitmap, f10, i15 + f10, paint);
                    i15 += bitmap.getHeight() + i10;
                    bitmap.recycle();
                }
                if (i16 >= itemCount) {
                    break;
                }
                i12 = i16;
            }
        }
        return createBitmap2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(k this$0, SportType sportType, p pVar) {
        i.f(this$0, "this$0");
        i.f(sportType, "$sportType");
        RecyclerView recyclerView = this$0.f16986a;
        if (recyclerView != null) {
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            Objects.requireNonNull(adapter, "null cannot be cast to non-null type com.mobvoi.companion.health.share.HealthShareChartAdapter");
            i iVar = (i) adapter;
            ArrayList<Integer> c10 = iVar.c();
            c10.clear();
            int i10 = sportType.typeCode;
            if (i10 == SportType.Swimming.typeCode || i10 == SportType.AutoSwimming.typeCode || i10 == SportType.OpenWaterSwimming.typeCode) {
                c10.add(3);
            } else {
                c10.add(0);
            }
            int i11 = sportType.typeCode;
            if (i11 == SportType.AutoWalking.typeCode || i11 == SportType.IndoorRunning.typeCode || i11 == SportType.TreadmillRunning.typeCode) {
                c10.add(1);
            }
            int i12 = sportType.typeCode;
            if (i12 == SportType.OutdoorWalk.typeCode || i12 == SportType.AutoCycling.typeCode || i12 == SportType.OutdoorBike.typeCode || i12 == SportType.IndoorCycling.typeCode) {
                c10.add(2);
            }
            iVar.e(pVar);
            iVar.notifyDataSetChanged();
            return;
        }
        i.u("healthShareRv");
        throw null;
    }

    @Override // com.mobvoi.companion.health.share.a
    public Bitmap L() {
        int applyDimension = (int) TypedValue.applyDimension(1, 16.0f, requireActivity().getResources().getDisplayMetrics());
        RecyclerView recyclerView = this.f16986a;
        if (recyclerView != null) {
            return Z(recyclerView, applyDimension);
        }
        i.u("healthShareRv");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        i.f(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_health_share_chart, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        sb.a.h(requireContext(), "chartShare");
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        sb.a.i(requireContext(), "chartShare");
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.f(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(R.id.healthShareRv);
        i.e(findViewById, "view.findViewById(R.id.healthShareRv)");
        this.f16986a = (RecyclerView) findViewById;
        int applyDimension = (int) TypedValue.applyDimension(1, 16.0f, requireActivity().getResources().getDisplayMetrics());
        RecyclerView recyclerView = this.f16986a;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
            RecyclerView recyclerView2 = this.f16986a;
            if (recyclerView2 != null) {
                recyclerView2.h(new a(applyDimension));
                RecyclerView recyclerView3 = this.f16986a;
                if (recyclerView3 != null) {
                    Context requireContext = requireContext();
                    i.e(requireContext, "requireContext()");
                    recyclerView3.setAdapter(new i(requireContext));
                    Bundle arguments = getArguments();
                    if (arguments != null) {
                        String string = arguments.getString("sportId");
                        if (string == null) {
                            string = "";
                        }
                        Serializable serializable = arguments.getSerializable("type");
                        Objects.requireNonNull(serializable, "null cannot be cast to non-null type com.mobvoi.health.common.data.pojo.SportType");
                        final SportType sportType = (SportType) serializable;
                        if (!TextUtils.isEmpty(string)) {
                            HealthShareChartViewModel.a aVar = HealthShareChartViewModel.Companion;
                            f requireActivity = requireActivity();
                            i.e(requireActivity, "requireActivity()");
                            HealthShareChartViewModel a10 = aVar.a(requireActivity, string, sportType.name());
                            a10.getHealthShareData().i(getViewLifecycleOwner(), new x() { // from class: com.mobvoi.companion.health.share.j
                                @Override // androidx.lifecycle.x
                                public final void a(Object obj) {
                                    k.a0(k.this, sportType, (p) obj);
                                }
                            });
                            a10.querySportData();
                            return;
                        }
                        return;
                    }
                    return;
                }
                i.u("healthShareRv");
                throw null;
            }
            i.u("healthShareRv");
            throw null;
        }
        i.u("healthShareRv");
        throw null;
    }
}
