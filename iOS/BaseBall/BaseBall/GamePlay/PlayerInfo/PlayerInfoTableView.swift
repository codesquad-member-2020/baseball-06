//
//  PlayerInfoTableView.swift
//  BaseBall
//
//  Created by TTOzzi on 2020/05/06.
//  Copyright © 2020 TTOzzi. All rights reserved.
//

import UIKit

class PlayerInfoTableView: UITableView {
    private let borderWidth: CGFloat = 2
    
    override init(frame: CGRect, style: UITableView.Style) {
        super.init(frame: frame, style: style)
        setBottomBorder()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        setBottomBorder()
    }
    
    private func setBottomBorder() {
        let border = CALayer()
        border.backgroundColor = UIColor.darkGray.cgColor
        border.frame = CGRect.init(x: frame.minX, y: frame.height - borderWidth, width: frame.width, height: borderWidth)
        layer.addSublayer(border)
    }
}
