//
//  ScoreViewModel.swift
//  BaseBall
//
//  Created by TTOzzi on 2020/05/11.
//  Copyright © 2020 TTOzzi. All rights reserved.
//

import Foundation

class ScoreViewModel: ViewModelBinding {
    typealias Key = InningStatus?
    typealias Data = Score
    
    struct Score {
        var strike: Int
        var ball: Int
        var out: Int
    }
    
    private var inningStatus: Key = nil {
        didSet {
            changedHandler(score)
        }
    }
    private var changedHandler: (Data) -> ()
    var score: Data {
        return Score(strike: inningStatus?.strike ?? 0,
                     ball: inningStatus?.ball ?? 0,
                     out: inningStatus?.out ?? 0)
    }
    
    init(with inningStatus: InningStatus? = nil, changed handler: @escaping (Data) -> () = { _ in }) {
        self.changedHandler = handler
        self.inningStatus = inningStatus
        changedHandler(score)
    }
    
    func updateKey(_ key: Key) {
        self.inningStatus = key
    }
}
