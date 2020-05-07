//
//  ScoreCell.swift
//  BaseBall
//
//  Created by TTOzzi on 2020/05/06.
//  Copyright © 2020 TTOzzi. All rights reserved.
//

import UIKit

class ScoreCell: UITableViewCell {
    static let identifier = "score"
    
    @IBOutlet weak var playerNameLabel: UILabel!
    @IBOutlet weak var batLabel: UILabel!
    @IBOutlet weak var hitLabel: UILabel!
    @IBOutlet weak var outLabel: UILabel!
    @IBOutlet weak var averageLabel: UILabel!
    
    func useForFooter(bat: String, hit: String, out: String) {
        playerNameLabel.text = "Total"
        playerNameLabel.bold()
        batLabel.text = bat
        batLabel.bold()
        hitLabel.text = hit
        hitLabel.bold()
        outLabel.text = out
        outLabel.bold()
        averageLabel.isHidden = true
    }
    
    func setValues(name: String, bat: String, hit: String, out: String, average: String) {
        playerNameLabel.text = name
        playerNameLabel.normal()
        batLabel.text = bat
        batLabel.normal()
        hitLabel.text = hit
        hitLabel.normal()
        outLabel.text = out
        outLabel.normal()
        averageLabel.text = average
        averageLabel.isHidden = false
    }
}
