package blueguy.rf_localizer;

import android.net.wifi.ScanResult;
import android.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by arjun on 2/14/17.
 */

public abstract class Scanner {

    private HashMap<Object, Long> mStaleEntries = new HashMap<>();

    /**
     *
     * @return
     */
    protected List<Object> updateStaleEntries(final List<Pair<Object, Long>> toAdd) {
        List<Object> updated = new ArrayList<>();

        for(Pair<Object, Long> singleItem : toAdd) {

            Long previousValue = mStaleEntries.get(singleItem.first);

            if(previousValue == null || (previousValue < singleItem.second))
            {
                mStaleEntries.put(singleItem.first, singleItem.second);
                updated.add(singleItem.first);
            }
        }
        return updated;
    }


    public abstract boolean startScan();
    public abstract boolean stopScan();
}