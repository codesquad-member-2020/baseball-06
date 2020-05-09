//
//  PlayViewController.swift
//  BaseBall
//
//  Created by TTOzzi on 2020/05/04.
//  Copyright © 2020 TTOzzi. All rights reserved.
//

import UIKit

class PlayViewController: UIViewController {
    static let identifier = "play"
    
    @IBOutlet weak var playerInfoTableView: PlayerInfoTableView!
    @IBOutlet weak var pitchingResultTableView: UITableView!
    @IBOutlet weak var scoreStackView: OverallScoreView!
    
    private let playerInfoDataSource = PlayerInfoDataSource()
    private let pitchingResultDataSource = PitchingResultDataSource()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        playerInfoTableView.dataSource = playerInfoDataSource
        pitchingResultTableView.dataSource = pitchingResultDataSource
    }
    
    @IBAction func pitchButtonTapped(_ sender: Any) {
        PitchUseCase.pitch(with: NetworkManager()) { result in
            switch result {
            case .success(let pitchResult):
                let result = pitchResult.inningStatus.components(separatedBy: " ").map { Int(String($0.first!))! }
                DispatchQueue.main.async {
                    self.scoreStackView.updateScore(strike: result[0], ball: result[1], out: result[2])
                }
            case .failure(let error):
                print(error)
            }
        }
    }
}

