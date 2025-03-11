import java.util.Scanner;

public class Game {
    private Board board;
    private Scanner scanner;
    private Block currentBlock;

    public Game() {
        board = new Board();
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.print("Block: ");
            String blockType = scanner.nextLine().trim().toUpperCase();
            
            if (blockType.equals("-")) {
                break;
            }

            currentBlock = createBlock(blockType);
            if (currentBlock == null) {
                System.out.println("Invalid block type!");
                continue;
            }

            System.out.print("Rotation: ");
            int rotation = Integer.parseInt(scanner.nextLine().trim());
            currentBlock.rotate(rotation);

            System.out.print("Place: ");
            String[] position = scanner.nextLine().trim().split(" ");
            int row = Integer.parseInt(position[0]);
            int col = Integer.parseInt(position[1]);

            if (board.canPlaceBlock(currentBlock, row, col)) {
                currentBlock.setPosition(row, col);
                board.placeBlock(currentBlock);
                board.display();
            } else {
                System.out.println("Cannot place block at that position!");
            }
        }
        scanner.close();
    }

    private Block createBlock(String type) {
        return switch (type) {
            case "L" -> new LBlock();
            case "O" -> new OBlock();
            case "I" -> new IBlock();
            case "J" -> new JBlock();
            case "T" -> new TBlock();
            default -> null;
        };
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}