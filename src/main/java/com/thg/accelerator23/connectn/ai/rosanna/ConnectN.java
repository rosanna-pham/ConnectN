package com.thg.accelerator23.connectn.ai.rosanna;

import com.thehutgroup.accelerator.connectn.player.Board;
import com.thehutgroup.accelerator.connectn.player.Counter;
import com.thehutgroup.accelerator.connectn.player.Player;

import java.util.Random;


public class ConnectN extends Player {
  public ConnectN(Counter counter) {
    // ROSANNA
    super(counter, ConnectN.class.getName());
  }

  @Override
  public int makeMove(Board board) {

    // Example: Simple AI makes a random move
    Random random = new Random();
    int col = random.nextInt(board.getConfig().getWidth());

    return col;
  }
}


