# Release Notes

## 11.2.1 - November 10, 2025

### Changed
* Bump Android SDK to [v11.1.4](https://github.com/smileidentity/android/releases/tag/v11.1.4)
* Bump iOS SDK to [v11.1.3](https://github.com/smileidentity/ios/releases/tag/v11.1.3)

## 11.2.0 - October 7, 2025

### 🚀 Major Updates
* **Upgraded Expo SDK from 53 to 54** - Full compatibility with the latest Expo release
    * Updated React and React Native to latest compatible versions
    * Updated Kotlin to version 2.1.20 and removed dependencies pinned to Kotlin 2.0.21 for Expo SDK 54 compatibility
    * Upgraded Android Gradle Plugin (AGP) to version 8.13

### Changed
* **Android SDK**: Bumped to [v11.1.2](https://github.com/smileidentity/android/releases/tag/v11.1.2)
* **sample-react-native**: Updated Metro and package configuration to use local SDK source, fixed iOS entry point, and resolved TypeScript type and path issues

### Added
* Added Dependabot for automatic dependency updates.

## 11.1.1 - August 26, 2025

### Changed
* Bump iOS to 11.1.1 (https://github.com/smileidentity/ios/releases/tag/v11.1.1)

## 11.1.0 - August 5, 2025

### Changed
* Changed `enableAutoCapture` to `AutoCapture` enum to allow partners change document capture options
* Upgraded Smile ID Android and iOS SDKs to version **v11.1.0**.
* Bumped `compileSdkVersion` to 36 and resolved related build issues.

### Added
* Added `autoCaptureTimeout` to allow partners to configure the auto-capture timeout duration.

### Removed
* Removed the default `ConsentInformation`

## 11.0.0 - July 31, 2025

* Initial Release
