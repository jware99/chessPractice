package chess;

import java.util.Collection;

public interface ChessPieceCalculator {
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition);
}
