//
//  OverallScoreView.swift
//  BaseBall
//
//  Created by TTOzzi on 2020/05/08.
//  Copyright © 2020 TTOzzi. All rights reserved.
//

import UIKit

class OverallScoreView: UIStackView {
    @IBOutlet weak var strikeStackView: ScoreStackView!
    @IBOutlet weak var ballStackView: ScoreStackView!
    @IBOutlet weak var outStackView: ScoreStackView!
    
    func updateScore(strike: Int, ball: Int, out: Int) {
        strikeStackView.updateScore(strike)
        ballStackView.updateScore(ball)
        if out < 3 {
            outStackView.updateScore(out)
        }
    }
}
