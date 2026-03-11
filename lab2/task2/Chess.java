package lab2.task2;
import java.util.*;

public class Chess {

    public static class Position {
        private int row;
        private int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() { return row; }
        public int getCol() { return col; }

        @Override
        public String toString() {
            return "(" + (char)('a' + col) + (row + 1) + ")";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Position)) return false;
            Position p = (Position) o;
            return row == p.row && col == p.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

    public enum Color { WHITE, BLACK }

    public abstract static class Piece {
        protected Position position;
        protected Color color;

        public Piece(Position position, Color color) {
            this.position = position;
            this.color = color;
        }

        public Position getPosition() { return position; }
        public Color getColor() { return color; }
        public void setPosition(Position position) { this.position = position; }

        public abstract boolean isLegalMove(Position b);
        public abstract String getSymbol();

        @Override
        public String toString() {
            return color + " " + getClass().getSimpleName() + " at " + position;
        }
    }

    public static class Rook extends Piece {
        public Rook(Position position, Color color) {
            super(position, color);
        }

        @Override
        public boolean isLegalMove(Position b) {
            return position.getRow() == b.getRow() || position.getCol() == b.getCol();
        }

        @Override
        public String getSymbol() { return color == Color.WHITE ? "♖" : "♜"; }
    }

    public static class Bishop extends Piece {
        public Bishop(Position position, Color color) {
            super(position, color);
        }

        @Override
        public boolean isLegalMove(Position b) {
            int dr = Math.abs(b.getRow() - position.getRow());
            int dc = Math.abs(b.getCol() - position.getCol());
            return dr == dc && dr != 0;
        }

        @Override
        public String getSymbol() { return color == Color.WHITE ? "♗" : "♝"; }
    }

    public static class Queen extends Piece {
        public Queen(Position position, Color color) {
            super(position, color);
        }

        @Override
        public boolean isLegalMove(Position b) {
            int dr = Math.abs(b.getRow() - position.getRow());
            int dc = Math.abs(b.getCol() - position.getCol());
            boolean straightLine = position.getRow() == b.getRow() || position.getCol() == b.getCol();
            boolean diagonal = dr == dc && dr != 0;
            return straightLine || diagonal;
        }

        @Override
        public String getSymbol() { return color == Color.WHITE ? "♕" : "♛"; }
    }

    public static class King extends Piece {
        public King(Position position, Color color) {
            super(position, color);
        }

        @Override
        public boolean isLegalMove(Position b) {
            int dr = Math.abs(b.getRow() - position.getRow());
            int dc = Math.abs(b.getCol() - position.getCol());
            return dr <= 1 && dc <= 1 && (dr + dc > 0);
        }

        @Override
        public String getSymbol() { return color == Color.WHITE ? "♔" : "♚"; }
    }

    public static class Knight extends Piece {
        public Knight(Position position, Color color) {
            super(position, color);
        }

        @Override
        public boolean isLegalMove(Position b) {
            int dr = Math.abs(b.getRow() - position.getRow());
            int dc = Math.abs(b.getCol() - position.getCol());
            return (dr == 2 && dc == 1) || (dr == 1 && dc == 2);
        }

        @Override
        public String getSymbol() { return color == Color.WHITE ? "♘" : "♞"; }
    }

    public static class Pawn extends Piece {
        private boolean hasMoved;

        public Pawn(Position position, Color color) {
            super(position, color);
            this.hasMoved = false;
        }

        @Override
        public boolean isLegalMove(Position b) {
            int direction = color == Color.WHITE ? 1 : -1;
            int dr = b.getRow() - position.getRow();
            int dc = Math.abs(b.getCol() - position.getCol());

            if (dc == 0 && dr == direction) return true;
            if (dc == 0 && dr == 2 * direction && !hasMoved) return true;
            if (dc == 1 && dr == direction) return true;
            return false;
        }

        public void markMoved() { this.hasMoved = true; }
        public boolean hasMoved() { return hasMoved; }

        @Override
        public String getSymbol() { return color == Color.WHITE ? "♙" : "♟"; }
    }

    public static class Board {
        private Piece[][] grid;
        private Color currentTurn;
        private String lastMessage;

        public Board() {
            grid = new Piece[8][8];
            currentTurn = Color.WHITE;
            lastMessage = "";
            setupBoard();
        }

        private void setupBoard() {
            Color[] sides = {Color.WHITE, Color.BLACK};
            int[] backRanks = {0, 7};
            int[] pawnRanks = {1, 6};

            for (int i = 0; i < 2; i++) {
                Color c = sides[i];
                int r = backRanks[i];
                grid[r][0] = new Rook(new Position(r, 0), c);
                grid[r][1] = new Knight(new Position(r, 1), c);
                grid[r][2] = new Bishop(new Position(r, 2), c);
                grid[r][3] = new Queen(new Position(r, 3), c);
                grid[r][4] = new King(new Position(r, 4), c);
                grid[r][5] = new Bishop(new Position(r, 5), c);
                grid[r][6] = new Knight(new Position(r, 6), c);
                grid[r][7] = new Rook(new Position(r, 7), c);

                for (int col = 0; col < 8; col++) {
                    grid[pawnRanks[i]][col] = new Pawn(new Position(pawnRanks[i], col), c);
                }
            }
        }

