## To run the tests

1) Start appium `appium -p 4723`
2) Keep emulator open
3) Run the tests in eclipse

## For inspecting elements

1) Start appium `appium -p 4723`
2) Start appium inspector with below capabilities.

```json
TheApp
{
  "platformName": "android",
  "appium:automationName": "uiautomator2",
  "appium:platformVersion": "10.0",
  "appium:deviceName": "Automation",
  "appium:app": "/Users/sriramku/Downloads/TheApp-v1.10.0.apk",
  "appium:appPackage": "io.cloudgrey.the_app",
  "appium:appActivity": "io.cloudgrey.the_app.MainActivity"
}
```


## Install Java 8, Open JDK from below link
- https://adoptium.net/temurin/releases?version=8

## Install android studio & setup env variables, emulator

Vi ~/.bash_profile would look like this
```console
export JAVA_HOME=/Library/Java/JavaVirtualMachines/temurin-11.jdk/Contents/Home
export ANDROID_HOME=${HOME}/Library/Android/sdk
export PATH="/Users/sriramku/Downloads/apache-jmeter-5.5/bin:${ANDROID_HOME}/emulator:${JAVA_HOME}/bin:${ANDROID_HOME}/tools:${ANDROID_HOME}/platform-tools:${PATH}"
```

## Install appium inspector
- https://github.com/appium/appium-inspector
-in releases install latest dmg file

## Install appium
```console
npm install -g appium@next
npm i appium@2.0.0-beta.43
sudo npm install -g appium@2.0.0-beta.43
```

## Install appium doctor
```console
npm install -g appium-doctor
```

## Use appium-doctor to verify things
```console
appium-doctor --android -> To check if android setup is fine
appium-doctor --ios -> To check if ios setup is fine
```

## install the Appium drivers
```console
appium driver list
appium driver install xcuitest
appium driver install uiautomator2
```

Now to verify if its been installed, you can run - appium driver list

## Setup project
```console
npm init -y
npm install @wdio/cli
npx wdio config
```

## start appium locally
```console
appium driver list
appium -p 4724
appium driver install uiautomator2
appium driver install xcuitest
```

## appium inspector

Start appium on terminal
`appium -p 4724`

- Start desired emulator
- In appium inspector
- use 0.0.0.0 & port as 4724, we dont use 4723 so that we dont get port conflicts.
- Now start session with capabilities on appium inspector.

## Locators

- Accessibility Id : $('~App'); Here, tilt symbol for accessibility id
- UI automator locator link: https://appium.io/docs/en/writing-running-appium/android/uiautomator-uiselector/

