package com.super_league.heroes.stardroid.activities;

import com.super_league.heroes.stardroid.ApplicationComponent;
import com.super_league.heroes.stardroid.activities.dialogs.EulaDialogFragment;
import com.super_league.heroes.stardroid.activities.dialogs.HelpDialogFragment;
import com.super_league.heroes.stardroid.activities.dialogs.MultipleSearchResultsDialogFragment;
import com.super_league.heroes.stardroid.activities.dialogs.NoSearchResultsDialogFragment;
import com.super_league.heroes.stardroid.activities.dialogs.NoSensorsDialogFragment;
import com.super_league.heroes.stardroid.activities.dialogs.TimeTravelDialogFragment;
import com.super_league.heroes.stardroid.inject.PerActivity;

import dagger.Component;

/**
 * Created by johntaylor on 3/29/16.
 */
@PerActivity
@Component(modules = DynamicStarMapModule.class, dependencies = ApplicationComponent.class)
public interface DynamicStarMapComponent extends EulaDialogFragment.ActivityComponent,
    TimeTravelDialogFragment.ActivityComponent, HelpDialogFragment.ActivityComponent,
    NoSearchResultsDialogFragment.ActivityComponent,
    MultipleSearchResultsDialogFragment.ActivityComponent,
    NoSensorsDialogFragment.ActivityComponent {
  void inject(DynamicStarMapActivity activity);
}

