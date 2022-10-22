package qj;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.mobvoi.companion.proto.SoundProto;
import com.mobvoi.record.h;
import com.mobvoi.record.i;
import com.mobvoi.record.utils.d;
import java.util.List;
/* compiled from: FlagAdapter.java */
/* loaded from: classes2.dex */
public class b extends RecyclerView.Adapter<C0456b> {

    /* renamed from: a  reason: collision with root package name */
    private Context f33214a;

    /* renamed from: b  reason: collision with root package name */
    private c f33215b;

    /* renamed from: c  reason: collision with root package name */
    private List<SoundProto.ConvertData> f33216c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlagAdapter.java */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C0456b f33217a;

        a(C0456b bVar) {
            this.f33217a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f33215b != null) {
                b.this.f33215b.a(((SoundProto.ConvertData) b.this.f33216c.get(this.f33217a.getAbsoluteAdapterPosition())).getOffset());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlagAdapter.java */
    /* renamed from: qj.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0456b extends RecyclerView.b0 {

        /* renamed from: a  reason: collision with root package name */
        private TextView f33219a;

        /* renamed from: b  reason: collision with root package name */
        private TextView f33220b;

        public C0456b(View view) {
            super(view);
            this.f33219a = (TextView) view.findViewById(h.M0);
            this.f33220b = (TextView) view.findViewById(h.D0);
        }
    }

    /* compiled from: FlagAdapter.java */
    /* loaded from: classes2.dex */
    public interface c {
        void a(int i10);
    }

    public b(Context context, List<SoundProto.ConvertData> list) {
        this.f33214a = context;
        this.f33216c = list;
    }

    /* renamed from: e */
    public void onBindViewHolder(C0456b bVar, int i10) {
        bVar.f33219a.setText(d.b(this.f33216c.get(bVar.getAbsoluteAdapterPosition()).getOffset()));
        bVar.f33220b.setText(this.f33216c.get(bVar.getAbsoluteAdapterPosition()).getText());
        bVar.itemView.setOnClickListener(new a(bVar));
    }

    /* renamed from: f */
    public C0456b onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return new C0456b(LayoutInflater.from(this.f33214a).inflate(i.f20649p, viewGroup, false));
    }

    public void g(List<SoundProto.ConvertData> list) {
        this.f33216c.clear();
        this.f33216c.addAll(list);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f33216c.size();
    }

    public void h(c cVar) {
        this.f33215b = cVar;
    }
}
