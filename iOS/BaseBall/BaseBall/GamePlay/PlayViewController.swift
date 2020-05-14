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
    
    private var playerInfoDataSource: PlayerInfoDataSource!
    private let pitchingResultDataSource = PitchingResultDataSource()
    private var scoreViewModel: ScoreViewModel!
    private var inningViewModel: InningViewModel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        configureDataSources()
        configureViewModels()
        updateGameInfo()
    }
    
    @IBAction func pitchButtonTapped(_ sender: Any) {
        PitchUseCase.pitch(with: NetworkManager()) { result in
            switch result {
            case .success(let pitchResult):
                // TODO: 애니메이션 적용에 pitchResult 활용 예정
//                print(pitchResult)
                self.updateGameInfo()
            case .failure(let error):
                print(error)
            }
        }
    }
    
    private func updateGameInfo() {
        GameInfoUseCase.gameInfo(with: NetworkManager()) { result in
            switch result {
            case .success(let gameInfo):
                self.scoreViewModel.updateKey(gameInfo.inningStatus)
                self.inningViewModel.updateKey(gameInfo.inningStatus)
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
    
    private func configureDataSources() {
        playerInfoDataSource = PlayerInfoDataSource.init(changed: {
            self.playerInfoTableView.reloadData()
        })
        playerInfoTableView.dataSource = playerInfoDataSource
        pitchingResultTableView.dataSource = pitchingResultDataSource
    }
}
