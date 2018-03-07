'''
# Queue는 FIFO(First In First Out) 자료구조
# Queue는
'''
class YCQueue :
	def __init__(self, max=Max):
		self.max_size = max
		self.array = [None] * self.max_size
		self.size = self.front = self.rear = 0

	# 비었는지 확인
	def is_empty(self):
		return self.size == 0

	# 꽉찾는지 확인
	def is_full(self):
		return self.next_idx(self.rear) == self.front
