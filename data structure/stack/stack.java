/*
 * Stack 구현에는 대표적으로 Array, LinkedList를 이용한다. (이건 LinkedList로 구현)
 * Stack은 LIFO(Last In First Out)의 대표적인 자료구조이다.
 */
public class YCStack {

	// LinkedList의 요소인 Node클래스 정의
	class YCNode {
		public Obejct data;
		public YCNode next = null;

		YCNode(Object data) {
			this.data = data;
		}
	}

	private YCNode top = null; //최초 인스턴스 생성시 Null
	private int size = 0;

	// DATA 추가
	public void push(Object data) {
		// 노드 생성
		YCNode node = new YCNode(data);
		// 노드의 다음 값은 무조건 top. top이 null이여도 괜찮다. 어차피 next의 기본값은 null이니까
		node.next = top;
		// 생성한 노드를 top으로
		top = node;
		// 사이즈 증분
		size++;
	}

	// DATA 추출
	public Obejct pop() {
		// 리턴객체 선언
		Object returnData = null;
		// Stack 사이즈가 0보다 클 경우
		if (size > 0) {
			// 리턴 데이터는 탑노드의 데이터
			returnData = top.data;
			// 추출 후 탑은 기존 탑의 다음값
			top = top.next;
			size--;
		}

		return returnData;
	}

	// Data 조회
	public Obejct peek() {
		if (top == null)
			return null;
		return top.data;
	}

	// Stack size 조회
	public int size() {
		return size;
	}
}
