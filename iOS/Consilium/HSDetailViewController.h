//
//  HSDetailViewController.h
//  Consilium
//
//  Created by Amog Kamsetty on 2/7/15.
//  Copyright (c) 2015 Amog Kamsetty. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "Assignment.h"

@interface HSDetailViewController : UIViewController

@property (nonatomic,strong) Assignment *assignment;
@property (nonatomic,strong) UILabel *myLabel;


-(void)updateAssignment:(Assignment *)assignment;

@end
