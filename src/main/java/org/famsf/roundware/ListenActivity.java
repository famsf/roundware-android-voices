package org.famsf.roundware;

import org.famsf.roundware.utils.LocationBg;
import org.roundware.rwapp.RwListenActivity;

/**
 *
 */
public class ListenActivity extends RwListenActivity{
    @Override
    protected void onResume() {
        super.onResume();
        LocationBg.setBackground(mBackgroundImageView, R.drawable.bg_listen, R.drawable.bg_listen_lh);
    }
}
