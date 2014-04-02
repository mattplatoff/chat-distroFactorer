package determinentFinder;

public class DeterminintFinder {

	

	private static int[][] shrinkMatrix(int[][] a, int row, int col) {
		int[][] newMatrix = new int[a.length - 1][a.length - 1];
		a = java.util.Arrays.copyOf(a, a.length);

		if (row + 1 < a.length)
			System.arraycopy(a, row + 1, a, row, newMatrix.length - row);

		for (int i = 0; i < newMatrix.length; i++)
			if (col + 1 < a.length)
				System.arraycopy(a[i], col + 1, a[i], col, newMatrix.length - col);

		for (int i = 0; i < newMatrix.length; i++)
			System.arraycopy(a[i], 0, newMatrix[i], 0, newMatrix.length);

		return newMatrix;
	}

	public static int determinant(int[][] matrix) {
		if (matrix.length == 2)
			return matrix[0][0] * matrix[1][1] - matrix[1][0] * matrix[0][1];

		int determinant = 0;
		boolean add = false;

		for (int i = 0; i < matrix.length; i++) {
			int submatrix = determinant(shrinkMatrix(matrix, i, 0));
			determinant += matrix[i][0]
					* ((add = !add) ? submatrix : -submatrix);
		}

		return determinant;
	}

}
