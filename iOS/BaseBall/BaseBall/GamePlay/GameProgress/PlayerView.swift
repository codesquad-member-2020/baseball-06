//
//  PlayerView.swift
//  BaseBall
//
//  Created by TTOzzi on 2020/05/15.
//  Copyright © 2020 TTOzzi. All rights reserved.
//

import UIKit

class PlayerView: UIImageView {
    var base = 0
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        setProperties()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        setProperties()
    }
    
    func setProperties() {
        image = UIImage(named: "player")
    }
}
