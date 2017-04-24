package edu.weberstate.cs3230.ui;

import edu.weberstate.cs3230.engine.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jdickey on 4/24/2017.
 */
public class UIGame implements IGame{

    private static UIGame gameInstance;
    private List<Player> players;
    private List<Ship> ships;
    private int boardSize;

    private UIGame() {
        players = new ArrayList<>();
        ships = new ArrayList<>();
    }

    public static UIGame getInstance(){
        if(gameInstance == null){
            gameInstance = new UIGame();
        }

        return gameInstance;
    }


    @Override
    public void startGame() {


    }

    @Override
    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    @Override
    public int getBoardSize() {
        return boardSize;
    }

    @Override
    public void addPlayer(String name) {

    }

    public void addPlayer(Player player){
        player.setGameboard(new GameBoard(boardSize));
        player.setPlayerShips(generateShips());
        players.add(player);

    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Ship> getShips() {
        return ships;
    }

    private List generateShips(){
        ships = new ArrayList<>(5);
        Ship carrier = new Carrier();
        Ship battleship = new Battleship();
        Ship cruiser = new Cruiser();
        Ship submarine = new Submarine();
        Ship destroyer = new Destroyer();

        ships.add(carrier);
        ships.add(battleship);
        ships.add(cruiser);
        ships.add(submarine);
        ships.add(destroyer);

        return ships;
    }

    public void placeShip(Ship ship, int x, int y, String orientation, GameBoard gameBoard){
        int shipXPlacementIndex = x;
        int shipYPlacementIndex = y;


        if (orientation.equalsIgnoreCase("horizontal") && ship.getShipSize() + x <= boardSize){
            gameBoard.placeInGameTile(ship, x, y);
        }else if (orientation.equalsIgnoreCase("vertical") && ship.getShipSize() + x <= boardSize){
            gameBoard.placeInGameTile(ship, x, y);
        }else{
            System.out.print("ship has not been placed\n\tship out of bounds");
        }
    }
}