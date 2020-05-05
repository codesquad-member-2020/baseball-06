//
//  CircleNumberLabel.swift
//  BaseBall
//
//  Created by TTOzzi on 2020/05/06.
//  Copyright © 2020 TTOzzi. All rights reserved.
//

import UIKit

class CircleNumberLabel: UILabel {
    private let padding = UIEdgeInsets(top: 3, left: 3, bottom: 3, right: 3)
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        setProperties()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        setProperties()
    }
    
    override var intrinsicContentSize : CGSize {
        let superContentSize = super.intrinsicContentSize
        let width = superContentSize.width + padding.left + padding.right
        let heigth = superContentSize.height + padding.top + padding.bottom
        return CGSize(width: width, height: heigth)
    }
    
    private func setProperties() {
        textColor = .white
        backgroundColor = .black
        clipsToBounds = true
        layer.cornerRadius = (intrinsicContentSize.height) / 2
    }
}
