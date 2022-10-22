package ug;

import com.mobvoi.health.common.data.pojo.SportType;
import java.util.Date;
/* compiled from: SportItem.java */
/* loaded from: classes2.dex */
public class e extends a {

    /* renamed from: a  reason: collision with root package name */
    public final String f35417a;

    /* renamed from: b  reason: collision with root package name */
    public final String f35418b;

    /* renamed from: c  reason: collision with root package name */
    public final SportType f35419c;

    /* renamed from: d  reason: collision with root package name */
    public final Date f35420d;

    /* renamed from: e  reason: collision with root package name */
    public final Date f35421e;

    /* renamed from: f  reason: collision with root package name */
    public final long f35422f;

    /* renamed from: g  reason: collision with root package name */
    public final int f35423g;

    /* renamed from: h  reason: collision with root package name */
    public float f35424h;

    /* renamed from: i  reason: collision with root package name */
    public int f35425i;

    /* renamed from: j  reason: collision with root package name */
    public int f35426j;

    public e(String str, SportType sportType, Date date, Date date2, long j10, int i10) {
        this(str, null, sportType, date, date2, j10, i10);
    }

    public boolean a() {
        return this.f35419c == SportType.FreeWorkout;
    }

    public boolean b() {
        SportType sportType = this.f35419c;
        return sportType == SportType.IndoorCycling || sportType == SportType.RowingMachine || sportType == SportType.RopeSkipping || sportType == SportType.Gymnastics || sportType == SportType.Spinning || sportType == SportType.EllipticalMachine || sportType == SportType.Yoga || sportType == SportType.BodyMechanics || sportType == SportType.Pilates || sportType == SportType.Taekwondo || sportType == SportType.Badminton || sportType.typeCode >= SportType.Hiit.typeCode;
    }

    public String toString() {
        return "SportItem{sportId='" + this.f35417a + "', sportType=" + this.f35419c + ", startTime=" + this.f35420d + ", stopTime=" + this.f35421e + ", duration=" + this.f35422f + ", percentCompletion=" + this.f35423g + ", calorie=" + this.f35424h + ", distance=" + this.f35425i + '}';
    }

    public e(String str, String str2, SportType sportType, Date date, Date date2, long j10, int i10) {
        this.f35417a = str;
        this.f35418b = str2;
        this.f35419c = sportType;
        this.f35420d = date;
        this.f35421e = date2;
        this.f35422f = j10;
        this.f35423g = i10;
    }
}
