package org.famsf.roundware;

import org.famsf.roundware.utils.LocationBg;
import org.roundware.rwapp.RwRefineActivity;

/**
 * Created by madler on 2/26/15.
 */
public class RefineActivity extends RwRefineActivity{

    @Override
    protected String mungeUrlData(String input) {
        return LocationBg.mungeUrlData( super.mungeUrlData(input) );
    }
}
