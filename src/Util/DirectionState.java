package Util;

public enum DirectionState {
	Left(0, -1, 0), Up(1, 0, -1), Down(2, 0, 1), Right(3, 1, 0), None(-1, 0, 0);
	private int num;
	private int x;
	private int y;
	private DirectionState(int num, int x, int y) {
		this.num = num;
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.num);
	}
	
	public int value() {
		return Integer.valueOf(this.toString());
	}


	public static DirectionState findValueToDirectionState(int value) {
		if (value == 0) {
			return DirectionState.Left;
		}
		else if (value == 1) {
			return DirectionState.Up;
		}
		else if (value == 2) {
			return DirectionState.Down;
		}
		else if (value == 3) {
			return DirectionState.Right;
		}

		return null;
	}
	public static DirectionState findValueToOppositeDirectionState(int value) {
		if (value == 0) {
			return DirectionState.Right;
		}
		else if (value == 1) {
			return DirectionState.Down;
		}
		else if (value == 2) {
			return DirectionState.Up;
		}
		else if (value == 3) {
			return DirectionState.Left;
		}

		return null;
	}


	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

}
