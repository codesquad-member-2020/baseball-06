//
//  InningViewModel.swift
//  BaseBall
//
//  Created by TTOzzi on 2020/05/11.
//  Copyright © 2020 TTOzzi. All rights reserved.
//

import Foundation

class InningViewModel: ViewModelBinding {
    typealias Key = GameInfo?
    typealias Data = String
    
    private var gameInfo: Key = nil {
        didSet {
            changedHandler(inning)
        }
    }
    private var changedHandler: (Data) -> ()
    var inning: Data {
        return inningText()
    }
    
    init(with inningStatus: GameInfo? = nil, changed handler: @escaping (Data) -> () = { _ in }) {
        self.changedHandler = handler
        self.gameInfo = inningStatus
        changedHandler(inning)
    }
    
    func updateKey(_ key: Key) {
        self.gameInfo = key
    }
    
    private func inningText() -> Data {
        guard let gameInfo = gameInfo else { return "" }
        return "\(gameInfo.earlyInningList.count)회\(gameInfo.earlyInningList.count > gameInfo.lateInningList.count ? "초\n공격" : "말\n수비")"
    }
}
