/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.systemui.statusbar.pipeline.wifi.data.repository.prod

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.android.systemui.SysuiTestCase
import com.android.systemui.statusbar.pipeline.shared.data.model.DataActivityModel
import com.android.systemui.statusbar.pipeline.wifi.shared.model.WifiNetworkModel
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@SmallTest
@RunWith(AndroidJUnit4::class)
class DisabledWifiRepositoryTest : SysuiTestCase() {

    private lateinit var underTest: DisabledWifiRepository

    @Before
    fun setUp() {
        underTest = DisabledWifiRepository()
    }

    @Test
    fun enabled_alwaysFalse() {
        assertThat(underTest.isWifiEnabled.value).isEqualTo(false)
    }

    @Test
    fun default_alwaysFalse() {
        assertThat(underTest.isWifiDefault.value).isEqualTo(false)
    }

    @Test
    fun network_alwaysUnavailable() {
        assertThat(underTest.wifiNetwork.value).isEqualTo(WifiNetworkModel.Unavailable)
    }

    @Test
    fun activity_alwaysFalse() {
        assertThat(underTest.wifiActivity.value)
            .isEqualTo(DataActivityModel(hasActivityIn = false, hasActivityOut = false))
    }
}
