package Model;

import Pieces.*;

public class Board {

    private Piece[][] board;

    public Board() {
        board = new Piece[8][8];
        initializeBoard();
    }

    private void initializeBoard() {
        // White pieces
        board[0][0] = new Rook(Color.WHITE, 0, 0);
        board[0][1] = new Knight(Color.WHITE, 0, 1);
        board[0][2] = new Bishop(Color.WHITE, 0, 2);
        board[0][3] = new Queen(Color.WHITE, 0, 3);
        board[0][4] = new King(Color.WHITE, 0, 4);
        board[0][5] = new Bishop(Color.WHITE, 0, 5);
        board[0][6] = new Knight(Color.WHITE, 0, 6);
        board[0][7] = new Rook(Color.WHITE, 0, 7);

        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(Color.WHITE, 1, i);
        }

        // Black pieces
        board[7][0] = new Rook(Color.BLACK, 7, 0);
        board[7][1] = new Knight(Color.BLACK, 7, 1);
        board[7][2] = new Bishop(Color.BLACK, 7, 2);
        board[7][3] = new Queen(Color.BLACK, 7, 3);
        board[7][4] = new King(Color.BLACK, 7, 4);
        board[7][5] = new Bishop(Color.BLACK, 7, 5);
        board[7][6] = new Knight(Color.BLACK, 7, 6);
        board[7][7] = new Rook(Color.BLACK, 7, 7);

        for (int i = 0; i < 8; i++) {
            board[6][i] = new Pawn(Color.BLACK, 6, i);
        }
    }

    public Piece getPiece(int row, int col) {
        return board[row][col];
    }

    public void setPiece(int row, int col, Piece piece) {
        board[row][col] = piece;
    }

    public boolean isValidMove(Piece piece, int destRow, int destCol) {
        if (piece == null || destRow < 0 || destRow > 7 || destCol < 0 || destCol > 7) {
            return false;
        }

        Piece destPiece = board[destRow][destCol];

        if ((destPiece == null || destPiece.getColor() != piece.getColor()) &&
                piece.canMove(this, destRow, destCol)) {
            return true;
        }
        return false;
    }

    public boolean isCheckmate(Color color) {
        if (!isInCheck(color)) {
            return false;
        }

        // Try all possible moves to escape check
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = board[row][col];
                if (piece != null && piece.getColor() == color) {
                    for (int desRow = 0; desRow < 8; desRow++) {
                        for (int desCol = 0; desCol < 8; desCol++) {
                            if (isValidMove(piece, desRow, desCol)) {
                                Piece backup = board[desRow][desCol];
                                board[desRow][desCol] = piece;
                                board[row][col] = null;

                                boolean stillInCheck = isInCheck(color);

                                // Undo move
                                board[row][col] = piece;
                                board[desRow][desCol] = backup;

                                if (!stillInCheck) {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean isStalemate(Color color) {
        // TODO: Implement stalemate logic
        return false;
    }

    public boolean isInCheck(Color color) {
        int kingRow = -1;
        int kingCol = -1;

        // Find the king
        outer:
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = board[row][col];
                if (piece instanceof King && piece.getColor() == color) {
                    kingRow = row;
                    kingCol = col;
                    break outer;
                }
            }
        }

        if (kingRow == -1 || kingCol == -1) {
            throw new IllegalArgumentException("King not found for color: " + color);
        }

        // Check if any opponent piece can attack the king
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = board[row][col];
                if (piece != null && piece.getColor() != color) {
                    if (piece.canMove(this, kingRow, kingCol)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
