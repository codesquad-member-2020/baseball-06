//
//  GameListBackgroundVIew.swift
//  BaseBall
//
//  Created by TTOzzi on 2020/05/05.
//  Copyright © 2020 TTOzzi. All rights reserved.
//

import UIKit

class GameListBackgroundView: UIImageView {
    private let backgroundImage = UIImage(named: "baseball")
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        setProperties()
        addBlurEffect()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        setProperties()
        addBlurEffect()
    }
    
    private func setProperties() {
        image = backgroundImage
        contentMode = .scaleAspectFill
    }
    
    private func addBlurEffect() {
        let blurEffect = UIBlurEffect(style: UIBlurEffect.Style.light)
        let blurEffectView = UIVisualEffectView(effect: blurEffect)
        blurEffectView.frame = self.bounds
        blurEffectView.alpha = 0.5
        self.addSubview(blurEffectView)
    }
}
