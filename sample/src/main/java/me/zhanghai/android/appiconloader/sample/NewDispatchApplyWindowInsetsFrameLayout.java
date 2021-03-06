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
import android.util.AttributeSet;
import android.view.WindowInsets;
import android.widget.FrameLayout;

import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;

public class NewDispatchApplyWindowInsetsFrameLayout extends FrameLayout {
    public NewDispatchApplyWindowInsetsFrameLayout(@NonNull Context context) {
        super(context);
    }

    public NewDispatchApplyWindowInsetsFrameLayout(@NonNull Context context,
                                                   @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public NewDispatchApplyWindowInsetsFrameLayout(@NonNull Context context,
                                                   @Nullable AttributeSet attrs,
                                                   @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public NewDispatchApplyWindowInsetsFrameLayout(@NonNull Context context,
                                                   @Nullable AttributeSet attrs,
                                                   @AttrRes int defStyleAttr,
                                                   @StyleRes int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @NonNull
    @Override
    public WindowInsets dispatchApplyWindowInsets(@NonNull WindowInsets insets) {
        for (int i = 0, count = getChildCount(); i < count; ++i) {
            getChildAt(i).dispatchApplyWindowInsets(insets);
        }
        return insets;
    }
}
