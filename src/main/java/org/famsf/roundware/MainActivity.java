package org.famsf.roundware;

import android.location.Location;

import org.famsf.roundware.utils.LocationBg;
import org.roundware.rwapp.RwMainActivity;
import org.roundware.service.RWLocationTracker;

/**
 *
 */
public class MainActivity extends RwMainActivity {

    @Override
    protected void onResume() {
        super.onResume();
        LocationBg.setBackground(mBackgroundImageView, R.drawable.bg_home, R.drawable.bg_home_lh);
    }

}
