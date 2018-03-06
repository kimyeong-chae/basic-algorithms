public class LinkedList {

	private class Node {

		private Object data;		//실제 데이터가 담기는 변수
		private Node next;			//다음 노드 변수

		public Node(Object data) {
			this.data = data;
			this.next = null;
		}
	}

	private Node head;		//첫번쨰 노드가 담기는 변수
	private Node tail;		//마지막 노드가 담기는 변수
	private int size = 0;		//리스트 사이즈가 담기는 변수

	// 리스트 헤드에 추가
	private void addFirst(data) {
		Node node = new Node(data);
		// 새로 생성된 노드의 다음 노드는 기존 헤드 노드
		node.next = head;
		// 새로 생성된 노드가 헤드 노드가 된다
		head = node;
		// 사이즈 증분
		size++;

		// 테일 노드가 널일 경우 헤드 노드가 테일 노드가 된다
		if (tail == null)
			tail = head;
	}

	// 리스트 마지막에 추가
	private void addLast(data) {

		// 리스트 사이즈가 마지막일 경우 addFirst 메서드 호출
		if (size == 0) {
			addFirst(data);
		} else {
			// 새 노드 생성
			Node node = new Node(data);
			// 기존 테일 노드의 다음 값이 새 노드
			tail.next = node;
			// 새 노드가 테일 노드가 된다
			tail = node;
			// 사이즈 증분
			size++;
		}

	// 인덱스에 데이터 추가
	public void add(int index, Object data) {
		// 새 노드 생성
		Node node = new Node(data);
		// 새 노드가 들어갈 자리의 이전 노드 조회
		Node beforeNode = getNode(index-1);
		// 새 노드가 들어갈 자리의 이전 노드의 다음 노드 조회
		Node nextNode = beforeNode.next;
		// 이전노드의 다음값을 새 노드로 변경
		beforeNode.next = node;
		// 새 노드의 다음값을 이전노드의 기존 다음 노드로 변경
		node.next = nextNode;
		// 사이즈 증분
		size++;

		// 새노드의 다음노드가 널일 경우 새노드를 테일 노드로 지정
		if (nextNode == null)
			tail = node;
	}

	// index의 해당하는 노드 가져오기
	private Node getNode(index) {
		// 조회하는 인덱스가 마지막 인덱스일 경우 테일 노드 리턴
		if (index == size-1) {
			return tail;
		} else {
			// 첫 노드에서 조회하려는 index 수 만큼 next 진행
			Node returnNode = head;
			for (int i = 0; i < index; i++)
				returnNode = returnNode.next;

			return returnNode;
		}
	}

	// 모든 노드의 값을 String으로 변환해서 출력
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");

		Node current = head;
		while(current.next != null) {
			sb.append(String.valufOf(current.data) + ",");
			current = current.next;
		}

		// 마지막 노드는 while문 안에서 실행되지 않기 떄문에 while문이 끝난 후 append
		sb.append(current.next);
		sb.append("]");
		return sb.toString();
	}

	// 첫번쨰 노드 삭제
	private void removeFirst() {
		// 여기서 궁금한게 이렇게 head 노드를 바꾸고 나면 기존 head는 메모리가 어쩃든 어딘가에 떠있을텐데 걔는 가비지 컬렉터가 돌때 메모리가 해제되는걸까
		head = head.next;
		size--;
	}

	// 마지막 노드 삭제
	private void removeLast() {
		tail = getNode(size-2).next();
		size--;
	}

	// index번째 노드 삭제
	public void remove(int index) {
		// index가 0일 경우
		if (index == 0) {
			removeFirst();
		// index가 마지막 index일 경우
		} else if (index == (size-1)) {
			removeLast();
		} else {
			Node beforeNode = getNode(index-1);
			beforeNode.next = beforeNode.next.next;
			size--;
		}
	}

	// 마지막 노드 추출
	public Object pop() {
		Node returnNode = tail;
		Node lastlastNode = getNode(index-2);
		lastlastNode.next = null;
		tail = lastlastNode;
		return returnNode;
	}

	// 리스트 사이즈 조회
	public int size() {
		return count;
	}



}
