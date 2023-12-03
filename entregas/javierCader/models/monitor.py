import string
import random
from models.board import Board
from data_structures.queue import Queue

class Monitor:
    def __init__(self, name):
        self.name = name
        self.board = Board()
        self.queue = Queue()

    def _generateInitialMessage(self, length=10):
        self.board.receiveMessage(''.join(random.choice(string.ascii_uppercase) for _ in range(length)))

    def receiveAndOrganizeKids(self, kid):
        print(f"Monitor {self.name} received {kid.name}")
        self.queue.enqueue(kid)
        
    def passKidsToNextMonitor(self, nextMonitor):
        if not self.queue.is_empty():
            for _ in range(self.queue.size()):
                nextMonitor.receiveAndOrganizeKids(self.queue.dequeue())

    def manageGame(self, game):
        if not game.isRunning and self.queue.size() >= 5:
            self._generateInitialMessage()
            game.startGame(self.board.message, self.queue)
        elif game.isRunning:
            game.continueGame()
            
    def receiveFinalMessage(self, message): 
        self.board.receiveMessage(message)
        
    def showQueue(self):
        print(f"Monitor {self.name} queue: {self.queue.string_queue()}")
            
    def readFinalMessage(self):
        print(f"The final message of this game was: {self.board.message}")  
