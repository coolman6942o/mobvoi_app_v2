package com.mobvoi.health.companion.heartrate.ui.detail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import fg.q;
import fg.s;
import fg.t;
import fg.u;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import og.v;
/* loaded from: classes2.dex */
public class HeartHealthView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextView f18307a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f18308b;

    /* renamed from: c  reason: collision with root package name */
    private RecyclerView f18309c;

    /* renamed from: d  reason: collision with root package name */
    private a f18310d;

    /* renamed from: e  reason: collision with root package name */
    private int f18311e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends BaseQuickAdapter<String, BaseViewHolder> {
        public a(HeartHealthView heartHealthView, List<String> list) {
            super(t.N, list);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: c */
        public void convert(BaseViewHolder baseViewHolder, String str) {
            ((TextView) baseViewHolder.getView(s.f26745o0)).setText(str);
        }
    }

    public HeartHealthView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void b(Context context) {
        View inflate = LayoutInflater.from(getContext()).inflate(t.O, (ViewGroup) this, true);
        this.f18307a = (TextView) inflate.findViewById(s.f26791u5);
        this.f18308b = (ImageView) inflate.findViewById(s.f26770r5);
        this.f18309c = (RecyclerView) inflate.findViewById(s.f26784t5);
        this.f18310d = new a(this, null);
        this.f18309c.setLayoutManager(new LinearLayoutManager(context));
        this.f18309c.setAdapter(this.f18310d);
        this.f18309c.setNestedScrollingEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int c(rh.a aVar, rh.a aVar2) {
        long j10 = aVar.f33515b;
        long j11 = aVar2.f33515b;
        if (j10 < j11) {
            return 1;
        }
        return j10 > j11 ? -1 : 0;
    }

    public void d(int i10, int i11, List<rh.a> list) {
        if (list == null || list.size() == 0) {
            setVisibility(8);
            return;
        }
        Collections.sort(list, v.f31704a);
        setVisibility(0);
        if (i10 == 1) {
            this.f18307a.setText(u.f26984v3);
            this.f18308b.setImageResource(q.f26552c);
        } else if (i10 == 2 || i10 == 3) {
            this.f18307a.setText(u.I3);
            this.f18308b.setImageResource(q.f26560e);
        } else if (i10 == 4) {
            this.f18307a.setText(u.F3);
            this.f18308b.setImageResource(q.f26556d);
        }
        this.f18311e = i11;
        ArrayList arrayList = new ArrayList();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
        Iterator<rh.a> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            rh.a next = it.next();
            int i12 = this.f18311e;
            if (i12 == 1) {
                String format = simpleDateFormat.format(new Date(next.f33515b));
                if (i10 == 1) {
                    arrayList.add(getResources().getString(u.f26972t3, format));
                } else if (i10 == 2) {
                    arrayList.add(getResources().getString(u.K3, format));
                } else if (i10 == 3) {
                    arrayList.add(getResources().getString(u.L3, format));
                } else if (i10 == 4) {
                    arrayList.add(getResources().getString(u.D3, format));
                }
            } else if (i12 == 2) {
                if (i10 == 1) {
                    arrayList.add(getResources().getString(u.f26990w3, Integer.valueOf(list.size())));
                } else if (i10 == 2 || i10 == 3) {
                    arrayList.add(getResources().getString(u.J3, Integer.valueOf(list.size())));
                } else if (i10 == 4) {
                    arrayList.add(getResources().getString(u.G3, Integer.valueOf(list.size())));
                }
            } else if (i12 == 3) {
                if (i10 == 1) {
                    arrayList.add(getResources().getString(u.f26978u3, Integer.valueOf(list.size())));
                } else if (i10 == 2 || i10 == 3) {
                    arrayList.add(getResources().getString(u.H3, Integer.valueOf(list.size())));
                } else if (i10 == 4) {
                    arrayList.add(getResources().getString(u.E3, Integer.valueOf(list.size())));
                }
            }
        }
        this.f18310d.setNewData(arrayList);
    }

    public HeartHealthView(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public HeartHealthView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        b(context);
    }
}
