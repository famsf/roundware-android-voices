package org.famsf.roundware.utils;

import android.location.Location;
import android.util.Log;
import android.widget.ImageView;

import org.roundware.service.RWLocationTracker;

/**
 * Simple static class to determine if the application is running closer to the de Young or to the
 * Legion of Honor allowing the Activities to change their background images.
 */
public class LocationBg {
    public static final String LOGTAG = LocationBg.class.getSimpleName();

    // Sites
    public final static int DE_YOUNG = 0;
    public final static int LEGION_OF_HONOR = 1;

    public final static Double DY_LATITUDE = 37.7715173;
    public final static Double DY_LONGITUDE = -122.46873260000001;

    public final static Double LOH_LATITUDE = 37.7844661;
    public final static Double LOH_LONGITUDE = -122.50084190000001;

    private LocationBg() {
    }

    public static int getSite(Location location) {
        if (location == null) {
            Log.d(LOGTAG, "Location is null, returning De Young by default.");
            return DE_YOUNG;
        }

        Location dy = new Location("");
        dy.setLatitude(DY_LATITUDE);
        dy.setLongitude((DY_LONGITUDE));

        Location loh = new Location("");
        loh.setLatitude(LOH_LATITUDE);
        loh.setLongitude(LOH_LONGITUDE);

        float dyDist = location.distanceTo(dy);
        float lohDist = location.distanceTo(loh);

        if (dyDist < lohDist) {
            Log.d(LOGTAG, "Location closer to De Young.");
            return DE_YOUNG;
        }
        Log.d(LOGTAG, "Location closer to Legion of Honor.");
        return LEGION_OF_HONOR;
    }

    /**
     * @return if closer to legion of honor
     */
    private static boolean isLocationAtLegionOfHonor(){
        Location location = RWLocationTracker.instance().getLastLocation();
        return location != null && LocationBg.getSite(location) == LocationBg.LEGION_OF_HONOR;
    }

    /**
     * sets the background based on location
     * @param bg
     * @param deYoungResId
     * @param legionHonorResId
     */
    public static void setBackground(ImageView bg, int deYoungResId, int legionHonorResId){
        if(isLocationAtLegionOfHonor()){
            bg.setImageResource(legionHonorResId);
        } else {
            bg.setImageResource(deYoungResId);
        }
    }

    /**
     * munges the data so the background is based on location
     * @param input
     * @return
     */
    public static String mungeUrlData(String input){
        if(!isLocationAtLegionOfHonor()) {
            return input.replace("/*%roundware_theme%*/", "roundware_theme = '_dy';");
        }else {
            return input;
        }
    }
}
