package gui;

import java.util.EventListener;

/**
 * Created by jourdanwoodrich on 7/4/16.
 */
public interface SettingListener extends EventListener {
    void settingEventOccurred(SettingEvent e);
}
