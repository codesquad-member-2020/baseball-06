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
    @IBOutlet weak var titleScoreView: TitleScoreView!
    @IBOutlet weak var scoreStackView: OverallScoreView!
    @IBOutlet weak var inningLabel: UILabel!
    @IBOutlet weak var fieldView: DiamondShapeView!
    @IBOutlet var bases: [UIView]!
    @IBOutlet weak var pitchButton: PitchButton!
    
    private var playerInfoDataSource: PlayerInfoDataSource!
    private let pitchingResultDataSource = PitchingResultDataSource()
    private var scoreViewModel: ScoreViewModel!
    private var inningViewModel: InningViewModel!
    private var titleScoreViewModel: TitleScoreViewModel!
    private var players = [PlayerView]()
    private var gameInfo: GameInfo?
    
    override func viewDidLoad() {
        super.viewDidLoad()
        configureDataSources()
        configureViewModels()
        DispatchQueue.global().async {
            while true {
                self.updateGameInfo()
                sleep(1)
            }
        }
    }
    
    @IBAction func pitchButtonTapped(_ sender: Any) {
        PitchUseCase.pitch(with: NetworkManager()) { result in
            switch result {
            case .success(let pitchResult):
                self.updateGameInfo()
            case .failure(let error):
                print(error)
            }
        }
    }
        
    private func hit() {
        DispatchQueue.main.async {
            let newPlayer = PlayerView(frame: self.bases[0].frame)
            self.fieldView.addSubview(newPlayer)
            self.players.append(newPlayer)
            self.players.forEach {
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
    }
    
    private func updateGameInfo() {
        GameInfoUseCase.gameInfo(with: NetworkManager()) { result in
            switch result {
            case .success(let gameInfo):
                if self.gameInfo != gameInfo {
                    self.gameInfo = gameInfo
                    self.scoreViewModel.updateKey(gameInfo.inningStatus)
                    self.inningViewModel.updateKey(gameInfo)
                    self.titleScoreViewModel.updateKey(gameInfo)
                    
                    guard gameInfo.baseStatus.firstBase else {
                        DispatchQueue.main.async {
                            self.players.forEach {
                                $0.removeFromSuperview()
                            }
                            self.players.removeAll()
                        }
                        return
                    }
                    if self.players.count < 1 {
                        self.hit()
                    }
                    guard gameInfo.baseStatus.secondBase else { return }
                    if self.players.count < 2 {
                        self.hit()
                    }
                    guard gameInfo.baseStatus.thirdBase else { return }
                    if self.players.count < 3 {
                        self.hit()
                    } else if self.players.count == 3, gameInfo.inningStatus.strike == 0, gameInfo.inningStatus.ball == 0 {
                        self.hit()
                    }
                }
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
        titleScoreViewModel = TitleScoreViewModel.init(changed: { data in
            DispatchQueue.main.async {
                self.titleScoreView.updateScore(home: data.0, away: data.1)
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
