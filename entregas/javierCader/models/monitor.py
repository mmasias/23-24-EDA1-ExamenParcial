import string
import random
from models.board import Board
from datastructures.queue import Queue

class Monitor:
    def __init__(self, name):
        self.name = name
        self.board = Board()
        self.queue = Queue()

    def _generateInitialMessage(self, length=10):
        self.board.receiveMessage(''.join(random.choice(string.ascii_uppercase) for _ in range(length)))

    def receiveAndOrganizeKids(self, kid):
        self.queue.enqueue(kid)

    def manageGame(self, game, waitingQueue):
        self.queue = waitingQueue
        if not game.isRunning and self.queue.size() >= 5:
            self._generateInitialMessage()
            game.startGame(self.board.message, self.queue)
        elif game.isRunning:
            game.continueGame()
            
    def receiveFinalMessage(self, message): 
        self.board.receiveMessage(message)
            
    def readFinalMessage(self):
        print(self.board.message)  
