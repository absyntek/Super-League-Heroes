package com.super_league.heroes.stardroid.activities;

import com.super_league.heroes.stardroid.ApplicationComponent;
import com.super_league.heroes.stardroid.inject.PerActivity;

import dagger.Component;

/**
 * Created by johntaylor on 4/24/16.
 */
@PerActivity
@Component(modules = CompassCalibrationModule.class, dependencies = ApplicationComponent.class)
public interface CompassCalibrationComponent {
  void inject(CompassCalibrationActivity activity);
}

