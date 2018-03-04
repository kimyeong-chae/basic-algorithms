
class ArrayList {

	private Object[] array;
	private int size;
	private int count;

	MyArrayList () {
		this.array = new Object[size];
		this.count = 0;
	}

	// 배열 확장
	private void extendArray() {
		size = size * 2;

		Object[] tmpArray = new Object[size];

		for (int i = 0; i < this.array.length; i++) {
			tmpArray[i] = this.array[i];
		}
		array = tmpArray;
	}

	public void add(Object data) {
		// 배열이 꽉 찾을 경우
		if (array.lenth == size) extendArray();

		this.array[this.count] = data;
		count += 1;
	}

	public void get(int index) throws IndexOutOfBoundsException {
		// 조회하려는 인덱스가 배열의 길이보다 클 경우 에러
		if (index >= this.array.length) throw new IndexOutOfBoundsException();
		return this.array[index];
	}

	public void remove(int index) throws IndexOutOfBoundsException {
		// 삭제하려는 인덱스가 배열의 길이보다 클 경우 에러
		if (index >= this.array.length) throw new IndexOutOfBoundsException();

		// 삭제될 인덱스를 채우기 위해 삭제될 인덱스 다음 인덱스부터 순차적으로 인덱스를 이동
		for (int i = index+1; i < this.array.length; i++) {
			this.array[i-1] = this.array[i];
		}

		// 배열의 마지막 값을 null처리
		this.array[count-1] = null;
		count -= 1;
	}

	// 리스트 사이즈 조회
	public int size() {
		return count;
	}

	// 데이터 추출 : 마지막 값 조회와 동시에 삭제
	public void pop() {
		// 마지막 값 저장 변수 선언
		Object returnData = this.array[count-1];
		// 마지막 데이터 삭제
		this.remove(this.count-1);
		return returnData;
	}

}
