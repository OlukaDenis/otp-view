# OtpPinView

A highly customizable OTP (One-Time Password) input view for Android, supporting multiple lines, custom shapes, and extensive styling options.

![License](https://img.shields.io/badge/license-Apache%202.0-blue.svg)

## Features

- **Customizable Shapes**: Support for both Rectangular and Circular fields.
- **Auto-wrapping**: Supports multiple lines if the number of fields exceeds `maxCountPerLine`.
- **Dynamic Styling**: Easily change colors, sizes, borders, and text styles via XML or Kotlin.
- **Feedback Animations**: Built-in shake animation and vibration for error states.
- **Password Mode**: Mask input for sensitive OTPs.
- **Auto-sizing**: Option to automatically fit fields within the available container width.
- **Event Callbacks**: Simple interfaces for completion and text change events.

## Installation

### Step 1: Add the JitPack repository to your build file
Add it in your root `build.gradle.kts` at the end of repositories:

```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}
```

### Step 2: Add the dependency
Add the following dependency to your app's `build.gradle.kts`:

```kotlin
dependencies {
    implementation("com.github.OlukaDenis:otpview:1.0.0")
}
```

---

## Usage

### XML Implementation
Add the `OtpPinView` to your layout file:

```xml
<com.dennnytech.otpview.OtpPinView
    android:id="@+id/otpView"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:squareCount="6"
    app:maxCountPerLine="6"
    app:squareSize="48dp"
    app:cornerRadius="8dp"
    app:borderWidth="1dp"
    app:borderColor="#CCCCCC"
    app:highlightColor="#6200EE"
    app:onCompleteBorderColor="#4CAF50"
    app:onOTPErrorBorderColor="#F44336"
    app:inputType="number"
    app:isPassword="false"
    app:showCursor="true"
    app:textSize="24"
    app:textStyle="bold" />
```

### Programmatic Usage (Kotlin)
You can interact with the `OtpPinView` in your Activity or Fragment:

```kotlin
val otpView = findViewById<OtpPinView>(R.id.otpView)

// Set completion listener (triggered when all fields are filled)
otpView.setOnCompleteListener { otp ->
    Toast.makeText(this, "OTP Entered: $otp", Toast.LENGTH_SHORT).show()
}

// Set change listener (triggered on every character change)
otpView.setOnChangedListener { otp ->
    // Handle text changes
}

// Trigger error state (shake animation + vibration)
otpView.onOtpError(clearOtp = true)

// Dynamically update properties
otpView.setSquareCount(4)
otpView.setSquareColor(Color.LTGRAY)
otpView.setTextColor(Color.BLACK)
```

---

## Customization Attributes

| Attribute | Format | Description |
|-----------|--------|-------------|
| `squareColor` | color | Background color of the OTP squares. |
| `squareSize` | dimension | Default size (width & height) of the squares. |
| `squareWidth` | dimension | Specific width of the squares (overrides `squareSize`). |
| `squareHeight` | dimension | Specific height of the squares (overrides `squareSize`). |
| `squareCount` | integer | Total number of OTP squares. |
| `maxCountPerLine` | integer | Maximum number of squares per line before wrapping. |
| `cornerRadius` | dimension | Corner radius for the squares (if shape is rectangle). |
| `shape` | string | Shape of the fields: `rectangle` or `circle`. |
| `borderWidth` | dimension | Thickness of the square border. |
| `borderColor` | color | Default color of the border. |
| `highlightColor` | color | Border color when a field is focused. |
| `onCompleteBorderColor` | color | Border color when all fields are filled. |
| `onOTPErrorBorderColor` | color | Border color when `onOtpError()` is called. |
| `textColor` | color | Color of the entered text. |
| `textSize` | float | Size of the text. |
| `textStyle` | string | Style of the text: `normal`, `bold`, `italic`, `bold_italic`. |
| `fontFamily` | string | Custom font family for the text. |
| `hint` | string | Hint text for empty fields. |
| `hintTextColor` | color | Color of the hint text. |
| `inputType` | string | Input type: `number` or `text`. |
| `isPassword` | boolean | If true, masks the input characters. |
| `showCursor` | boolean | If true, shows the cursor in the active field. |
| `autoSize` | boolean | If true, automatically adjusts square sizes to fit container width. |
| `margins` | integer | Margins between the squares. |

---

## Public Methods

- `setSquareCount(count: Int)`: Updates the number of OTP fields.
- `setInputType(type: Int)`: Sets input type (e.g., `InputType.TYPE_CLASS_NUMBER`).
- `onOtpError(clearOtp: Boolean)`: Triggers an error animation and optional clear.
- `toggleAutoSizing(enabled: Boolean)`: Enables or disables auto-sizing mode.
- `setSquareColor(color: Int)`: Updates the background color of fields.
- `setBorderColor(color: Int)`: Updates the default border color.
- `setTextColor(color: Int)`: Updates the text color.
- `setTextSize(size: Float)`: Updates the text size.
- `setOnCompleteListener(handler)`: Callback for when the OTP is fully entered.
- `setOnChangedListener(handler)`: Callback for every character change.

---

## Publishing the Library

This library is configured to be published via **JitPack**.

### 1. Prepare for Release
Ensure your `otpview/build.gradle.kts` has the correct `version`, `groupId`, and `artifactId`:
```kotlin
afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])
                groupId = "com.github.OlukaDenis"
                artifactId = "otpview"
                version = "1.0.0"
            }
        }
    }
}
```

### 2. Push to GitHub
Commit and push your changes to your GitHub repository.

### 3. Create a Release
1. Go to your repository on GitHub.
2. Click on **Releases** -> **Create a new release**.
3. Set the tag version (e.g., `1.0.0`) and title.
4. Publish the release.

### 4. Verify on JitPack
Go to [jitpack.io](https://jitpack.io), enter your repository URL, and click **Get it**. JitPack will build the library and provide the implementation coordinates.

---

## License
```
Copyright 2024 Oluka Denis

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
