package chess;

import java.util.ArrayList;
import java.util.Collection;

public class KingMoves implements ChessPieceCalculator {

    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        Collection<ChessMove> moves = new ArrayList<>();
        ChessGame.TeamColor myTeamColor = board.getPiece(new ChessPosition(myPosition.getRow(), myPosition.getColumn())).getTeamColor();
        //direction: {1,1}
        if (myPosition.getRow() + 1 <= 8 && myPosition.getColumn() + 1 <= 8) {
            if (board.getPiece(new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn() + 1)) != null) {
                ChessGame.TeamColor otherPieceColor = board.getPiece(new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn() + 1)).getTeamColor();
                if (myTeamColor != otherPieceColor) {
                    moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn() + 1), null));
                    System.out.println((myPosition.getRow() + 1) + " " + (myPosition.getColumn() + 1));
                }
            }
            else {
                moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn() + 1), null));
                System.out.println((myPosition.getRow() + 1) + " " + (myPosition.getColumn() + 1));
            }
        }

        //direction: {1,-1}
        if (myPosition.getRow() + 1 <= 8 && myPosition.getColumn() - 1 >= 1) {
            if (board.getPiece(new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn() - 1)) != null) {
                ChessGame.TeamColor otherPieceColor = board.getPiece(new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn() - 1)).getTeamColor();
                if (myTeamColor != otherPieceColor) {
                    moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn() - 1), null));
                    System.out.println((myPosition.getRow() + 1) + " " + (myPosition.getColumn() - 1));
                }
            }
            else {
                moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn() - 1), null));
                System.out.println((myPosition.getRow() + 1) + " " + (myPosition.getColumn() - 1));
            }
        }

        //direction: {-1,1}
        if (myPosition.getRow() - 1 >= 1 && myPosition.getColumn() + 1 <= 8) {
            if (board.getPiece(new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn() + 1)) != null) {
                ChessGame.TeamColor otherPieceColor = board.getPiece(new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn() + 1)).getTeamColor();
                if (myTeamColor != otherPieceColor) {
                    moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn() + 1), null));
                    System.out.println((myPosition.getRow() - 1) + " " + (myPosition.getColumn() + 1));
                }
            }
            else {
                moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn() + 1), null));
                System.out.println((myPosition.getRow() - 1) + " " + (myPosition.getColumn() + 1));
            }
        }

        //direction: {-1,-1}
        if (myPosition.getRow() - 1 >= 1 && myPosition.getColumn() - 1 >= 1) {
            if (board.getPiece(new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn() - 1)) != null) {
                ChessGame.TeamColor otherPieceColor = board.getPiece(new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn() - 1)).getTeamColor();
                if (myTeamColor != otherPieceColor) {
                    moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn() - 1), null));
                    System.out.println((myPosition.getRow() - 1) + " " + (myPosition.getColumn() - 1));
                }
            }
            else {
                moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn() - 1), null));
                System.out.println((myPosition.getRow() - 1) + " " + (myPosition.getColumn() - 1));
            }
        }

        //direction: {1,0}
        if (myPosition.getRow() + 1 <= 8) {
            if (board.getPiece(new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn())) != null) {
                ChessGame.TeamColor otherPieceColor = board.getPiece(new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn())).getTeamColor();
                if (myTeamColor != otherPieceColor) {
                    moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn()), null));
                    System.out.println((myPosition.getRow() + 1) + " " + (myPosition.getColumn()));
                }
            }
            else {
                moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn()), null));
                System.out.println((myPosition.getRow() + 1) + " " + (myPosition.getColumn()));
            }
        }

        //direction: {0,1}
        if (myPosition.getColumn() + 1 <= 8) {
            if (board.getPiece(new ChessPosition(myPosition.getRow(), myPosition.getColumn() + 1)) != null) {
                ChessGame.TeamColor otherPieceColor = board.getPiece(new ChessPosition(myPosition.getRow(), myPosition.getColumn() + 1)).getTeamColor();
                if (myTeamColor != otherPieceColor) {
                    moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow(), myPosition.getColumn() + 1), null));
                    System.out.println((myPosition.getRow()) + " " + (myPosition.getColumn() + 1));
                }
            }
            else {
                moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow(), myPosition.getColumn() + 1), null));
                System.out.println((myPosition.getRow()) + " " + (myPosition.getColumn() + 1));
            }
        }

        //direction: {-1,0}
        if (myPosition.getRow() - 1 >= 1) {
            if (board.getPiece(new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn())) != null) {
                ChessGame.TeamColor otherPieceColor = board.getPiece(new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn())).getTeamColor();
                if (myTeamColor != otherPieceColor) {
                    moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn()), null));
                    System.out.println((myPosition.getRow() - 1) + " " + (myPosition.getColumn()));
                }
            }
            else {
                moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn()), null));
                System.out.println((myPosition.getRow() - 1) + " " + (myPosition.getColumn()));
            }
        }

        //direction: {0,-1}
        if (myPosition.getColumn() - 1 >= 1) {
            if (board.getPiece(new ChessPosition(myPosition.getRow(), myPosition.getColumn() - 1)) != null) {
                ChessGame.TeamColor otherPieceColor = board.getPiece(new ChessPosition(myPosition.getRow(), myPosition.getColumn() - 1)).getTeamColor();
                if (myTeamColor != otherPieceColor) {
                    moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow(), myPosition.getColumn() - 1), null));
                    System.out.println((myPosition.getRow()) + " " + (myPosition.getColumn() - 1));
                }
            }
            else {
                moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow(), myPosition.getColumn() - 1), null));
                System.out.println((myPosition.getRow()) + " " + (myPosition.getColumn() - 1));
            }
        }
        return moves;
    }
}
