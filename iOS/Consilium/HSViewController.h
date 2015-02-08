//
//  HSViewController.h
//  Consilium
//
//  Created by Amog Kamsetty on 2/7/15.
//  Copyright (c) 2015 Amog Kamsetty. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface HSViewController : UITableViewController
@property (nonatomic, strong) NSArray *assignments;
-(void) updateAssignments:(NSArray *)assignments;
@end
