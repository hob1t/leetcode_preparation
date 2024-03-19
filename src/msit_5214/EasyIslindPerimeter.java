package msit_5214;

import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * You are given row x col grid representing a map where grid[i][j] = 1
 * represents land and grid[i][j] = 0 represents water.
 * 
 * Grid cells are connected horizontally/vertically (not diagonally). The grid
 * is completely surrounded by water, and there is exactly one island (i.e., one
 * or more connected land cells).
 * 
 * The island doesn't have "lakes", meaning the water inside isn't connected to
 * the water around the island. One cell is a square with side length 1. The
 * grid is rectangular, width and height don't exceed 100. Determine the
 * perimeter of the island.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]] Output: 16
 * Explanation: The perimeter is the 16 yellow stripes in the image above.
 * 
 * Example 2:
 * 
 * Input: grid = [[1]] Output: 4
 * 
 * Example 3:
 * 
 * Input: grid = [[1,0]] Output: 4
 * 
 * Many thanks to NeetCode https://www.youtube.com/watch?v=fISIuAFRM2s&t=474s
 * 
 * 
 */
public class EasyIslindPerimeter {

	public int islandPerimeter(int[][] grid) {

		Set<Entry<?, ?>> visited = new HashSet<>();

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {

				if (grid[i][j] == 1) {
					return dfs(i, j, visited, grid);
				}
			}
		}

		return 0;
	}

	int dfs(int i, int j, Set<Entry<?, ?>> visited, int[][] grid) {
		Entry<Integer, Integer> coord = Map.entry(i, j);

		int perimeter = 0;

		// if goes over grid, beyond or below
		if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0 || grid[i][j] == 0) {
			return 1;
		}

		if (visited.contains(coord)) {
			return 0;
		}

		visited.add(coord);

		perimeter = dfs(i, j + 1, visited, grid);
		perimeter += dfs(i + 1, j, visited, grid);
		perimeter += dfs(i, j - 1, visited, grid);
		perimeter += dfs(i - 1, j, visited, grid);

		return perimeter;
	}

	public static void main(String[] args) {
		int[][] grid = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
		EasyIslindPerimeter runner = new EasyIslindPerimeter();
		int perimeter = runner.islandPerimeter(grid);
		System.out.println("Perimeter " + perimeter);
	}
}
