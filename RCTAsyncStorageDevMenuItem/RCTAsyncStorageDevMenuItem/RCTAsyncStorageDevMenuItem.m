#import "RCTAsyncStorageDevMenuItem.h"
#import <React/RCTDevMenu.h>

@implementation RCTAsyncStorageDevMenuItem

RCT_EXPORT_MODULE();

- (dispatch_queue_t)methodQueue
{
  return dispatch_get_main_queue();
}

- (NSArray<NSString *> *)supportedEvents
{
  return @[@"LogAsyncStorage"];
}

RCT_EXPORT_METHOD(initialize)
{
  [self.bridge.devMenu addItem:[RCTDevMenuItem buttonItemWithTitleBlock:^NSString *{
    return @"Log AsyncStorage";
  } handler:^{
    [self sendEventWithName:@"LogAsyncStorage" body:nil];
  }]];
}

@end
