//
//  TitleScoreViewModel.swift
//  BaseBall
//
//  Created by TTOzzi on 2020/05/15.
//  Copyright © 2020 TTOzzi. All rights reserved.
//

import Foundation

class TitleScoreViewModel: ViewModelBinding {
    typealias Key = GameInfo?
    typealias Data = (Int, Int)
    
    private var gameInfo: Key {
        didSet {
            changedHandler(score)
        }
    }
    private var changedHandler: (Data) -> ()
    var score: Data {
        return calculateScore()
    }
    
    init(with gameInfo: GameInfo? = nil, changed handler: @escaping (Data) -> () = { _ in }) {
        self.gameInfo = gameInfo
        self.changedHandler = handler
    }
    
    func updateKey(_ key: GameInfo?) {
        self.gameInfo = key
    }
    
    private func calculateScore() -> Data {
        guard let gameInfo = gameInfo else { return (0, 0)}
        var homeTeamScore = 0
        var awayTeamScore = 0
        gameInfo.earlyInningList.forEach {
            homeTeamScore += $0.score
        }
        gameInfo.lateInningList.forEach {
            awayTeamScore += $0.score
        }
        return (homeTeamScore, awayTeamScore)
    }
}
