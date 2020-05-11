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
    @IBOutlet weak var inningLabel: UILabel!
    
    private let playerInfoDataSource = PlayerInfoDataSource()
    private let pitchingResultDataSource = PitchingResultDataSource()
    private var scoreViewModel: ScoreViewModel!
    private var inningViewModel: InningViewModel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        playerInfoTableView.dataSource = playerInfoDataSource
        pitchingResultTableView.dataSource = pitchingResultDataSource
        configureViewModels()
    }
    
    @IBAction func pitchButtonTapped(_ sender: Any) {
        PitchUseCase.pitch(with: MockNetworkSuccessStub()) { result in
            switch result {
            case .success(let pitchResult):
                self.scoreViewModel.updateKey(pitchResult.inningStatus)
                self.inningViewModel.updateKey(pitchResult.inningStatus)
            case .failure(let error):
                print(error)
            }
        }
    }
    
    private func configureViewModels() {
        scoreViewModel = ScoreViewModel.init(changed: { data in
            DispatchQueue.main.async {
                self.scoreStackView.updateScore(strike: data.strike, ball: data.ball, out: data.out)
            }
        })
        inningViewModel = InningViewModel.init(changed: { data in
            DispatchQueue.main.async {
                self.inningLabel.text = data
            }
        })
    }
}
