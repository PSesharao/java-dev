package superior24;

public class Matrix {
	int matrix[][];
	int rows;
	int cols;
	public int[][] getMatrix() {
		return matrix;
	}
	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getCols() {
		return cols;
	}
	public void setCols(int cols) {
		this.cols = cols;
	}
	public Matrix(int[][] matrix, int rows, int cols) {
		this.matrix = matrix;
		this.rows = rows;
		this.cols = cols;
	}
	
	public void printMatrix()
	{
		for(int row=0;row<rows;row++)
		{
			for(int line=0;line<cols*4+1;line++)
			System.out.print('-');
			System.out.println();
			for(int col=0;col<cols;col++)
				System.out.printf("| %d ",matrix[row][col]);
			System.out.println("|");
		}
		for(int line=0;line<cols*4+1;line++)
			System.out.print('-');
			System.out.println();
	}
}
