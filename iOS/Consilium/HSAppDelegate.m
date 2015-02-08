//
//  HSAppDelegate.m
//  Consilium
//
//  Created by Amog Kamsetty on 2/7/15.
//  Copyright (c) 2015 Amog Kamsetty. All rights reserved.
//

#import "HSAppDelegate.h"
#import "HSViewController.h"
#import "Assignment.h"

@implementation HSAppDelegate


- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions
{
    HSViewController *firstVC = [[HSViewController alloc] init];
    UINavigationController *firstNavVC = [[UINavigationController alloc] initWithRootViewController:firstVC];
    firstVC.title = @"Assignment";
    firstVC.assignments = [[NSArray alloc] init];
    
    Assignment *ass1 = [[Assignment alloc] initWithName:@"APUSH"];
    Assignment *ass2 = [[Assignment alloc] initWithName:@"APENG"];
    Assignment *ass3 = [[Assignment alloc] initWithName:@"Religion"];
    NSArray *assignments = @[ass1,ass2,ass3];
    [firstVC updateAssignments:assignments];
    
    
    UINavigationBar *navBar = firstNavVC.navigationBar;
    navBar.barTintColor = [UIColor colorWithRed:242.0 / 255.0 green:122.0 / 255.0 blue:87.0 / 255.0 alpha:1.0];
    navBar.tintColor = [UIColor whiteColor];
    navBar.barStyle = UIBarStyleBlackOpaque;
    
    self.window = [[UIWindow alloc] initWithFrame:[UIScreen mainScreen].bounds];
    self.window.rootViewController = firstNavVC;
    [self.window makeKeyAndVisible];
    return YES;
}
							
- (void)applicationWillResignActive:(UIApplication *)application
{
    
}

- (void)applicationDidEnterBackground:(UIApplication *)application
{
    
}

- (void)applicationWillEnterForeground:(UIApplication *)application
{
    
}

- (void)applicationDidBecomeActive:(UIApplication *)application
{

}

- (void)applicationWillTerminate:(UIApplication *)application
{
    
}

@end
