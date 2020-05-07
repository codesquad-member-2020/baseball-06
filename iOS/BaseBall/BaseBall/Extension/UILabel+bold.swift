//
//  UILabel+bold.swift
//  BaseBall
//
//  Created by TTOzzi on 2020/05/06.
//  Copyright © 2020 TTOzzi. All rights reserved.
//

import UIKit

extension UILabel {
    func bold() {
        self.font = .boldSystemFont(ofSize: self.font.pointSize)
    }
    
    func normal() {
        self.font = .systemFont(ofSize: self.font.pointSize)
    }
}
