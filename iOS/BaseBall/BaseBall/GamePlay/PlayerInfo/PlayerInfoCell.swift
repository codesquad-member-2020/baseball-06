//
//  PlayerInfoCell.swift
//  BaseBall
//
//  Created by TTOzzi on 2020/05/06.
//  Copyright © 2020 TTOzzi. All rights reserved.
//

import UIKit

class PlayerInfoCell: UITableViewCell {
    static let identifier = "playerInfo"
    
    @IBOutlet weak var roleLabel: UILabel!
    @IBOutlet weak var nameLabel: UILabel!
    @IBOutlet weak var infoLabel: UILabel!
    
    func updateCell(_ data: Player) {
        roleLabel.text = data.type
        nameLabel.text = data.name
    }
}
