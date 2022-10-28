package com.super_league.heroes.stardroid.activities;

import com.super_league.heroes.stardroid.ApplicationComponent;
import com.super_league.heroes.stardroid.inject.PerActivity;

import dagger.Component;

/**
 * Created by johntaylor on 4/15/16.
 */
@PerActivity
@Component(modules = DiagnosticActivityModule.class, dependencies = ApplicationComponent.class)
public interface DiagnosticActivityComponent {
  void inject(DiagnosticActivity activity);
}
