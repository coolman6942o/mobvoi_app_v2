package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class IntentSenderRequest implements Parcelable {
    public static final Parcelable.Creator<IntentSenderRequest> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final IntentSender f347a;

    /* renamed from: b  reason: collision with root package name */
    private final Intent f348b;

    /* renamed from: c  reason: collision with root package name */
    private final int f349c;

    /* renamed from: d  reason: collision with root package name */
    private final int f350d;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<IntentSenderRequest> {
        a() {
        }

        /* renamed from: a */
        public IntentSenderRequest createFromParcel(Parcel parcel) {
            return new IntentSenderRequest(parcel);
        }

        /* renamed from: b */
        public IntentSenderRequest[] newArray(int i10) {
            return new IntentSenderRequest[i10];
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private IntentSender f351a;

        /* renamed from: b  reason: collision with root package name */
        private Intent f352b;

        /* renamed from: c  reason: collision with root package name */
        private int f353c;

        /* renamed from: d  reason: collision with root package name */
        private int f354d;

        public b(IntentSender intentSender) {
            this.f351a = intentSender;
        }

        public IntentSenderRequest a() {
            return new IntentSenderRequest(this.f351a, this.f352b, this.f353c, this.f354d);
        }

        public b b(Intent intent) {
            this.f352b = intent;
            return this;
        }

        public b c(int i10, int i11) {
            this.f354d = i10;
            this.f353c = i11;
            return this;
        }
    }

    IntentSenderRequest(IntentSender intentSender, Intent intent, int i10, int i11) {
        this.f347a = intentSender;
        this.f348b = intent;
        this.f349c = i10;
        this.f350d = i11;
    }

    public Intent a() {
        return this.f348b;
    }

    public int b() {
        return this.f349c;
    }

    public int c() {
        return this.f350d;
    }

    public IntentSender d() {
        return this.f347a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f347a, i10);
        parcel.writeParcelable(this.f348b, i10);
        parcel.writeInt(this.f349c);
        parcel.writeInt(this.f350d);
    }

    IntentSenderRequest(Parcel parcel) {
        this.f347a = (IntentSender) parcel.readParcelable(IntentSender.class.getClassLoader());
        this.f348b = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
        this.f349c = parcel.readInt();
        this.f350d = parcel.readInt();
    }
}
