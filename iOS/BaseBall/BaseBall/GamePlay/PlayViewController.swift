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
    @IBOutlet weak var fieldView: DiamondShapeView!
    @IBOutlet var bases: [UIView]!
    @IBOutlet weak var pitchButton: PitchButton!
    
    private var playerInfoDataSource: PlayerInfoDataSource!
    private let pitchingResultDataSource = PitchingResultDataSource()
    private var scoreViewModel: ScoreViewModel!
    private var inningViewModel: InningViewModel!
    private var players = [PlayerView]()
    
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
                if pitchResult.battingResult == "HIT" {
                    DispatchQueue.main.async {
                        self.hit()
                    }
                } else if pitchResult.battingResult == "END" {
                    DispatchQueue.main.async {
                        self.players.forEach {
                            $0.removeFromSuperview()
                        }
                        self.players.removeAll()
                    }
                }
                self.updateGameInfo()
            case .failure(let error):
                print(error)
            }
        }
    }
    
    private func hit() {
        let newPlayer = PlayerView(frame: bases[0].frame)
        fieldView.addSubview(newPlayer)
        players.append(newPlayer)
        players.forEach {
            let player = $0
            player.base += 1
            if player.base == 4 {
                UIView.animate(withDuration: 1.0, animations: {
                    self.pitchButton.toggle()
                    player.frame = self.bases[0].frame
                }) { _ in
                    self.pitchButton.toggle()
                    player.removeFromSuperview()
                    self.players.removeFirst()
                }
            } else {
                UIView.animate(withDuration: 1.0, animations: {
                    self.pitchButton.toggle()
                    player.frame = self.bases[player.base].frame
                }) { _ in
                    self.pitchButton.toggle()
                }
            }
        }
    }
    
    private func updateGameInfo() {
        GameInfoUseCase.gameInfo(with: NetworkManager()) { result in
            switch result {
            case .success(let gameInfo):
                self.scoreViewModel.updateKey(gameInfo.inningStatus)
                self.inningViewModel.updateKey(gameInfo)
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
