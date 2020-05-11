//
//  ViewModelBinding.swift
//  BaseBall
//
//  Created by TTOzzi on 2020/05/11.
//  Copyright © 2020 TTOzzi. All rights reserved.
//

import Foundation

protocol ViewModelBinding {
    associatedtype Key
    associatedtype Data
    func updateKey(_ key: Key)
}
