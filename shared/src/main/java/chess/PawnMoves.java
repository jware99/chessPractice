package chess;

import java.util.ArrayList;
import java.util.Collection;

public class PawnMoves implements ChessPieceCalculator {

    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        Collection<ChessMove> moves = new ArrayList<>();
        ChessGame.TeamColor myTeamColor = board.getPiece(new ChessPosition(myPosition.getRow(), myPosition.getColumn())).getTeamColor();

        //direction: {1,0} (White)
        if (board.getPiece(myPosition).getTeamColor() == ChessGame.TeamColor.WHITE) {
            if (myPosition.getRow() + 1 <= 8) {
                if (board.getPiece(new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn())) == null) {
                    if (myPosition.getRow() + 1 == 8) {
                        moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn()), ChessPiece.PieceType.QUEEN));
                        moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn()), ChessPiece.PieceType.ROOK));
                        moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn()), ChessPiece.PieceType.BISHOP));
                        moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn()), ChessPiece.PieceType.KNIGHT));
                        System.out.println((myPosition.getRow() + 1) + " " + (myPosition.getColumn()));
                    } else if (myPosition.getRow() == 2 && board.getPiece(new ChessPosition(myPosition.getRow() + 2, myPosition.getColumn())) == null) {
                        moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn()), null));
                        moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() + 2, myPosition.getColumn()), null));
                    } else {
                        moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn()), null));
                        System.out.println((myPosition.getRow() + 1) + " " + (myPosition.getColumn()));
                    }
                }
            }
        }

        //direction: {-1,0} (Black)
        if (board.getPiece(myPosition).getTeamColor() == ChessGame.TeamColor.BLACK) {
            if (myPosition.getRow() - 1 >= 1) {
                if (board.getPiece(new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn())) == null) {
                    if (myPosition.getRow() - 1 == 1) {
                        moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn()), ChessPiece.PieceType.QUEEN));
                        moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn()), ChessPiece.PieceType.ROOK));
                        moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn()), ChessPiece.PieceType.BISHOP));
                        moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn()), ChessPiece.PieceType.KNIGHT));
                        System.out.println((myPosition.getRow() - 1) + " " + (myPosition.getColumn()));
                    } else if (myPosition.getRow() == 7 && board.getPiece(new ChessPosition(myPosition.getRow() - 2, myPosition.getColumn())) == null) {
                        moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn()), null));
                        moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() - 2, myPosition.getColumn()), null));
                    } else {
                        moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn()), null));
                        System.out.println((myPosition.getRow() - 1) + " " + (myPosition.getColumn()));
                    }
                }
            }
        }

        //white pawn capture
        if (board.getPiece(myPosition).getTeamColor() == ChessGame.TeamColor.WHITE) {
            //right capture
            if (myPosition.getRow() + 1 <= 8 && myPosition.getColumn() + 1 <= 8) {
                if (board.getPiece(new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn() + 1)) != null) {
                    ChessGame.TeamColor otherPieceColor = board.getPiece(new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn() + 1)).getTeamColor();
                    if (myTeamColor != otherPieceColor) {
                        moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn() + 1), null));
                        System.out.println((myPosition.getRow() + 1) + " " + (myPosition.getColumn() + 1));
                    }
                } // right capture pawn promotion
            } else if (myPosition.getRow() + 1 == 8 && myPosition.getColumn() + 1 <= 8) {
                if (board.getPiece(new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn() + 1)) != null) {
                    ChessGame.TeamColor otherPieceColor = board.getPiece(new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn() + 1)).getTeamColor();
                    if (myTeamColor != otherPieceColor) {
                        moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn() + 1), ChessPiece.PieceType.QUEEN));
                        moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn() + 1), ChessPiece.PieceType.ROOK));
                        moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn() + 1), ChessPiece.PieceType.BISHOP));
                        moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn() + 1), ChessPiece.PieceType.KNIGHT));
                        System.out.println((myPosition.getRow() + 1) + " " + (myPosition.getColumn() + 1));
                    }
                }
            }
            //left capture
            if (myPosition.getRow() + 1 < 8 && myPosition.getColumn() - 1 >= 1) {
                if (board.getPiece(new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn() - 1)) != null) {
                    ChessGame.TeamColor otherPieceColor = board.getPiece(new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn() - 1)).getTeamColor();
                    if (myTeamColor != otherPieceColor) {
                        moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn() - 1), null));
                        System.out.println((myPosition.getRow() + 1) + " " + (myPosition.getColumn() - 1));
                    }
                } //left capture pawn promotion
            } else if (myPosition.getRow() + 1 == 8 && myPosition.getColumn() - 1 >= 1) {
                if (board.getPiece(new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn() - 1)) != null) {
                    ChessGame.TeamColor otherPieceColor = board.getPiece(new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn() - 1)).getTeamColor();
                    if (myTeamColor != otherPieceColor) {
                        moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn() - 1), ChessPiece.PieceType.QUEEN));
                        moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn() - 1), ChessPiece.PieceType.ROOK));
                        moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn() - 1), ChessPiece.PieceType.BISHOP));
                        moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn() - 1), ChessPiece.PieceType.KNIGHT));
                        System.out.println((myPosition.getRow() + 1) + " " + (myPosition.getColumn() - 1));
                    }
                }
            }
        }

        //black pawn capture
        if (board.getPiece(myPosition).getTeamColor() == ChessGame.TeamColor.BLACK) {
            //right capture
            if (myPosition.getRow() - 1 >= 1 && myPosition.getColumn() + 1 <= 8) {
                if (board.getPiece(new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn() + 1)) != null) {
                    ChessGame.TeamColor otherPieceColor = board.getPiece(new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn() + 1)).getTeamColor();
                    if (myTeamColor != otherPieceColor) {
                        moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn() + 1), null));
                        System.out.println((myPosition.getRow() - 1) + " " + (myPosition.getColumn() + 1));
                    }
                } // right capture pawn promotion
            } else if (myPosition.getRow() - 1 == 1 && myPosition.getColumn() + 1 <= 8) {
                if (board.getPiece(new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn() + 1)) != null) {
                    ChessGame.TeamColor otherPieceColor = board.getPiece(new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn() + 1)).getTeamColor();
                    if (myTeamColor != otherPieceColor) {
                        moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn() + 1), ChessPiece.PieceType.QUEEN));
                        moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn() + 1), ChessPiece.PieceType.ROOK));
                        moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn() + 1), ChessPiece.PieceType.BISHOP));
                        moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn() + 1), ChessPiece.PieceType.KNIGHT));
                        System.out.println((myPosition.getRow() - 1) + " " + (myPosition.getColumn() + 1));
                    }
                }
            }
            //left capture
            if (myPosition.getRow() - 1 > 1 && myPosition.getColumn() - 1 >= 1) {
                if (board.getPiece(new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn() - 1)) != null) {
                    ChessGame.TeamColor otherPieceColor = board.getPiece(new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn() - 1)).getTeamColor();
                    if (myTeamColor != otherPieceColor) {
                        moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn() - 1), null));
                        System.out.println((myPosition.getRow() - 1) + " " + (myPosition.getColumn() - 1));
                    }
                } //left capture pawn promotion
            } else if (myPosition.getRow() - 1 == 1 && myPosition.getColumn() - 1 >= 1) {
                if (board.getPiece(new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn() - 1)) != null) {
                    ChessGame.TeamColor otherPieceColor = board.getPiece(new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn() - 1)).getTeamColor();
                    if (myTeamColor != otherPieceColor) {
                        moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn() - 1), ChessPiece.PieceType.QUEEN));
                        moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn() - 1), ChessPiece.PieceType.ROOK));
                        moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn() - 1), ChessPiece.PieceType.BISHOP));
                        moves.add(new ChessMove(myPosition, new ChessPosition(myPosition.getRow() - 1, myPosition.getColumn() - 1), ChessPiece.PieceType.KNIGHT));
                        System.out.println((myPosition.getRow() - 1) + " " + (myPosition.getColumn() - 1));
                    }
                }
            }
        }
        return moves;
    }
}
