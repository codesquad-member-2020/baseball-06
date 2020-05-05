//
//  PlayViewController.swift
//  BaseBall
//
//  Created by TTOzzi on 2020/05/04.
//  Copyright © 2020 TTOzzi. All rights reserved.
//

import UIKit

class PlayViewController: UIViewController {
    @IBOutlet weak var playerInfoTableView: PlayerInfoTableView!
    
    private let playerInfoDataSource = PlayerInfoDataSource()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        playerInfoTableView.dataSource = playerInfoDataSource
    }
}
