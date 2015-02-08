//
//  Assignment.h
//  Consilium
//
//  Created by Amog Kamsetty on 2/7/15.
//  Copyright (c) 2015 Amog Kamsetty. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface Assignment : NSObject

@property (nonatomic,strong,readonly) NSString *name;


-(id)initWithName:(NSString *) name;
@end
