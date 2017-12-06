import { NativeModules, NativeEventEmitter, AsyncStorage } from 'react-native'
import logAsyncStorage from 'react-native-log-async-storage'

if (__DEV__) {
  const AsyncStorageDevMenuItem = NativeModules.AsyncStorageDevMenuItem
  const asyncStorageDevMenuItemEmitter = new NativeEventEmitter(
    AsyncStorageDevMenuItem,
  )

  asyncStorageDevMenuItemEmitter.addListener('LogAsyncStorage', logAsyncStorage)

  AsyncStorageDevMenuItem.initialize()
}
