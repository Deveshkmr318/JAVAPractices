public class SierpinskiCarpet {

    public static void main(String[] args) {
        int level = 4; // Change this value to set the depth of recursion (1 <= N <= 6)
        int size = (int) Math.pow(3, level);

        char[][] carpet = new char[size][size];

        // Initialize the carpet with all black cells
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                carpet[i][j] = '#';
            }
        }

        // Generate the Sierpinski carpet pattern
        generateCarpet(carpet, 0, 0, size);

        // Print the carpet
        printCarpet(carpet);
    }

    private static void generateCarpet(char[][] carpet, int x, int y, int size) {
        if (size < 3) return;

        int newSize = size / 3;

        // Clear the center part
        for (int i = x + newSize; i < x + 2 * newSize; i++) {
            for (int j = y + newSize; j < y + 2 * newSize; j++) {
                carpet[i][j] = '.';
            }
        }

        // Recursively generate the pattern for the remaining 8 parts
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != 1 || j != 1) {
                    generateCarpet(carpet, x + i * newSize, y + j * newSize, newSize);
                }
            }
        }
    }

    private static void printCarpet(char[][] carpet) {
        for (int i = 0; i < carpet.length; i++) {
            for (int j = 0; j < carpet[i].length; j++) {
                System.out.print(carpet[i][j]);
            }
            System.out.println();
        }
    }
}
