//
//  GameStackView.swift
//  BaseBall
//
//  Created by TTOzzi on 2020/05/05.
//  Copyright © 2020 TTOzzi. All rights reserved.
//

import UIKit

class GameStackView: UIStackView {
    override init(frame: CGRect) {
        super.init(frame: frame)
        setProperties()
    }
    
    required init(coder: NSCoder) {
        super.init(coder: coder)
        setProperties()
    }
    
    private func setProperties() {
        translatesAutoresizingMaskIntoConstraints = false
    }
    
    func addGame(gesture: UITapGestureRecognizer) {
        let name = String(describing: GameTitleView.self)
        guard let loadedNib = Bundle.main.loadNibNamed(name, owner: self, options: nil),
            let gameTitleView = loadedNib.first as? GameTitleView else { return }
        gameTitleView.addGestureRecognizer(gesture)
        addArrangedSubview(gameTitleView)
        gameTitleView.heightAnchor.constraint(equalToConstant: 100).isActive = true
    }
}

