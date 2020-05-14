//
//  ScoreStackView.swift
//  BaseBall
//
//  Created by TTOzzi on 2020/05/09.
//  Copyright © 2020 TTOzzi. All rights reserved.
//

import UIKit

class ScoreStackView: UIStackView {
    @IBInspectable private var fillColor: UIColor = .white
    
    func updateScore(_ score: Int) {
        reset()
        guard score > 0 else { return }
        for index in 1...score {
            arrangedSubviews[index].backgroundColor = fillColor
        }
    }
    
    private func reset() {
        arrangedSubviews.forEach {
            guard (($0 as? UILabel) == nil) else { return }
            $0.backgroundColor = .white
        }
    }
}
