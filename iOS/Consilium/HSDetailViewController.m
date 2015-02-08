//
//  HSDetailViewController.m
//  Consilium
//
//  Created by Amog Kamsetty on 2/7/15.
//  Copyright (c) 2015 Amog Kamsetty. All rights reserved.
//

#import "HSDetailViewController.h"

@interface HSDetailViewController ()

@end

@implementation HSDetailViewController



- (void)viewDidLoad
{
    self.view.backgroundColor = [UIColor colorWithWhite:1.0 alpha:0.95];
    self.myLabel = [[UILabel alloc]initWithFrame:CGRectMake(120,300, 175, 100)];
    self.myLabel.font = [UIFont fontWithName:@"Helvetica" size:35];
    self.myLabel.adjustsFontSizeToFitWidth = YES;
    [self.myLabel setBackgroundColor:[UIColor clearColor]];
    [self.myLabel setText: [self.assignment name]];
    [self.view addSubview:self.myLabel];
}

-(void)updateAssignment:(Assignment *)assignment
{
    self.assignment = assignment;
    [self.myLabel setText:[self.assignment name]];
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
}

@end
