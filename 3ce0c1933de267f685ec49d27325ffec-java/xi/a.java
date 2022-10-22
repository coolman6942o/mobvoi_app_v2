package xi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import sh.h;
import sh.i;
import sh.k;
import xi.a;
/* compiled from: ScreenOnDialog.java */
/* loaded from: classes2.dex */
public class a extends com.google.android.material.bottomsheet.a implements View.OnClickListener {

    /* renamed from: n  reason: collision with root package name */
    private c f36572n;

    /* renamed from: o  reason: collision with root package name */
    private int[] f36573o;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ScreenOnDialog.java */
    /* loaded from: classes2.dex */
    public class b extends RecyclerView.Adapter<d> {
        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(int i10, View view) {
            if (a.this.f36572n != null) {
                a.this.f36572n.a(i10);
            }
            a.this.dismiss();
        }

        /* renamed from: e */
        public void onBindViewHolder(d dVar, int i10) {
            final int i11 = a.this.f36573o[i10];
            dVar.f36575a.setText(a.this.getContext().getString(k.f34886w2, Integer.valueOf(i11)));
            dVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: xi.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    a.b.this.d(i11, view);
                }
            });
        }

        /* renamed from: f */
        public d onCreateViewHolder(ViewGroup viewGroup, int i10) {
            return new d(LayoutInflater.from(a.this.getContext()).inflate(i.f34733c1, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (a.this.f36573o != null) {
                return a.this.f36573o.length;
            }
            return 0;
        }
    }

    /* compiled from: ScreenOnDialog.java */
    /* loaded from: classes2.dex */
    public interface c {
        void a(int i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ScreenOnDialog.java */
    /* loaded from: classes2.dex */
    public static class d extends RecyclerView.b0 {

        /* renamed from: a  reason: collision with root package name */
        private TextView f36575a;

        d(View view) {
            super(view);
            this.f36575a = (TextView) view.findViewById(h.f34666m3);
        }
    }

    public a(Context context, int[] iArr) {
        super(context);
        this.f36573o = iArr;
        p();
    }

    private void p() {
        View inflate = LayoutInflater.from(getContext()).inflate(i.U, (ViewGroup) null);
        setContentView(inflate);
        inflate.findViewById(h.f34682q0).setOnClickListener(this);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(h.Z1);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.h(new ba.a(0, getContext().getResources().getColor(sh.d.F), 1, 0));
        recyclerView.q0();
        recyclerView.setAdapter(new b());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == h.f34682q0) {
            dismiss();
        }
    }

    public void q(c cVar) {
        this.f36572n = cVar;
    }
}
