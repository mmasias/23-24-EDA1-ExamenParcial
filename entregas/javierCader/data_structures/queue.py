class Queue:
    def __init__(self):
        self._elements = []
    
    def enqueue(self, element):
        self._elements.append(element)
    
    def dequeue(self):
        if self.is_empty():
            raise IndexError("dequeue from an empty queue")
        return self._elements.pop(0)
    
    def peek(self):
        if self.is_empty():
            raise IndexError("peek from an empty queue")
        return self._elements[0]
    
    def is_empty(self):
        return len(self._elements) == 0
    
    def size(self):
        return len(self._elements)
    
    def to_iterable(self):
        return self._elements
    
    def string_queue(self):
        return '/'.join(str(element) for element in self._elements)
    
    def __repr__(self):
        return f"Queue({self._elements})"
