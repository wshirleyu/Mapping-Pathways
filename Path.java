public class Path {
	private Map cityMap; // references the object representing the city map

	public Path(Map theMap) {
		// receives as input a reference a Map object representing the city map.
		cityMap = theMap;

	}

	public void findPath() {
		ArrayStack<MapCell> newPath = new ArrayStack<MapCell>(10, 4, 4);
		MapCell startPoint = cityMap.getStart();

		newPath.push(startPoint);
		startPoint.markInStack();

		while (!newPath.isEmpty() && !startPoint.isDestination()) {
			MapCell currentCell = newPath.peek();
			if (currentCell.isDestination()) {
				System.out.println("Destination found!\nThe path is " + newPath.size() + " cells in total.");
				break;
			}
			MapCell next = nextCell(currentCell);
			if (next != null) {
				newPath.push(next);
				next.markInStack();
			} else if (currentCell.isStart() && next == null) {
				System.out.println("There are no possible paths.");
				break;
			} else {
				newPath.pop();
				currentCell.markOutStack();
			}
		}
	}

	private MapCell nextCell(MapCell cell) {

		for (int i = 0; i <= 3; i++) {
			if ((cell.getNeighbour(i)) != null && !(cell.getNeighbour(i).isMarked())) {
				if ((cell.getNeighbour(i)).isDestination()) {
					return cell.getNeighbour(i);
				} else if ((cell.getNeighbour(i)).isIntersection()) {
					return cell.getNeighbour(i);
				} else if ((cell.getNeighbour(i)).isNorthRoad()) {
					return cell.getNeighbour(i);
				} else if ((cell.getNeighbour(i)).isSouthRoad()) {
					return cell.getNeighbour(i);
				} else if ((cell.getNeighbour(i)).isEastRoad()) {
					return cell.getNeighbour(i);
				} else if ((cell.getNeighbour(i)).isWestRoad()) {
					return cell.getNeighbour(i);
				}
			}
		}
		return null;
	}

}
