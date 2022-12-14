// Copyright 2010 Google Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.super_league.heroes.stardroid.util;

import android.os.Bundle;

import com.super_league.heroes.stardroid.StardroidApplication;

import javax.inject.Inject;

/**
 * Encapsulates interactions with Google Analytics, allowing it to be
 * disabled etc.
 *
 * @author John Taylor
 */
public class Analytics implements AnalyticsInterface {

    @Inject
    Analytics(StardroidApplication application) {
    }

    @Override
    public void setEnabled(boolean enabled) {
    }

    @Override
    public void trackEvent(String event, Bundle params) {
    }

    @Override
    public void setUserProperty(String propertyName, String propertyValue) {

    }
}
