package retrofit2;
/* loaded from: classes3.dex */
public interface Callback<T> {
    void onFailure(Call<T> call, Throwable th2);

    void onResponse(Call<T> call, Response<T> response);
}
