package org.famsf.roundware;

import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;
import org.roundware.rwapp.RwApplication;
import org.roundware.rwapp.utils.ClassRegistry;

/**
 *
 */
public class MyApplication extends RwApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());

        // Override the original Activities
        ClassRegistry.register("RwMainActivity", org.famsf.roundware.MainActivity.class);
        ClassRegistry.register("RwSpeakActivity", org.famsf.roundware.SpeakActivity.class);
        ClassRegistry.register("RwListenActivity", org.famsf.roundware.ListenActivity.class);
    }
}
