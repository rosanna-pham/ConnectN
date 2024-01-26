package com.thg.accelerator23.connectn.ai.rosanna;

import com.thehutgroup.accelerator.connectn.player.Board;
import com.thehutgroup.accelerator.connectn.player.Counter;
import com.thehutgroup.accelerator.connectn.player.Player;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

// Example: Simple AI makes a random move
//    Random random = new Random();
//    int col = random.nextInt(board.getConfig().getWidth());
//
//    return col;

public class ConnectN extends Player {
  public ConnectN(Counter counter) {
    // ROSANNA
    super(counter, ConnectN.class.getName());
  }

  @Override
  public int makeMove(Board board) {
    Counter[][] counterPlacements = board.getCounterPlacements();
    int width = board.getConfig().getWidth();
    int height = board.getConfig().getHeight();

    int move = horizontalWin(counterPlacements, width, height);
    if ( move != -1) return move;

    move = verticalWin(counterPlacements, width, height);
    if ( move != -1) return move;

    move = diagonalWin1(counterPlacements, width, height);
    if ( move != -1) return move;

    move = diagonalWin2(counterPlacements, width, height);
    if ( move != -1) return move;


    Random random = new Random();
    return random.nextInt(width);

  }

  private int horizontalWin(Counter[][] counterPlacements, int width, int height) {
    int block = -1;
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width - 3; x++) {
        int nullCount = 0;
        int nullPosition = -1;
        Set<Counter> uniqueCounters = new HashSet<>();

        for (int i = x; i <= x + 3; i ++ ){
          if (counterPlacements[i][y] == null) {
            nullCount++;
            nullPosition = i;
            uniqueCounters.add(counterPlacements[i][y]);
          }

        }
        if (nullCount == 1 && uniqueCounters.size() ==1){
          block = nullPosition;
          break;
        }
      }
    }
    return block;
  }
  private int verticalWin(Counter[][] counterPlacements, int width, int height) {
    int block = -1;
    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height - 3; y++) {
        int nullCount = 0;
        int nullPosition = -1;
        Set<Counter> uniqueCounters = new HashSet<>();

        for (int i = y; i<= y+3; i++) {
          if (counterPlacements[x][i] == null) {
            nullCount++;
            nullPosition = i;
            uniqueCounters.add(counterPlacements[i][y]);
          }
        }
        if (nullCount ==  1 && uniqueCounters.size() ==1) {
          block = nullPosition;
          break;
        }
      }
    }
    return block;
  }

  private int diagonalWin1(Counter[][] counterPlacements, int width, int height) {
    //downward diagonal
    int block = -1;
    for (int x = 0; x < width - 3; x++) {
      for (int y = 0; y < height - 3; y++) {
        int nullCount = 0;
        int nullPosition = -1;
        Set<Counter> uniqueCounters = new HashSet<>();

        for ( int i = x; i <= x + 3; i++) {
          for(int z = y; z <= y + 3; z++) {
            if (counterPlacements[i][z] == null) {
              nullCount++;
              nullPosition = i;
              uniqueCounters.add(counterPlacements[i][z]);
            }
          }
        }

        if (nullCount == 1 && uniqueCounters.size() ==1) {
          block = nullPosition;
          break;
        }
      }
    }
    return block;
  }
  private int diagonalWin2(Counter[][] counterPlacements, int width, int height) {
    //upwards diagonal
    int block = -1;
    for (int x = 3; x < width; x++) {
      for (int y = 0; y < height - 3; y++) {
        int nullCount = 0;
        int nullPosition = -1;
        Set<Counter> uniqueCounters = new HashSet<>();

        for ( int i = x; i >= x -3; i--) {
          for (int z = y; z <= y-3; z--){
            if (counterPlacements[i][z] == null) {
              nullCount++;
              nullPosition = i;
              uniqueCounters.add(counterPlacements[i][z]);
            }
          }
        }
        if (nullCount == 1 && uniqueCounters.size() ==1) {
          block = nullPosition;
          break;
        }
      }

    }
    return block;
  }


}


