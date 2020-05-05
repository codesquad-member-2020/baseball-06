//
//  PlayerInfoDataSource.swift
//  BaseBall
//
//  Created by TTOzzi on 2020/05/06.
//  Copyright © 2020 TTOzzi. All rights reserved.
//

import UIKit

class PlayerInfoDataSource: NSObject, UITableViewDataSource {
    private let rowCount = 2
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return rowCount
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        guard let cell = tableView.dequeueReusableCell(withIdentifier: PlayerInfoCell.identifier, for: indexPath) as? PlayerInfoCell else {
            return UITableViewCell()
        }
        return cell
    }
}
