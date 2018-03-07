'''
python으로는 Array로 Stack 구현
'''
class ArrayStack :

	# 생성자
	def __init__(self):
		self.array = []
		self.top_index = 0

	# top_index 셋
	def setTopIndex(self) :
		# top_index는 항상 array 크기의 -1을 한 값.
		self.top_index = len(self.array) - 1

	# 데이터 삽입
	def push(self, data):
		# array의 데이터 추가
		self.array.append(data)
		self.setTopIndex()

	# 추출
	def pop(self):
		# array의 길이가 0보다 클 경우
		if len(self.array) > 0 :
			data = self.array[self.top_index]
			del self.array[self.top_index]
			self.setTopIndex()
			return data

	# 데이터 조회
	def peek(self):
		# array의 길이가 0보다 클 경우
		if len(self.array) > 0 :
			return self.array[self.top_index]

	# 스택 사이즈 조회
	def size(self):
		return len(self.array)
