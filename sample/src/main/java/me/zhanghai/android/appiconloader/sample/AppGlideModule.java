/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.zhanghai.android.appiconloader.sample;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;

import androidx.annotation.NonNull;
import me.zhanghai.android.appiconloader.glide.AppIconModelLoader;

@GlideModule
public class AppGlideModule extends com.bumptech.glide.module.AppGlideModule {
    @Override
    public boolean isManifestParsingEnabled() {
        return false;
    }

    @Override
    public void registerComponents(@NonNull Context context, @NonNull Glide glide,
                                   @NonNull Registry registry) {
        int iconSize = context.getResources().getDimensionPixelSize(R.dimen.app_icon_size);
        registry.prepend(PackageInfo.class, Bitmap.class, new AppIconModelLoader.Factory(iconSize,
                false, context));
    }
}
