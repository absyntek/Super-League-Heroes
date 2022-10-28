package com.super_league.heroes.stardroid.activities;

import com.super_league.heroes.stardroid.ApplicationComponent;
import com.super_league.heroes.stardroid.activities.dialogs.EulaDialogFragment;
import com.super_league.heroes.stardroid.activities.dialogs.WhatsNewDialogFragment;
import com.super_league.heroes.stardroid.inject.PerActivity;

import dagger.Component;

/**
 * Created by johntaylor on 4/2/16.
 */
@PerActivity
@Component(modules = SplashScreenModule.class, dependencies = ApplicationComponent.class)
public interface SplashScreenComponent extends EulaDialogFragment.ActivityComponent,
    WhatsNewDialogFragment.ActivityComponent {
  void inject(SplashScreenActivity activity);
}
