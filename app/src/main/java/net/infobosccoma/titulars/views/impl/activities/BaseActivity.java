package net.infobosccoma.titulars.views.impl.activities;

import android.support.v7.app.ActionBarActivity;

import com.octo.android.robospice.SpiceManager;
import com.octo.android.robospice.request.listener.RequestListener;

import net.infobosccoma.titulars.models.business.entities.Titular;
import net.infobosccoma.titulars.network.TitularsRetrofitSpiceService;

/**
 * This class is the base class of all activities of the sample project. This class offers all
 * subclasses an easy access to a {@link SpiceManager} that is linked to the {@link ActionBarActivity}
 * lifecycle. Typically, in a new project, you will have to create a base class like this one and
 * copy the content of the {@link TitularsRetrofitSpiceService} into your own class.
 *
 * @author mnicolau
 */
public abstract  class BaseActivity extends ActionBarActivity {

    private SpiceManager spiceManager = new SpiceManager(TitularsRetrofitSpiceService.class);

    @Override
    protected void onStart() {
        spiceManager.start(this);
        super.onStart();
    }

    @Override
    protected void onStop() {
        spiceManager.shouldStop();
        super.onStop();
    }

    public SpiceManager getSpiceManager() {
        return spiceManager;
    }

    public abstract RequestListener<?> getListListener();
    public abstract RequestListener<?> getUpdateListener();

}
