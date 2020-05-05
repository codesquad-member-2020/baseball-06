//
//  PitchButton.swift
//  BaseBall
//
//  Created by TTOzzi on 2020/05/06.
//  Copyright © 2020 TTOzzi. All rights reserved.
//

import UIKit

class PitchButton: UIButton {
    override init(frame: CGRect) {
        super.init(frame: frame)
        setProperties()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        setProperties()
    }
    
    private func setProperties() {
        layer.cornerRadius = frame.height / 5
    }
}
