package com.primlo.asyncstoragedevmenuitem;

import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.devsupport.interfaces.DevOptionHandler;
import com.facebook.react.modules.core.RCTNativeAppEventEmitter;

public class AsyncStorageDevMenuItemModule extends ReactContextBaseJavaModule {
  public AsyncStorageDevMenuItemModule(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  @Override
  public String getName() {
    return "AsyncStorageDevMenuItem";
  }

  @ReactMethod
  public void initialize() {
    ReactApplication application = (ReactApplication)getReactApplicationContext()
      .getCurrentActivity()
      .getApplication();

    DevSupportManager devSupportManager = application
      .getReactNativeHost()
      .getReactInstanceManager()
      .getDevSupportManager();

    devSupportManager.addCustomDevOption("Log AsyncStorage", new DevOptionHandler() {
        @Override
        public void onOptionSelected() {
          getReactApplicationContext()
            .getJSModule(RCTNativeAppEventEmitter.class)
            .emit("LogAsyncStorage", null);
        }
    });
  }
} 