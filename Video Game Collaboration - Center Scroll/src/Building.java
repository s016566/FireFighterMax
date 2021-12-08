
public class Building {
	private int columns;
	private int rows;
	private Windows windows;

	public Building(int columns,int rows) {
		this.columns = columns;
		this.rows  = rows;
		
		
	}
	
	public Building() {
		columns = 3;
		rows = 3;
		
	}
	public int getColumns() {
		return columns;
	}
	public void setColumns(int columns) {
		this.columns = columns;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
//	public int[][] getBuildingFire() {
//		return buildingFire;
//	}
//	public void setBuildingFire(int[][] buildingFire) {
//		this.buildingFire = buildingFire;
//	}
	public void getBuilding() {
		
		return int [columns][rows];	
		//creating 2D array to setup building frame
		
	}
	

}
