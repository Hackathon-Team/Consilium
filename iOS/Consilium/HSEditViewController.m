
//
//  HSEditViewController.m
//  Consilium
//
//  Created by Amog Kamsetty on 2/7/15.
//  Copyright (c) 2015 Amog Kamsetty. All rights reserved.
//

#import "HSEditViewController.h"
#import "HSViewController.h"

@interface HSEditViewController ()

@property (nonatomic,strong) NSString *name;

@end

@implementation HSEditViewController



- (void)viewDidLoad
{
    [super viewDidLoad];
    self.view.backgroundColor = [UIColor whiteColor];
    self.navigationItem.rightBarButtonItem = [[UIBarButtonItem alloc] initWithBarButtonSystemItem:UIBarButtonSystemItemDone target:self action:@selector(done)];
    self.textField1 = [[UITextField alloc] initWithFrame:CGRectMake(0, 50, 325, 100)];
    self.textField1.font = [UIFont fontWithName:@"Helvetica" size:20];
    self.textField1.backgroundColor=[UIColor clearColor];
    self.textField1.returnKeyType = UIReturnKeyDone;
    self.textField1.delegate = self;
    if(self.assignment.name == nil)
    {
        self.textField1.placeholder=@"Assignment Name";
    }
    else
    {
        self.textField1.text = self.assignment.name;
        self.name = self.assignment.name;
    }
    UITapGestureRecognizer *gestureRecognizer = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(hideKeyboard)];
    gestureRecognizer.delegate = self;
    [self.view addGestureRecognizer:gestureRecognizer];
    [self.view addSubview:self.textField1];
}

-(void) updateAssignment:(Assignment *)assignment
{
    self.assignment = assignment;
}

- (BOOL)textFieldShouldBeginEditing:(UITextField *)textField
{
    if (textField.placeholder != nil)
    {
        textField.text = @"";
    }
    return YES;
}

-(BOOL)textFieldShouldEndEditing:(UITextField *)textField
{
    self.name = self.textField1.text;
    return YES;
}

- (BOOL)textFieldShouldReturn:(UITextField *)textField
{
    [textField resignFirstResponder];
    
    return YES;
}

-(void)hideKeyboard
{
    [self.textField1 resignFirstResponder];
}

-(void)done
{
    self.assignment.name = self.name;
    HSViewController *vc = [self.navigationController.viewControllers objectAtIndex:0];
    [vc updateAssignments:[vc.assignments arrayByAddingObject:self.assignment]];
    [self.navigationController popViewControllerAnimated:YES];
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
}

@end
