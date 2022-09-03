## Mobile workshop

Slide Deck:
https://slides.com/ushasai/palette#/44

Setup instructions:
https://github.com/saikrishna321/VodQa_MobileAutomationWorkShop/wiki/Appium-Mac-Installation 

Native APK link: (VodQA)
https://github.com/saikrishna321/VodQaAdvancedAppium/blob/master/apps/VodQA.apk 

Hybrid APK link: (The App)
https://github.com/cloudgrey-io/the-app/releases/download/v1.10.0/TheApp-v1.10.0.apk 

API Demos apk: (API Demos)
https://github.com/saikrishna321/VodQaAdvancedAppium/blob/master/apps/ApiDemos.apk

Repo for Java Code
https://github.com/UshaSaiC/AppiumWorkshop 

Note: Add appium wait plugin to handle waits automatically

adb —version

List of devices running

adb devices

adb start-server

adb kill-server


Emulator commands

List of AVD’s
cd ${ANDROID_HOME}/emulator
./emulator -list-avds

To run a AVD:
./emulator -avd AVD_NAME
./emulator -avd Nexus_6_API_29

then do 
adb devices
it gives below output saying one emulator is running
emulator-5554	device


Few ADB actions

1. Install an app using comands
 adb install ~/Downloads/VodQA.apk

2. UnInstall an app using comands
 Open the emulator and open app and keep it running
Use below command to find package & activity
adb shell dumpsys window | grep -E 'mCurrentFocus'
This lists package & activity
mCurrentFocus=Window{fe35644 u0 com.vodqareactnative/com.vodqareactnative.MainActivity}
1st part is package name, 2nd part is activity

adb uninstall <package_name>
adb uninstall com.vodqareactnative

3. Screenshot 
adb shell screencap -p /sdcard/screencap5.png
Pull the screenshot to our desktop
adb pull /sdcard/screencap5.png

4. Record screen 
screenrecord  /sdcard/screenrecord5.mp4
pull the recording file
adb pull /sdcard/screenrecord5.mp4




Appium Inspector

1) start appium

command: 
appium
or
appium -p 4724

2) start appium inspector, give capabilities

VodQA app
{
  "platformName": "android",
  "appium:automationName": "uiautomator2",
  "appium:platformVersion": "10.0",
  "appium:deviceName": "Automation",
  "appium:app": "/Users/sriramku/Downloads/VodQA.apk",
  "appium:appPackage": "com.vodqareactnative",
  "appium:appActivity": "com.vodqareactnative.MainActivity"
}

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

Browser (Appium inspector not needed for browser -> chrome browser locators should be fine inspect)
{
  "platformName": "Android",
  "appium:automationName": "UiAutomator2",
  "appium:platformVersion": "10.0",
  "appium:browserName": "Chrome",
  "appium:deviceName": "Android",
  "appium:chromedriverExecutable": "/Users/sriramku/eclipse-workspace/AppiumJava2022/Drivers/chromedriver"
}




3) To check appium drivers installed

appium driver list —installed

to install uiautomator2 and xcuitest drivers

appium driver install uiautomator2
appium driver install xcuitest

Locators

We use 
AppiumBy.id(“***”)
AppiumBy.accessibilityid(“***”)
AppiumBy.androidUIAutomator(“textStartsWith(\“ some text \”)”)

For espresso
Android view tag
Android data matcher

Task

Use “The App”
 1) Login Demo - 
Provide random creds and login and assert on alert message

2) Clipboard demo -
Set a clipboard text and refresh it and verify the data    

3) Picker demo - 
Set a month and date and assert on month and date in alert message










Notes
===========

adb devices → to find the list of connected devices 
adb install [options] path_to_package/path_to_app → install a package/app on connected devices 
adb uninstall path_to_package/path_to_app → uninstall a package/app from connected devices 
adb logcat → to display log of connected devices 
adb logcat > path_to_file/log.txt → to store adb logs in a txt file 
adb kill-server → to kill adb server 
adb start-server → to start adb server


