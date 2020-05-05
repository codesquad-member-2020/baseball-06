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
        gameStack.addGame(gesture: tapRecognizer())
        gameStack.addGame(gesture: tapRecognizer())
        gameStack.addGame(gesture: tapRecognizer())
        gameStack.addGame(gesture: tapRecognizer())
    }
    
    @objc private func handleTap(sender: UITapGestureRecognizer) {
        guard let mainTabbarController = storyboard?.instantiateViewController(identifier: "main") else { return }
        mainTabbarController.modalPresentationStyle = .fullScreen
        present(mainTabbarController, animated: true, completion: nil)
    }
    
    private func tapRecognizer() -> UITapGestureRecognizer {
        return UITapGestureRecognizer(target: self, action: #selector(handleTap))
    }
    
    private func setBackgroundImage() {
        let backgroundImage = GameListBackgroundView(frame: self.view.bounds)
        self.view.insertSubview(backgroundImage, at: 0)
    }
}

