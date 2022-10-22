package sh;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* compiled from: RecyclerItemClickListener.java */
/* loaded from: classes2.dex */
public class n implements RecyclerView.r {

    /* renamed from: a  reason: collision with root package name */
    private b f34923a;

    /* renamed from: b  reason: collision with root package name */
    private GestureDetector f34924b;

    /* compiled from: RecyclerItemClickListener.java */
    /* loaded from: classes2.dex */
    class a extends GestureDetector.SimpleOnGestureListener {
        a(n nVar) {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return true;
        }
    }

    /* compiled from: RecyclerItemClickListener.java */
    /* loaded from: classes2.dex */
    public interface b {
        void j(View view, int i10);
    }

    public n(Context context, b bVar) {
        this.f34923a = bVar;
        this.f34924b = new GestureDetector(context, new a(this));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        View S;
        if (recyclerView.getScrollState() != 0 || (S = recyclerView.S(motionEvent.getX(), motionEvent.getY())) == null || this.f34923a == null || !this.f34924b.onTouchEvent(motionEvent)) {
            return false;
        }
        if (S.dispatchTouchEvent(motionEvent)) {
            return true;
        }
        this.f34923a.j(S, recyclerView.g0(S));
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public void onRequestDisallowInterceptTouchEvent(boolean z10) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
    }
}
