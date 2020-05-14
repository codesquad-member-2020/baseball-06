//
//  PlayerInfoDataSource.swift
//  BaseBall
//
//  Created by TTOzzi on 2020/05/06.
//  Copyright © 2020 TTOzzi. All rights reserved.
//

import UIKit

class PlayerInfoDataSource: NSObject, UITableViewDataSource {
    private var playerInfo: [Player]? {
        didSet {
            changedHandler()
        }
    }
    private var changedHandler: () -> ()
    
    init(changed handler: @escaping () -> ()) {
        self.changedHandler = handler
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return playerInfo?.count ?? 0
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        guard let cell = tableView.dequeueReusableCell(withIdentifier: PlayerInfoCell.identifier, for: indexPath) as? PlayerInfoCell,
            let playerInfo = playerInfo?[indexPath.row] else {
            return UITableViewCell()
        }
        cell.updateCell(playerInfo)
        return cell
    }
    
    func updateData(_ data: [Player]) {
        playerInfo = data
    }
}
