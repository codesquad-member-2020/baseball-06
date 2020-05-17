//
//  TitleScoreView.swift
//  BaseBall
//
//  Created by TTOzzi on 2020/05/15.
//  Copyright © 2020 TTOzzi. All rights reserved.
//

import UIKit

class TitleScoreView: UIView {
    @IBOutlet weak var homeTeamScoreLabel: UILabel!
    @IBOutlet weak var awayTeamScoreLabel: UILabel!
    
    func updateScore(home: Int, away: Int) {
        homeTeamScoreLabel.text = "\(home)"
        awayTeamScoreLabel.text = "\(away)"
    }
}
