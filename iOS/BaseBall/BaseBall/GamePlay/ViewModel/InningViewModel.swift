//
//  InningViewModel.swift
//  BaseBall
//
//  Created by TTOzzi on 2020/05/11.
//  Copyright © 2020 TTOzzi. All rights reserved.
//

import Foundation

class InningViewModel: ViewModelBinding {
    typealias Key = InningStatus?
    typealias Data = String
    
    private var inningStatus: Key = nil {
        didSet {
            changedHandler(inning)
        }
    }
    private var changedHandler: (Data) -> ()
    var inning: Data {
        return inningText()
    }
    
    init(with inningStatus: InningStatus? = nil, changed handler: @escaping (Data) -> () = { _ in }) {
        self.changedHandler = handler
        self.inningStatus = inningStatus
        changedHandler(inning)
    }
    
    func updateKey(_ key: Key) {
        self.inningStatus = key
    }
    
    private func inningText() -> Data {
        guard let inningStatus = inningStatus else { return "" }
        return "\(inningStatus.id)회\(inningStatus.halfInningId == 1 ? "초" : "말")\n\(inningStatus.halfInningId == 1 ? "공격" : "수비")"
    }
}
