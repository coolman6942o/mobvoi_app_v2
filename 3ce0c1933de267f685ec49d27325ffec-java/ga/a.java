package ga;

import androidx.lifecycle.LiveData;
import com.mobvoi.apollo.protocol.model.Contact;
import java.util.List;
/* compiled from: ContactsDao.kt */
/* loaded from: classes2.dex */
public interface a {
    int a();

    void b(Contact... contactArr);

    void c(List<Contact> list);

    void clear();

    void d(String str, String str2);

    LiveData<List<Contact>> getAll();

    int size();
}
