import random
import string
from models.board import Board
from utils.kid_names import KID_NAMES

class Kid:
    def __init__(self):
        self.name = random.choice(KID_NAMES)
        self.board = Board()

    def receiveMessage(self, message):
        deformedMessage = self._deformMessage(message)
        self.board.receiveMessage(deformedMessage)
        print(f"{self.name} received message: {message}, and deformed it to: {deformedMessage}")

    def showMessage(self):
        return self.board.message

    def _deformMessage(self, message):
        if not message:
            return message
        deformedMessage = message.replace(random.choice(message), random.choice(string.ascii_uppercase))
        return deformedMessage
