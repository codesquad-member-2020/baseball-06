//
//  GameListViewController.swift
//  BaseBall
//
//  Created by TTOzzi on 2020/05/05.
//  Copyright © 2020 TTOzzi. All rights reserved.
//

import UIKit

class GameListViewController: UIViewController {
    @IBOutlet weak var gameStack: GameStackView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setBackgroundImage()
        gameStack.addGame()
        gameStack.addGame()
        gameStack.addGame()
        gameStack.addGame()
    }
    
    private func setBackgroundImage() {
        let backgroundImage = GameListBackgroundView(frame: self.view.bounds)
        self.view.insertSubview(backgroundImage, at: 0)
    }
}

