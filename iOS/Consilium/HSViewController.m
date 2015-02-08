//
//  HSViewController.m
//  Consilium
//
//  Created by Amog Kamsetty on 2/7/15.
//  Copyright (c) 2015 Amog Kamsetty. All rights reserved.
//

#import "HSViewController.h"
#import "Assignment.h"
#import "HSDetailViewController.h"

@interface HSViewController ()

@end

@implementation HSViewController

- (void)viewDidLoad
{
    [super viewDidLoad];
	self.navigationItem.rightBarButtonItem = [[UIBarButtonItem alloc] initWithBarButtonSystemItem:UIBarButtonSystemItemAdd target:self action:nil];
        
    
}

-(NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section
{
    return self.assignments.count;
}

-(NSString *)tableView:(UITableView *)tableView titleForHeaderInSection:(NSInteger)section
{
    return @"Assignments";
}

-(UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath
{
    static NSString *CellIdentifier = @"Cell";
    UITableViewCell *cell = [tableView dequeueReusableCellWithIdentifier:CellIdentifier];
    
    if(cell==nil) {
        cell = [[UITableViewCell alloc]initWithStyle:UITableViewCellStyleSubtitle reuseIdentifier:CellIdentifier];
    }
    
    Assignment *cellValue = [self.assignments objectAtIndex:indexPath.row];
    NSString *text = [cellValue name];
    cell.textLabel.text = text;
    return cell;
}

-(void) updateAssignments:(NSArray *)assignments
{
    self.assignments = assignments;
    [self.tableView reloadData];
}

- (void)tableView:(UITableView *)collectionView didSelectRowAtIndexPath:(NSIndexPath *)indexPath {
    
    NSInteger row = [indexPath row];
    Assignment *assignment = [[Assignment alloc] init];
    assignment = [self.assignments objectAtIndex:row];
    HSDetailViewController *detailVC = [[HSDetailViewController alloc] init];
    [detailVC updateAssignment:assignment];
    [self.navigationController pushViewController:detailVC animated:YES];
    
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];

}

@end
