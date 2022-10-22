package ne;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.c;
import androidx.recyclerview.widget.RecyclerView;
import io.m;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.i;
import pe.b;
/* compiled from: FeedbackCnDeviceListModule.kt */
/* loaded from: classes2.dex */
public final class q extends RecyclerView.Adapter<r> implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private final Context f31169a;

    /* renamed from: b  reason: collision with root package name */
    private final List<b> f31170b;

    /* renamed from: c  reason: collision with root package name */
    private qo.q<? super String, ? super Boolean, ? super Integer, m> f31171c;

    public q(Context context, List<b> contentList) {
        i.f(context, "context");
        i.f(contentList, "contentList");
        this.f31169a = context;
        this.f31170b = contentList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(q this$0, String source, DialogInterface dialogInterface, int i10) {
        i.f(this$0, "this$0");
        i.f(source, "$source");
        qo.q<? super String, ? super Boolean, ? super Integer, m> qVar = this$0.f31171c;
        if (qVar != null) {
            qVar.invoke(source, Boolean.TRUE, Integer.valueOf(i10));
        }
        dialogInterface.dismiss();
    }

    /* renamed from: d */
    public void onBindViewHolder(r holder, int i10) {
        i.f(holder, "holder");
        holder.c().setText(this.f31170b.get(i10).d());
        holder.a().setImageResource(this.f31170b.get(i10).b());
        int a10 = this.f31170b.get(i10).a();
        if (a10 > 0) {
            holder.b().setVisibility(0);
            holder.b().setText(this.f31169a.getString(y.f31215d, Integer.valueOf(a10)));
        } else {
            holder.b().setVisibility(4);
        }
        holder.itemView.setTag(holder);
        holder.itemView.setOnClickListener(this);
    }

    /* renamed from: f */
    public r onCreateViewHolder(ViewGroup parent, int i10) {
        i.f(parent, "parent");
        b d10 = b.d(LayoutInflater.from(this.f31169a), parent, false);
        i.e(d10, "inflate(LayoutInflater.from(context), parent, false)");
        return new r(d10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f31170b.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        i.f(view, "view");
        Object tag = view.getTag();
        Objects.requireNonNull(tag, "null cannot be cast to non-null type com.mobvoi.feedback.FeedbackItemViewHolder");
        int bindingAdapterPosition = ((r) tag).getBindingAdapterPosition();
        b bVar = this.f31170b.get(bindingAdapterPosition);
        if (bVar.e()) {
            final String c10 = this.f31170b.get(bindingAdapterPosition).c();
            if (bVar.a() > 1) {
                c.a aVar = new c.a(this.f31169a, z.f31228a);
                aVar.e(View.inflate(this.f31169a, x.f31208b, null));
                aVar.p(new a(this.f31169a, null), -1, new DialogInterface.OnClickListener() { // from class: ne.p
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i10) {
                        q.e(q.this, c10, dialogInterface, i10);
                    }
                });
                c a10 = aVar.a();
                i.e(a10, "builder.create()");
                a10.show();
            } else if (bVar.a() == 1) {
                qo.q<? super String, ? super Boolean, ? super Integer, m> qVar = this.f31171c;
                if (qVar != null) {
                    qVar.invoke(c10, Boolean.TRUE, 0);
                }
            } else {
                qo.q<? super String, ? super Boolean, ? super Integer, m> qVar2 = this.f31171c;
                if (qVar2 != null) {
                    qVar2.invoke(c10, Boolean.TRUE, -1);
                }
            }
        } else {
            qo.q<? super String, ? super Boolean, ? super Integer, m> qVar3 = this.f31171c;
            if (qVar3 != null) {
                qVar3.invoke(this.f31170b.get(bindingAdapterPosition).c(), Boolean.FALSE, -1);
            }
        }
    }
}