        public boolean movePiece(int fromRow, int fromCol, int toRow, int toCol) {
            if (!isInBounds(fromRow, fromCol) || !isInBounds(toRow, toCol)) {
                lastMessage = "Position out of bounds.";
                return false;
            }

            Piece piece = grid[fromRow][fromCol];
            if (piece == null) {
                lastMessage = "No piece at source position.";
                return false;
            }

            if (piece.getColor() != currentTurn) {
                lastMessage = "It's " + currentTurn + "'s turn.";
                return false;
            }

            Position target = new Position(toRow, toCol);
            if (!piece.isLegalMove(target)) {
                lastMessage = "Illegal move for " + piece.getClass().getSimpleName() + ".";
                return false;
            }

            Piece targetPiece = grid[toRow][toCol];
            if (targetPiece != null && targetPiece.getColor() == piece.getColor()) {
                lastMessage = "Cannot capture your own piece.";
                return false;
            }

            if (piece instanceof Pawn) {
                int dc = Math.abs(toCol - fromCol);
                if (dc == 1 && targetPiece == null) {
                    lastMessage = "Pawns capture diagonally only when there is an enemy piece.";
                    return false;
                }
                if (dc == 0 && targetPiece != null) {
                    lastMessage = "Pawns cannot capture forward.";
                    return false;
                }
                ((Pawn) piece).markMoved();
            }

            grid[toRow][toCol] = piece;
            grid[fromRow][fromCol] = null;
            piece.setPosition(target);

            lastMessage = piece.getClass().getSimpleName() + " moved to " + target;
            currentTurn = (currentTurn == Color.WHITE) ? Color.BLACK : Color.WHITE;
            return true;
        }

        public void printBoard() {
            System.out.println("\n   a  b  c  d  e  f  g  h");
            System.out.println("  +--+--+--+--+--+--+--+--+");
            for (int row = 7; row >= 0; row--) {
                System.out.print((row + 1) + " |");
                for (int col = 0; col < 8; col++) {
                    Piece p = grid[row][col];
                    System.out.print(p != null ? p.getSymbol() + " |" : "  |");
                }
                System.out.println(" " + (row + 1));
            }
            System.out.println("  +--+--+--+--+--+--+--+--+");
            System.out.println("   a  b  c  d  e  f  g  h");
            System.out.println("Turn: " + currentTurn);
            if (!lastMessage.isEmpty()) System.out.println(">> " + lastMessage);
        }

        private boolean isInBounds(int row, int col) {
            return row >= 0 && row < 8 && col >= 0 && col < 8;
        }

        public Color getCurrentTurn() { return currentTurn; }
        public Piece getPiece(int row, int col) { return grid[row][col]; }
        public String getLastMessage() { return lastMessage; }
    }

    public static class TestChess {
        public static void main(String[] args) {
            System.out.println("=== Legal Move Tests ===");

            Rook rook = new Rook(new Position(0, 0), Color.WHITE);
            System.out.println("Rook (0,0) -> (0,5) [horizontal]: " + rook.isLegalMove(new Position(0, 5)));
            System.out.println("Rook (0,0) -> (5,0) [vertical]:   " + rook.isLegalMove(new Position(5, 0)));
            System.out.println("Rook (0,0) -> (3,3) [diagonal]:   " + rook.isLegalMove(new Position(3, 3)));

            Bishop bishop = new Bishop(new Position(2, 2), Color.WHITE);
            System.out.println("\nBishop (2,2) -> (5,5) [diagonal]:  " + bishop.isLegalMove(new Position(5, 5)));
            System.out.println("Bishop (2,2) -> (2,5) [horizontal]: " + bishop.isLegalMove(new Position(2, 5)));

            Knight knight = new Knight(new Position(4, 4), Color.WHITE);
            System.out.println("\nKnight (4,4) -> (6,5) [L-shape]: " + knight.isLegalMove(new Position(6, 5)));
            System.out.println("Knight (4,4) -> (5,6) [L-shape]: " + knight.isLegalMove(new Position(5, 6)));
            System.out.println("Knight (4,4) -> (6,6) [invalid]:  " + knight.isLegalMove(new Position(6, 6)));

            Queen queen = new Queen(new Position(3, 3), Color.WHITE);
            System.out.println("\nQueen (3,3) -> (7,7) [diagonal]:   " + queen.isLegalMove(new Position(7, 7)));
            System.out.println("Queen (3,3) -> (3,7) [horizontal]:  " + queen.isLegalMove(new Position(3, 7)));
            System.out.println("Queen (3,3) -> (2,5) [invalid]:     " + queen.isLegalMove(new Position(2, 5)));

            King king = new King(new Position(4, 4), Color.WHITE);
            System.out.println("\nKing (4,4) -> (4,5) [one step]: " + king.isLegalMove(new Position(4, 5)));
            System.out.println("King (4,4) -> (4,6) [two steps]: " + king.isLegalMove(new Position(4, 6)));

            Pawn pawn = new Pawn(new Position(1, 0), Color.WHITE);
            System.out.println("\nPawn (1,0) -> (2,0) [one forward]:  " + pawn.isLegalMove(new Position(2, 0)));
            System.out.println("Pawn (1,0) -> (3,0) [two forward]:  " + pawn.isLegalMove(new Position(3, 0)));
            System.out.println("Pawn (1,0) -> (2,1) [diagonal cap]: " + pawn.isLegalMove(new Position(2, 1)));
            System.out.println("Pawn (1,0) -> (1,1) [sideways]:     " + pawn.isLegalMove(new Position(1, 1)));

            System.out.println("\n=== Board Game Simulation ===");
            Board board = new Board();
            board.printBoard();

            board.movePiece(1, 4, 3, 4);
            board.printBoard();

            board.movePiece(6, 4, 4, 4);
            board.printBoard();

            board.movePiece(0, 6, 2, 5);
            board.printBoard();
        }
    }

    public static void main(String[] args) {
        TestChess.main(args);
    }
}
