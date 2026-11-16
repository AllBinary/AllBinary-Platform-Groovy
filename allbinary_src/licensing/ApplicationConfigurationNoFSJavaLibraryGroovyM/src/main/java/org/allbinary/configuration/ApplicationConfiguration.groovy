/* Generated Code Do Not Modify */
package org.allbinary.configuration;

import org.allbinary.game.configuration.feature.Feature;
import org.allbinary.game.configuration.feature.Features;
import org.allbinary.game.configuration.feature.MainFeatureFactory;
import org.allbinary.logic.NullUtil;
import org.allbinary.logic.communication.log.LogUtil;
import org.allbinary.logic.string.StringMaker;
import org.allbinary.string.CommonStrings;

@groovy.transform.CompileStatic
public class ApplicationConfiguration {
    protected final LogUtil logUtil = LogUtil.getInstance();

    private static Object instance = NullUtil.getInstance().@NULL_OBJECT;

    public static ApplicationConfiguration getInstance() {
        if (ApplicationConfiguration.instance === NullUtil.getInstance().@NULL_OBJECT) {
            ApplicationConfiguration.instance = new ApplicationConfiguration();
        }
        return ((ApplicationConfiguration) ApplicationConfiguration.instance);
    }

    /*      * private boolean fullscreen = true; private boolean showTitleBar = true;      * protected boolean progressBarView = true;      */
    private boolean fullscreen = true;

    private boolean showTitleBar = false;

    private boolean progressBarView = false;

    //private final String FILE = "ReloadConfiguration.dat";
    private ApplicationConfiguration() {
        try {
            //            {
            this.read();
        } catch (Exception e) {
            final CommonStrings commonStrings = CommonStrings.getInstance();
            this.logUtil.put(commonStrings.@EXCEPTION, this, commonStrings.@CONSTRUCTOR, e);
        }
    }

    private void read() throws Exception {
        //        {
        this.setFullscreen(true);
        //        {
        this.setProgressBarView(false);
        //        {
        this.setShowTitleBar(false);
        //PreLogUtil.put("Read Configuration: " + this.toString(), this, "read");
        this.logUtil.putF('Read Configuration: ' + this.toString(), this, 'read');
    }

    public void write() throws Exception {
    }

    public void update(final Feature gameFeature) throws Exception {
        if (gameFeature === MainFeatureFactory.getInstance().@FULL_SCREEN) {
            final Features features = Features.getInstance();
            if (features.isFeature(gameFeature)) {
                if (!this.isFullscreen()) {
                    this.setFullscreen(true);
                    this.write();
                }
            } else {
                if (this.isFullscreen()) {
                    this.setFullscreen(false);
                    this.write();
                }
            }
        }
    }

    public void setFullscreen(final boolean fullscreen) {
        this.fullscreen = fullscreen;
    }

    public boolean isFullscreen() {
        return this.fullscreen;
    }

    public void setShowTitleBar(final boolean showTitleBar) {
        this.showTitleBar = showTitleBar;
    }

    public boolean isShowTitleBar() {
        return this.showTitleBar;
    }

    public void setProgressBarView(final boolean progressBarView) {
        this.progressBarView = progressBarView;
    }

    public boolean isProgressBarView() {
        return this.progressBarView;
    }

    public String toString() {
        final StringMaker stringBuffer = new StringMaker();
        stringBuffer.append('isFullscreen: ');
        stringBuffer.appendboolean(this.isFullscreen());
        stringBuffer.append(' isProgressBarView: ');
        stringBuffer.appendboolean(this.isProgressBarView());
        stringBuffer.append(' isShowTitleBar: ');
        stringBuffer.appendboolean(this.isShowTitleBar());
        return stringBuffer.toString();
    }

}


