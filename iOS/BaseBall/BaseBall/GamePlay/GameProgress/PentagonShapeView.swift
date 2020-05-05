//
//  PentagonShapeView.swift
//  BaseBall
//
//  Created by TTOzzi on 2020/05/05.
//  Copyright © 2020 TTOzzi. All rights reserved.
//

import UIKit

@IBDesignable
class PentagonShapeView: UIView {
    override init(frame: CGRect) {
        super.init(frame: frame)
        backgroundColor = .clear
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        backgroundColor = .clear
    }
    
    override func draw(_ rect: CGRect) {
        let path = UIBezierPath()
        UIColor.white.setFill()
        path.lineWidth = 0
        path.move(to: CGPoint(x: rect.width / 2, y: 0))
        path.addLine(to: CGPoint(x: 0, y: rect.height / 3))
        path.addLine(to: CGPoint(x: 0, y: rect.height))
        path.addLine(to: CGPoint(x: rect.width, y: rect.height))
        path.addLine(to: CGPoint(x: rect.width, y: rect.height / 3))
        path.addLine(to: CGPoint(x: rect.width / 2, y: 0))
        path.fill()
        path.stroke()
    }
}
