package com.super_league.heroes.stardroid.activities;

import android.content.Context;

import com.super_league.heroes.stardroid.inject.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by johntaylor on 4/24/16.
 */
@Module
public class CompassCalibrationModule {
  private CompassCalibrationActivity activity;
  public CompassCalibrationModule(CompassCalibrationActivity activity) {
    this.activity = activity;
  }

  @Provides
  @PerActivity
  Context provideContext() {
    return activity;
  }
}
