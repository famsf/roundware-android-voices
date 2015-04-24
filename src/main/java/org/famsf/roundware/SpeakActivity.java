package org.famsf.roundware;

import org.famsf.roundware.utils.LocationBg;
import org.roundware.rwapp.RwSpeakActivity;


/**
 *
 */
public class SpeakActivity extends RwSpeakActivity {

    @Override
    protected void onResume() {
        super.onResume();
        LocationBg.setBackground(mBackgroundImageView, R.drawable.bg_speak, R.drawable.bg_speak_lh);
    }

    @Override
    protected String mungeUrlData(String input) {
        return LocationBg.mungeUrlData( super.mungeUrlData(input) );
    }
}
