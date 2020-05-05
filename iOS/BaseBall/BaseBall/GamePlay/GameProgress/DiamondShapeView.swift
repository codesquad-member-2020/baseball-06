//
//  DiamondShapeView.swift
//  BaseBall
//
//  Created by TTOzzi on 2020/05/05.
//  Copyright © 2020 TTOzzi. All rights reserved.
//

import UIKit

@IBDesignable
class DiamondShapeView: UIView {
    @IBInspectable var lineWidth: CGFloat = 0.0
    @IBInspectable var fillColor: UIColor = .white
    
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
        fillColor.setFill()
        UIColor.gray.setStroke()
        path.lineWidth = lineWidth
        path.move(to: CGPoint(x: rect.width / 2, y: 0))
        path.addLine(to: CGPoint(x: 0, y: rect.height / 2))
        path.addLine(to: CGPoint(x: rect.width / 2, y: rect.height))
        path.addLine(to: CGPoint(x: rect.width, y: rect.height / 2))
        path.addLine(to: CGPoint(x: rect.width / 2, y: 0))
        path.fill()
        path.stroke()
    }
}
