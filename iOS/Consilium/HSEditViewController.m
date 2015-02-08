
//
//  HSEditViewController.m
//  Consilium
//
//  Created by Amog Kamsetty on 2/7/15.
//  Copyright (c) 2015 Amog Kamsetty. All rights reserved.
//

#import "HSEditViewController.h"

@interface HSEditViewController ()

@end

@implementation HSEditViewController


- (void)viewDidLoad
{
    [super viewDidLoad];
    self.textField1 = [[UITextField alloc] initWithFrame:CGRectMake(0, 50, 325, 100)];
    self.textField1.font = [UIFont fontWithName:@"Helvetica" size:20];
    self.textField1.backgroundColor=[UIColor clearColor];
    self.textField1.returnKeyType = UIReturnKeyDone;
    self.textField1.delegate = self;
    if(self.asignment.firstname == nil)
    {
        self.textField1.placeholder=@"First Name";
    }
    else
    {
        self.textField1.text = self.player.firstname;
        self.firstname = self.player.firstname;
    }

}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
}

@end
