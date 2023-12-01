import random
import string
from models.board import Board

class Kid:
    def __init__(self):
        self.board = Board()

    def receiveMessage(self, message):
        print("Kid received message:", message)
        deformedMessage = self._deformMessage(message)
        self.board.receiveMessage(deformedMessage)

    def showMessage(self):
        return self.board.message

    def _deformMessage(self, message):
        if not message:
            return message
        deformedMessage = message.replace(random.choice(message), random.choice(string.ascii_uppercase))
        return deformedMessage
