//
//  ScoreDataSource.swift
//  BaseBall
//
//  Created by TTOzzi on 2020/05/06.
//  Copyright © 2020 TTOzzi. All rights reserved.
//

import UIKit

class ScoreDataSource: NSObject, UITableViewDataSource {
    private let playerCount = 10
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return playerCount
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        guard let cell = tableView.dequeueReusableCell(withIdentifier: ScoreCell.identifier, for: indexPath) as? ScoreCell else { return UITableViewCell() }
        if indexPath.row == playerCount - 1 {
            cell.useForFooter(bat: "3", hit: "4", out: "5")
        } else {
            cell.setValues(name: "이름", bat: "1", hit: "2", out: "3", average: "1.000")
        }
        return cell
    }
}
