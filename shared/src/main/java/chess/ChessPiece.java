package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * Represents a single chess piece
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessPiece {
    private final ChessGame.TeamColor pieceColor;
    private final ChessPiece.PieceType type;

    public ChessPiece(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) {
        this.pieceColor = pieceColor;
        this.type = type;
    }

    /**
     * The various different chess piece options
     */
    public enum PieceType {
        KING,
        QUEEN,
        BISHOP,
        KNIGHT,
        ROOK,
        PAWN
    }

    /**
     * @return Which team this chess piece belongs to
     */
    public ChessGame.TeamColor getTeamColor() {
        return pieceColor;
    }

    /**
     * @return which type of chess piece this piece is
     */
    public PieceType getPieceType() {
        return type;
    }

    /**
     * Calculates all the positions a chess piece can move to
     * Does not take into account moves that are illegal due to leaving the king in
     * danger
     *
     * @return Collection of valid moves
     */
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        if (board.getPiece(myPosition).type == PieceType.BISHOP) {
            return new BishopMoves().pieceMoves(board, myPosition);
        } else if (board.getPiece(myPosition).type == PieceType.ROOK) {
            return new RookMoves().pieceMoves(board, myPosition);
        } else if (board.getPiece(myPosition).type == PieceType.QUEEN) {
            return new QueenMoves().pieceMoves(board, myPosition);
        } else if (board.getPiece(myPosition).type == PieceType.KNIGHT) {
            return new KnightMoves().pieceMoves(board, myPosition);
        } else if (board.getPiece(myPosition).type == PieceType.KING) {
            return new KingMoves().pieceMoves(board, myPosition);
        } else if (board.getPiece(myPosition).type == PieceType.PAWN) {
            return new PawnMoves().pieceMoves(board, myPosition);
        }
        return new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChessPiece that = (ChessPiece) o;
        return pieceColor == that.pieceColor && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pieceColor, type);
    }

    @Override
    public String toString() {
        return "ChessPiece{" +
                "pieceColor=" + pieceColor +
                ", type=" + type +
                '}';
    }
}
