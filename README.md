1. In your app `build.gradle` file paste:
>`implementation 'com.github.ClisbyShawn:android-auth:v1.0.0'`

2. Create a subclass of `Application` and override the `onCreate` lifecycle method.
  <br>a. Below `super.onCreate()` method call `TokenEntry.init(applicationContext, fileName, key)`. The `key` and `fileName` arguments are both Strings and the `applicationContext` can be the `Application` subclass.
  <br>b. Below `TokenEntry.init()` call `AuthHTTP.init(url:String)`. Passing in the endpoint of the Authentication/Authorization whose paths end in `login` and `me`.
