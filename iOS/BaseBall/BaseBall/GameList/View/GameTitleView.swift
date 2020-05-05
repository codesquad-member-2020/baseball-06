//
//  GameTitleView.swift
//  BaseBall
//
//  Created by TTOzzi on 2020/05/05.
//  Copyright © 2020 TTOzzi. All rights reserved.
//

import UIKit

class GameTitleView: UIView {
    @IBOutlet weak var gameNumberLabel: UILabel!
    @IBOutlet weak var awayTeamLabel: UILabel!
    @IBOutlet weak var homeTeamLabel: UILabel!
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        setProperties()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        setProperties()
    }
    
    private func setProperties() {
        layer.cornerRadius = frame.size.height / 5
        backgroundColor = UIColor.white.withAlphaComponent(0.6)
    }
}
