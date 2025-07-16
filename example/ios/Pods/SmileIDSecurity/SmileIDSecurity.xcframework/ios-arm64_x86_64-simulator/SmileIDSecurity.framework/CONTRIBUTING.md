# Smile ID Secure iOS SDK

## 0. Overview

This repo contains all the code required to run the Smile ID Secure iOS SDK. The project folder structure is described below.

- `Sources`- Contains all source code
- `CHANGELOG.md` - Contains a list of changes
- `SECRET` - Contains the secret value
- `VERSION` - Contains the version of the package

## 1. Requirements

- iOS 13 or higher
- Xcode 14 or higher

To generate the xcodeproj file, we use xcodegen. To install xcodegen run:
```shell
brew install xcodegen
```

Then, to generate the xcodeproj file run:

```shell
xcodegen
```
This needs to be run whenever there is a change in the file structure (eg. after a git pull and new files are being added to the project). 

## 2. Github Actions

We have a workflow in this project: [.github/workflows/build-framework.yml](https://github.com/smileidentity/ios-secure/blob/main/.github/workflows/build-framework.yml) which contains the jobs `build` and `release`. The build job is trigged on every `pull request` and builds and XCFramework. The release job is trigged on a manual `workflow_dispatch` event and pushes the XCFramework to the [SmileID Security](https://github.com/smileidentity/smile-id-security) repository, which hold and releases all versions to cocoapods and SPM.

## 3. Releasing a new SDK version flow

1. (Optional) If there are any changes needed on the closed source dependency, create a new PR and merge this in.
2. Before releasing changes on [Secret Rotator](https://github.com/smileidentity/secret-rotator) repository, trigger a [.github/workflows/rotate.yml](https://github.com/smileidentity/secret-rotator/blob/main/.github/workflows/rotate.yml) workflow, select iOS and enter the sdk version (ie. the version under which you intent to release you changes).
3. This will rotate the secret and update dynamo. You need to manually update this on the repo untill we fix this to automatically do that
4. Update the `SmileIDSecurity` version in [SmileID's iOS](https://github.com/smileidentity/ios) and proceed with your release.
