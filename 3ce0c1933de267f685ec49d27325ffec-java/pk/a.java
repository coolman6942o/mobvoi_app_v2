package pk;
/* compiled from: AbstractDataHandler.java */
/* loaded from: classes2.dex */
public abstract class a<BandData, CompanionData> implements j {

    /* renamed from: a  reason: collision with root package name */
    protected final i<BandData, CompanionData> f32776a;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(i<BandData, CompanionData> iVar) {
        this.f32776a = iVar;
    }

    @Override // pk.j
    public void a(Object obj) {
        b(this.f32776a.convert(obj));
    }

    protected abstract void b(CompanionData companiondata);
}
